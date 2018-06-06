package mySecondTut;

public class javaLessonSeven {
	public static void main(String[] args){
		Monster Frank = new Monster();
		Frank.name = "Frank";
		System.out.println(Frank.attack); // attack is not visible
		System.out.println(Frank.getAttack());
	}

}
