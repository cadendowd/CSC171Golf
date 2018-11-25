/*
  * Name: Caden Dowd
  * NetID: 31320610
  * Assignment No.: Project 2
  * Lab MW 2-3:15PM
  * I did not collaborate with anyone on this assignment.
  */

import java.util.Random;
import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		playGame();
	}
	
	public static void playGame() {
		String play = "y";
		while(play.equals("y")){
			System.out.println("<--- Welcome to Caden's TTY Golf! --->");
			System.out.println("Please select a course: \n1. Genesee Valley Park North Course\n2. The Old Course at St. Andrews");
			System.out.print("Your choice [1-2]: ");
			Scanner myScan = new Scanner(System.in);
			int choice = myScan.nextInt();		
			System.out.print("How many holes do you want to play [1-18]? ");
			int numHoles = myScan.nextInt();
			System.out.println();
			Player tiger = new Player(0, 0, 0, 0);
			Bag club = new Bag(createClubs());
			Bag put = new Bag(createPutter());
			Course gen = new Course(createHoles());
			gen.setName("Genesee Valey Park North Course");
			Course old = new Course(createHoles2());
			old.setName("The Old Course at St. Andrews");
			if(choice == 1)
				playHole(club, put, gen, tiger, numHoles);
			if(choice == 2)
				playHole(club, put, old, tiger, numHoles);
			System.out.print("Want to play another round? [y/n] ");
			play = myScan.next();
			//myScan.close();
			System.out.println();
		}
	}
	
	public static void playHole(Bag bag, Bag put, Course hole, Player player, int numHoles) {
		Scanner myScan = new Scanner(System.in);
		int totalStrokes = 0;
		int par = 0;

		for(int i = 1; i <= numHoles; i++) {
			int distanceYds = hole.getHole(i).getYardage();
			int distanceFt = distanceYds * 3;
			int numStrokes = 0;
			int holeDistance = 1;
			int startPut = 60;
			System.out.println("Welcome to " + hole.getHole(i).getName() + " hole!\n" + distanceYds + " yards away! Par " + hole.getHole(i).getPar());
			while(distanceFt > holeDistance) {
				if(distanceFt > holeDistance && distanceFt < startPut) {
					System.out.println("You are on the green! " + distanceFt + " more feet.");
					System.out.print("Putt Power [1-10]: ");
					int putPow = myScan.nextInt();
					int a = nextDistance(put.getClub(putPow).getMean(),put.getClub(putPow).getStandardDeviation(),10);
					distanceFt = Math.abs(distanceFt - a);
					if(distanceFt <= holeDistance) {
						System.out.println("That went " + a + " feet! Way to sink it!");
					} else {
						System.out.println("That went " + a + " feet! ");
					}
				} 
				if(distanceFt >= startPut){
					if(numStrokes > 0)
					System.out.println("You are on the fairway! " + distanceYds + " more yards to go.");
					System.out.print("Choose your club [1-10]: ");
					int club = myScan.nextInt();
					System.out.print("Power [1-10]: ");
					int pow = myScan.nextInt();
					int b = nextDistance(bag.getClub(club).getMean(),bag.getClub(club).getStandardDeviation(),pow);
					distanceYds = Math.abs(distanceYds - b);
					System.out.println("That went " + b + " yards! Wow!");
					distanceFt = distanceYds * 3;
				}
				System.out.println();
				totalStrokes++;
				numStrokes++;
				player.setCurrentDistance(distanceYds);
				player.setNumShots(totalStrokes);
			}
			player.addScore(numStrokes - hole.getHole(i).getPar());
			player.setHoleIndex(i);
			par += hole.getHole(i).getPar();
			printCurrentScore(hole.getHole(i).getPar(), numStrokes);
			if(i < numHoles)
				i = quitGame(i,numHoles);
			System.out.println("\n");
		}
		System.out.println("Total strokes for that game: " + totalStrokes);
		System.out.println("Par for the game: " + par);
		System.out.print("Overall ");
		printOverallScore(player);
		System.out.println("Good Game!\n");
		//myScan.close();
	}
	
	public static Club[] createClubs() {
		Club[] one =  new Club[12];
		one[1] = new Club(230, 30);
		one[2] = new Club(215, 20);
		one[3] = new Club(180, 20);
		one[4] = new Club(170, 17);
		one[5] = new Club(155, 15);
		one[6] = new Club(145, 15);
		one[7] = new Club(135, 15);
		one[8] = new Club(125, 15);
		one[9] = new Club(110, 10);
		one[10] = new Club(50, 10);
		return one;
	}
	
	public static Hole[] createHoles() {
		Hole[] one = new Hole[19];
		one[1] = new Hole(530, 5, "first");
		one[2] = new Hole(305, 4, "second");
		one[3] = new Hole(331, 4, "third");
		one[4] = new Hole(201, 3, "fourth");
		one[5] = new Hole(500, 5, "fifth");
		one[6] = new Hole(226, 3, "sixth");
		one[7] = new Hole(409, 4, "seventh");
		one[8] = new Hole(410, 4, "eigth");
		one[9] = new Hole(229, 3, "ninth");
		one[10] = new Hole(433, 4, "tenth");
		one[11] = new Hole(363, 4, "eleventh");
		one[12] = new Hole(174, 3, "twelfth");
		one[13] = new Hole(545, 5, "thirteenth");
		one[14] = new Hole(419, 4, "fourteenth");
		one[15] = new Hole(512, 5, "fifteenth");
		one[16] = new Hole(410, 4, "sixteenth");
		one[17] = new Hole(320, 4, "seventeenth");
		one[18] = new Hole(170, 3, "eighteenth");
		return one;
	}
	
	public static Hole[] createHoles2() {
		Hole[] one = new Hole[19];
		one[1] = new Hole(376, 4, "Burn");
		one[2] = new Hole(453, 4, "Dyke");
		one[3] = new Hole(397, 4, "Cartgate (Out)");
		one[4] = new Hole(480, 4, "Ginger Beer");
		one[5] = new Hole(568, 5, "Hole O'Cross (Out)");
		one[6] = new Hole(412, 4, "Heathery (Out)");
		one[7] = new Hole(371, 4, "High (Out)");
		one[8] = new Hole(175, 3, "Short");
		one[9] = new Hole(352, 4, "End");
		one[10] = new Hole(386, 4, "Bobby Jones");
		one[11] = new Hole(174, 3, "High (In)");
		one[12] = new Hole(348, 4, "Heathery (In)");
		one[13] = new Hole(465, 4, "Hole O'Cross (In)");
		one[14] = new Hole(618, 5, "Long");
		one[15] = new Hole(455, 4, "Cartgate (In)");
		one[16] = new Hole(423, 4, "Corner of the Dyke");
		one[17] = new Hole(495, 4, "Road");
		one[18] = new Hole(357, 4, "Tom Morris");
		return one;
	}
	
	public static Club[] createPutter() {
		Club[] one = new Club[11];
		one[1] = new Club(1, 1);
		one[2] = new Club(2, 1);
		one[3] = new Club(4, 2);
		one[4] = new Club(8, 2);
		one[5] = new Club(12, 3);
		one[6] = new Club(16, 3);
		one[7] = new Club(20, 4);
		one[8] = new Club(25, 4);
		one[9] = new Club(30, 5);
		one[10] = new Club(40, 5);
		return one;
	}
	
	public static int nextDistance(int mean, int stddev, int power) {
		Random rand = new Random();
		double mean_adj = mean * power / 10.0;
		double mean_stddev = stddev * power / 10.0;
		double val = Math.abs(rand.nextGaussian() * mean_stddev + mean_adj);
		return (int) val;
	}
	
	public static int quitGame(int i, int numHoles) {
		Scanner myScan = new Scanner(System.in);
		System.out.print("Keep going? [y/n]: ");
		String answer = myScan.nextLine();
		if(answer.equals("n"))
			 i = numHoles + 1;
		return i;
	}
	
	public static void printOverallScore(Player p) {
		int score = p.getScore();
		String golfTerm = golfTerm(score);
		if(score > 0) {
			System.out.println("Score: +" + score + golfTerm);
		} else {
			System.out.println("Score: " + score + golfTerm);
		}
	}
	
	public static void printCurrentScore(int par , int numStrokes) {
		int score = numStrokes - par;
		String golfTerm = golfTerm(score);
		if(score > 0) {
			System.out.println("Score for that hole: +" + score + golfTerm);
		} else {
			System.out.println("Score for that hole: " + score + golfTerm);
		}
	}
	
	public static String golfTerm(int score) {
		if(score == 0) {
			return " (par)";
		} else if (score == 1) {
			return " (bogey)";
		} else if (score == 2) {
			return " (double bogey)";
		} else if (score == -1) {
			return " (birdie)";
		} else if (score == -2) {
			return " (eagle)";
		} else if (score == -3) {
			return " (albatross)";
		} else if (score == 3) {
			return " (triple bogey)";
		} else {
			return "";
		}
	}
}

