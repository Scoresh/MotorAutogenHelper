import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Generate {
    public static String name;


    public static void main(String[] args) throws FileNotFoundException, IOException{
        name = args[0];
        String inputs = "inputs/";
        String outputPATH = "outputs/" + name + "/";
        String[] names = new String[]{
            "Constant",
            "IO",
            "SparkIO",
            "System"
        };
        for (String n : names){
            Scanner sc = new Scanner(new File(inputs + n + ".txt"));
            File filePath = new File(outputPATH);
            File fwf = new File(outputPATH+ name + n + ".java");
            filePath.mkdir();
            fwf.createNewFile();
            FileWriter fw = new FileWriter(fwf);
            while (sc.hasNextLine()){
                fw.write(sc.nextLine().replace("@NAME@", name) + "\n");
            }
            sc.close();
            fw.close();
        }
    }

}