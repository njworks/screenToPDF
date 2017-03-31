import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

/**
 * Created by N on 31/03/2017.
 */
public class PDFWrite {

    public static void pdfExport() {
        try {
            Document document = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));
            document.open();
            for (int i = 0; i < Run.names.size(); i++) {
                String each = (String) Run.names.get(i);
                Image img = Image.getInstance(each);
                img.scaleToFit(PageSize.A4.getWidth() + 190, PageSize.A4.getHeight() + 500);
                document.add(img);
            }
            document.close();
            System.out.println("PDF created");
        } catch (Exception e) {
            System.out.println("PDF export exception: " + e);
        }
    }

}
