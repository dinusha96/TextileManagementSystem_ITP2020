package com.itp.pdf;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itp.util.DBConnectionUtil;
import com.itp.util.DbConnection;

public class GeneratePDF {
	private static Font TIME_ROMAN = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
	private static Font TIME_ROMAN_SMALL = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
 
	/**
	 * @param args
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public static Document createPDF(String file) throws SQLException, DocumentException,MalformedURLException, IOException {
 
		Document document = null;
 
		try {
			document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();
 
			addMetaData(document);
			
			addImage(document);
 
			addTitlePage(document);
			
			createTable(document);
 
			document.close();
 
		} catch (FileNotFoundException e) {
 
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;
 
	}
 
	
	private static void addMetaData(Document document) {
		document.addTitle("Order PDF report");
		document.addSubject("Order PDF report");
		document.addAuthor("Sona Nizer");
		document.addCreator("Sona Nizer");
	}
	
	private static void addTitlePage(Document document)
			throws DocumentException, MalformedURLException, IOException {
 
		Paragraph preface = new Paragraph();
		creteEmptyLine(preface, 3);
		
		 Font f =  FontFactory.getFont(FontFactory.TIMES, 30f, Font.BOLD);
	
		 
		preface.add(new Paragraph("WORLD OF FASHION", f));
 
		creteEmptyLine(preface, 1);
		
	
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		preface.add(new Paragraph("Order Report created on "
				+ simpleDateFormat.format(new Date()), TIME_ROMAN_SMALL));
		document.add(preface);
 
		
	}
	
	private static void addImage(Document document) throws MalformedURLException, IOException, DocumentException {
		Image img = Image.getInstance("C:/Users/Nizer/Desktop/logo1.jpeg");
		
        img.setAlignment(Element.ALIGN_CENTER);
        document.add(img);
		
	}
		 
 
	private static void creteEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
 
	private static void createTable(Document document) throws DocumentException, SQLException {
		Paragraph paragraph = new Paragraph();
		creteEmptyLine(paragraph, 2);
		document.add(paragraph);
		PdfPTable table = new PdfPTable(8);
		table.setWidthPercentage(100);
		
		
 
		PdfPCell c1 = new PdfPCell(new Phrase("Order ID"));
		
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
 
		c1 = new PdfPCell(new Phrase("Product Name"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
 
		c1 = new PdfPCell(new Phrase("Quantity"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Size"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Sub Total"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Total"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		
		c1 = new PdfPCell(new Phrase("Purchase Date"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Status of the Order"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		table.setHeaderRows(1);
 
		 DbConnection obJDBConnection=new DbConnection();
		   Connection connection=obJDBConnection.getConnection();
		   
		   PreparedStatement ps=null;
		   ResultSet rs=null;
		   
		   String query="select * from `order`";
		   ps=connection.prepareStatement(query);
		   rs=ps.executeQuery();
		   
		
		   while(rs.next()) {
			   table.addCell(rs.getString("orderID"));
			   table.addCell(rs.getString("product"));
			   table.addCell(rs.getString("quantity"));
			   table.addCell(rs.getString("size"));
	           table.addCell(rs.getString("subTotal"));
			   table.addCell(rs.getString("Total"));
			   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			   table.addCell(simpleDateFormat.format(new Date()));
			   table.addCell(rs.getString("status"));
		   }
		   
		   document.add(table);
		   
	}
 
}

