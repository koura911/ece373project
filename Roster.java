package system.forms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import system.people.Person;

public class Roster extends Report {
	private int totalPeople;

	public Roster() {
		super();
		totalPeople = 0;
	}
	
	public int getTotalPeople() {
		this.setTotalPeople(this.getPeople().size());
		return this.getPeople().size();
	}

	public void setTotalPeople(int totalPeople) {
		this.totalPeople = this.getPeople().size();
	}

	public void sortPeople() {
		ArrayList<String> people = new ArrayList<String>();
		ArrayList<Person> temp = new ArrayList<Person>();
		
		for (int i = 0; i < this.getPeople().size(); i++) {
			people.add(this.getPeople().get(i).getName());
		}
		
		Collections.sort(people, String.CASE_INSENSITIVE_ORDER);
		
		for (int i = 0; i < people.size(); i++) {
			for (int j = 0; j < this.getTotalPeople(); j++) {
				if (people.get(i).equals(this.getPeople().get(j).getName())) {
					temp.add(this.getPeople().get(j));
					this.getPeople().remove(j);
				}
			}
		}
		
		this.setPeople(temp);
	}
	
	public void generateRoster() {
		PDDocument roster = new PDDocument();
		PDFont font = PDType1Font.HELVETICA;
		PDPage contentPage = new PDPage();
		PDPageContentStream  contentStream = null;
		
		roster.addPage(contentPage);
		
		try {
			contentStream = new PDPageContentStream(roster, contentPage);
			PDImageXObject businessLogo = PDImageXObject.createFromFile("C:/Users/Oura9_000/Documents/ECE 373/ECE_373_Project/src/images.png", roster);
			contentStream.drawImage(businessLogo,  70, 70);
			contentStream.beginText();
			contentStream.setFont(font, 12);
			contentStream.newLineAtOffset(50, 600);
			contentStream.setLeading(14.5f);
			
			contentStream.showText("Roster");
			contentStream.newLine();
			contentStream.newLine();
			
			for (int i = 0; i < this.getPeople().size(); i++) {
				contentStream.showText(this.getPeople().get(i).getName());
				contentStream.newLine();
			}
			contentStream.endText();
			contentStream.close();
			roster.save("Roster.pdf");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
