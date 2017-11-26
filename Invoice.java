package system.forms;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import system.information.Date;

public class Invoice extends Form {
	private double minDue;
	private double totalDue;
	private Date dueDate;

	public Invoice() {
		super();
		minDue = 0;
		totalDue = 0;
		dueDate = new Date();
	}
	
	public double getMinDue() {
		return this.minDue;
	}

	public double getTotalDue() {
		return this.totalDue;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setMinDue(double minDue) {
		this.minDue = minDue;
	}

	public void setTotalDue(double totalDue) {
		this.totalDue = totalDue;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public void generateInvoice() {
		PDDocument invoice = new PDDocument();
		PDFont font = PDType1Font.HELVETICA;
		PDPage contentPage = new PDPage();
		PDPageContentStream contentStream = null;
		
		invoice.addPage(contentPage);
		
		try {
			contentStream = new PDPageContentStream(invoice, contentPage);
			PDImageXObject businessLogo = PDImageXObject.createFromFile("C:/Users/Oura9_000/Desktop/ECE_373_Project_Git/ece373project/images.png", invoice);
			contentStream.drawImage(businessLogo,  70, 70);
			contentStream.beginText();
			contentStream.setFont(font, 12);
			contentStream.newLineAtOffset(50, 600);
			contentStream.setLeading(14.5f);
			contentStream.showText(this.getPerson().getName());
			contentStream.newLine();
			contentStream.newLine();
			contentStream.newLine();
			contentStream.showText("Amount due this cycle: " + this.getMinDue());
			contentStream.newLine();
			contentStream.showText("Total amount due for contract: " + this.getTotalDue());
			contentStream.newLine();
			contentStream.newLine();
			contentStream.newLine();
			contentStream.showText("Payment due by: " + this.getDueDate().getDate());
			contentStream.endText();
			contentStream.close();
			invoice.save("Invoice_" + this.getPerson().getName() + ".pdf");
			invoice.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
