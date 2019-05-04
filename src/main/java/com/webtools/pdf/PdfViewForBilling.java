package com.webtools.pdf;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;
import com.webtools.pojo.Student;

public class PdfViewForBilling extends AbstractPdfView{

	Student s;
	public PdfViewForBilling(Student s) {
		this.s=s;
	}
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Element e1=new Chunk("NORTHEASTERN UNIVERSITY BILLING STATEMENT\n");
		Element e2= new Phrase("Hi "+s.getFirstname()+" "+s.getLastname());
		Element e3= new Paragraph("Your Billing Statement for the month adds upto $6,345 which includes Tuition, Recreational and Student Fees."
				+ " Please pay the bill before the due date.\n STUDENT FINANCIAL SERVICES \n	NORTHEASTERN UNIVERSITY");
		document.add(e1);
		document.add(e2);
		document.add(e3);
		
	}

}
