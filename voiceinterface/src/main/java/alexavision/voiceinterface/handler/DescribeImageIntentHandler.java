package alexavision.voiceinterface.handler;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import alexavision.voiceinterface.ImageDescriber;

import java.util.Optional;

public class DescribeImageIntentHandler implements RequestHandler {

     
     public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.intentName("DescribeImageIntent"));
     }

  
     public Optional<Response> handle(HandlerInput input) {
       
    	 ImageDescriber describer = new ImageDescriber();
    	 String speechText = "I have seen " + describer.describeImage();
    	 
         
         return input.getResponseBuilder()
                 .withSpeech(speechText)
                 .withSimpleCard("HelloWorld", speechText)
                 .build();
     }
     
     
     

}
