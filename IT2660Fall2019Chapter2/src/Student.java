public class Student {
	
	private String name;
	private String address;
	private String number;
	
	public Student(String n, String a, String num) {		
		name = n;
		address = a;
		number = num;		
	}
	
	public Student() {		
		name = "";
		address = "";
		number = "";		
	}
	
	//public String getName() {		
		//return this.name;		
	//}
	/*
	public void setName(String n) {
		this.name = n;
	}
	
	public void setAddress(String a) {
		this.address = a;
	}
	
	public void setNumber(String num) {
		this.number = num;
	}
	*/
	
	public void collectInfo(String n, String a, String num) {
		this.name = n;
		this.address = a;
		this.number = num;
	}
	
	public void clearInfo() {
		this.name = "";
		this.address = "";
		this.number = "";
	}
	
	@Override
	public String toString() {		
		return "Name is " + name + "." +
				"\nAddress is " + address + "." +
				"\nNumber is " + number + ".\n";		
	}
	
	public Student deepCopy() {		
		Student clone = new Student(name, address, number);
		return clone;		
	}
	
	
	public int compareTo(String targetKey) {		
		return(this.name.compareTo(targetKey));		
	}
}
