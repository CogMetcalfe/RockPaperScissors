package RPSGame;

import java.util.Random;

public class RPS {
	int totalGames, compWins, playerWins, draws;
	int[] handCount;
	Random rand;
	public RPS(){
		totalGames=compWins=playerWins=draws=0;
		rand = new Random();
		handCount = new int[3];
	}
	
	public String info() {
		int highestCount=-1;
		String str="";
		for(int i=0;i<3;i++) {
			if(handCount[i]>=highestCount) {
				if(handCount[i]==highestCount) {
					str+= " and " + playToHand(i);
				}else {
					highestCount=handCount[i];
					str = playToHand(i);
				}
			}
		}
		return "Total: " + totalGames + ", " + "W|D|L: " + playerWins + "|" + draws + "|" + compWins + "  -  Most common hand is " + str + " with " + highestCount + " uses, R|P|S: " + handCount[0] + "|" + handCount[1] + "|" + handCount[2];
	}
	
	public String play(String hand) {
		int handNum = handToNum(hand);
		return play(handNum);
	}
	public String play(int handNum) {
		//0 1 2
		//handCount[0]
		//handCount[1]
		//handCount[2]
		handCount[handNum]++;
		int status = rand.nextInt(3)-1;
		totalGames++;
		switch(status) {
		case -1:
			playerWins++;
			break;
		case 0:
			draws++;
			break;
		case 1:
			compWins++;
			break;
		}
		return "Computer chose " + playToHand((handNum+status+3)%3);
	}
	
	public static int handToNum(String hand) {
		hand = hand.toLowerCase();
		if(hand.equals("r")||hand.contains("rock")) {
			return 0;
		}
		if(hand.equals("p")||hand.contains("paper")) {
			return 1;
		}
		if(hand.equals("s")||hand.contains("scissors")) {
			return 2;
		}
		return -1;
	}
	
	public static String playToHand(int n) {
		if(n==0) {
			return "Rock";
		}else if(n==1) {
			return "Paper";
		}else if(n==2) {
			return "Scissors";
		}else {
			return "ERROR";
		}
	}
	
//	private int win(int n) {
//		return (n+1)%3;
//	}
//	private int lose(int n) {
//		return (n-1)%3;
//	}
	
}
