package alexa.backend;

//Singelton class for queue management
public class Queue {
	
	private static Queue queue  = new Queue();

	//TODO: Storage keys etc
	
	private Queue() {}
	
	public static Queue getQueue() {
		return queue;
	}
	
	
	
}
