package modul4;

import java.util.LinkedList;

public class Buffer {
	private LinkedList<Visitor> adventurePoolQueue = new LinkedList<Visitor>();
	private LinkedList<Visitor> adventurePool = new LinkedList<Visitor>();
	private LinkedList<Visitor> commonPoolQueue = new LinkedList<Visitor>();
	private LinkedList<Visitor> commonPool = new LinkedList<Visitor>();
	private LinkedList<Visitor> exitAdventurePool = new LinkedList<Visitor>();
	private LinkedList<Visitor> exitCommonPool = new LinkedList<Visitor>();

	
	public synchronized void addAdventurePoolQueue(Visitor v) throws InterruptedException {
		adventurePoolQueue.add(v);
		notifyAll();
	}

	public synchronized Visitor getAdventurePoolQueue() throws InterruptedException {
		while (adventurePoolQueue.isEmpty()) {
			wait();
		}
		Visitor v = adventurePoolQueue.remove();
		notifyAll();
		return v;
	}

	public synchronized int getAdventurePoolQueueSize() {
		return adventurePoolQueue.size();
	}

	public synchronized void addAdventurePoolVisiter(Visitor v) throws InterruptedException {
		adventurePool.add(v);
		notifyAll();
	}

	public synchronized Visitor getAdventurePoolVisiter() throws InterruptedException {
		while (adventurePool.isEmpty()) {
			wait();
		}
		Visitor v = adventurePool.removeFirst();
		notifyAll();
		return v;
	}

	public synchronized int getAdventurePoolSize() {
		if (adventurePool.size() == 0) {
			return 0;
		} else {
			return adventurePool.size();
		}

	}

	public synchronized void addCommonPoolQueue(Visitor v) throws InterruptedException {
		commonPoolQueue.add(v);
		notifyAll();
	}

	public synchronized Visitor getCommonPoolQueue() throws InterruptedException {
		while (commonPoolQueue.isEmpty()) {
			wait();
		}
		Visitor v = commonPoolQueue.removeFirst();
		notifyAll();
		return v;
	}

	public synchronized int getCommonPoolQueueSize() {
		return commonPoolQueue.size();
	}

	public synchronized void addCommonPoolVisiter(Visitor v) {
		commonPool.add(v);
		notifyAll();
	}

	public synchronized Visitor getCommonPoolVisiter() throws InterruptedException {
		while (commonPool.isEmpty()) {
			System.out.println("deadlock i commonPool");
			wait();
		}
		Visitor v = commonPool.removeFirst();
		notifyAll();
		return v;
	}

	public synchronized int getCommonPoolSize() {
		if (commonPool.size() == 0) {
			return 0;
		} else {
			return commonPool.size();
		}

	}
	
	public synchronized void addExitAdventurePool(Visitor v) {
		exitAdventurePool.add(v);
		notifyAll();
	}
	
	public synchronized int exitAdventurePoolSize() {
		return exitAdventurePool.size();
	}
	
	public synchronized void addExitcommonPool(Visitor v) {
		exitCommonPool.add(v);
		notifyAll();
	}
	
	public synchronized int exitCommonPoolSize() {
		return exitCommonPool.size();
	}
 }
