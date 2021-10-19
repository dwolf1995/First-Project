
package battle_pack;

import java.util.Scanner; //method to retrieve input

import javax.swing.JOptionPane;
/**
 * This code is a sample program to 
 * show the concepts I can achieve thus far
 *
 */

public class Maincode {
	static int EnemyHP;
	static int UserHP110; // setup hit points with the user having advantage
	static int Damage;
	static Scanner keyboard = new Scanner(System.in); // create input
	
	Dice_roll d= new Dice_roll(); //pulled in class for the dice roll

	/**
	 * 
	 */
	public int Attack(int HP, int Damage) { 
		HP = HP - Damage;
		return HP;
	}
	public int GetDamage() {
		Damage = d.diceRoll();
		return Damage;
	}
	public int GetHP(int HP) {
		if (HP <= 0) { 
			HP = 100;
			System.out.println("HP reset with method");
		}
		return HP;
	}
	public String GetText(String s, String n) {
		s = s + "\n" + n;
		return s;
	}
	public int GetWins(int WinCount) {
		WinCount++;
		return WinCount;
	}
	public String GetName() {
		String Name = JOptionPane.showInputDialog("What would you like your name to be?");
		return Name;
	}
	}