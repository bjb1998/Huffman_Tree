public class HuffmanTree<T>{

    HuffmanTreeNode<T> root;
    static int tracker = 0;
    String[][] table;
    String original;
    int bitSize = 0;

    public HuffmanTree(PriorityQueue<T> queue, String[][] table, String original){
        this.table = table;
        this.original = original;
        queue.heapify();
        this.root = queue.poll();
        this.generatePaths(root, "");
    }

    /**@return void generate the paths to be put into the encoded string
     * @param root the root node of the tree
     * @param path the string path to be added per iteration*/
    void generatePaths(HuffmanTreeNode<T> root, String path){ //recursive formula to find all the paths needed to get to the chars
        if(root == null)
            return;

        if(root.isLeaf()) { //Add to the frequency table
            table[tracker][0] = "" + root.nodeChar;
            table[tracker][1] = "" + root.count;
            table[tracker][2] = path;
            tracker++;
        }

        generatePaths(root.left, path.concat("0"));
        generatePaths(root.right, path.concat("1"));
    }

    /**@return String the encoded string  from the table
     * @param s the original string
     * @param table the array containg the chars and the pathway to it*/
    String encode(String s, String[][] table){
        String result = "";
        for(char c : s.toCharArray()){
            for (String[] strings : table) {
                if (c == strings[0].charAt(0))//If the characters are equal...
                    result = result.concat(strings[2]); //add its path to the encoded string...
            }
        }
        bitSize = result.length();
        return result;
    }

    /**@return String the decoded string from an encoded string
     * @param s the encoded string, contains paths to all the char's neccesary*/
    String decode(String s){
        HuffmanTreeNode<T> dummy = root;
        String result = "";
        for(char c : s.toCharArray()){
            if(dummy.isLeaf()) //We reached a leaf, go back from the top
                dummy = root;

            switch(c){
                case '1':
                    dummy = dummy.right;
                    break;
                case'0':
                    dummy = dummy.left;
                    break;
            }

            if(dummy.nodeChar != null)
                result = result.concat("" + dummy.nodeChar);

        }
        return result;
    }

}
