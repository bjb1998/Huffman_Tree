import java.lang.reflect.Array;
import java.util.Arrays;

public class PriorityQueue<T> extends ArrayHeap<HuffmanTreeNode<T>>{

    public PriorityQueue(int[] freq){
        this.arraySize = Arrays.stream(freq).filter(x -> x != 0).toArray().length;
        this.nodes = (HuffmanTreeNode<T>[]) Array.newInstance(HuffmanTreeNode.class, arraySize);

        for(int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) { // If a count of the character exists
                this.add(new HuffmanTreeNode((char) i, freq[i]));
            }
        }
    }

    /**@return HuffmanTreeNode<T> get a copy of the lead node in the queue*/
    HuffmanTreeNode<T> peek(){ return nodes[0];}

    /**@return HuffmanTreeNode<T> get a copy of the lead node in the queue, and remove it from queue*/
    HuffmanTreeNode<T> poll(){
        HuffmanTreeNode<T> dummy = nodes[0];
        nodes = Arrays.copyOfRange(nodes, 1, nodes.length);
        return dummy;
    }

    /**@return void heapify the entire queue*/
    protected void heapify(){
        while(nodes.length > 1) {
            HuffmanTreeNode<T> node1 = this.poll();
            HuffmanTreeNode<T> node2 = this.poll();
            HuffmanTreeNode<T> parent = new HuffmanTreeNode(node1, node2, (int) node1.count + (int) node2.count);
            parent.left = node1;
            parent.right = node2;
            this.heapifyNode(parent);
        }
    }

    /**@return void heapify a single node
     * @param newNode the new node to add to the array
     * */
    @Override
    protected void heapifyNode(HuffmanTreeNode<T> newNode) {
        int i = 0;
        HuffmanTreeNode<T>[] result = new HuffmanTreeNode[nodes.length + 1];
        while(i < nodes.length && newNode.compareTo((T)nodes[i]) >= 0){
            i++;
        }
        copyOver(result, i, newNode);

    }


}

