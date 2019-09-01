import java.util.Scanner;

public class Listing {
	
	private String name;
	int age;
	
	Listing() {
		
		this.name = "";
		this.age = 0;
		
	}
	
	Listing(String n, int a) {
		
		this.name = n;
		this.age = a;
		
	}
	
	public void input() {		
		
		Scanner inputKB;
		inputKB = new Scanner(System.in);
		
		System.out.println("Input Method Demo: Please enter a name.");
		this.name = inputKB.nextLine();
		System.out.println("Please input an integer.");
		this.age = inputKB.nextInt();
		
	}
	
	public void setName(String n) {
		
		this.name = n;
		
	}

	public void setAge(int a) {
		
		this.age = a;
		
	}
	
	public String getName() {
		
		return this.name;
		
	}
	
	public int getAge() {
		
		return this.age;
		
	}
	
	public String toString() {
		
		return "toString Method Demo: This Listing's name is " + this.name +
				" and this Listing's age is " + this.age +
				".\n";
		
	}
}