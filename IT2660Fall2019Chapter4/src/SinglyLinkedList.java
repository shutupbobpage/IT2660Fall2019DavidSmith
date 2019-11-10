public class SinglyLinkedList {

    //Header
    private Node h;

    //Constructor
    public SinglyLinkedList() {
        h = new Node();
        h.l = null;
        h.next = null;
    }

    //Insert
    public boolean insert(Student newStudent) {
        Node n = new Node();
        if (n == null){
            return false;
        }
        else {
            n.next = h.next;
            h.next = n;
            n.l = newStudent.deepCopy();
            return true;
        }
    }

    //Fetch
    public Student fetch(String targetKey) {
        Node p = h.next;
        while (p != null && !(p.l.compareTo(targetKey) == 0)) {
            p = p.next;
        }
        if (p != null) {
            return p.l.deepCopy();
        }
        else {
            return null;
        }
    }

    //Delete
    public boolean delete(String targetKey) {
        Node q = h;
        Node p = h.next;
        while (p != null && !(p.l.compareTo(targetKey) == 0)) {
            q = p;
            p = p.next;
        }
        if (p != null) {
            q.next = p.next;
            return true;
        }
        else {
            return false;
        }
    }

    //Update
    public boolean update(String targetKey, Student newStudent) {
        if (delete(targetKey) == false) {
            return false;
        }
        else if (insert(newStudent) == false) {
            return false;
        }
        else {
            return true;
        }
    }

    //Show All
    public void showAll() {
        Node p = h.next;
        while (p != null) {
            System.out.println(p.l.toString());
            p = p.next;
        }
    }

    //Inner Class Node
    public class Node {
        private Student l;
        private Node next;
        public Node() {

        }
    }
    /*instructor code



    private Student root;
    private Student last;
    private int size;

    public SinglyLinkedList(Student student) {
        root = student;
        last = student;
        size = 1;
    }

    //Insertion
    public void insertNodeAtPosition(Student student, int position) {
        if(position == 0) insertNewRoot(student);
        else if(position == size) append(student);
        else insert(student, position);
    }
    private void insertNewRoot(Student student) {
        student.setNextStudent(root);
        root = student;
        size++;
    }
    private void append(Student student) {
        last.setNextStudent(student);
        last = student;
        size++;
    }
    private void insert(Student student, int index) {
        Student targetStudent = getStudent(index, false);
        student.setNextStudent(targetStudent.getNextStudent());
        targetStudent.setNextStudent(student);
        size++;
    }

    //Fetching

    public void fetch(String targetKey) {
        Student p = root;
        while(p != null && (last.compareTo(targetKey)) == 0) {
            p = last;
        }


    }

    //Deleting


    //Printing
    public void print() {
        System.out.println("List size: [" + size + "] (includes root node)\n\n");
        getStudent(size, true);
    }

    private Student getStudent(int position, boolean shouldPrint) {
        Student walker = root;

        //"<" used for 'i < position' instead of "<=" because I don't want the root node to display on printing
        for (int i = 1; i < position; i++) {
            if(shouldPrint) {
                System.out.print(walker.toString() + "");
            }
            walker = walker.getNextStudent();
        }
        return walker;
    }


    end instructor code
     */
}
