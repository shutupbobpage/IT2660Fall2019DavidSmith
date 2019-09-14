public class USOArray {
	
	private int next;
	private int size;	
	private Student[] data;
	
	public USOArray() {
		next = 0;
		size = 100;
		data = new Student[size];
	}
	
	public USOArray(int n) {
		next = 0;
		size = n;
		data = new Student[size];		
	}
	
	public boolean insert(Student newNode) {
		//if structure is full
		if (next >= size) {
			System.out.println("Error: Data Structure full.");
			return false; 
		}		
		data[next] = newNode.deepCopy(); //store deep copy in client's node
		//insufficient system memory
		if (data[next] == null) {
			System.out.println("Error: Insufficient system memory.");
			return false;
		}
		next = next + 1; //prepare for next insert
		System.out.println(newNode.toString());
		return true; //the node was inserted		
	}
	
	public Student fetch(String targetKey) {
		Student node;
		Student temp;	
		//access node using sequential search
		int i = 0;		
		while (i < next && !(data[i].compareTo(targetKey) == 0)) {
			i++;			
		}
		//node not found
		if (i == next) {
			System.out.println("Error: Student not found.");
			return null;
		}
		
		node = data[i].deepCopy(); //deep copy into client node
		//move node up one position in array, unless first node
		if (i != 0) { //bubble up accessed node
			temp = data[i - 1];
			data[i - 1] = data[i];
			data[i] = temp;
		}
		return node;
	}
	
	public boolean delete(String targetKey) {
		int i = 0; //access node using sequential search
		while (i < next && !(data[i].compareTo(targetKey) == 0)) {
			i++;
		}
		if (i == next) {
			System.out.println("Error: Student not found.");
			return false; //node not found
		}
		data[i] = data[next - 1]; //move the last node into deleted node's position
		data[next - 1] = null;
		next = next - 1;
		return true; //node found and deleted
	}
	
	public boolean update(String targetKey, Student newNode) {
		if (delete(targetKey) == false) { //node not in structure
			return false;
		}
		else if (insert(newNode) == false) {
			return false; // insufficient memory
		}
		else {
			return true; //node found and updated
		}
	}
	
	public void showAll() {
		System.out.println("Array Capacity: " + data.length + "\n");
		for (int i = 0; i < next; i++) {
			System.out.println(data[i].toString());
		}
	}
}
