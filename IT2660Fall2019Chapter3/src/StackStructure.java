public class StackStructure {

    private char[] data;
    private int top;
    private int size;

    public StackStructure() {
        top = -1;
        size = 100;
        data = new char[100];
    }

    public StackStructure(int n) {
        top = -1;
        size = n;
        data = new char[n];
    }

    public boolean push(char newNode) {
        if(top == size - 1)
            return false; // ** overflow **
        else {
            top = top + 1;
            data[top] = newNode;
            return true;
        }
    }

    public char pop() {
        int topLocation;
        char s = '\0';
        if(top == -1) {
            return s;// ** underflow **
        } else {
            topLocation = top;
            top = top - 1;
            return data[topLocation];
        }
    }









}
