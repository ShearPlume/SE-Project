import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class DBWriter{
    private static String path = "/Database.xml";
    private DataBase DB;
    public DBWriter(DataBase DB)
    {
        this.DB=DB;
    }
    public void writeToDB()
    {
       
    }

    public static void addCandidate(Candidate candidate) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        Document document = XMLTool.getDocument(path);
        NodeList nodeList = document.getElementsByTagName("candidates");
        Element candidateEle = document.createElement("candidate");

        //create element cId
        Element cIdEle = document.createElement("cId");
        //set text value
        cIdEle.setTextContent(String.valueOf(candidate.getId()));
        //add to parent node
        candidateEle.appendChild(cIdEle);

        //create element name
        Element nameEle = document.createElement("name");
        //set text value
        nameEle.setTextContent(candidate.getName());
        //add to parent node
        candidateEle.appendChild(nameEle);

        //create element workExp
        Element workExpEle = document.createElement("workExp");
        //set text value
        workExpEle.setTextContent(String.valueOf(candidate.getWorkExperience()));
        //add to parent node
        candidateEle.appendChild(workExpEle);

        //create element eduLevel
        Element eduLevelEle = document.createElement("eduLevel");
        //set text value
        eduLevelEle.setTextContent(String.valueOf(candidate.getEducationLevel()));
        //add to parent node
        candidateEle.appendChild(eduLevelEle);

        //create element workExp
        Element skillsEle = document.createElement("skills");
        for (String s:candidate.getSkills()) {
            Element aEle = document.createElement("a");
            aEle.setTextContent(s);
            skillsEle.appendChild(aEle);
        }
        //set text value

        //add to parent node
        candidateEle.appendChild(skillsEle);

        //add to parent node
        nodeList.item(0).appendChild(candidateEle);

        //save xml
        XMLTool.saveXml(document, path);

    }
    public static void addRequirement(Requirement requirement) throws TransformerException, ParserConfigurationException, IOException, SAXException {
        Document document = XMLTool.getDocument(path);
        NodeList nodeList = document.getElementsByTagName("requirements");
        Element requirementEle = document.createElement("requirement");

        //create element cId
        Element cIdEle = document.createElement("rId");
        //set text value
        cIdEle.setTextContent(String.valueOf(requirement.getId()));
        //add to parent node
        requirementEle.appendChild(cIdEle);

        //create element name
        Element nameEle = document.createElement("rCourse");
        //set text value
        nameEle.setTextContent(requirement.getCourse());
        //add to parent node
        requirementEle.appendChild(nameEle);

        //create element cId
        Element rNumEle = document.createElement("rNum");
        //set text value
        rNumEle.setTextContent(String.valueOf(requirement.getNum()));
        //add to parent node
        requirementEle.appendChild(rNumEle);

        //create element workExp
        Element rWorkExpEle = document.createElement("rWorkExp");
        //set text value
        rWorkExpEle.setTextContent(String.valueOf(requirement.getWorkExperience()));
        //add to parent node
        requirementEle.appendChild(rWorkExpEle);

        //create element eduLevel
        Element rEduLevelEle = document.createElement("rEduLevel");
        //set text value
        rEduLevelEle.setTextContent(String.valueOf(requirement.getEducationLevel()));
        //add to parent node
        requirementEle.appendChild(rEduLevelEle);

        //create element workExp
        Element skillsEle = document.createElement("skills");
        for (String s:requirement.getSkills()) {
            Element aEle = document.createElement("a");
            aEle.setTextContent(s);
            skillsEle.appendChild(aEle);
        }
        //set text value

        //add to parent node
        requirementEle.appendChild(skillsEle);

        //add to parent node
        nodeList.item(0).appendChild(requirementEle);

        //save xml
        XMLTool.saveXml(document, path);

    }
}