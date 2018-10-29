package alexa.backend;

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



public class CognitiveVision {

	private static final String SUBSCRIPTION_KEY = "47fc7169755f4b87a8125dbafbedab72";
	
	//URL of cognitive services in North Europe
	private static final String uriBase =
            "https://northeurope.api.cognitive.microsoft.com/vision/v1.0/analyze"; 
	
	//empty constructor. 
	public CognitiveVision() {
		
	}
	
	public String describeImage (String imageToAnalyze) {
       
		 CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		 JSONObject json = new JSONObject();
		 String description = "";
		 
	        try {
	            URIBuilder builder = new URIBuilder(uriBase);

	            // Request parameters. All of them are optional.
	            builder.setParameter("visualFeatures", "Description");
	            builder.setParameter("language", "en");

	            // Prepare the URI for the REST API method.
	            URI uri = builder.build();
	            HttpPost request = new HttpPost(uri);

	            // Request headers.
	            request.setHeader("Content-Type", "application/json");
	            request.setHeader("Ocp-Apim-Subscription-Key", SUBSCRIPTION_KEY);

	            // Request body.
	            StringEntity requestEntity =
	                    new StringEntity("{\"url\":\"" + imageToAnalyze + "\"}");
	            request.setEntity(requestEntity);

	            // Call the REST API method and get the response entity.
	            HttpResponse response = httpClient.execute(request);
	            HttpEntity entity = response.getEntity();

	            if (entity != null) {
	                // Format and display the JSON response.
	                String jsonString = EntityUtils.toString(entity);
	                json = new JSONObject(jsonString);
	                description = json.getJSONObject("description").getJSONArray("captions").getJSONObject(0).toString();
	            	System.out.println(description);	               
	               	            }
	        } catch (Exception e) {
	            // Display error message.
	            System.out.println(e.getMessage());
	        }
	        
	        return description;
	    }	
		
	}
	
	
	
	
