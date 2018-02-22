
# react-native-speach-text

React Native Speach Text is a module that lets you translate plane text into a voice.

## Getting started

`$ npm install react-native-speach-text --save`

### Mostly automatic installation

`$ react-native link react-native-speach-text`

### Manual installation

#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-speach-text` and add `RNSpeachText.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNSpeachText.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNSpeachTextPackage;` to the imports at the top of the file
  - Add `new RNSpeachTextPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-speach-text'
  	project(':react-native-speach-text').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-speach-text/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-speach-text')
  	```

## Background mode

#### iOS

```
// MARK: - Keep Audio in Background
  AVAudioSession *audioSession = [AVAudioSession sharedInstance];
  BOOL ok;
  NSError *setCategoryError = nil;
  ok = [audioSession setCategory:AVAudioSessionCategoryPlayback error:&setCategoryError];
```

#### Android (comming soon)

## Usage
```javascript
import RNSpeachText from 'react-native-speach-text';

export default SpeachText extends Component{
  
  componentDidMount(){
    RNSpeachText.speak({
      text : "Hello World this is a react native speach text native module, and this voice will stop in 5,4,3,2,1, now!"
    });
    
    setTimeout(() => {
      RNSpeachText.stop();
    },6000);
  }
  
  _getAvailableVoices(){
     RNSpeachText.supportedVoices((voices) => {
        console.log(voices,'voices');
     });
  }
  
  render(){
    return(
        <View />
    );
  } 
}
```

## Methods

| Method | iOS | Android |
| ------- | ----| --------|
| RNSpeachText.speak({ text : "Hello World" }) | yes | yes |
| RNSpeachText.pause() | yes | yes |
| RNSpeachText.stop()  | yes | yes |
| RNSpeachText.resume() | yes | no |
| RNSpeachText.isPaused((paused) => {}) | yes | yes |
| RNSpeachText.isSpeaking((speaking) => {}) | yes | yes |
| RNSpeachText.supportedVoices((voices) => {}) | yes | no |

## Of courseeee, your PR are welcome :)
  
