import java.io.FileReader;
import java.io.IOException;

public class filehanfle {

    public static void main(String[] args) throws IOException 
    {
        // int count=0;
        FileReader fr=new FileReader("file.txt"); 
        int i;
        while ((i=fr.read())!=-1) {
            if ((i>=65&& i<78)) {
                // count++;
            System.out.print((char)i);
            }
        }
        System.out.println();
            // System.out.print(count);

        if (fr!=null) {
            fr.close();
        }
        
        
    }
}