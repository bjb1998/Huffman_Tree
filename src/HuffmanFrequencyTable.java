import java.io.PrintWriter;
import java.util.Arrays;

public class HuffmanFrequencyTable<T> { //For simplicity, this will use only ASCII characters.

    int[] freq = new int[255]; //for each 255 values within ascii, counting accents and special char's.
    PrintWriter pw = Tester.pw;
    String original;
    String[][] myTable;
    HuffmanTree<HuffmanTreeNode<T>> myTree;

    HuffmanFrequencyTable(String s){
        this.original = s;
    }

    /**@return void determine count of ascii charcters via a 255 length array*/
    void getFreq(){
        if(original.equals("")){
            pw.println("Empty String. " + "Aborting!");
            pw.flush();
            System.exit(0);
        }
        for(char c : original.toCharArray()) {
            if(c > 255){
                pw.println("Invalid character " + c + ". Aborting!");
                pw.flush();
                System.exit(0);
            }
            freq[c]++;
        }
    }

    /**@return void Initizalize the Queue, Tree, etc.*/
    void initFreq(){
        PriorityQueue<HuffmanTreeNode<T>> myQueue = new PriorityQueue<>(freq); //initialize Queue

        int arraySize = Arrays.stream(freq).filter(x -> x != 0).toArray().length;
        myTable = new String[arraySize][3]; //Create frequency table

        myTree = new HuffmanTree<>(myQueue, myTable, original);
        myTree.encode(original, myTable);
        printTable();
    }

    /**@return void print the table to output.txt**/
    void printTable(){
        String code = myTree.encode(original, myTable);
        float uncompressedSize = original.length() * 8;
        pw.println("% " + "Java Tester " + original);
        pw.println("======================================");
        pw.printf("%-10s", "char");
        pw.printf("%-15s", "frequency");
        pw.printf("%-12s", "code");
        pw.println("\n--------------------------------------");
        for (String[] charsAndCode : myTable) {
            pw.printf("%-10s", charsAndCode[0]);
            pw.printf("%-15s", charsAndCode[1]);
            pw.printf("%-12s", charsAndCode[2]);
            pw.println();
        }

        pw.println("======================================");
        pw.println("Encoded bit stream: ");
        pw.println(code);
        pw.println("Total number of bits without Huffman coding (8-bits per character): ");
        pw.println(original.length() * 8);
        pw.println("Total number of bits with Huffman coding: " + myTree.bitSize);
        pw.print("Compression Ratio: ");
        pw.printf("%.3f", uncompressedSize / (float)myTree.bitSize);
        pw.print(". Or roughly ");
        pw.printf("%.3f", ((float)myTree.bitSize / uncompressedSize) * 100f);
        pw.print("% of the original size");
        pw.println();
        pw.println("Decoded String: " + myTree.decode(code));
        pw.flush();
    }

}
