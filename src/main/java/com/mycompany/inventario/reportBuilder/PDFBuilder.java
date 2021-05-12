/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inventario.reportBuilder;


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Data;

/**
 *
 * @author wuser
 */
@Data
public class PDFBuilder {
    private String fileName;
   private PdfWriter pdfWriter;
    private PdfDocument pdfDoc;

    public PDFBuilder(String filename) {
        try {
            this.pdfWriter = new PdfWriter(filename);
            this.pdfDoc = new PdfDocument(pdfWriter);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDFBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setHeader(){
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyyy-mm-dd");
        this.pdfDoc.addNewPage();
    }
}
