package modul4;

/**
 * Object Visitor with boolean VIP.
 * @author Sandr
 *
 */

public class Visitor {
	private boolean VIP;

	/**
	 * Constructor
	 * @param VIP - the status of this Visitor
	 */
	public Visitor(boolean VIP) {
		this.VIP = VIP;
	}
	
	/**
	 * Getter for VIP status
	 * @return - the VIP status
	 */
	public boolean isVIP() {
		return VIP;
	}
}
