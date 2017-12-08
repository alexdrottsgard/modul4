package modul4;

import java.util.Random;

import javax.swing.JLabel;

public class CommonPool extends Thread {
	private int limit = 15;
	private boolean threadRunning = true;

	private Buffer buffer;
	private JLabel lblComNr;
	private Visitor v;
	private Random rand = new Random();
	// private JLabel lblComLim;

	public CommonPool(Buffer buffer, JLabel lblCom, JLabel lblComLim, int limit) {
		this.buffer = buffer;
		this.lblComNr = lblCom;
		this.limit = limit;
		lblComLim.setText("" + limit);
		start();
	}

	@Override
	public void run() {
		while (buffer.getCommonPoolSize() < limit) {
			try {
				System.out.println("CommonPool");
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
				
				System.out.println(lblComNr.getText());
				sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("CommonPoolThread InterruptedException");
			}
		}
	}

}
