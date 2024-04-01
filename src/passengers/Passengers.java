package passengers;

// TODO: Auto-generated Javadoc
/**
 * The Class Passengers. Represents a GROUP of passengers that are 
 * traveling together from one floor to another. Tracks information that 
 * can be used to analyze Elevator performance.
 */
public class Passengers {
	
	/**  Constant for representing direction. */
	private static final int UP = 1;
	
	/** The Constant DOWN. */
	private static final int DOWN = -1;
	
	/**  ID represents the NEXT available id for the passenger group. */
	private static int ID=0;

	/** id is the unique ID assigned to each Passenger during construction.
	 *  After assignment, static ID must be incremented.
	 */
	private int id;
	
	/** These fields will be passed into the constructor by the Building.
	 *  This data will come from the .csv file read by the SimController
	 */
	private int time;         // the time that the Passenger will call the elevator
	
	/** The num pass. */
	private int numPass;      // the number of passengers in this group
	
	/** The on floor. */
	private int onFloor;      // the floor that the Passenger will appear on
	
	/** The dest floor. */
	private int destFloor;	  // the floor that the Passenger will get off on
	
	/** The polite. */
	private boolean polite;   // will the Passenger let the doors close?
	
	/** The wait time. */
	private int waitTime;     // the amount of time that the Passenger will wait for the
	                          // Elevator
	
	/** These values will be calculated during construction.
	 */
	private int direction;      // The direction that the Passenger is going
	
	/** The time will give up. */
	private int timeWillGiveUp; // The calculated time when the Passenger will give up
	
	/** These values will actually be set during execution. Initialized to -1 */
	private int boardTime=-1;
	
	/** The time arrived. */
	private int timeArrived=-1;
	
	/** The pass dir. */
	private String passDir;
	
	/**
	 * Instantiates a new passengers.
	 *
	 * @param time the time
	 * @param numPass the number of people in this Passenger
	 * @param on the floor that the Passenger calls the elevator from
	 * @param dest the floor that the Passenger is going to
	 * @param polite - are the passengers polite?
	 * @param waitTime the amount of time that the passenger will wait before giving up
	 */
	public Passengers(int time, int numPass, int on, int dest, boolean polite, int waitTime) {
	// TODO: Write the constructor for this class
	//       Remember to appropriately adjust the onFloor and destFloor to account  
	//       to convert from American to European numbering...
		this.time = time;
		this.numPass = numPass;
		this.onFloor = on-1;
		this.destFloor = dest-1;
		this.polite = polite;
		this.waitTime = waitTime;
		this.direction = calcDirection(); 
		id = ID;
		ID++;
		
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 * 
	 * Reviewed by Arjun
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * checks if a passenger is polite or not.
	 *
	 * @return polite
	 * 
	 * Reviewed by Arjun
	 */
	public boolean isPolite() {
		return polite;
	}

	/**
	 * sets polite .
	 *
	 * @param polite the new value of polite
	 * 
	 * Reviewed by Arjun
	 */
	public void setPolite(boolean polite) {
		this.polite = polite;
	}

	/**
	 * sets time.
	 *
	 * @param time the new value of time
	 * 
	 * Reviewed by Arjun
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * sets numPass.
	 *
	 * @param numPass the new value of numPass
	 * 
	 * Reviewed by Arjun
	 */
	public void setNumPass(int numPass) {
		this.numPass = numPass;
	}

	/**
	 * sets onFloor.
	 *
	 * @param onFloor the new value of onFloor
	 * 
	 * Reviewed by Arjun
	 */
	public void setOnFloor(int onFloor) {
		this.onFloor = onFloor;
	}

	/**
	 * sets DestFloor.
	 *
	 * @param destFloor the new value of destFloor
	 * 
	 * Reviewed by Arjun
	 */
	public void setDestFloor(int destFloor) {
		this.destFloor = destFloor;
	}

	/**
	 * sets waitTime.
	 *
	 * @param waitTime the new value of waitTime
	 * 
	 * Reviewed by Arjun
	 */
	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}


	/**
	 * Gets the time.
	 *
	 * @return the time
	 * 
	 * Reviewed by Arjun
	 */
	public int getTime() {
		return time;
	}

	/**
	 * Gets the num pass.
	 *
	 * @return the num pass
	 * 
	 * Reviewed by Arjun
	 */
	public int getNumPass() {
		return numPass;
	}

	/**
	 * Gets the on floor.
	 *
	 * @return the on floor
	 * 
	 * Reviewed by Arjun
	 */
	public int getOnFloor() {
		return onFloor;
	}

	/**
	 * Gets the dest floor.
	 *
	 * @return the dest floor
	 * 
	 * Reviewed by Arjun
	 */
	public int getDestFloor() {
		return destFloor;
	}

	/**
	 * Gets the wait time.
	 *
	 * @return the wait time
	 * 
	 * Reviewed by Arjun
	 */
	public int getWaitTime() {
		return waitTime;
	}

	/**
	 * Gets the board time.
	 *
	 * @return the board time
	 * 
	 * Reviewed by Arjun
	 */
	public int getBoardTime() {
		return boardTime;
	}

	/**
	 * Gets the time arrived.
	 *
	 * @return the time arrived
	 * 
	 * Reviewed by Arjun
	 */
	public int getTimeArrived() {
		return timeArrived;
	}

	
	/**
	 * Reset static ID. 
	 * This method MUST be called during the building constructor BEFORE
	 * reading the configuration files. This is to provide consistency in the
	 * Passenger ID's during JUnit testing.
	 * 
	 * Reviewed by Arjun
	 */
	public static void resetStaticID() {
		ID = 0;
	}
	
	/**
	 * calculates the direction.
	 *
	 * @return the direction
	 * 
	 * Reviewed by Arjun
	 */
	private int calcDirection() {
		if(destFloor > onFloor) {
			return UP;
		}
			return DOWN;
	}
	
	/**
	 * Gets direction.
	 *
	 * @return direction
	 * 
	 * Reviewed by Arjun
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * toString - returns the formatted string for this class.
	 *
	 * @return the
	 */
	@Override
	public String toString() {
		return("ID="+id+"   Time="+time+"   NumPass="+numPass+"   From="+(onFloor+1)+"   "
				+ "To="+(destFloor+1)+"   Polite="+polite+"   Wait="+waitTime);
	}

	/**
	 * Whether passengers gaveUp.
	 *
	 * @param the current time
	 * @return gaveUp
	 */
	public boolean gaveUp(int currTime) {
		if(time + waitTime < currTime) {
			return true;
		}
		return false;
		
	}
	/**
	 * Sets the boardTime
	 * @param time
	 */
	public void setBoardTime(int time) {
		boardTime = time;
	}
	/**
	 * Sets the timeArrived
	 * @param time
	 */
	public void setArrivalTime(int time) {
		timeArrived = time;
		
	}

}
