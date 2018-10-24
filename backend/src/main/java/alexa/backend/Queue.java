package alexa.backend;

//Include the following imports to use queue APIs.
import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.queue.*;



//Singelton class for queue management

public class Queue {
	
	
	// Define the connection-string .
	
	public static final String storageConnectionString =
	    "DefaultEndpointsProtocol=https;" +
	    "AccountName=storagealexabackend;" +
	    "AccountKey=plXS3adPyrqrrf6uly/zjjcP3jN9iu3Po/dBM6JS/o4Mfqzfg6y7abrkIHfIzfaqMpdOaklT6lUm52qFlZKTYQ==";
	
	//the queueu on which we will work
	private CloudQueue cloudqueue;
	
	//Azure queue name
	private static final String QUEUE_NAME = "imagequeue";

	
	//Contsructor
	public Queue() {
		try
		{
		    // Retrieve storage account from connection-string.
		    CloudStorageAccount storageAccount =
		       CloudStorageAccount.parse(storageConnectionString);

		   // Create the queue client.
		   CloudQueueClient queueClient = storageAccount.createCloudQueueClient();

		   // Retrieve a reference to a queue.
		   cloudqueue = queueClient.getQueueReference(QUEUE_NAME);

		   // Create the queue if it doesn't already exist.
		   cloudqueue.createIfNotExists();
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
		    cloudqueue.addMessage(message);
		}
		catch (Exception e)
		{
		    // Output the stack trace.
		    e.printStackTrace();
		}
	}
	
	
	public String getMessageFromQueue() {
		
		String ret = "";
		
		try {
		// Retrieve the first visible message in the queue.
	    CloudQueueMessage retrievedMessage = cloudqueue.retrieveMessage();

	    if (retrievedMessage != null)
	    {
	        
	    	//get the message string
	    	ret = retrievedMessage.getMessageContentAsString();
	    	
	    	// Process the message in less than 30 seconds, and then delete the message.
	    	cloudqueue.deleteMessage(retrievedMessage);
	  
	    }
	}
	catch (Exception e)
	{
	    // Output the stack trace.
	    e.printStackTrace();

	}

		return ret;
	}
	

public String peekAtMessageFromQueue() {
		
		String ret = "";
		
		try {
		// Retrieve the first visible message in the queue.
	    CloudQueueMessage retrievedMessage = cloudqueue.peekMessage();

	    if (retrievedMessage != null)
	    {
	        
	    	//get the message string
	    	ret = retrievedMessage.getMessageContentAsString();
	    	
	    	
	    }
	}
	catch (Exception e)
	{
	    // Output the stack trace.
	    e.printStackTrace();

	}

		return ret;
	}

	
	
	
}
