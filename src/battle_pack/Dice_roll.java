package battle_pack;

public class Dice_roll {
	public int diceRoll() {
		int roll = 0;
		int max = 10;
		int min = 1;
		int range = max - min + 1;
		for (int i = 0; i < 10; i++) {
			int rand = (int)(Math.random() * range) + min;
			roll = rand;
		}
		return roll;
	}

	public Dice_roll() {
		// TODO Auto-generated constructor stub
		
	}

}
