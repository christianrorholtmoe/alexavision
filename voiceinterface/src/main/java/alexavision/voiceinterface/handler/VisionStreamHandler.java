package alexavision.voiceinterface.handler;

import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;


 public class VisionStreamHandler extends SkillStreamHandler {

     private static Skill getSkill() {
         return Skills.standard()
                 .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new DescribeImageIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler(),
                        new FallbackIntentHandler())
                 .build();
     }

     public VisionStreamHandler() {
         super(getSkill());
     }

 }
