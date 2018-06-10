package mySecondTut;

public  class Vehicle extends Crashable implements Drivable{
	// must contains all the things in the Drivable coz i will implement that later
	int numOfWheels = 2;
	double theSpeed = 0;
	
	int carStrength = 0;
	
	public int getWheel()
	{
		return this.numOfWheels;
	}
	
	public void setWheels(int numWheels)
	{
		this.numOfWheels = numWheels;
	}
	
	public double getSpeed() {
		return this.theSpeed;
	}
	
	public void setSpeed(double Speed)
	{
		this.theSpeed = Speed;
	}
	
	// always define the constructor
	public Vehicle(int Wheels, double Speed)
	{
		this.numOfWheels = Wheels;
		this.theSpeed = Speed;
	}
	
	public void setCarStrength(int carStrength)
	{
		this.carStrength = carStrength;
	}
	
	public int getCarStrength()
	{
		return this.carStrength;
	}
	
	
}
