package modul4;

import java.util.LinkedList;
import java.util.Random;

import javax.swing.JLabel;

public class Reception extends Thread {
	private Buffer buffer;
	private JLabel lblWadv, lblWcom;
	private boolean threadRunning = true;

	private Random rand = new Random();

	public Reception(Buffer buffer, JLabel lblWadv, JLabel lblWcom) {
		this.buffer = buffer;
		this.lblWadv = lblWadv;
		this.lblWcom = lblWcom;
		start();
	}


	@Override
	public void run() {
		while (threadRunning) {
			
			try {
				if (rand.nextBoolean()) {
					buffer.addAdventurePoolQueue(new Visitor(rand.nextBoolean()));
					lblWadv.setText("" + buffer.getAdventurePoolQueueSize());
				} else {
					buffer.addCommonPoolQueue(new Visitor(rand.nextBoolean()));
					lblWcom.setText("" + buffer.getCommonPoolQueueSize());
				}
				sleep(500);
			} catch (InterruptedException e) {
				System.out.println("CommonPoolThread InterruptedException");
			}
		}
	}

}
