package modul4;

import java.util.LinkedList;

/**
 * Buffer for all Visitor positions
 * @author Alexander J. Drottsgård
 *
 */
public class Buffer {
	private LinkedList<Visitor> adventurePoolQueue = new LinkedList<Visitor>();
	private LinkedList<Visitor> adventurePool = new LinkedList<Visitor>();
	private LinkedList<Visitor> commonPoolQueue = new LinkedList<Visitor>();
	private LinkedList<Visitor> commonPool = new LinkedList<Visitor>();
	private LinkedList<Visitor> exitAdventurePool = new LinkedList<Visitor>();
	private LinkedList<Visitor> exitCommonPool = new LinkedList<Visitor>();

	/**
	 * Puts Visitor in Queue and notify threads so they can get the Visitor
	 * @param v
	 * @throws InterruptedException
	 */
	public synchronized void addAdventurePoolQueue(Visitor v) throws InterruptedException {
		adventurePoolQueue.add(v);
		notifyAll();
	}

	/**
	 * Returns visitor from the Waiting queue. If queue is empty the thread has to wait to be notified.
	 * @return
	 * @throws InterruptedException
	 */
	public synchronized Visitor getAdventurePoolQueue() throws InterruptedException {
		while (adventurePoolQueue.isEmpty()) {
			wait();
		}
		Visitor v = adventurePoolQueue.remove();
		notifyAll();
		return v;
	}

	/**
	 * 
	 * @return - size of the Queue for AdventurePool
	 */
	public synchronized int getAdventurePoolQueueSize() {
		return adventurePoolQueue.size();
	}

	/**
	 * Puts Visitor in the Pool
	 * @param v
	 * @throws InterruptedException
	 */
	public synchronized void addAdventurePoolVisiter(Visitor v) throws InterruptedException {
		adventurePool.add(v);
		notifyAll();
	}

	/**
	 * Returns visitor from the AdventurePool. If queue is empty the thread has to wait to be notified.
	 * @return
	 * @throws InterruptedException
	 */
	public synchronized Visitor getAdventurePoolVisiter() throws InterruptedException {
		while (adventurePool.isEmpty()) {
			wait();
		}
		Visitor v = adventurePool.removeFirst();
		notifyAll();
		return v;
	}

	/**
	 * 
	 * @return - size of adventure pool.
	 */
	public synchronized int getAdventurePoolSize() {
		return adventurePool.size();
	}

	/**
	 * Puts Visitor in Queue and notify threads so they can get the Visitor
	 * @param v
	 * @throws InterruptedException
	 */
	public synchronized void addCommonPoolQueue(Visitor v) throws InterruptedException {
		commonPoolQueue.add(v);
		notifyAll();
	}

	/**
	 * Returns visitor from the CommonPool queue. If queue is empty the thread has to wait to be notified.
	 * @return
	 * @throws InterruptedException
	 */
	public synchronized Visitor getCommonPoolQueue() throws InterruptedException {
		while (commonPoolQueue.isEmpty()) {
			wait();
		}
		Visitor v = commonPoolQueue.removeFirst();
		notifyAll();
		return v;
	}

	/**
	 * 
	 * @return - size of CommonPool queue
	 */
	public synchronized int getCommonPoolQueueSize() {
		return commonPoolQueue.size();
	}

	/**
	 * Puts Visitor in the Pool
	 * @param v
	 */
	public synchronized void addCommonPoolVisiter(Visitor v) {
		commonPool.add(v);
		notifyAll();
	}

	/**
	 * Returns visitor from the AdventurePool. If queue is empty the thread has to wait to be notified.
	 * @return
	 * @throws InterruptedException
	 */
	public synchronized Visitor getCommonPoolVisiter() throws InterruptedException {
		while (commonPool.isEmpty()) {
			System.out.println("deadlock i commonPool");
			wait();
		}
		Visitor v = commonPool.removeFirst();
		notifyAll();
		return v;
	}

	/**
	 * 
	 * @return - size of commonPool
	 */
	public synchronized int getCommonPoolSize() {	
		return commonPool.size();
	}
	
	/**
	 * Puts Visitor in the Exit queue, if adventurePool
	 * @param v
	 */
	public synchronized void addExitAdventurePool(Visitor v) {
		exitAdventurePool.add(v);
		notifyAll();
	}
	
	/**
	 * 
	 * @return - size of exitAdventurePool
	 */
	public synchronized int exitAdventurePoolSize() {
		return exitAdventurePool.size();
	}
	
	/**
	 * Puts Visitor in the Exit queue, if commonPool
	 * @param v
	 */
	public synchronized void addExitcommonPool(Visitor v) {
		exitCommonPool.add(v);
		notifyAll();
	}
	
	/**
	 * 
	 * @return - size of exitCommonPool
	 */
	public synchronized int exitCommonPoolSize() {
		return exitCommonPool.size();
	}
 }
