package classes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import components.Account;

public class WriteFile {
	public void writeXmlFile(ArrayList<Account> list) {

	    try {

	        DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
	        DocumentBuilder build = dFact.newDocumentBuilder();
	        Document doc = build.newDocument();

	        Element root = doc.createElement("Studentinfo");
	        doc.appendChild(root);

	        Element Details = doc.createElement("Details");
	        root.appendChild(Details);


	        for (Account dtl : list) {

	            Element label = doc.createElement("Label");
	            label.appendChild(doc.createTextNode(String.valueOf(dtl
	                    .getLabel())));
	            Details.appendChild(label);

	            Element balance = doc.createElement("balance");
	            balance.appendChild(doc.createTextNode(String.valueOf(dtl.getBalance())));
	            Details.appendChild(balance);

	            Element account = doc.createElement("account");
	            account.appendChild(doc.createTextNode(String.valueOf(dtl.getAccountNumber())));
	            Details.appendChild(account);

	        }

	        // Save the document to the disk file
	        TransformerFactory tranFactory = TransformerFactory.newInstance();
	        Transformer aTransformer = tranFactory.newTransformer();

	        // format the XML nicely
	        aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

	        aTransformer.setOutputProperty(
	                "{http://xml.apache.org/xslt}indent-amount", "4");
	        aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

	        DOMSource source = new DOMSource(doc);
	        try {
	            // location and name of XML file you can change as per need
	            FileWriter fos = new FileWriter("./xmldata.xml");
	            StreamResult result = new StreamResult(fos);
	            aTransformer.transform(source, result);

	        } catch (IOException e) {

	            e.printStackTrace();
	        }

	    } catch (TransformerException ex) {
	        System.out.println("Error outputting document");

	    } catch (ParserConfigurationException ex) {
	        System.out.println("Error building document");
	    }
	}
}
