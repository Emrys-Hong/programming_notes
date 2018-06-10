package mySecondTut;
import java.util.Arrays;
import java.util.LinkedList;
// linked list is easy to append or delete a list at the end of the linked list
// but finding an index is not so easy
public class javaLessonTwelve {
	public static void main(String[] args)
	{
		LinkedList linkedListOne = new LinkedList();
		
		LinkedList<String> names = new LinkedList<String>(); // restricted to string
		
		names.add("Hong Pengfei");
		names.add("Ali syed");
		
		names.addFirst("Peter");
		names.addLast("Pengfei");
		names.add(0, "yunyi");
		names.set(2, "Gao");
		names.remove(2);
		names.remove("Pengfei");
		names.get(2);
		
		System.out.println(names.getLast());
		
		LinkedList<String> nameCopy = new LinkedList<String>(names);
		
		
		System.out.println(names.contains("Pengfei"));
		System.out.println(names.containsAll(nameCopy));
		System.out.println(names.indexOf("Ali syed")); // will return negative if the entry is not inside
		System.out.println(names.isEmpty());
		System.out.println(names.size());
		names.clear();
		System.out.println(names.peek()); // return null if the zeroth element does not exist, otherwise gives the first value
		
		System.out.println(nameCopy.poll()); // retrieve the first element and delete it
		System.out.println(nameCopy.pollLast()); // retrieve the last element and delete it
		
		nameCopy.push("Noah Peters"); // insert Noah peters at the first element
		nameCopy.pop(); // pop off the first element
		
		Object[] nameArray = new Object[5];
		System.out.println(nameArray.length); // the output is 5
		nameArray = names.toArray();
		System.out.println(nameArray.length); // the output is 0
		System.out.println(Arrays.toString(nameArray));
		
		
		
		for(String name:names)
		{
			System.out.println(name);
		}
	}
}
