package alexa.backend;

//Singelton class for queue management
public class Queue {
	
	private static Queue queue  = new Queue();
	
	//Azure queue access key
	private static final String ACCESS_KEY = "";
	
	//Azure queue name
	private static final String QUEUE_NAME = "AlexaBackendQueue";
	
	
	private Queue() {}
	
	public static Queue getQueue() {
		return queue;
	}
	
	
	
}
