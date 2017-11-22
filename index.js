'use strict';

var React = require('react-native');
var { NativeModules, Platform } = React;
var NativeSpeechSynthesizer = NativeModules.RNSpeachText;

var RNSpeachText = {
  speak(options) {
    if(Platform.OS === "ios"){
      return new Promise(function(resolve, reject) {
        NativeSpeechSynthesizer.speakUtterance(options, (error, success) => {
          if (error) {
            return reject(error);
          }
  
          resolve(true);
        });
      });
    }else{
      NativeSpeechSynthesizer.speakUtterance(options.text);
    }
  },

  stop: NativeSpeechSynthesizer.stopSpeakingAtBoundary,

  pause: NativeSpeechSynthesizer.pauseSpeakingAtBoundary,

  resume: NativeSpeechSynthesizer.continueSpeakingAtBoundary,

  isPaused() {
    return new Promise((resolve, reject) => {
      NativeSpeechSynthesizer.paused((error, paused)  =>{
        if (error) {
          return reject(error);
        }

        if (paused === 1) {
          resolve(true);
        } else {
          resolve(false);
        }
      });
    });
  },

  isSpeaking() {
    return new Promise((resolve, reject) => {
      NativeSpeechSynthesizer.speaking((speaking) => {
        if (speaking === 1) {
          resolve(true);
        } else {
          resolve(false);
        }
      });
    });
  },

  supportedVoices() {
    return new Promise((resolve, reject) => {
      NativeSpeechSynthesizer.speechVoices((error, locales) => {
        if (error) {
          return reject(error);
        }

        resolve(locales);
      });
    });
  }
};

module.exports = RNSpeachText;
