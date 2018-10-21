package alexa.backend;

//Include the following imports to use queue APIs.
import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.queue.*;



//Singelton class for queue management

public class Queue {
	
	private static Queue queue  = new Queue();
	
	// Define the connection-string with your values.
	public static final String storageConnectionString =
	    "DefaultEndpointsProtocol=http;" +
	    "AccountName=your_storage_account;" +
	    "AccountKey=your_storage_account_key";
	
	//the queueu on which we will work
	private CloudQueue cloudqueue;
	
	//Azure queue name
	private static final String QUEUE_NAME = "AlexaBackendQueue";

	
	//Singelton contsructor
	private Queue() {
		try
		{
		    // Retrieve storage account from connection-string.
		    CloudStorageAccount storageAccount =
		       CloudStorageAccount.parse(storageConnectionString);

		   // Create the queue client.
		   CloudQueueClient queueClient = storageAccount.createCloudQueueClient();

		   // Retrieve a reference to a queue.
		   queue = queueClient.getQueueReference(QUEUE_NAME);

		   // Create the queue if it doesn't already exist.
		   queue.createIfNotExists();
		}
		catch (Exception e)
		{
		    // Output the stack trace.
		    e.printStackTrace();
		}
			
	}
	
	
/*Add message to queue*/
	public void addMessageToQueue(String s) {
		try
		{
		 // Create a message and add it to the queue.
		    CloudQueueMessage message = new CloudQueueMessage(s);
		    queue.addMessage(message);
		}
		catch (Exception e)
		{
		    // Output the stack trace.
		    e.printStackTrace();
		}
	}
	
	
	public String getMessageFromQueue() {
		
		try {
		// Retrieve the first visible message in the queue.
	    CloudQueueMessage retrievedMessage = queue.retrieveMessage();

	    if (retrievedMessage != null)
	    {
	        
	    	//get the message string
	    	//String ret = retreivedMessage.getString()
	    	
	    	// Process the message in less than 30 seconds, and then delete the message.
	        queue.deleteMessage(retrievedMessage);
	    }
	}
	catch (Exception e)
	{
	    // Output the stack trace.
	    e.printStackTrace();
	}
	}
	
	public static Queue getQueue() {
		return queue;
	}
	
	
	
}
