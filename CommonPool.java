package modul4;

import javax.swing.JLabel;

public class CommonPool extends Thread {
	private int limit = 15;
	private boolean threadRunning = true;

	private Buffer buffer;
	private JLabel lblComNr;
//	private JLabel lblComLim;

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
				System.out.println(lblComNr.getText());
				sleep(500);
			} catch (InterruptedException e) {

			}
		}
	}

}
