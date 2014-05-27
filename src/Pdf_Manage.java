import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Алекс on 23.05.2014.
 */
public class Pdf_Manage  {
    public void createFile () throws IOException, DocumentException{
        String path = "C:\\Users\\Алекс\\Desktop\\СофтСерв\\Padavans.xls";
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(path));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);

        Document doc = new Document();
        PdfWriter writer;

        File pdfFile = new File("C:\\Users\\Алекс\\Desktop\\СофтСерв\\pdf.pdf");
        pdfFile.createNewFile();
        FileOutputStream fstream = new FileOutputStream(pdfFile);

        writer = PdfWriter.getInstance(doc, fstream);
        BaseFont times = BaseFont.createFont("c:/windows/fonts/times.ttf", "cp1251", BaseFont.EMBEDDED);
        BaseFont timesb = BaseFont.createFont("c:/windows/fonts/timesbd.ttf", "cp1251", BaseFont.EMBEDDED);

        doc.open();

        Paragraph header = null;
        Paragraph data = null;

        for (int i = 1; i < 11; i++){
            header = new Paragraph(sheet.getRow(i).getCell(0).getStringCellValue(), new Font(timesb, 14));
            header.setAlignment(Element.ALIGN_CENTER);
            doc.add(header);
            System.out.println(sheet.getRow(i).getCell(0).getStringCellValue());
            for (int j = 1; j < 4; j++){
                System.out.println(sheet.getRow(0).getCell(j).getStringCellValue() + " - " +
                        sheet.getRow(i).getCell(j).getStringCellValue());
                data = new Paragraph(sheet.getRow(0).getCell(j).getStringCellValue() + " - " +
                         sheet.getRow(i).getCell(j).getStringCellValue() + "\n", new Font(times, 12));
                doc.add(data);
            }
        }

        doc.close();
        writer.close();
        fstream.close();
    }
}
