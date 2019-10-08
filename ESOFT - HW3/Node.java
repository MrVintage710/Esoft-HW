public class Node {
    public Node parent, right, left;
    public int value;

    public Node(int value) {
        this.value = value;
    }

    //Helper methods to make tree creation less tedious, non neccisary for full functionality.
    public Node addLeft(int value) {
        this.left = new Node(value);
        left.parent = this;
        return this.left;
    }

    public Node addRight(int value) {
        this.right = new Node(value);
        right.parent = this;
        return this.right;
    }
}

class Driver {
    
    public static void main(String[] args) {
        //This creates a binary tree with one root node with a value 100 and 2 leaf nodes with values both being 10
        Node tree = new Node(100).addLeft(10).parent.addRight(10).parent;

        //Getting the first right child, or address "1"
        System.out.println(tree.right.value);
    }
}