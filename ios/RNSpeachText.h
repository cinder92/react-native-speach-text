//
//  RNSpeechText.h
//
//  Created by Dante Cervantes on 18/10/17.
//  Copyright © 2017 Facebook. All rights reserved.
//

#import <React/RCTBridgeModule.h>

@import AVFoundation;

@interface RNSpeachText : NSObject <RCTBridgeModule, AVSpeechSynthesizerDelegate>
@property (nonatomic, strong) AVSpeechSynthesizer *synthesizer;
@end
