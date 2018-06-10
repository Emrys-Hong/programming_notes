package mySecondTut;
import java.util.Arrays;

public class JavaLesson13 {
	public static void main(String[] args)
	{
		// if you want to print \ you need to \\ for " you need to \\
		// .equals and .equalsIgnoreCase
		String letters = "abcde";
		System.out.println(letters.charAt(1));
		System.out.println(letters.compareTo("a"));
		System.out.println(letters.contains("a")); // if the letters have more letters it will return a positive value
		System.out.println(letters.endsWith("de")); // returns a boolean type
		System.out.println(letters.indexOf("cd"));  // this return true
		
		// specify the first index you want to start searching
		// indexOf(StringToLookFor, IndexStartPosition);
		
		// specify the last index you want to search
		// lastIndexOf()
		
		// letter.length
		
		System.out.println(letters.replace("abc", "ads")); // will return the answer of the corrected one
		
		String[] letterArray = letters.split(""); // "" means you want to split every char
		System.out.println(letterArray);  // in java, convert the array in to string can print
		System.out.println(Arrays.toString(letterArray));
		
		char[] charArray = letters.toCharArray();
		System.out.println(Arrays.toString(charArray));
		
		System.out.println(letters.substring(1,4)); // this one does not have uppercase
		System.out.println(letters.toUpperCase());
		System.out.println(letters.toLowerCase());
		
		String randString = "   random   ";
		System.out.println("randString.trim()"); // strip the white string in the beginning of the string
		
		StringBuilder randSB = new StringBuilder("a random value");
		System.out.println(randSB.append(" again" )); // this one permenantly changed the string and this is good for edition in the string
		System.out.println(randSB.delete(15, 21));
		System.out.println(randSB.capacity()); // how many space is allocated to the string
		randSB.ensureCapacity(60); // expand the capacity allocated for the string
		
		System.out.println(randSB.length());
		randSB.trimToSize();
		System.out.println(randSB.insert(1, "nother"));
		String oldSB = randSB.toString(); // convert the builder to string
		// charAt() indexOf() lastIndexOf() subString() is the same as the one with substring
		
		
	} 

}
