/*
  * Name: Caden Dowd
  * NetID: 31320610
  * Assignment No.: Project 2
  * Lab MW 2-3:15PM
  * I did not collaborate with anyone on this assignment.
  */

/*
 * The Course class is an array of Holes
 */
public class Course {
	private Hole[] courseName;
	private String name;
	
	public Course(Hole[] cn) {
		courseName = cn;
	}
	
	public Hole[] getName() {
		return courseName;
	}
	
	public Hole getHole(int x) {
		return courseName[x];
	}
	
	public void setCourseName(Hole[] cn) {
		courseName = cn;
	}
	
	public void setHole(int x, Hole h) {
		courseName[x] = h;
	}
	
	public void setName(String n) {
		name = n;
	}
}
