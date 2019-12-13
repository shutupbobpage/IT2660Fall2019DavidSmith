public class Vertex {

    private boolean pushed;
    private boolean searched;
    private int value;

    public Vertex(int n) {
        value = n;
        searched = false;
        pushed = false;
    }

    public String toString() {
        return ("Value is " + value + ".");
    }

    public void visit() {
        System.out.println(this);
    }

    public Vertex deepCopy() {
        return new Vertex(value);
    }

    public int getValue() {
        return this.value;
    }
    public boolean getPushed() {
        return this.pushed;
    }
    public boolean getSearched() {
        return this.searched;
    }

    public void setSearchedTrue() {
        this.searched = true;
    }
    public void setPushedTrue() {
        this.pushed = true;
    }
    public void resetSearched() {
        this.searched = false;
    }
    public void resetPushed() {
        this.pushed = false;
    }
}


