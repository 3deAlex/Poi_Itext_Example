import com.lowagie.text.DocumentException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Connection conn = new Connection();

        try {
            conn.connect();
        } catch (FileNotFoundException fe) {
            System.out.println("File not found");
        } catch (IOException ie) {
            System.out.println("Can not read file");
        }

        Pdf_Manage pdf = new Pdf_Manage();

        try {
            pdf.createFile();
        } catch (IOException e) {
            System.out.println("Could not read/write file");
        } catch (DocumentException de){
            System.out.println("could not reach document");
        }
    }
}
