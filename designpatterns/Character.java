package designpatterns;

public class Character {
	
	WeaponBehavior weapon;
	
	public void fight(){
		weapon.useWeapon();
	}

	public void setWeapon(WeaponBehavior w){
		
		this.weapon = w;
		
	}
}
