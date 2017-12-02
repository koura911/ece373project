package system.forms;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Quote extends Form {
	private int availableSpeedUp;
	private int availableSpeedDown;
	private double price;

	public Quote() {
		super();
		availableSpeedUp = 0;
		availableSpeedDown = 0;
		price = 0.0;
	}
	
	public int getAvailableSpeedUp() {
		return this.availableSpeedUp;
	}

	public int getAvailableSpeedDown() {
		return this.availableSpeedDown;
	}

	public double getPrice() {
		return this.price;
	}

	public void setAvailableSpeedUp(int availableSpeedUp) {
		this.availableSpeedUp = availableSpeedUp;
	}

	public void setAvailableSpeedDown(int availableSpeedDown) {
		this.availableSpeedDown = availableSpeedDown;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void generateQuote() {
		PDDocument quote = new PDDocument();
		PDFont font = PDType1Font.HELVETICA;
		PDPage contentPage = new PDPage();
		PDPageContentStream  contentStream = null;
		
		quote.addPage(contentPage);
		
		try {
			contentStream = new PDPageContentStream(quote, contentPage);
			PDImageXObject businessLogo = PDImageXObject.createFromFile("C:/Users/Oura9_000/Desktop/ECE_373_Project_Git/ece373project/images.png", quote);
			contentStream.drawImage(businessLogo,  70, 70);
			contentStream.beginText();
			contentStream.setFont(font, 12);
			contentStream.newLineAtOffset(50, 600);
			contentStream.setLeading(14.5f);
			contentStream.showText(this.getPerson().getName() + "'s Quote");
			contentStream.newLine();
			contentStream.newLine();
			contentStream.showText("Available speed up: " + this.getAvailableSpeedUp() + " Mbps");
			contentStream.newLine();
			contentStream.showText("Available speed down: " + this.getAvailableSpeedDown() + " Mbps");
			contentStream.newLine();
			contentStream.showText("Price: $" + this.getPrice());
			contentStream.endText();
			contentStream.close();
			quote.save("Quote_" + this.getPerson().getName() + ".pdf");
			quote.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
