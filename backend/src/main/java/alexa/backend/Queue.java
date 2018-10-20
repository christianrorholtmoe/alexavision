package alexa.backend;

//Include the following imports to use queue APIs.
import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.queue.*;



//Singelton class for queue management
public class Queue {
	
	private static Queue queue  = new Queue();
	
	
	//Azure queue name
	private static final String QUEUE_NAME = "AlexaBackendQueue";

	
	// Define the connection-string with your values.
	public static final String storageConnectionString =
	    "DefaultEndpointsProtocol=http;" +
	    "AccountName=your_storage_account;" +
	    "AccountKey=your_storage_account_key";
	
	private CloudQueue queue;
	
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
	
	public static Queue getQueue() {
		return queue;
	}
	
	
	
}
