package no.ntnu.stud.gombos.tdt4186.exercise2;

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
	private int register;
	
	private Gui gui;
	
    public CustomerQueue(int queueLength, Gui gui) {
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
    
    public synchronized void addCustomerToQueue(Customer customer) {
    	if((customerStart == 0 && customerEnd == customerQueue.length-1)||(customerStart-1==customerEnd)){
    		try { 
    			gui.println("Queue is full.");
    			wait(); 
    		} catch(InterruptedException e) { 
    			System.out.println("InterruptedException caught in add"); 
    		}
    	}
    	if(customerEnd+1 == customerQueue.length){
    		customerEnd = 0;
    		customerQueue[customerEnd] = customer;
    		gui.fillLoungeChair(customerEnd, customer);
    	}
    	else{
    		customerQueue[++customerEnd] = customer;
    		gui.fillLoungeChair(customerEnd, customer);
    		if(customerStart == -1) customerStart = 0;
    	}
    	notifyAll();
    }
    
    public synchronized Customer takeCustomerFromQueue() {
    		if(customerStart == -1) {
    			try { 
    				gui.println("No customers in queue.");
    				wait(); 
    			} catch(InterruptedException e) { 
    				System.out.println("InterruptedException caught in take"); 
    			}
    		}
    	
	    	Customer customer = customerQueue[customerStart];
    		gui.emptyLoungeChair(customerStart);
	    	if(customerStart == customerEnd){
	    		customerStart = -1;
	    		customerEnd = -1;
	    	}
	    	else{
	    		customerStart = (customerStart+1)%customerQueue.length;
	    	}
	    	notifyAll();
	    	return customer;
    }
    
    public synchronized void takePaymentFromCustomer(){
    	register++;
    }
    
    public synchronized int getHowManyCustomersWhoHavePayedYo(){
    	return register;
    }

}
