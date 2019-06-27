
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class Player_Info {

	private String NL = "\r\n";

	public Scanner console = new Scanner(System.in);
	private SpellCheck SpellCheck = new SpellCheck();
	private RaceExtra RaceExtra = new RaceExtra();
	private Random rand = new Random();

	public ArrayList<String> traits, resistances, profWeapons, profArmor, profTools, cantrips = new ArrayList<>();

	public String[] languages = new String[16];

	public int[] SavingThrow = new int[1];

	public boolean[] acrobatics = new boolean[1];
	public boolean[] animalhandling = new boolean[1];
	public boolean[] arcana = new boolean[1];
	public boolean[] athletics = new boolean[1];
	public boolean[] deception = new boolean[1];
	public boolean[] history = new boolean[1];
	public boolean[] insight = new boolean[1];
	public boolean[] intimidation = new boolean[1];
	public boolean[] investigation = new boolean[1];
	public boolean[] medicine = new boolean[1];
	public boolean[] nature = new boolean[1];
	public boolean[] perception = new boolean[1];
	public boolean[] performance = new boolean[1];
	public boolean[] persuasion = new boolean[1];
	public boolean[] religion = new boolean[1];
	public boolean[] sleightofhand = new boolean[1];
	public boolean[] stealth = new boolean[1];
	public boolean[] survival = new boolean[1];

	public int gold = 100;
	public int xp = 0;
	public int level = 1;

	public int hp;
	public int mana;
	public String race;
	public String subrace = "";
	public double move;
	public double height;

	public String name;

	public int Charisma, CharMod, Strength, StrMod, Wisdom, WisMod, Dext, DextMod, Intel, IntelMod, Const, ConstMod;

	public int HitDie = 8;

	public int ProfBonus = 2;

	public boolean dwarvenToughness = false;

	public String draconicAnc;

	public Player_Info() {
		for (int i = 0; i < 1; i++) {
			acrobatics[i] = false;
			animalhandling[i] = false;
			arcana[i] = false;
			athletics[i] = false;
			deception[i] = false;
			history[i] = false;
			insight[i] = false;
			intimidation[i] = false;
			investigation[i] = false;
			medicine[i] = false;
			nature[i] = false;
			perception[i] = false;
			performance[i] = false;
			persuasion[i] = false;
			religion[i] = false;
			sleightofhand[i] = false;
			stealth[i] = false;
			survival[i] = false;
		}
	}

	public void RaceChoice(String input) {
		boolean methoddone = false;
		do {
			if (input == "human") {
				hp = 100;
				mana = 100;
				move = 30;
				height = 2.0;

				race = "human";

				Charisma++;
				Strength++;
				Wisdom++;
				Dext++;
				Intel++;
				Const++;

				RaceExtra.LanguageChoice("human", languages);
				System.out.println("You may choose one more language as a Human:");
				RaceExtra.AddLanguage(languages);

				methoddone = true;
			} else if (input == "elf") {
				hp = 100;
				mana = 200;
				move = 30;
				height = 2.0;
				race = "elf";
				Dext += 2;
				RaceExtra.LanguageChoice("elf", languages);

				traits.add("darkvision");

				perception[0] = true;

				System.out.println("Please choose a subrace of Elf: ");
				subrace = console.next().trim().toLowerCase();
				if (subrace == "high") {
					Intel++;

					profWeapons.add("shortsword");
					profWeapons.add("longsword");
					profWeapons.add("shortbow");
					profWeapons.add("longbow");

					System.out.println("As a High Elf, you are knowledgable about one cantrip of your choice \r\n "
							+ "from the wizard's spell list. Please choose it now:");
					cantrips.add(console.nextLine().toLowerCase().trim());

					System.out.println("By choosing High Elf, you may choose an extra language:");
					RaceExtra.AddLanguage(languages);
				} else if (subrace == "wood") {
					Wisdom++;

					profWeapons.add("shortsword");
					profWeapons.add("longsword");
					profWeapons.add("shortbow");
					profWeapons.add("longbow");

					move = 35;
				} else if (subrace == "dark" || subrace == "drow") {
					Charisma++;

					traits.add("superior darkvision");

					profWeapons.add("rapier");
					profWeapons.add("shortsword");
					profWeapons.add("hand crossbow");

					cantrips.add("dancing lights");
					cantrips.add("faerie fire");
					cantrips.add("darkness");

				}
				methoddone = true;
			} else if (input == "half-orc") {
				hp = 200;
				mana = 50;
				move = 30;
				height = 2.0;

				race = "half-orc";

				Strength += 2;
				Const++;

				RaceExtra.LanguageChoice("half-orc", languages);

				traits.add("darkvision");
				intimidation[0] = true;

				methoddone = true;
			} else if (input == "halfling") {
				hp = 100;
				mana = 100;
				move = 25;
				height = 1.0;

				race = "halfling";

				Dext += 2;

				RaceExtra.LanguageChoice("halfling", languages);

				System.out.println("Please choose a subrace of Halfling: ");
				subrace = console.next().trim().toLowerCase();
				if (subrace == "lightfoot") {
					Charisma++;
				} else if (subrace == "stout") {
					Const++;
				}
				methoddone = true;
			} else if (input == "tiefling") {
				hp = 100;
				mana = 200;
				move = 30;
				height = 2.0;

				race = "tiefling";

				Intel++;
				Dext += 2;

				RaceExtra.LanguageChoice("tiefling", languages);

				traits.add("darkvision");
				resistances.add("fire");
				cantrips.add("thaumaturgy");
				cantrips.add("hellish rebuke");
				cantrips.add("darkness");

				methoddone = true;
			} else if (input == "dragonborn") {
				hp = 150;
				mana = 100;
				move = 30;
				height = 3.0;

				race = "dragonborn";

				Strength += 2;
				Charisma++;

				RaceExtra.LanguageChoice("dragonborn", languages);

				System.out.println("Please choose a Draconic Ancestry from the following list:" + NL + "-Black" + NL
						+ "-Blue" + NL + "-Brass" + NL + "-Bronze" + NL + "-Copper" + NL + "-Gold" + NL + "-Green" + NL
						+ "-Red" + NL + "-Silver" + NL + "-White");

				draconicAnc = console.next().toLowerCase().trim();

				resistances.add(RaceExtra.draconicResistance(draconicAnc));

				methoddone = true;
			} else if (input == "gnome") {
				hp = 100;
				mana = 100;
				move = 25;
				height = 1.0;

				race = "gnome";

				Intel += 2;

				RaceExtra.LanguageChoice("gnome", languages);

				traits.add("darkvision");

				System.out.println("Please choose a subrace of Gnome: ");
				subrace = console.next().trim().toLowerCase();
				if (subrace == "forest") {
					Dext++;

					cantrips.add("minor illusion");

				} else if (subrace == "rock") {
					Const++;

					profTools.add("artisan's tools");
					profTools.add("tinker's tools");
				}

				methoddone = true;
			} else if (input == "dwarf") {
				hp = 100;
				mana = 100;
				move = 25;
				height = 1.0;

				race = "dwarf";

				Const += 2;

				RaceExtra.LanguageChoice("dwarf", languages);

				traits.add("darkvision");
				resistances.add("poison");
				profWeapons.add("battleaxe");
				profWeapons.add("handaxe");
				profWeapons.add("throwing hammer");
				profWeapons.add("warhammer");

				System.out.println("Please choose a subrace of Dwarf: ");
				subrace = console.next().toLowerCase();
				if (subrace == "hill") {
					Wisdom++;
					dwarvenToughness = true;
				} else if (subrace == "mountain") {
					Strength += 2;
					profArmor.add("light");
					profArmor.add("medium");
				}
				methoddone = true;
			} else if (input == "half-elf") {
				hp = 100;
				mana = 150;
				move = 30;
				height = 2.0;

				race = "half-elf";

				Charisma += 2;

				RaceExtra.LanguageChoice("half-elf", languages);

				traits.add("darkvision");

				String temp[] = new String[1];

				System.out.println("As a Half-Elf, you gain proficiencies in two skills of your choice." + NL
						+ "Please type them in now, with no spaces, pressing enter after each one:");

				boolean done = false;

				do {
					temp[0] = console.next().toLowerCase().trim();
					temp[1] = console.next().toLowerCase().trim();

					for (int k = 0; k < 2; k++) {
						if (temp[0] == temp[1]) {
							break;
						} else if (temp[k] == "acrobatics") {
							acrobatics[0] = true;
						} else if (temp[k] == "animalhandling") {
							animalhandling[0] = true;
						} else if (temp[k] == "arcana") {
							arcana[0] = true;
						} else if (temp[k] == "athletics") {
							athletics[0] = true;
						} else if (temp[k] == "deception") {
							deception[0] = true;
						} else if (temp[k] == "history") {
							history[0] = true;
						} else if (temp[k] == "insight") {
							insight[0] = true;
						} else if (temp[k] == "intimidation") {
							intimidation[0] = true;
						} else if (temp[k] == "investigation") {
							investigation[0] = true;
						} else if (temp[k] == "medicine") {
							medicine[0] = true;
						} else if (temp[k] == "nature") {
							nature[0] = true;
						} else if (temp[k] == "perception") {
							perception[0] = true;
						} else if (temp[k] == "performance") {
							performance[0] = true;
						} else if (temp[k] == "persuasion") {
							persuasion[0] = true;
						} else if (temp[k] == "religion") {
							religion[0] = true;
						} else if (temp[k] == "sleightofhand") {
							sleightofhand[0] = true;
						} else if (temp[k] == "stealth") {
							stealth[0] = true;
						} else if (temp[k] == "stealth") {
							survival[0] = true;
						}
						if (k == 1) {
							done = true;
						}
					}

				} while (temp[0] == temp[1] || done == false);

				System.out.println("Please choose two more abilities to have a +1 modifier in, \r\n "
						+ "pressing enter after each entry:");
				boolean test = false;

				do {
					temp[0] = console.next().toLowerCase();
					temp[1] = console.next().toLowerCase();
					for (int j = 0; j < 2; j++) {

						test = SpellCheck.run(temp[j]);
						if (test = true) {
							continue;
						} else {
							System.out.println("You have misspelled " + temp[j]);
							break;
						}

					}
					if (temp[0] == "charisma" || temp[1] == "charisma") {
						System.out.println("You cannot choose Charisma. Please choose again:");
						break;
					}
					if (temp[0] == temp[1]) {
						System.out.println("You cannot choose the same ability twice. Please choose again");
						break;
					}
					for (int i = 0; i < 2; i++) {
						if (temp[i] == "dexterity") {
							Dext++;
						} else if (temp[i] == "strength") {
							Strength++;
						} else if (temp[i] == "constitution") {
							Const++;
						} else if (temp[i] == "wisdom") {
							Wisdom++;
						} else if (temp[i] == "intelligence") {
							Intel++;
						} else {
							break;
						}
					}

				} while (temp[0] == "charisma" || temp[1] == "charisma" || temp[0] == temp[1] || test == false);
			} else {
				System.out.println("That is an invalid choice. Please choose another race:");
			}
		} while (methoddone = false);
	}

	public void ModifierCalc(Player_Info player) {
		CharMod = Charisma / 2;
		StrMod = Strength / 2;
		WisMod = Wisdom / 2;
		DextMod = Dext / 2;
		IntelMod = Intel / 2;
		ConstMod = Const / 2;
	}

	public void ClassSelect(String input) {
		boolean done = false;
		do {
			if (input == "barbarian" && Strength >= 15) {
				HitDie = 12;
				SavingThrow[0] = StrMod;
				SavingThrow[1] = ConstMod;
				done = true;
			} else if (input == "bard" && Charisma >= 15) {
				SavingThrow[0] = DextMod;
				SavingThrow[1] = CharMod;
				done = true;
			} else if (input == "cleric" && Wisdom >= 15) {
				SavingThrow[0] = WisMod;
				SavingThrow[1] = DextMod;
				done = true;
			} else if (input == "druid" && Wisdom >= 15) {
				SavingThrow[0] = IntelMod;
				SavingThrow[1] = WisMod;
				done = true;
			} else if (input == "fighter" && (Strength >= 15 || Dext >= 15)) {
				HitDie = 10;
				SavingThrow[0] = StrMod;
				SavingThrow[1] = ConstMod;
				done = true;
			} else if (input == "monk" && Dext >= 10 && Wisdom >= 10) {
				SavingThrow[0] = StrMod;
				SavingThrow[1] = DextMod;
				done = true;
			} else if (input == "paladin" && Strength >= 10 && Charisma >= 10) {
				HitDie = 10;
				SavingThrow[0] = WisMod;
				SavingThrow[1] = CharMod;
				done = true;
			} else if (input == "ranger" && Dext >= 10 && Wisdom >= 10) {
				HitDie = 10;
				SavingThrow[0] = StrMod;
				SavingThrow[1] = DextMod;
				done = true;
			} else if (input == "rogue" && Dext >= 15) {
				SavingThrow[0] = DextMod;
				SavingThrow[1] = IntelMod;
				done = true;
			} else if (input == "sorceror" && Charisma >= 15) {
				HitDie = 6;
				SavingThrow[0] = CharMod;
				SavingThrow[1] = ConstMod;
				done = true;
			} else if (input == "warlock" && Charisma >= 15) {
				SavingThrow[0] = CharMod;
				SavingThrow[1] = WisMod;
				done = true;
			} else if (input == "wizard" && Intel >= 15) {
				HitDie = 6;
				SavingThrow[0] = IntelMod;
				SavingThrow[1] = WisMod;
				done = true;
			} else {
				System.out.println("You cannot choose this class. Please choose another class:");
			}
		} while (done = false);
	}

	public void XpGain(int XpEarned) {
		xp += XpEarned;
		int i = 1;
		do {
			if (xp >= (100 * (Math.pow(3, i))) && xp < 6500 && level != 4) {
				level++;
			} else if (xp >= 6500 && xp < 14000 && level == 4) {
				level++;
				ProfBonus++;
			} else if (xp >= 14000 && level == 5 && xp < 23000) {
				level++;
			} else if (xp >= 23000 && level == 6 && xp < 34000) {
				level++;
			} else if (xp >= 34000 && level == 7 && xp < 48000) {
				level++;
			} else if (xp >= 48000 && level == 8 && xp < 64000) {
				level++;
				ProfBonus++;
			} else if (xp >= 64000 && level == 9 && xp < 85000) {
				level++;
			} else if (xp >= 85000 && level == 10 && xp < 100000) {
				level++;
			} else if (xp >= 100000 && level == 11 && xp < 120000) {
				level++;
			} else if (xp >= 120000 && level == 12 && xp < 140000) {
				level++;
				ProfBonus++;
			} else if (xp >= 140000 && level == 13 && xp < 165000) {
				level++;
			} else if (xp >= 165000 && level == 14 && xp < 195000) {
				level++;
			} else if (xp >= 195000 && level == 15 && xp < 225000) {
				level++;
			} else if (xp >= 225000 && level == 16 && xp < 265000) {
				level++;
				ProfBonus++;
			} else if (xp >= 265000 && level == 17 && xp < 305000) {
				level++;
			} else if (xp >= 305000 && level == 18 && xp < 355000) {
				level++;
			} else if (xp >= 355000 && level == 19) {
				level++;
			} else {
				level = 20;
			}
			if (level < 20) {
				i++;
			}
		} while (level <= i);
	}

	public void StatCreation() throws IOException {
		int[] temp = new int[6];
		int input = 0;
		boolean dextDone = false;
		boolean strDone = false;
		boolean constDone = false;
		boolean wisdomDone = false;
		boolean intelDone = false;
		boolean charismaDone = false;
		boolean done = false;
		do {
			for (int i = 0; i < 6; i++) {

				temp[i] = rand.nextInt(15) + 5;

			}

			Arrays.sort(temp);
			System.out.println("These are your Stat Rolls.");
			System.out.println("{" + temp[0] + ", " + temp[1] + ", " + temp[2] + ", " + temp[3] + ", " + temp[4] + ", "
					+ temp[5] + "}");

			System.out.println("You may reroll to get different stats, but you cannot keep specific stats." + NL
					+ " Would you like to reroll? 1 for Yes or 2 for No:");
			input = console.nextInt();
			if (input == 2) {
				done = true;
			}
		} while (done == false);
		for (int j = 0; j < 6; j++) {
			System.out.println("Please choose which stat you would like " + temp[j]
					+ " to go into. Here are your Choices:" + NL + "1 = Dexterity" + NL + "2 = Strength" + NL
					+ "3 = Constitution" + NL + "4 = Wisdom" + NL + "5 = Intelligence" + NL + "6 = Charisma");
			input = console.nextInt();

			if (input == 1 && dextDone != true) {
				Dext = temp[j];
				dextDone = true;
			} else if (input == 2 && strDone != true) {
				Strength = temp[j];
				strDone = true;
			} else if (input == 3 && constDone != true) {
				Const = temp[j];
				constDone = true;
			} else if (input == 4 && wisdomDone != true) {
				Wisdom = temp[j];
				wisdomDone = true;
			} else if (input == 5 && intelDone != true) {
				Intel = temp[j];
				intelDone = true;
			} else if (input == 6 && charismaDone != true) {
				Charisma = temp[j];
				charismaDone = true;
			} else {
				System.out.println(input + " is not a valid statement. Please retype your answer.");
				j--;
			}
		}
	}

	public void printStats() {
		String line = ("Stats:" + NL + "-Charisma: " + Charisma + NL + "--Charisma Modifier: " + CharMod + NL
				+ "-Strength: " + Strength + NL + "--Strength Modifier: " + StrMod + NL + "-Wisdom: " + Wisdom + NL
				+ "--Wisdom Modifier: " + WisMod + NL + "-Dexterity: " + Dext + NL + "--Dexterity Modifier: " + DextMod
				+ NL + "-Intelligence: " + Intel + NL + "--Intelligence Modifier: " + IntelMod + NL + "-Constitution: "
				+ Const + NL + "--Constitution Modifier: " + ConstMod);
		System.out.println(line);
	}

	public void printPlayer() {
		String line = ("Player Information: " + NL + "-Race: " + subrace + " " + race + NL + "-Name: " + name + NL
				+ "-Health = " + hp + NL + "-Gold = " + gold + NL + "-Level: " + level + NL + "XP = " + xp);

		System.out.println(line);
	}

}
