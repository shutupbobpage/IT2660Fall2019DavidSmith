import java.util.Scanner;

//IT2660 - Data Structures and Algorithms
//Fall 2019
//David Smith S01208193
//Chapter 2
//Assignment 2
//Exercises 19, 20, 21

public class Main {

	public static void main(String[] args) {
		
		//Driver Program for Exercise 19
		
		/*
		Student Test19A;
		Test19A = new Student();
		System.out.println(Test19A.toString());
		
		Student Test19B;
		Test19B = new Student("Jack", "111 Main St.", "111-111-1111");
		System.out.println(Test19B.toString());
		System.out.println(Test19B.getName());
		
		Student Test19C;
		Test19C = new Student();
		Test19C.input();
		System.out.println(Test19C.toString());
		*/
		
		//Program for Exercise 21, showing Exercise 20 was implemented correctly
		
		//Scanners
		Scanner dataSc =  new Scanner(System.in);	
		Scanner menuSc = new Scanner(System.in);		
		
		//Greeting
		System.out.println("Exercise 21: Student Database Implementation Test\n\n"
				+ "Please enter an integer for maximum size data set:\n");
		
		//Force Integer Entry
		while(!menuSc.hasNextInt()) {
			menuSc.next();
			System.out.println("Entry error.");
		}
		
		//User-Determined Array Capacity
		int size = menuSc.nextInt();				
		
		//Sorted Array Initialization
		SortedArray studentSortedList = new SortedArray(size);
		
		//USO Array Initialization
		/*
		USOArray studentUSOList = new USOArray(size);
		Student temp = new Student();// = new Student("test", "test1", "test1");
		*/			
		
		//Main Menu		
		while (1 == 1) {
			System.out.println("Main Menu\n"
					+ "Please choose from one of the following options:\n"
					+ "1) Insert new Student information\n"
					+ "2) Fetch and output Student information\n"
					+ "3) Delete Student information\n"
					+ "4) Update Student information\n"
					+ "5) Output all student information\n"
					+ "6) Exit Program\n");
			
			//Force Integer Entry
			while(!menuSc.hasNextInt()) {
				menuSc.next();
				System.out.println("Entry error.");
			}
			
			//Option Selection
			int option = menuSc.nextInt();
			
			//Main Menu Options
			switch (option) {
			
				//Insert
				case 1: {					
					String[] info = new String[3];
					
					//Name Entry - "" not allowed
					while (1 == 1) {
						System.out.println("Please enter Student name:");
						info[0] = dataSc.nextLine(); //targetKey
						//Block "" Entry
						if (!(info[0].compareTo("") == 0)) {
							break;
						}
						System.out.println("Entry Error: Student needs name.");						
					}
					
					//Address Entry - "" allowed
					System.out.println("Please enter address:");
					info[1] = dataSc.nextLine();
					
					//Phone Number Entry - "" allowed
					System.out.println("Please enter phone number:");
					info[2] = dataSc.nextLine();
					
					//SortedArray Insert				
					if (studentSortedList.sortedInsert(info[0], info[1], info[2]) == false) {
						System.out.println("Insert failed. Please press Return/Enter to continue.");
						dataSc.hasNextLine();
						break;
					}
					
					//USOArray Insert
					/* 
					temp.collectInfo(info[0], info[1], info[2]);
					if (studentUSOList.insert(temp) == false) { 
						System.out.println("Insert failed. Please press Return/Enter to continue.");
						dataSc.nextLine();
						break;
					}
					temp.clearInfo();
					*/
					
					System.out.println("Student added!\n"
							+ "Please press Return/Enter to continue.");					
					dataSc.nextLine();										
					break;
				}
						
						
				//Fetch
				case 2: {
					System.out.println("Please enter Student name:");
					String targetKey = dataSc.nextLine();
					
					//Sorted Array Fetch
					if (studentSortedList.sortedFetch(targetKey) == null) {
						System.out.println("Fetch failed. Please press Return/Enter to continue.");
						dataSc.nextLine();
						break;
					}
					System.out.println(studentSortedList.sortedFetch(targetKey).toString());
					
					//USO Array Fetch
					/*
					if (studentUSOList.fetch(targetKey) == null) {
						System.out.println("Fetch failed. Please press Return/Enter to continue.");
						dataSc.nextLine();
						break;
					}
					*/
					
					System.out.println("Please press Return/Enter to continue.");
					dataSc.nextLine();
					break;
				}
						
				//Delete
				case 3: {
					System.out.println("Please enter Student name:");
					String targetKey = dataSc.nextLine();
					
					//Sorted Array Delete
					if (studentSortedList.sortedDelete(targetKey) == false) { 
						System.out.println("Delete failed. Please press Return/Enter to continue.");
						dataSc.nextLine();
						break;
					}
					
					//USO Array Delete
					/*
					if (studentUSOList.delete(targetKey) == false) { 
						System.out.println("Delete failed. Please press Return/Enter to continue.");
						dataSc.nextLine();
						break;
					}
					*/
					
					System.out.println(targetKey + " deleted.\n"
							+ "Please press Return/Enter to continue.");
					dataSc.nextLine();
					break;
				}
						
				//Update
				case 4: {
					String[] info = new String[3];
					System.out.println("Please enter Student name:");
					info[0] = dataSc.nextLine(); //targetKey
					System.out.println("Please enter Address update:");
					info[1] = dataSc.nextLine();
					System.out.println("Please enter Number update:");
					info[2] = dataSc.nextLine();
					
					
					//Sorted Array Update
					if (studentSortedList.sortedUpdate(info[0], info[1], info[2]) == false) {
						System.out.println("Update failed. Please press Return/Enter to continue.");
						dataSc.nextLine();
						break;
					}
					
					//USO Array Update
					/*
					temp.collectInfo(info[0], info[1], info[2]);
					if (studentUSOList.update(info[0], temp) == false) {
						System.out.println("Update failed. Please press Return/Enter to continue.");
						temp.clearInfo();
						dataSc.nextLine();
						break;
					}
					*/
					
					System.out.println("Update for student " + info[0] + " successful!\n"
							+ "Please press Return/Enter to continue.");
					dataSc.nextLine();
					break;
				}
						
				//Output All
				case 5: {
					
					//Sorted Output
					studentSortedList.sortedShowAll();
					
					//USOArray Output
					/*
					studentUSOList.showAll();
					*/					
					
					System.out.println("Please press Return/Enter to continue.");
					dataSc.nextLine();
					break;
				}
						
				//Program Exit
				case 6: {
					System.out.println("Exiting program. Have a good day!");
					menuSc.close();
					dataSc.close();
					System.exit(0);
				}
				
				//Main Menu Entry Error
				default: {
					System.out.println("Entry error.");	
				}			
			}
		}		
	}
}
