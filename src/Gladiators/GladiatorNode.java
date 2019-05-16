package Gladiators;

/**
 * @author Daniel Acuña Mora
 *
 */
public class GladiatorNode  {
	private Gladiator Glad;
	private GladiatorNode  next;
	private GladiatorNode  prev;

	/**
	 * @param name
	 * @param next
	 * @param prev
	 */
	public GladiatorNode( Gladiator obj) {
		this.Glad = obj;
	}

	public void linkNext(GladiatorNode  next) {
		this.next = next;
	}

	public void linkPrev(GladiatorNode  prev) {
		this.next = prev;
	}

	public  Gladiator getGlad() {
		return this.Glad;
	}
	public void setGlad( Gladiator gl) {
		this.Glad = gl;
	}

	/**
	 * @return the next
	 */
	public GladiatorNode  getNext() {
		return next;
	}

	/**
	 * @return the prev
	 */
	public GladiatorNode  getPrev() {
		return prev;
	}

	/**
	 * 
	 */
}