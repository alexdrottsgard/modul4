package modul4;

import javax.swing.JLabel;

public class Exit extends Thread {
	private Buffer buffer;
	private JLabel lblAexit;
	private JLabel lblCexit;
	private boolean threadRunning = true;

	public Exit(Buffer buffer, JLabel lblAexit, JLabel lblCexit) {
		this.buffer = buffer;
		this.lblAexit = lblAexit;
		this.lblCexit = lblCexit;
		start();
	}

	@Override
	public void run() {
		while (threadRunning) {
			try {
				buffer.addExitAdventurePool(buffer.getAdventurePoolVisiter());
				lblAexit.setText("" + buffer.exitAdventurePoolSize());
				System.out.println("removed " + lblAexit.getText() + " vistors from adventurePool");
				buffer.addExitcommonPool(buffer.getCommonPoolVisiter());
				lblCexit.setText("" + buffer.exitCommonPoolSize());
				System.out.println("removed " + lblCexit.getText() + " vistors from commonPool");

				Thread.sleep(1500);
			} catch (InterruptedException e) {

			}
		}
	}

}
