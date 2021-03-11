import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Tester {

    static PrintWriter pw;

    public static void main(String[] args){
        getOutputFile();
        HuffmanFrequencyTable h1 = new HuffmanFrequencyTable("Eerie eyes seen near lake.");
        h1.getFreq();
        h1.initFreq();
    }

    /**@return void get the file output.txt from the output file*/
    static void getOutputFile(){
        File outputFile = new File("output/output.txt");
        try {
            pw = new PrintWriter(new FileOutputStream(outputFile, false));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
