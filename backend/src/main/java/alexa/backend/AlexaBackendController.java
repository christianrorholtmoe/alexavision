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

	
	//http://localhost:8080/describeImage?url=http://e24.vgc.no/drpublish/images/article/2015/11/13/23560926/1/default/Anita.jpg
	//https:/ /alexavision.azurewebsites.net/getImagedescription
	//https://github.com/kasperkamperman/MobileCameraTemplate.git
	
	//class vars
	CognitiveVision cv = new CognitiveVision();
	Queue q = new Queue();

	
	//REST API for describing an image specified with an URL
	@RequestMapping("/describeImage")
    public void describeImage(@RequestParam(value="url") String url) {
    	q.addMessageToQueue(cv.describeImage(url));

    }
	
	//RESt API for describing an image delivered as a media stream
	@RequestMapping("/describeImageStream")
    public void describeImageStream(@RequestParam(value="url") String url) {
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
