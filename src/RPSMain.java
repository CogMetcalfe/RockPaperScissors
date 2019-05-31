import java.util.Random;
import java.util.Scanner;

import RPSGame.RPS;

public class RPSMain {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		RPS rpsGame = new RPS();
		
		while(true) {
			System.out.println("Rock, Paper or Scissors? [Info][Quit]");
			String command = s.nextLine().toLowerCase();
			if(command.equals("q")||command.contains("quit")||command.contains("stop")||command.contains("exit")) {
				System.out.println("Thanks for playing!");
				break;
			}
			if(command.equals("i")||command.contains("info")||command.contains("games")) {
				System.out.println(rpsGame.info());
				continue;
			}
			if(RPS.handToNum(command)!=-1) {
				System.out.println("You chose: " + RPS.playToHand(RPS.handToNum(command)));
				System.out.println(rpsGame.play(command));
			}else {
				System.out.println("Invalid command :\"" + command + "\"");
			}
			
		}

//		RPS rpsGame = new RPS();
//		Random rand = new Random();
//		for(int i=0;i<100;i++) {
//			int play = rand.nextInt(3);
//			System.out.println(RPS.playToHand(play));
//			System.out.println(rpsGame.play(play));
//			System.out.println(rpsGame.info());
//		}

	}

}
