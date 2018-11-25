/*
  * Name: Caden Dowd
  * NetID: 31320610
  * Assignment No.: Project 2
  * Lab MW 2-3:15PM
  * I did not collaborate with anyone on this assignment.
  */

/*
 * The Putter class is an array of clubs because each power
 * of the putter has a different mean/standard deviation.
 */
public class Putter {
	private Club[] put;
	
	public Putter(Club[] p) {
		put = p;
	}
	
	public Club[] getPutter() {
		return put;
	}
	
	public Club getPut(int x) {
		return put[x];
	}
	
	public void setPutter(Club[] c) {
		put = c;
	}
	
	public void setPut(int x, Club c) {
		put[x] = c;
	}
}
