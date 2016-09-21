package ocrtesseract;

import java.util.List;


import org.apache.commons.io.FilenameUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import net.sourceforge.tess4j.*;

import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;


public class TesseractEx {
				
public String performocr(String filepath) 
{	
	
	String result = "";
	File filetoocr = null;
	//String filepath = "/home/megha/print-1.pdf";
	File imagefile = new File (filepath);
	String ext = FilenameUtils.getExtension(filepath);
	System.out.println("ext="+ext);
	System.out.println("a");
	System.out.println(filepath);
	PDDocument document = null;
	if(ext.equals("pdf") || (ext.equals("PDF"))) {
		
		try {
			document = PDDocument.load(imagefile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}             
		List<PDPage> pages = document.getDocumentCatalog().getAllPages();
		for (int i = 0; i < pages.size(); i++) {
			try
			{	 PDPage singlePage = (PDPage)pages.get(i);
				 BufferedImage image = singlePage.convertToImage();		 
				 filetoocr = new File("/home/megha/output2.png");
				 ImageIO.write(image, "png", filetoocr);
			}
			catch(IOException e){
				System.out.println(e.toString());
			}
		}
   }
	
	else {
		filetoocr = imagefile;
	}
  
		Tesseract instance = new Tesseract();
		
		try {
			instance.setHocr(false);
			instance.setLanguage("eng");
			instance.setOcrEngineMode(0);
			//instance.setDatapath("/home/megha/tessdata/");
			instance.setDatapath("/usr/share/tesseract-ocr/tessdata");
			result = instance.doOCR(filetoocr);
			//System.out.println("R");
			System.out.println(result);	
			return result;
		}
		
		catch( TesseractException e) {
			System.err.println(e.getMessage());
		}
		return result;
	}

	
}
	

