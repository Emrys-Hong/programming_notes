package mySecondTut;
// create classes

public class Monster{
	// one file cannot have two public classes
	// class name begin with a Capital letter
	public final String TOMBSTONE = "Here lies a dead monster";
	
	private int health = 500;
	private int attack = 20;
	private int movement = 2;
	private int xPosition = 0;
	private int yPosition = 0;
	private boolean alive = true;
	
	public String name = "Big Monster";
	
	// getter for attack
	public int getAttack(){
		return attack;
	}
	public void setHealth(int decreaseHealth){
		health -= decreaseHealth;
		if (health < 0){
			alive = false;
		}
	}
	
	public void setHealth(double decrease){
		// if the overloading attribute is not the same it can over load and can only overload in this way
		int intDecreaseHealth = (int) decrease;
		health -= intDecreaseHealth;
		if (health < 0){
			alive = false;
		}
	}
	
	// something like init in python
	public Monster(int newHealth, int newAttack, int newMovement){
		// do not need void here
		this.health = newHealth;		 // this avoids confusion this is just for this class.
		this.attack = newAttack;
		this.movement = newMovement;
	}
	// default constructor
	public Monster(){
		
	}
	
	// the below is just showing another usage for this
	
//	public Monster(int newHealth){
//		health = newHealth;
//	}
//	
//	
//	public Monster(int newHealth, int newAttack){
//		this(newHealth);			// this refer to the class with only one varaible now which is above
//		attack = newAttack;
//	}
	
	// this is not wrong but this is a function that is inside the Monster class function
	public static void main(String[] args){
		Monster Frank = new Monster();
		System.out.println(Frank.attack);
		
	}
	
}