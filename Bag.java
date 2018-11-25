/*
  * Name: Caden Dowd
  * NetID: 31320610
  * Assignment No.: Project 2
  * Lab MW 2-3:15PM
  * I did not collaborate with anyone on this assignment.
  */

/*
 * The Bag class creates an array of clubs.
 */
public class Bag {
	private Club[] bag;
	
	public Bag(Club[] b) {
		bag = b;
	}
	
	public Club[] getBag() {
		return bag;
	}
	
	public Club getClub(int x) {
		return bag[x];
	}
	
	public void setBag(Club[] b) {
		bag = b;
	}
	
	public void setClub(int x, Club c) {
		bag[x] = c;
	}
}
