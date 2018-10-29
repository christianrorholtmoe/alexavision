/**
 * 
 */
package alexa.backend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author christian    	
 */
@RestController
public class AlexaBackendController {

	
	//class vars
	CognitiveVision cv = new CognitiveVision();
	Queue q = new Queue();
	
	@RequestMapping("/x")
    public void describeImage(@RequestParam(value="url") String url) {
    	q.addMessageToQueue(cv.describeImage(url));

    }
	
	@RequestMapping("/getImagedescription")
    public String getImagedescription() {        
		return q.getMessageFromQueue();    	    	
    }

	@RequestMapping("/")
    public String defaultmapping() {        
		return "Velkommen til MIN app! - endelig";    	    	
    }

	
}
