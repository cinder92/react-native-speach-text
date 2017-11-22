#import <React/RCTBridgeModule.h>

@import AVFoundation;

@interface RNSpeachText : NSObject <RCTBridgeModule, AVSpeechSynthesizerDelegate>
@property (nonatomic, strong) AVSpeechSynthesizer *synthesizer;
@end
