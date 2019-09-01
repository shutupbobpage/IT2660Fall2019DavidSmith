import java.util.Scanner;


//IT2660 - Data Structures and Algorithms
//Fall 2019
//David Smith S01208193
//Chapter 1
//Assignment 1
//Exercises 41, 42


public class Main {

	public static void main(String[] args) {
		
		//Exercise 41.
		System.out.println("Exercise 41.\n");
		
		Listing list1;
		list1 = new Listing("Joe", 20);		
		
		Listing list2;
		list2 = new Listing();
		
		Listing list3;
		list3 = new Listing();
		
		Listing list4;
		list4 = new Listing("Jack", 50);
		
		
		System.out.println(list1.toString());
		System.out.println(list2.toString());
		
		Scanner keyboard;
		keyboard = new Scanner(System.in);
		
		System.out.println("Set Method Demo: Please enter a name.");
		String sName = keyboard.nextLine();
		System.out.println("Please enter an integer.");
		int sAge = keyboard.nextInt();		
		list2.setName(sName);
		list2.setAge(sAge);
		
		System.out.println(list2.toString());
		
		list3.input();
		System.out.println(list3.toString());
		
		System.out.println("Get Method Demo: This listing's name is " + 
							list4.getName() +
							" and this listing's age is " +
							list4.getAge() + ".\n");
		
		//Exercise 42.
		System.out.println("Exercise 42.\n");
		
		Listing[] listingArray;
		listingArray = new Listing[3];
		
		for(int i = 0; i < listingArray.length; i++) {
			
			listingArray[i] = new Listing();
			listingArray[i].input();
			System.out.println(listingArray[i].toString());
			
		}
		
		System.out.println("End of program.");
		
		
		
		
		
		
		
		
		
		

	}

}
