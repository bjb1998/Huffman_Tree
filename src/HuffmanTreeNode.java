public class HuffmanTreeNode<T> implements Comparable<T>{

    HuffmanTreeNode<T> left;
    HuffmanTreeNode<T> right;
    T nodeChar;
    T count;

    HuffmanTreeNode(T nodeChar, T count){
        this.left = null;
        this.right = null;
        this.nodeChar = nodeChar;
        this.count = count;
    }

    HuffmanTreeNode(HuffmanTreeNode<T> left, HuffmanTreeNode<T> right, T count){
        this.left = left;
        this.right = right;
        this.nodeChar = null;
        this.count = count;
    }

    @Override
    /**@return int determines if one node takes precedence over another. count > 0 get less priority in Queue*/
    public int compareTo(T other){
        HuffmanTreeNode<T> temp = (HuffmanTreeNode<T>)other;
        return ((int)this.count - (int)temp.count);
    }

    /**@return boolean determine if the node is a leaf or not*/
    boolean isLeaf(){
        return (this.left == null && this.right == null);
    }

    private static <T> T instanceOf(Object o) {
        return (T) o;
    }

}
