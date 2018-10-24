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

	CognitiveVision cv = new CognitiveVision();
	Queue q = new Queue();
	
	@RequestMapping("/describeImage")
    public void describeImage(@RequestParam(value="url") String url) {
    	q.addMessageToQueue(cv.describeImage(url));

    }
	
	@RequestMapping("/getImagedescription")
    public String getImagedescription() {        
		return q.getMessageFromQueue();    	    	
    }
	
}
