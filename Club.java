/*
  * Name: Caden Dowd
  * NetID: 31320610
  * Assignment No.: Project 2
  * Lab MW 2-3:15PM
  * I did not collaborate with anyone on this assignment.
  */

/*
 * The Club class has a mean, standard deviation to calculate the next shot.
 */
public class Club {
	private int mean, standardDeviation;
	
	public Club(int m, int sD) {
		mean = m;
		standardDeviation = sD;
	}
	
	public int getMean() {
		return mean;
	}
	
	public int getStandardDeviation() {
		return standardDeviation;
	}
	
	public void setMean(int m) {
		mean = m;
	}
	
	public void setStandardDeviation(int sd) {
		standardDeviation = sd;
	}
}
