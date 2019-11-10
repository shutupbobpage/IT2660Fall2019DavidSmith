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
}
