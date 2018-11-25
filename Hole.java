/*
  * Name: Caden Dowd
  * NetID: 31320610
  * Assignment No.: Project 2
  * Lab MW 2-3:15PM
  * I did not collaborate with anyone on this assignment.
  */

/*
 * The Hole class keeps par, yardage and has a name. All used to play golf.
 */

public class Hole {
	private int yardage;
	private int par; 
	private String name;
	
	public Hole(int y, int p) {
		yardage = y;
		par = p;
	}
	
	public Hole(int y, int p, String n) {
		yardage = y;
		par = p;
		name = n;
	}
	
	public int getYardage() {
		return yardage;
	}
	
	public int getPar() {
		return par;
	}
	
	public String getName() {
		return name;
	}
	
	public void setYardage(int y) {
		yardage = y;
	}
	
	public void setPar(int p) {
		par = p;
	}
	
	public void setName(String n) {
		name = n;
	}
}
