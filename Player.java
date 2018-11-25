/*
  * Name: Caden Dowd
  * NetID: 31320610
  * Assignment No.: Project 2
  * Lab MW 2-3:15PM
  * I did not collaborate with anyone on this assignment.
  */

/*
 * The Player class keeps track of a players score, number of shots,
 * which hole they are on, and their current distance from the hole.
 */

public class Player {
	private int score, holeIndex, numShots;
	private double currentDistance;
	
	public Player(int s, int hi, int ns, double cd) {
		score = s;
		holeIndex = hi;
		numShots = ns;
		currentDistance = cd;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getHoleIndex() {
		return holeIndex;
	}
	
	public int getNumShots() {
		return numShots;
	}
	
	public double getCurrentDistance() {
		return currentDistance;
	}
	
	public void setScore(int s) {
		score = s;
	}
	
	public void setHoleIndex(int hi) {
		holeIndex = hi;
	}
	
	public void setNumShots(int ns) {
		numShots = ns;
	}
	
	public void setCurrentDistance(double cd) {
		currentDistance = cd;
	}
	
	//keep track of score
	public void addScore(int s) {
		score = score + s;
	}

}
