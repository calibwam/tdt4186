package no.gombos.tdt4186.exercise2;

/**
 * This class implements the doorman's part of the
 * Barbershop thread synchronization example.
 */
public class Doorman {
	private Gui gui;
	private CustomerQueue customerQueue;
	
	/**
	 * Creates a new doorman.
	 * @param queue		The customer queue.
	 * @param gui		A reference to the GUI interface.
	 */
	public Doorman(CustomerQueue queue, Gui gui) { 
		this.gui = gui;
		this.customerQueue = queue;
	}

	/**
	 * Starts the doorman running as a separate thread.
	 */
	public void startThread() {
		// Incomplete
	}

	/**
	 * Stops the doorman thread.
	 */
	public void stopThread() {
		// Incomplete
	}

	// Add more methods as needed
}
