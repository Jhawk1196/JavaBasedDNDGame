
import java.util.Scanner;
import java.io.*;

public class Java_DND_Game {
	
	static public Scanner console = new Scanner (System.in);
	
	public SpellCasting SpellCasting = new SpellCasting();
	public Combat Combat = new Combat();
	
	
	public static void main(String[] args) throws IOException{
	
		System.out.println("Hello world! And welcome to this test program for DND.");
		//for(int i = 0; i < 3; i++) {
			Player_Info player = new Player_Info();
			
			player.StatCreation();
		
			System.out.println("Now, please choose a Race: ");
			player.RaceChoice(console.next());
			
			System.out.println("Now, choose what class you would like to play as: ");
			player.ClassSelect(console.next());
			
			player.ModifierCalc(player);
			
			System.out.println("Finally, what would you like you're name to be?");
			player.name = console.nextLine();
		//}
		
		player.printPlayer();
		player.printStats();
		
		console.close();
		System.exit(0);
	}
}
