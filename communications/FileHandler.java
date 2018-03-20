package communications;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.input.SAXBuilder;

public class FileHandler {
	private static String StorPath = core.Install.getStorage();
	public Document doc = getDoc();

	public static Document getDoc() {
		SAXBuilder bld = new SAXBuilder();
		try {
			return (Document) bld.build(core.Install.getStorageFile());
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
			return new Document();
		}
	}

	public boolean push() { // FIXME: Implement File Output
		try {
			return true;
		} catch (IOException io) {
			System.out.println(io.getMessage());
			return false;
		} catch (JDOMException e) {
			e.printStackTrace();
			return false;
		}

	}

	public static boolean generateFile() { // @return True if file operation does not throw IOException.
		try {
			File FS = core.Install.getStorageFile();
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

	public void outputToFile() {
		try {
			FileOutputStream fs = new FileOutputStream(core.Install.getStorageFile());
			XMLOutputter xml = new XMLOutputter();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}