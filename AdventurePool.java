package modul4;

import java.util.Random;

import javax.swing.JLabel;

public class AdventurePool extends Thread {
	private int limit = 10;
	private boolean threadRunning = true;

	private Buffer buffer;
	private JLabel lblAdvNr;
	private Random rand = new Random();

	public AdventurePool(Buffer buffer, JLabel lblAdv, JLabel lblAdvLim, int limit) {
		this.buffer = buffer;
		this.lblAdvNr = lblAdv;
		this.limit = limit;
		lblAdvLim.setText("" + limit);
		start();
	}

	@Override
	public void run() {
		while (buffer.getAdventurePoolSize() < limit) {
			try {
				System.out.println("AdventurePool");

				buffer.addAdventurePoolVisiter(buffer.getAdventurePoolQueue());
				// v = buffer.getAdventurePoolSize();
				lblAdvNr.setText("" + buffer.getAdventurePoolSize());
				System.out.println(lblAdvNr.getText());

				sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("CommonPoolThread InterruptedException");
			}

		}
	}
}
