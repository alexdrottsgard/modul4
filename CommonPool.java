package modul4;

import java.util.Random;
import javax.swing.JLabel;

/**
 * This class gets a visitor from a queue and puts in the pool.
 * @author Alexander J. Drottsgård
 *
 */

public class CommonPool extends Thread {
	private int limit = 15;

	private Buffer buffer;
	private JLabel lblComNr;
	private Visitor v;
//	private Random rand = new Random();
// 	private JLabel lblComLim;

	/**
	 * Constructor
	 * @param buffer - where it can get visitors and put in another queue
	 * @param lblCom
	 * @param lblComLim
	 * @param limit - max visitors possible
	 */
	public CommonPool(Buffer buffer, JLabel lblCom, JLabel lblComLim, int limit) {
		this.buffer = buffer;
		this.lblComNr = lblCom;
		this.limit = limit;
		lblComLim.setText("" + limit);
		start();
	}

	/**
	 * Thread gets visitor and puts back in a queue for the visitors. 
	 * This thread also puts VIP members into the AdventurePool
	 */
	@Override
	public void run() {
		while (buffer.getCommonPoolSize() < limit) {
			try {
//				System.out.println("CommonPool");
				buffer.addCommonPoolVisiter(buffer.getCommonPoolQueue());
				lblComNr.setText("" + buffer.getCommonPoolSize());
				v = buffer.getCommonPoolVisiter();
				if (v.isVIP() == true) {
					System.out.println("Flyttar vip till adventurePool");
					buffer.addAdventurePoolVisiter(v);
				} else {
					System.out.println("Gick ej att flytta visitor adventurePool");
					buffer.addCommonPoolVisiter(v);
				}
				
//				System.out.println(lblComNr.getText());
				sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("CommonPoolThread InterruptedException");
			}
		}
	}

}
