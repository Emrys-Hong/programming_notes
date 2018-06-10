package mySecondTut;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

public class javaLessonEleven {
	public static void main(String[] args) {
		ArrayList arrayListOne;
		arrayListOne = new ArrayList(); // array list can have any type in the array list
		ArrayList arrayListTwo = new ArrayList();
		
		ArrayList<String> names = new ArrayList<String>(); // a list can only accept strings
		names.add("Hong Pengfei");
		names.add("Gao Yunyi");
		names.add("cato");
		names.add(0, "perro"); // insert the index into a specific place
		names.set(0, "perro");
		names.remove(3);
		// names.removeRange(0, 1); this method seems not to work
		for(int i=0; i < names.size(); i++) // list.size to get all the values inside
		{
			System.out.println(names.get(i));
		}
		System.out.println(names);
		
		for(String i: names)
		{
			System.out.println(i);
		}
		
		Iterator indivItems = names.iterator();
		
		while(indivItems.hasNext())
		{
			System.out.println(indivItems.next());
		}
		
		ArrayList nameCopy = new ArrayList(); // ArrayList and Array is two different datatypes
		ArrayList nameBackup = new ArrayList();
		
		nameCopy.addAll(names);  // copy the names to name copy
		String paulYoung = "Paul Young";
		
		names.add(paulYoung);
		
		if(names.contains(paulYoung))
		{
			System.out.println("paul is here");
		}
		
		if (nameCopy.contains(paulYoung))
		{
			System.out.println("paul is in nameCopy also");
		} // this will give you a result no because paul young is not here
		
		if(names.containsAll(nameCopy))
		{
			System.out.println("everything in nameCopy is in name");
		} // see if namecopy contains everything in names
		
		names.clear();

		if(names.isEmpty())
		{
			System.out.println(names.isEmpty());
		}
		
		Object[] moreNames = new Object[4]; // object datatype
		System.out.println(moreNames);
		
		System.out.println();
		System.out.println(nameCopy);
		System.out.println(nameCopy.toArray());
		System.out.println();
		moreNames = nameCopy.toArray();
		
		System.out.println(Arrays.toString(moreNames));
		
		
	}
}
