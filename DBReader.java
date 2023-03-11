import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DBReader {
    private DataBase DB;
    private static String path = "/Database.xml";

    public DBReader(DataBase DB) {
        this.DB = DB;
    }

    public void readFromDB() {

    }



    public static List<Candidate> getCandidateList() throws ParserConfigurationException, IOException, SAXException {
        Document document = XMLTool.getDocument(path);
        List<Candidate> candidateList = new ArrayList<>();
        NodeList nlist = document.getElementsByTagName("candidate");
        for (int i = 0; i < nlist.getLength(); i++) {
            Candidate candidate = new Candidate("", 0, false, 0, 0);
            Node node = nlist.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                System.err.println("Error: Search node not of element type");
                System.exit(22);
            }

            System.out.println(node.getNodeName());
            NodeList subNlist = node.getChildNodes();
            for (int j = 0; j < subNlist.getLength(); j++) {
                Node subnode = subNlist.item(j);
                if (subnode.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println(subnode.getNodeName() + ":" + subnode.getTextContent());
                    if (subnode.getNodeName().equals("cId")) {
                        candidate.setId(Integer.parseInt(subnode.getTextContent()));
                    }
                    if (subnode.getNodeName().equals("name")) {
                        candidate.setName(subnode.getTextContent());
                    }
                    if (subnode.getNodeName().equals("workExp")) {
                        candidate.setWorkExperience(Boolean.parseBoolean(subnode.getTextContent()));
                    }
                    if (subnode.getNodeName().equals("eduLevel")) {
                        candidate.setEducationLevel(Integer.parseInt(subnode.getTextContent()));
                    }
                    if (subnode.getNodeName().equals("skills")) {
                        List<String> skillList = new ArrayList<>();
                        if (subnode.hasChildNodes()) {
                            NodeList skillNlist = subnode.getChildNodes();
                            for (int o = 0; o < skillNlist.getLength(); o++) {
                                skillList.add(subNlist.item(j).getTextContent());
                            }
                        }
                        candidate.setSkills(skillList);
                    }
                }
            }
            candidateList.add(candidate);
        }
        return candidateList;
    }
    public static List<Requirement> getRequirementList() throws ParserConfigurationException, IOException, SAXException {
        Document document = XMLTool.getDocument(path);
        List<Requirement> requirementList = new ArrayList<>();
        NodeList nlist = document.getElementsByTagName("requirement");
        for (int i = 0; i < nlist.getLength(); i++) {
            Requirement requirement = new Requirement();
            Node node = nlist.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                System.err.println("Error: Search node not of element type");
                System.exit(22);
            }

            System.out.println(node.getNodeName());
            NodeList subNlist = node.getChildNodes();
            for (int j = 0; j < subNlist.getLength(); j++) {
                Node subnode = subNlist.item(j);
                if (subnode.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println(subnode.getNodeName() + ":" + subnode.getTextContent());
                    if (subnode.getNodeName().equals("rId")) {
                        requirement.setId(Integer.parseInt(subnode.getTextContent()));
                    }
                    if (subnode.getNodeName().equals("rCourse")) {
                        requirement.setCourse(subnode.getTextContent());
                    }
                    if (subnode.getNodeName().equals("rNum")) {
                        requirement.setNum(Integer.parseInt(subnode.getTextContent()));
                    }
                    if (subnode.getNodeName().equals("workExp")) {
                        requirement.setWorkExperience(Boolean.parseBoolean(subnode.getTextContent()));
                    }
                    if (subnode.getNodeName().equals("eduLevel")) {
                        requirement.setEducationLevel(Integer.parseInt(subnode.getTextContent()));
                    }
                    if (subnode.getNodeName().equals("skills")) {
                        List<String> skillList = new ArrayList<>();
                        if(subnode.hasChildNodes()) {
                            NodeList skillNlist = subnode.getChildNodes();
                            for (int o = 0; o < skillNlist.getLength(); o++){
                                skillList.add(subNlist.item(j).getTextContent());
                            }
                        }
                        requirement.setSkills(skillList);
                    }
                }
            }
            requirementList.add(requirement);
        }
        return requirementList;
    }

}