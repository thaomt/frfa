package ThaoMT8_Assigment_Day08.ex1;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ReadXML {
	public static void main(String args[]) {
		final String file = "student.xml";
		extractNode(file);

	}

	public static void extractNode(String file) {
		try {
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document dom = documentBuilder.newDocument();
			
            Element rootElement = dom.createElement("Student");
            dom.appendChild(rootElement);
            
            Element student1 = dom.createElement("student");
            rootElement.appendChild(student1);
            // student 1       
            Element name = dom.createElement("name");
            name.appendChild(dom.createTextNode("Rick Grimes"));
            student1.appendChild(name);
            Element age = dom.createElement("age");
            age.appendChild(dom.createTextNode("35"));
            student1.appendChild(age);
            Element subject = dom.createElement("subject");
            subject.appendChild(dom.createTextNode("Maths"));
            student1.appendChild(subject);
            Element gender = dom.createElement("gender");
            gender.appendChild(dom.createTextNode("Male"));
            student1.appendChild(gender);
            // student 2 
            Element student2 = dom.createElement("student");
            rootElement.appendChild(student2);
            Element name2 = dom.createElement("name");
            name2.appendChild(dom.createTextNode("Daryl Dixon"));
            student2.appendChild(name2);
            Element age2 = dom.createElement("age");
            age2.appendChild(dom.createTextNode("33"));
            student2.appendChild(age2);
            Element subject2 = dom.createElement("subject");
            subject2.appendChild(dom.createTextNode("Science"));
            student2.appendChild(subject2);
            Element gender2 = dom.createElement("gender");
            gender2.appendChild(dom.createTextNode("Male"));
            student2.appendChild(gender2);
            // student 3
            Element student3 = dom.createElement("student");
            rootElement.appendChild(student3);
            Element name3 = dom.createElement("name");
            name3.appendChild(dom.createTextNode("Maggie"));
            student3.appendChild(name3);
            Element age3 = dom.createElement("age");
            age3.appendChild(dom.createTextNode("36"));
            student3.appendChild(age3);
            Element subject3 = dom.createElement("subject");
            subject3.appendChild(dom.createTextNode("Arts"));
            student3.appendChild(subject3);
            Element gender3 = dom.createElement("gender");
            gender3.appendChild(dom.createTextNode("FeMale"));
            student3.appendChild(gender3);
			// write DOM to XML file
			Transformer tr = TransformerFactory.newInstance().newTransformer();
			tr.setOutputProperty(OutputKeys.INDENT, "yes");
			tr.transform(new DOMSource(dom), new StreamResult(new File(file)));
            // console 
			DOMSource source = new DOMSource(dom);
            StreamResult consoleResult = new StreamResult(System.out);
            tr.transform(source, consoleResult);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
