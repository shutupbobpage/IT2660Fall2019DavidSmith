public class QueueStructure {

    private String[] data;
    private int size;
    private int numOfNodes;
    private int front;
    private int rear;

    public QueueStructure() {
        size = 100;
        numOfNodes = 0;
        front = 0;
        rear = 0;
        data = new String[100];
    }

    public QueueStructure(int n) {
        size = n;
        numOfNodes = 0;
        front = 0;
        rear = 0;
        data = new String[n];
    }

    public boolean enque(String newNode) {
        if(numOfNodes == size)
            return false; // ** overflow **
        else {
            numOfNodes = numOfNodes + 1;
            data[rear] = newNode;
            rear = (rear + 1) % size;
            return true; // ** enque successful **
        }
    }

    public String deque() {
        int frontLocation;
        if(numOfNodes == 0)
            return null;
        else {
            frontLocation = front;
            front = (front + 1) % size;
            numOfNodes = numOfNodes - 1;
            return data[frontLocation];
        }
    }

}
