package no.gombos.tdt4186.exercise2;

/**
 * This class implements a queue of customers as a circular buffer.
 */
public class CustomerQueue {
	/**
	 * Creates a new customer queue.
	 * @param queueLength	The maximum length of the queue.
	 * @param gui			A reference to the GUI interface.
	 */
	
	private Customer[] customerQueue;
	private int customerStart;
	private int customerEnd;
	
	private Gui gui;
	
    public CustomerQueue(int queueLength, Gui gui) {
		// Incomplete
    	customerQueue = new Customer[queueLength];
    	customerStart = -1;
    	customerEnd = -1;
    	this.gui = gui;
	}
    
    public int getCustomerStart(){
    	return customerStart;
    }
    
    public int getCustomerEnd(){
    	return customerEnd;
    }
    
    public synchronized void addCustomerToQueue(Customer customer){
    	if(customerEnd+1 != customerStart){
    		customerQueue[++customerEnd] = customer;
    		gui.fillLoungeChair(customerEnd-1, customer);
    		if(customerStart == -1) customerStart = 0;
    	}
    }
    
    public synchronized Customer takeCustomerFromQueue(){
    	return customerQueue[customerStart++];
    }

}
