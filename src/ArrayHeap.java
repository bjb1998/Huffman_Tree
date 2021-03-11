import java.util.Arrays;

abstract class ArrayHeap<T> {

    T[] nodes = (T[]) new Object[0]; //Temporary storage until the actual NodeList is made
    int arrayCount = 0;
    int arraySize = 0;

    public ArrayHeap(){}

    /**@return void add an element to the array
     * @param newNode the HuffmanTreeNode to add*/
    protected void add(T newNode){
        if(arrayCount >= nodes.length)
            nodes = Arrays.copyOf(nodes, nodes.length + 1); //increase the length of nodes
        nodes[arrayCount] = newNode;
        arrayCount++;
        if(arrayCount > 1)
            heapifyAdd();
    }

    /**@return void Heapify a new element within the array*/
    void heapifyAdd(){
        int next = arrayCount - 1;
        T temp = nodes[next]; //prep a temp T for swapping
        while ((next != 0) && (((Comparable)nodes[next]).compareTo(nodes[(next-1)/2]) < 0)){ //Best I could to to implement Comparable with just T
            nodes[next] = nodes[(next-1)/2]; //find the child node
            nodes[(next-1)/2]= temp; //Swap the two nodes
            next = (next-1)/2;
        }
    }

    /**@return void heapify a single node
     * @param newNode the new node to add to the array
     * */
    protected void heapifyNode(T newNode) {
        int i = 0;
        T[] result = (T[]) new Object[nodes.length + 1];
        while(i < nodes.length && (((Comparable)newNode).compareTo(nodes[i]) >= 0)){ //Best I could do with just T
            i++;
        }
        copyOver(result, i, newNode);

    }

    /**@return HuffmanTreeNode<T> the minimum node*/
    T removeMin(){
        T dummy = nodes[0];
        nodes = Arrays.copyOfRange(nodes, 1, nodes.length);
        return dummy;
    }

    /**@return void Add a new node to its appropriate position in a HuffmanTree.*/
    void copyOver(T[] result, int i, T newNode){
        for(int j = 0; j < i; j++)
            result[j] = nodes[j];
        result[i] = newNode;
        for(int j = i + 1; j <= nodes.length; j++)
            result[j] = nodes[j - 1];

        nodes = result;
    }

}
