package system.forms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import system.hardware.Equipment;
import system.people.Person;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Inventory extends Report {
	private int totItems;

	public int getTotItems() {
		this.setTotItems(this.getEquipment().size());
		return this.totItems;
	}

	public void setTotItems(int totItems) {
		this.totItems = totItems;
	}

	public void sortByPeople() {
		ArrayList<String> people = new ArrayList<String>();
		ArrayList<Person> temp = new ArrayList<Person>();
		
		for (int i = 0; i < this.getPeople().size(); i++) {
			people.add(this.getPeople().get(i).getName());
		}
		
		Collections.sort(people, String.CASE_INSENSITIVE_ORDER);
		
		for (int i = 0; i < people.size(); i++) {
			for (int j = 0; j < this.getPeople().size(); j++) {
				if (people.get(i).equals(this.getPeople().get(j).getName())) {
					temp.add(this.getPeople().get(j));
					this.getPeople().remove(j);
				}
			}
		}
		
		this.setPeople(temp);
	}

	public void sortEquipment() {
		ArrayList<Integer> iDNums = new ArrayList<Integer>();
		ArrayList<Equipment> temp = new ArrayList<Equipment>();
		
		for (int i = 0; i < this.getEquipment().size(); i++) {
			iDNums.add(this.getEquipment().get(i).getIDNum());
		}
		
		Collections.sort(iDNums);
		
		for (int i = 0; i < iDNums.size(); i++) {
			for (int j = 0; j < this.getEquipment().size(); j++) {
				if (iDNums.get(i) == this.getEquipment().get(j).getIDNum()) {
					temp.add(this.getEquipment().get(j));
					this.getEquipment().remove(j);
				}
			}
		}
		
		this.setEquipment(temp);
	}
	
	public void generateInventoryReport() {
		PDDocument inventoryReport = new PDDocument();
		PDPage coverpage = new PDPage();
		PDFont font = PDType1Font.HELVETICA;
		PDPage contentPage = new PDPage();
		inventoryReport.addPage(coverpage);
		inventoryReport.addPage(contentPage);
		PDPageContentStream contentStream = null;
		
		try {
			contentStream = new PDPageContentStream(inventoryReport, coverpage);
			PDImageXObject coverImage = PDImageXObject.createFromFile("C:/Users/Oura9_000/Documents/ECE 373/ECE_373_Project/src/images.png", inventoryReport);
			contentStream.drawImage(coverImage,  70, 70);
			contentStream.beginText();
			contentStream.setFont(font, 20);
			contentStream.newLineAtOffset(50,  600);
			contentStream.setLeading(14.5f);
			contentStream.showText("Inventory Report " + this.getNumber());
			contentStream.endText();
			contentStream.close();
			contentStream = new PDPageContentStream(inventoryReport, contentPage);
			contentStream.beginText();
			contentStream.setFont(font, 12);
			contentStream.newLineAtOffset(50, 700);
			contentStream.setLeading(14.5f);
			contentStream.showText("Inventory:");
			contentStream.newLine();
			contentStream.newLine();
			for (int i = 0; i < this.getEquipment().size(); i++) {
				contentStream.showText("Name: " + this.getEquipment().get(i).getName());
				contentStream.newLine();
				contentStream.showText("     Brand: " + this.getEquipment().get(i).getBrand());
				contentStream.newLine();
				contentStream.showText("     Model: " + this.getEquipment().get(i).getModel());
				contentStream.newLine();
				contentStream.showText("     IDNum: " + this.getEquipment().get(i).getIDNum());
				contentStream.newLine();
				contentStream.showText("     SerialNumber: " + this.getEquipment().get(i).getSerialNumber());
				contentStream.newLine();
				contentStream.showText("     DateInstalled: " + this.getEquipment().get(i).getDateInstalled().getDate());
				contentStream.newLine();
				contentStream.showText("     Location: " + this.getEquipment().get(i).getLocation().getAddress() + " " + this.getEquipment().get(i).getLocation().getGPS());
				contentStream.newLine();
			}
			contentStream.endText();
			contentStream.close();
			inventoryReport.save("Inventory Report_" + this.getNumber() + ".pdf");
			inventoryReport.close();
		} 
		catch (IOException e3) {
			e3.printStackTrace();
		}
	}
}
