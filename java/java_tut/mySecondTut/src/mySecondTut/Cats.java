package mySecondTut;

public class Cats extends Animals{
	public String favToy = "yarn";
	public void playWith()
	{
		System.out.println("yeah" + favToy);
	}
	// the walk around method is not final so it can be implemented as final
	public void walkAround()
	{
		System.out.println(this.getName() + "stalks around");
	}
	
	public String getToy()
	{
		return this.favToy;
	}
	
	public Cats()
	{
		
	}
	
	public Cats(String name, String favFood, String favToy)
	{
		super(name,favFood);
		this.favToy = favToy;
	}
}
