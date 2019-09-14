public class SortedArray {
	
	private int next;
	private int size;	
	private Student[] data;
	
	public SortedArray() {
		next = 0;
		size = 100;
		data = new Student[size];
	}
	
	public SortedArray(int n) {
		next = 0;
		size = n;
		data = new Student[size];
	}
	
	public boolean sortedInsert(String targetKey, String address, String number) {
		
		
		
		
		//Array Full
		if (next == data.length) {
			System.out.println("Array full. Please delete a student before inserting a new one.");
			return false;			
		}
		
		//Fill 1st Node
		if (data[0] == null) {
			data[0] = new Student(targetKey, address, number).deepCopy();
			next = next + 1;
			return true;
		}
		
		//Fill 2nd Node
		if (data[1] == null) {			
			if (data[0].compareTo(targetKey) < 0) {
				data[1] = new Student(targetKey, address, number).deepCopy();
				next = next + 1;
				return true;
			}
			else {
				data[1] = data[0].deepCopy();
				data[0] = null;
				data[0] = new Student(targetKey, address, number).deepCopy();
				next = next + 1;
				return true;
			}		
		}
		
		//Fill 3rd Node
		if (data[2] == null) {			
			if (data[1].compareTo(targetKey) > 0) {
				data[2] = data[1].deepCopy();
				if (data[0].compareTo(targetKey) > 0) {
					data[1] = data[0].deepCopy();
					data[0] = new Student(targetKey, address, number).deepCopy();					
					next = next + 1;
					return true;				
				}					
				data[1] = new Student(targetKey, address, number).deepCopy();
				next = next + 1;
				return true;
			}
			data[2] = new Student(targetKey, address, number).deepCopy();
			next = next + 1;
			return true;					
		}		
		
		//Sorted Array algorithm can be used with 3 or more nodes initially present		
		//assumes targetKey is the key of the node to be inserted
		//find the node's place in sorted order using a binary search
		
		//As written, must use if loop for (targetKey > data[max value].key)
		//As written, must use breaks for (targetKey < data[min value].key)
		
		int low = 0;
		int high = next - 1;
		int i = (low + high)/2;
		
		//Insert in last position if key is greater than greatest array value
		if (data[high].compareTo(targetKey) < 0) {
			data[next] = new Student(targetKey, address, number).deepCopy();
			next = next + 1;
			return true;
		}
		else if (data[high].compareTo(targetKey) == 0) {
			System.out.println("Error: Student already exists. Delete or Update instead.");			
			return false;
		}
		
		//Search
		while (!((data[i].compareTo(targetKey) > 0) && (data[i - 1].compareTo(targetKey) < 0))) {
			if (data[i].compareTo(targetKey) > 0) {
				high = i - 1;
			}
			else {				
				low = i + 1;				
			}
			i = (high + low)/2;
			
			//Seems to be needed, otherwise array goes out of bounds if key smaller than smallest array value
			if (i == 0) {
				break;
			}			
		}
		
		//Block overwrite, delete or update should be used.
		if ((data[i].compareTo(targetKey) == 0)) {
			System.out.println("Error: Student already exists. Delete or Update instead.");
			return false;
		}
		
		//Move all the nodes down to "open up" a spot for the new node
		for (int j = next; j >= i; j--) {
			if (j == 0)
				break;
			data[j] = data[j - 1];
		}
		next = next + 1;
		
		//Add a deep copy of the new node to the structure
		data[i] = new Student(targetKey, address, number).deepCopy();
		return true;
	}
	
	public Student sortedFetch(String targetKey) {	
		
		//Check to see if any students present in array
		if (next == 0) {
			System.out.println("No students in array, please insert at least one student first.");
			return null;
		}
		
		//Search
		int low = 0;
		int high = next - 1;
		int i = (low + high)/2;
		
		while (data[i].compareTo(targetKey) != 0) {
			if ((data[i].compareTo(targetKey) > 0) && (high != low)) {
				high = i - 1;
			}
			else {
				low = i + 1;			
			}
			i = (low + high)/2;
			if (high < 0 || low > high) {
				break;				
			}			
		}
		
		//Student not found
		if (data[i].compareTo(targetKey) != 0) {
			System.out.println ("Student not found.");
			return null;
		}	
		
		//Fetch successful
		return data[i].deepCopy();		
	}
	
	public boolean sortedDelete(String targetKey) {
		
		//Search		
		int low = 0;
		int high = next - 1;
		int i = (low + high)/2;
		
		while ((data[i].compareTo(targetKey) != 0) && (high != low)) {
			if ((data[i].compareTo(targetKey)) > 0) {
				high = i - 1;
			}
			else {
				low = i + 1;
			}
			i = (low + high)/2;
			if (high < 0 || low > high) {
				break;				
			}	
		}
		
		//Student not found
		if ((data[i].compareTo(targetKey) != 0)) {
			System.out.println ("Student not found.");
			return false;
		}
		
		//Move all the references up to delete the node and collect the garbage
		for (int j = i; j < next - 1; j++) {
			data[j] = data[j + 1];
		}
		next = next - 1;
		data[next] = null;
		return true;
	}
	
	public boolean sortedUpdate(String targetKey, String address, String number)  {
		//Node not in Structure
		if (sortedDelete(targetKey) == false) {
			return false;
		}
		//Insufficient Memory
		else if (sortedInsert(targetKey, address, number) == false) {
			return false;
		}
		//Node found and updated
		else {
			return true;
		}	
	}
	
	public void sortedShowAll() {
		System.out.println("Array Capacity: " + data.length + "\n"
				+ "Number of students: " + next + "\n");
		for (int i = 0; i < next; i++) {
			if (data[i] == null) {
				break;
			}
			System.out.println(data[i].toString());
		}
	}	
}
