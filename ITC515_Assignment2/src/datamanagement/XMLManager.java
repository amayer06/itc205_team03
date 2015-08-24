package datamanagement;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import java.io.FileWriter;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import java.io.IOException;
import org.jdom.JDOMException;

public class XMLManager {
	private static XMLManager self_ = null;
	private Document document_;

	
	
	public static XMLManager getXML() {
		if (self_ == null)
			self_ = new XMLManager();
		return self_;
	}

	
	
	private XMLManager() {
		init();

	}

	
	
	public void init() {
		String s = AppProperties.getInstance().getProperties().getProperty("XMLFILE");
		try {
			SAXBuilder builder = new SAXBuilder();
			builder.setExpandEntities(true);
			document_ = builder.build(s);
		}
		catch (JDOMException e) {
			System.err.printf("%s", "DBMD: XMLManager : init : caught JDOMException\n");
			throw new RuntimeException("DBMD: XMLManager : init : JDOMException");
		} 
		catch (IOException e) {
			System.err.printf("%s", "DBMD: XMLManager : init : caught IOException\n");
			throw new RuntimeException("DBMD: XMLManager : init : IOException");
		}
	}

	
	
	public Document getDocument() {
		return document_;
	}

	
	
	public void saveDocument() {
		String xmlfile = AppProperties.getInstance().getProperties().getProperty("XMLFILE");
		try (FileWriter fileOut = new FileWriter(xmlfile)) {
			XMLOutputter xmlOut = new XMLOutputter(Format.getPrettyFormat());
			xmlOut.output(document_, fileOut);
			fileOut.close();
		} 
		catch (IOException ioe) {
			System.err.printf("%s\n", "DBMD : XMLManager : saveDocument : Error saving XML to " + xmlfile);
			throw new RuntimeException("DBMD: XMLManager : saveDocument : error writing to file");
		}
	}
}
