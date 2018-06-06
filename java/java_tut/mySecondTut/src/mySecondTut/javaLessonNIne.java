package mySecondTut;

import java.util.Arrays;

public class javaLessonNIne {
	public static void main(String[] args){
		int[] randomArray;
		int[] numberArray = new int[10];
		
		randomArray = new int[20];
		randomArray[1] = 2;
		
		String[] stringArray = {"just","random","words"};
		
		for(int i = 0; i < numberArray.length; i++){
			numberArray[i] = i;
		}
		
		int k = 1;
		while(k <= 41){System.out.print('-'); k++;}
		System.out.println();
		
		for(int j = 0; j < numberArray.length; j++){
			System.out.print("| " + j + "| ");
		}
		System.out.println("|");
		
		String[][] multiArray = new String[10][10];
		
		for(int i = 0; i < multiArray.length; i++){
			for(int j=0; j<multiArray[i].length; j++){
				multiArray[i][j] = i + " " + j;
				
			}
		}
		k = 1;
		while(k <= 41){System.out.print('-'); k++;}
		System.out.println();
		
		for(int i = 0; i < multiArray.length; i++){
			for(int j=0; j<multiArray[i].length; j++){
				System.out.print("| " + multiArray[i][j] + "| ");
				
			}
			System.out.println();
		}
		
		k = 1;
		while(k <= 41){System.out.print('-'); k++;}
		System.out.println();
		
		for(int row : numberArray){
			System.out.print(row);
			
		}
		System.out.println("\n");
		
		// for(datatype[] varForRow : arrayName)
		for(String[] rows : multiArray){
			
			for(String column : rows){
				System.out.print("| " + column + "| ");
			}
			System.out.println("|");
		}
		
		int[] numberCopy = Arrays.copyOf(numberArray, 5);  		// copy the first five space from the array
		// there is also a Array.copyOfRange(numberArray, 3, 6)
		
		//array to string
		System.out.println(Arrays.toString(numberCopy));
		
		
		// fill in the array
		
		char[][] boardGame = new char[10][10];
		for(char[] row : boardGame){
			
				
			Arrays.fill(row, '*');
		}
		Arrays.sort(numberArray); 			// this does not return any value but sort the array

		int whereIs50 = Arrays.binarySearch(numberArray, 50); 		// find the index of number 50 return negative value if index is not inside the list
	}
}
