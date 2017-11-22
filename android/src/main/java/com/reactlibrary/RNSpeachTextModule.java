
package com.reactlibrary;

import android.os.Build;
import android.speech.tts.TextToSpeech;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.Locale;

public class RNSpeachTextModule extends ReactContextBaseJavaModule {
    private TextToSpeech textToSpeech;
    private final Locale locale = new Locale("es", "MX");

    private final ReactApplicationContext reactContext;

    public RNSpeachTextModule(ReactApplicationContext reactContext) {
      super(reactContext);
      this.reactContext = reactContext;
    }

    @Override
    public String getName() {
      return "RNSpeachText";
    }

    @ReactMethod
    public void speakUtterance(final String message) throws Exception {
        textToSpeech = new TextToSpeech(getReactApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                textToSpeech.setLanguage(locale);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    textToSpeech.speak(message,TextToSpeech.QUEUE_FLUSH,null,null);
                } else {
                    textToSpeech.speak(message, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });
    }

    @ReactMethod
    public void stopSpeakingAtBoundary(){
        if(textToSpeech != null) {
            boolean isSpeaking = textToSpeech.isSpeaking();
            if(isSpeaking){
                textToSpeech.stop();
            }
        }
    }

    @ReactMethod
    public void pauseSpeakingAtBoundary(){
        if(textToSpeech != null) {
            boolean isSpeaking = textToSpeech.isSpeaking();
            if(isSpeaking){
                textToSpeech.stop();
            }
        }
    }

    @ReactMethod
    public void continueSpeakingAtBoundary(){
       //not implemented
    }

    @ReactMethod
    public void speaking(Callback callback){
        if(textToSpeech != null){
            boolean isSpeaking = textToSpeech.isSpeaking();
            if(isSpeaking){
                callback.invoke(true);
            }else{
                callback.invoke(false);
            }
        }
    }

    @ReactMethod
    public void speechVoices(Callback callback){
        //not implemented
        //Set voiceSet = textToSpeech.getVoices();
    }
}