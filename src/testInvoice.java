
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;


public class testInvoice {

    public static void main(String[] args) throws IOException, ParseException {
        
        
        // Create PdfWriter and PdfDocument
//        String dest = "invoice_no_table.pdf";
//        PdfWriter writer = new PdfWriter(dest);
//        PdfDocument pdf = new PdfDocument(writer);
//        Document document = new Document(pdf);
//
//        // Add the invoice title
//        document.add(new Paragraph("Invoice / Receipt")
//                .setTextAlignment(TextAlignment.CENTER)
//                .setFontSize(20));
//
//        // Add item details as plain text
//        document.add(new Paragraph("Item 1: Coca-Cola (1) - 20 Baht")
//                .setFontSize(14));
//        document.add(new Paragraph("Item 2: Bread (2) - 15 Baht")
//                .setFontSize(14));
//        document.add(new Paragraph("Item 3: Snack (1) - 10 Baht")
//                .setFontSize(14));
//
//        // Add total amount
//        document.add(new Paragraph("\nTotal: 45 Baht")
//                .setTextAlignment(TextAlignment.RIGHT)
//                .setFontSize(14));
//
//        // Add a thank-you note
//        document.add(new Paragraph("\nThank you for your purchase!")
//                .setTextAlignment(TextAlignment.CENTER)
//                .setFontSize(12));
//
//        // Close the document
//        document.close();
//
//        System.out.println("Invoice created successfully at: " + dest);
        

            // สร้าง DecimalFormat
            DecimalFormat df = new DecimalFormat("##,###,###.##");
            
            // ข้อมูลใน TextField (สมมุติว่าเป็นสตริงที่คั่นด้วย comma เช่น "1,234.56")
            String text = "61,234.56";  // เปลี่ยนตรงนี้เป็นข้อมูลจาก TextField ของคุณ
            
            // ใช้ parse เพื่อแปลงสตริงเป็น Number
            Number number = df.parse(text);
            
            // แปลงเป็น double
            double value = number.doubleValue();
            
            // ใช้ในการคำนวณ
            System.out.println("ค่าที่แปลงเป็น double: " + value);
            
    }
}
