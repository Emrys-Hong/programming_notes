package first_java_tut;

import java.util.Scanner;
import java.util.*;
public class Animal {
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public boolean isHasOwner() {
		return hasOwner;
	}
	public void setHasOwner(boolean hasOwner) {
		this.hasOwner = hasOwner;
	}
	public byte getAge() {
		return age;
	}
	public void setAge(byte age) {
		this.age = age;
	}
	public long getUniqueID() {
		return uniqueID;
	}
	public void setUniqueID(long uniqueID) {
		this.uniqueID = uniqueID;
		System.out.println("Unique ID set to:" + this.uniqueID);
	}
	public void setUniqueID(){
		long minNumber = 1;
		long maxNumber = 1000000;
		
		// you want to cast your dataset to a position
		this.uniqueID = minNumber + (long) (Math.random() * ((maxNumber - minNumber) + 1));
		
		String stringNumber = Long.toString(maxNumber);
		int numberString = Integer.parseInt("this is a string");
		System.out.println("Unique ID set to: " + this.uniqueID);
		
	}
	public char getFavouriteChar() {
		return favouriteChar;
	}
	
	public void setFavouriteChar(char favouriteChar) {
		this.favouriteChar = favouriteChar;
	}
	
	public void setFavouriteChar(){
		int randomNumber = (int) (Math.random() * 126) + 1;
		
		this.favouriteChar = (char) randomNumber;
		
		if (randomNumber == 32){
			System.out.println("Favorite character set to Space");
			
		}else if (randomNumber == 10){
			System.out.println("Favourite character set to a Newline");
			
		}else{
			System.out.println("Favourite character set to: " + this.favouriteChar);
			
		}
		if ((randomNumber > 97) && (randomNumber < 122)){
			System.out.println("Favourite character is a lowercase letter");
			
		}
		if (((randomNumber > 97) && (randomNumber < 122)) || ((randomNumber>64) && (randomNumber < 91))){
			System.out.println("Favourite character is a lowercase letter");
			
		}
		
		int whichIsBigger = (50 > randomNumber)? 50 : randomNumber;
		
		switch(randomNumber){
			case 8:
				System.out.println("Favourite character set to backspace");
				break;
			case 10:
			case 11:
			case 12:
				System.out.println("Favourite character set to backspace");
			
			default:
				System.out.println("default");
				break;
		}
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	
	
	protected static void countTo(int startingNumber){
		for (int i = startingNumber; i<= 100; i++){
			if (i==90) continue;
			System.out.println(i);
			// this is not gonna to print the 90
		}
	}
	// this is how the for loop works
	
	protected static String printNumbers(int maxNumbers){
		int i = 1;
		while (i < (maxNumbers/2)){
			System.out.println(i);
			i++;
			if (i == (maxNumbers/2)) break;
		}
		Animal.countTo(maxNumbers/2);
		
		return "End of printNumbers";
	}
	
	protected static void guessMyNumber(){
		int number;
		do {
			System.out.println("Guess number up to 1800");
			while(!userInput.hasNextInt()){
				String numberEntered = userInput.next();
				System.out.printf("%s is not a number", numberEntered);
			}
			number = userInput.nextInt();
			
		}while(number != 50);
	}
	
	public String makeSound(){
		
		return "Grrrr";
	}
	
	public static void speakAnimal(Animal randAnimal){
		System.out.println("Animal says: " + randAnimal.makeSound());
	}
	
	public static void main(String[] args) {
		Animal theAnimal = new Animal();
		
		int[] favoriteNumbers;
		favoriteNumbers = new int[20];
		
		String[] stringArray = {"Random", "Words", "Here"};
		
		for (String word: stringArray){
			System.out.println(word);
		}
		
		String[][][] arrayName = { { {"000"}, {"100"}, {"200"} }, { {"010"}, {"020"}, {"110"}, {"210"} } };
		
		for (int i = 0; i < arrayName.length; i++){
			for (int j = 0; j < arrayName.length; j++){
				for (int k = 0; k < arrayName[i][j].length; k++){
					
					System.out.println("| " + arrayName[i][j][k] + " ");
				}
			}
		}
		
		String[] cloneOfArray = Arrays.copyOf(stringArray, 3);
		System.out.println(Arrays.toString(cloneOfArray));
		System.out.println(Arrays.binarySearch(cloneOfArray, "Random"));
		
	}
	public static final double FAVNUMBER = 1.618;
	
	// variables can start off with _ letter or % 
	private String name;
	private int weight;
	private boolean hasOwner = false;
	private byte age;
	private long uniqueID;
	private char favouriteChar;
	private double speed;
	private float height;
	// double is 64 bit and float is 32 bit
	protected static int numberOfAnimals = 0;
	// only for this class can access protected
	
	static Scanner userInput = new Scanner(System.in);
	// user input
	public Animal() {
		numberOfAnimals++;
		
		int sumOfNumbers = 5 + 1;
		System.out.println("5 + 1 = " + sumOfNumbers);
		
		System.out.print("Enter the name: \n");
		
		// hasNextLine is only gonna to return true if user have input string
		// has NextInt
		// has NextDouble
		// has NextFloat
		// has NextBoolean
		// has NextByte
		
		// to get the value of the input
		// nextInt, nextFloat, nextDouble
		if (userInput.hasNextLine()){
			this.setName(userInput.nextLine());
			
		}
		
		this.setFavoriteColor();
		this.setUniqueID();
	}
	public static void main(String[] args){
		Animal theAnimal = new Animal();
	}
	// this makes it a java 
	// we do not need to create the super because we do not want inhereted
	
	
	

}
