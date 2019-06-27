
import java.util.Scanner;

public class RaceExtra {

	public Scanner console = new Scanner(System.in); // Sets up scanner to be used by all methods

	/**
	 * LanguageChoice
	 * 
	 * Sets up what languages the player[] will know for the game
	 * 
	 * @param race - the race of the player
	 * @param languages - array of languages that the player will know
	 * @return languages[]
	 */
	public String[] LanguageChoice(String race, String languages[]){
		
		boolean done = false;
		int i = 1;
		languages[0] = "common";
		
		do {
			
			if(race == "tiefling") {
				languages[i] = "infernal";
			}
			else if(race == "half-orc") {
				languages[i] = "orc";
			}
			else if(race == "half-elf" || race == "elf") {
				languages[i] = "elvish";
			}
			else if(race == "gnome") {
				languages[i] = "gnomish";
			}
			else if(race == "dragonborn"){
				languages[i] = "draconic";
			}
			else if(race == "halfling") {
				languages[i] = "halfling";
			}
			else if(race == "dwarf") {
				languages[i] = "dwarvish";
			}
			else {done = true;}
			
			i++;
		}while(done == false);
		
		return languages;
	}
	
	/**
	 * AddLanguage
	 * 
	 * Method will ask for the player to add a language, and then,
	 * 	after checking to see if the player knows the language,
	 * 	adds said language to the players language[] array.
	 * 
	 * @param languages
	 * @return languages[]
	 */
	public String[] AddLanguage(String[] languages) {
		String temp = "";
		int i = 0;
		int j = 0;
		boolean done = false;
		
		System.out.println("Please choose your extra language");
		
		do {
			temp = console.next().trim().toLowerCase();
			if(languages[i] == temp) {
				
				System.out.println("This language has already been chosen. Please choose another language:");
				i -= j;
				break;
				
			}else if(languages[i] == null) {
				
				languages[i] = temp;
				done = true;
				
			}
			j++;
			i++;
		}while(done == false);
		
		return languages;
	}

	/**
	 * checkLanguage
	 * 
	 * Method will check if the player[] knows the language and return a whether the player
	 * 	does or does not know the language.
	 * 
	 * @param languages
	 * @param languageCheck
	 * @return
	 */
	public boolean checkLanguage(String[] languages, String languageCheck) {
		
		boolean check = false;
		
		for(int i = 0; i < 17; i++) {
			if(languages[i] == languageCheck) {
				check = true;
			}
		}
		return check;
	}
	
	public String draconicResistance(String input) {
		
		String resistance = "";
		
		if(input == "black" || input == "copper") {
			resistance = "acid";
		}
		else if(input == "blue" || input == "bronze") {
			resistance = "lightning";
		}
		else if(input == "brass" || input == "gold" || input == "red") {
			resistance = "fire";
		}
		else if(input == "green") {
			resistance = "poison";
		}
		else if(input == "silver" || input == "white") {
			resistance = "cold";
		}
		
		return resistance;
	}
}
