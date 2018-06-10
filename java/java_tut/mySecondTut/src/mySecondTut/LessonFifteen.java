package mySecondTut;

public class LessonFifteen {
	public static void main(String[] args) {
		Vehicle car = new Vehicle(4, 1000);
		
		System.out.println("speed" + car.getSpeed());
		System.out.println("Num of wheels" + car.getWheel());
		
		car.setCarStrength(10);
		System.out.println(car.getCarStrength());
	}
}
