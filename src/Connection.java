import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Алекс on 23.05.2014.
 */
public class Connection  {

    String path = "C:\\Users\\Алекс\\Desktop\\СофтСерв\\Padavans.xls";
    POIFSFileSystem fs = null;
    HSSFWorkbook wb = null;

    public void connect () throws IOException{
        String path = "C:\\Users\\Алекс\\Desktop\\СофтСерв\\Padavans.xls";
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(path));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);

        for (Row row : sheet){
            for (Cell cell : row){
                if (cell.getCellType() == Cell.CELL_TYPE_STRING){
                    System.out.print(cell.getStringCellValue() + " | ");
                } else {
                    if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
                        System.out.print(cell.getNumericCellValue() + " | ");
                    }
                }
            }
            System.out.print("\n");
        }
    }

    public String getRowText () throws IOException {
        fs = new POIFSFileSystem(new FileInputStream(path));
        wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);
        Row row0 = sheet.getRow(0);
        Row row = sheet.getRow(1);

        String text = "";

        for (int i = 0; i < 4; i++){
            text += row0.getCell(i).getStringCellValue() + " - " + row.getCell(i).getStringCellValue() + "\n";
        }

        return text;
    }
}
