package alexavision.voiceinterface;

// This sample uses the Apache HTTP client from HTTP Components (http://hc.apache.org/httpcomponents-client-ga/)
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.amazon.ask.model.interfaces.display.Image;

//mvn org.apache.maven.plugins:maven-assembly-plugin:2.6:assembly -DdescriptorId=jar-with-dependencies package

public class ImageDescriber {

	
	
	//URL of cognitive services in North Europe
	private static final String uriBase =
           "https://alexavision.azurewebsites.net/getImagedescription"; 
	
	//empty constructor. 
	public ImageDescriber() {
		
	}
	
/*	public static void main (String args[]) {
		ImageDescriber describer = new ImageDescriber();
		System.out.println("API ga følgende svar: " + describer.describeImage());
	}
	*/
	
	public String describeImage () {
      
		 CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		 JSONObject json = new JSONObject();
		 String description = "";
		 
	        try {
	            URIBuilder builder = new URIBuilder(uriBase);

	            // Request parameters. All of them are optional.
	            //builder.setParameter("visualFeatures", "Description");
	            //builder.setParameter("language", "en");

	            // Prepare the URI for the REST API method.
	            URI uri = builder.build();
	            HttpPost request = new HttpPost(uri);

	            // Request headers.
	            request.setHeader("Content-Type", "application/json");
	            
	            // Request body.
	            
	            // Call the REST API method and get the response entity.
	            HttpResponse response = httpClient.execute(request);
	            HttpEntity entity = response.getEntity();

	            if (entity != null) {
	            	System.out.println("entity finnes...");
	            	// Format and display the JSON response.
	                String jsonString = EntityUtils.toString(entity);
	                System.out.println("jsonString er: " + jsonString);
	                json = new JSONObject(jsonString);
	                description = json.getString("text");
	            		               
	               	            }
	        } catch (Exception e) {
	            // Display error message.
	            System.out.println(e.getMessage());
	        }
	        
	        return description;
	    }	
		
	}
	
	
