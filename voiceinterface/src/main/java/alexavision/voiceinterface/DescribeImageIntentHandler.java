package alexavision.voiceinterface;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

public class DescribeImageIntentHandler implements RequestHandler {

     
     public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.intentName("HelloWorldIntent"));
     }

     
     public Optional<Response> handle(HandlerInput input) {
         String speechText = "Hello world";
         return input.getResponseBuilder()
                 .withSpeech(speechText)
                 .withSimpleCard("HelloWorld", speechText)
                 .build();
     }

}