package designpatterns;


public class Tester {

	public static void main(String[] args) {
		
		Character c = new King();
		
		c.setWeapon( new KnifeBehavior());
		
		c.fight();
		
		Character c2 = new Queen();
		
		c2.setWeapon( new BowAndArrowBehavior());
		
		c2.fight();
		
		Character c3 = new Troll();
		
		c3.setWeapon( new AxeBehavior());
		
		c3.fight();
		
		Character c4 = new Knight();
		
		c4.setWeapon( new SwordBehavior());
		
		c4.fight();
		
		
		c4.setWeapon(new AxeBehavior());
		c4.fight();
		
		
		c4.setWeapon(new BowAndArrowBehavior());
		c4.fight();

		return;
	}

}
