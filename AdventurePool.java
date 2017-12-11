package modul4;

import java.util.Random;

import javax.swing.JLabel;

/**
 * This class gets a visitor from a queue and puts in the pool.
 * @author Alexander J. Drottsgård
 *
 */
public class AdventurePool extends Thread {
	private int limit = 10;

	private Buffer buffer;
	private JLabel lblAdvNr;
//	private Random rand = new Random();

	/**
	 * Constructor
	 * @param buffer - where it can get visitors and put in another queue
	 * @param lblAdv
	 * @param lblAdvLim
	 * @param limit - max visitors possible
	 */
	public AdventurePool(Buffer buffer, JLabel lblAdv, JLabel lblAdvLim, int limit) {
		this.buffer = buffer;
		this.lblAdvNr = lblAdv;
		this.limit = limit;
		lblAdvLim.setText("" + limit);
		start();
	}

	/**
	 * Thread gets visitor and puts back in a queue for the visitors.
	 */
	@Override
	public void run() {
		while (buffer.getAdventurePoolSize() < limit) {
			try {
//				System.out.println("AdventurePool");

				buffer.addAdventurePoolVisiter(buffer.getAdventurePoolQueue());
				// v = buffer.getAdventurePoolSize();
				lblAdvNr.setText("" + buffer.getAdventurePoolSize());
//				System.out.println(lblAdvNr.getText());

				sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("CommonPoolThread InterruptedException");
			}

		}
	}
}
