package communications;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.input.SAXBuilder;

public class FileHandler {
	String Appdata = System.getenv("APPDATA");
	String StorPath = new String(Appdata + "\\PalindromeGame\\storage.xml");
	
	public static Document getDoc() {
		SAXBuilder bld = new SAXBuilder();
		try {
			return (Document) bld.build(new File(System.getenv("APPDATA")+"\\PalindromeGame\\storage.xml"));
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
			return new Document();
		}
	}

	public boolean push() { // FIXME: Implement File Output
		try {
			File doc = new File(StorPath);
			SAXBuilder dc = new SAXBuilder();
			Document docu = (Document) dc.build(doc);

			return true;
		} catch (IOException io) {
			System.out.println(io.getMessage());
			return false;
		} catch (JDOMException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean generateFile() { // returns true if the file was created successfully, or exists already.
		try {
			File FS = new File(Appdata + "\\PalindromeGame");
			Element docRoot = new Element("Root");
			Document doc = new Document(docRoot);
			XMLOutputter xmlOut = new XMLOutputter();
			xmlOut.setFormat(Format.getPrettyFormat());
			FS.mkdir();
			xmlOut.output(doc, new FileWriter(StorPath));
			return true;
		} catch (IOException io) {
			System.out.println(io.getMessage());
			return false;
		}
	}

	private void reflowTree() {

	}
}