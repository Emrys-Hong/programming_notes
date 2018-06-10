package mySecondTut;

public class JavaLessonFourteen {
	public static void main(String[] args)
	{
		Animals genericAnimal = new Animals();
		System.out.println(genericAnimal.getName());
		System.out.println(genericAnimal.favFood);
		
		Cats morris = new Cats("Morris", "Tuna", "Rubber Mouse");
		
		System.out.println();
		
		System.out.println(morris.getName());
		System.out.println(morris.favFood);
		System.out.println(morris.favToy);
		
		Animals tabby = new Cats("Tabby", "Salmon", "Ball"); // every class is an animal so here the type can be animal
		
		acceptAnimal(tabby);
	}
	
	public static void acceptAnimal(Animals randAnimal)
	{
		System.out.println();
		System.out.println(randAnimal.getName());
		System.out.println(randAnimal.favFood);
		
		System.out.println();
		randAnimal.walkAround();
		// polymorphism says that if the class belongs to the subclass and whether the method needs to be overwrite
		// polymorphism accepts overwrite but it does not accept undefined
		
		Cats tempCat = (Cats) randAnimal; // cast the animal to the cats class
		System.out.println(tempCat.favToy);
		System.out.println(randAnimal instanceof Animals);
		System.out.println(tempCat instanceof Cats);
	}
	
	
}
