package alexavision.voiceinterface;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

public class LaunchRequestHandler implements RequestHandler {
	
	//The canHandle method returns true if the incoming request is a LaunchRequest. 

     public boolean canHandle(HandlerInput input) {
         return input.matches(Predicates.requestType(LaunchRequest.class));
     }

     
     //The handle method generates and returns a basic greeting response with response objects such as Speech, Card, and Reprompt which you can find more information here.
     public Optional<Response> handle(HandlerInput input) {
         String speechText = "Welcome to the Alexa Skills Kit, you can say hello";
         return input.getResponseBuilder()
                 .withSpeech(speechText)
                 .withSimpleCard("HelloWorld", speechText)
                 .withReprompt(speechText)
                 .build();
     }

}