package mySecondTut;
// abstract class: which methods does not neccessarily need to use the varible
public class Crashable {
	boolean carDrivable = true;
	// the value can change in the abstract class
	public void youCrashed()
	{
		this.carDrivable = false;
	}
	
	public abstract void setCarStrength(int carStrength);
	
	public abstract void getCarStrength();
}
