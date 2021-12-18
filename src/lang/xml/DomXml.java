package lang.xml;

import java.io.File;
import java.util.ArrayList;

import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomXml {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>(3);
        try {
            File file = new File("D:/workspaceFolder/CODE_JAVA/lang/xml/student.xml");
            var Factory = DocumentBuilderFactory.newInstance();
            var Builder = Factory.newDocumentBuilder();
            var doc = Builder.parse(file);

            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("student");
            for (int i = 0; i < nList.getLength(); ++i) {
                org.w3c.dom.Node nNode = nList.item(i);
                System.out.println("Current element: " + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    var element = (Element) nNode;
                    int id = Integer.parseInt(element.getAttribute("id"));
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    int age = Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent());
                    students.add(new Student(name, age, id));
                }
            }
            for (Student student : students) {
                System.out.println("-------------------------");

                System.out.println(student);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
