import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// import java.io.File;
import java.io.IOException;

public class DBWriter {
    private static String path = System.getProperty("user.dir")+"\\Database.xml";
    private static DataBase DB;

    public DBWriter(DataBase DB) {
        this.DB = DB;
    }

    public void writeToDB() {

    }

    public static void addCandidate(Candidate candidate)
            throws ParserConfigurationException, IOException, SAXException, TransformerException {
        // Document document = XMLTool.getDocument(path);
        Document document = DB.getDoc();

    //     <candidate>
    //     <cId>24336</cId>
    //     <name>Alex</name>
    //     <workExp>true</workExp>
    //     <eduLevel>1</eduLevel>
    //     <Gpa>3.2</Gpa>
    //     <skills>
    //         <a>matlab</a>
    //         <a>excel</a>
    //         <a>programming</a>
    //     </skills>
    // </candidate>

        NodeList nodeList = document.getElementsByTagName("candidates");
        Element candidateEle = document.createElement("candidate");

        // create element cId
        Element cIdEle = document.createElement("cId");
        // set text value
        cIdEle.setTextContent(String.valueOf(candidate.getId()));
        // add to parent node
        candidateEle.appendChild(cIdEle);

        // create element name
        Element nameEle = document.createElement("name");
        // set text value
        nameEle.setTextContent(candidate.getName());
        // add to parent node
        candidateEle.appendChild(nameEle);

        // create element workExp
        Element workExpEle = document.createElement("workExp");
        // set text value
        workExpEle.setTextContent(String.valueOf(candidate.getWorkExperience()));
        // add to parent node
        candidateEle.appendChild(workExpEle);

        // create element eduLevel
        Element eduLevelEle = document.createElement("eduLevel");
        // set text value
        eduLevelEle.setTextContent(String.valueOf(candidate.getEducationLevel()));
        // add to parent node
        candidateEle.appendChild(eduLevelEle);

        // create element eduLevel
        Element GpaEle = document.createElement("Gpa");
        // set text value
        GpaEle.setTextContent(String.valueOf(candidate.getGpa()));
        // add to parent node
        candidateEle.appendChild(GpaEle);

        // create element workExp
        Element skillsEle = document.createElement("skills");
        for (String s : candidate.getSkills()) {
            Element aEle = document.createElement("a");
            aEle.setTextContent(s);
            skillsEle.appendChild(aEle);
        }
        // set text value

        // add to parent node
        candidateEle.appendChild(skillsEle);

        // add to parent node
        nodeList.item(0).appendChild(candidateEle);

        // save xml
        XMLTool.saveXml(document, path);

    }

    public static void addRequirement(Requirement requirement)
            throws TransformerException {
        // Document document = XMLTool.getDocument(path);
        Document document = DB.getDoc();
        NodeList nodeList = document.getElementsByTagName("requirements");
        Element requirementEle = document.createElement("requirement");

        // create element cId
        Element cIdEle = document.createElement("rId");
        // set text value
        cIdEle.setTextContent(String.valueOf(requirement.getId()));
        // add to parent node
        requirementEle.appendChild(cIdEle);

        // create element name
        Element nameEle = document.createElement("rCourse");
        // set text value
        nameEle.setTextContent(requirement.getCourse());
        // add to parent node
        requirementEle.appendChild(nameEle);

        // create element cId
        Element rNumEle = document.createElement("rNum");
        // set text value
        rNumEle.setTextContent(String.valueOf(requirement.getNum()));
        // add to parent node
        requirementEle.appendChild(rNumEle);

        // create element workExp
        Element rWorkExpEle = document.createElement("rWorkExp");
        // set text value
        rWorkExpEle.setTextContent(String.valueOf(requirement.getWorkExperience()));
        // add to parent node
        requirementEle.appendChild(rWorkExpEle);

        // create element eduLevel
        Element rEduLevelEle = document.createElement("rEduLevel");
        // set text value
        rEduLevelEle.setTextContent(String.valueOf(requirement.getEducationLevel()));
        // add to parent node
        requirementEle.appendChild(rEduLevelEle);

        // create element rGpa
        Element rGpaEle = document.createElement("rGpa");
        // set text value
        rGpaEle.setTextContent(String.valueOf(requirement.getGpa()));
        // add to parent node
        requirementEle.appendChild(rGpaEle);

        // create element workExp
        Element skillsEle = document.createElement("skills");
        for (String s : requirement.getSkills()) {
            Element aEle = document.createElement("a");
            aEle.setTextContent(s);
            skillsEle.appendChild(aEle);
        }
        // set text value

        // add to parent node
        requirementEle.appendChild(skillsEle);

        // add to parent node
        nodeList.item(0).appendChild(requirementEle);

        // save xml
        XMLTool.saveXml(document, path);

    }

    public static void addSuitableStaff(SuitableStaff staff)
            throws ParserConfigurationException, IOException, SAXException, TransformerException {
        // Document document = XMLTool.getDocument(path);
        Document document = DB.getDoc();

    //     <SuitableStaffs>
    //     <Staff>
    //         <sId>24350</sId>
    //         <name>Tamplate Staff</name>
    //         <workExp>false</workExp>
    //         <eduLevel>2</eduLevel>
    //         <Gpa>4.5</Gpa>
    //         <skills>
    //             <a>matlab</a>
    //             <a>excel</a>
    //             <a>academic writing</a>
    //             <a>programming</a>
    //         </skills>
    //         <TrainingTime>null</TrainingTime>
    //     </Staff>    
    // </SuitableStaffs>
        NodeList nodeList = document.getElementsByTagName("SuitableStaffs");
        Element staffEle = document.createElement("Staff");

        // create element cId
        Element sIdEle = document.createElement("sId");
        // set text value
        sIdEle.setTextContent(String.valueOf(staff.getId()));
        // // add to parent node
        staffEle.appendChild(sIdEle);
        Element trainedEle = document.createElement("trained");
        // set text value
        trainedEle.setTextContent(String.valueOf(staff.getIfTrained()));
        // add to parent node
        staffEle.appendChild(trainedEle);

        // create element name
        Element nameEle = document.createElement("name");
        // set text value
        nameEle.setTextContent(staff.getName());
        // add to parent node
        staffEle.appendChild(nameEle);

        // create element workExp
        Element workExpEle = document.createElement("workExp");
        // set text value
        workExpEle.setTextContent(String.valueOf(staff.getWorkExperience()));
        // add to parent node
        staffEle.appendChild(workExpEle);

        // create element eduLevel
        Element eduLevelEle = document.createElement("eduLevel");
        // set text value
        eduLevelEle.setTextContent(String.valueOf(staff.getEducationLevel()));
        // add to parent node
        staffEle.appendChild(eduLevelEle);

        // create element eduLevel
        Element GpaEle = document.createElement("Gpa");
        // set text value
        GpaEle.setTextContent(String.valueOf(staff.getGpa()));
        // add to parent node
        staffEle.appendChild(GpaEle);

        // create element workExp
        Element skillsEle = document.createElement("skills");
        for (String s : staff.getSkills()) {
            Element aEle = document.createElement("a");
            aEle.setTextContent(s);
            skillsEle.appendChild(aEle);
        }
        // set text value

        // add to parent node
        staffEle.appendChild(skillsEle);

        // add to parent node
        nodeList.item(0).appendChild(staffEle);

        // save xml
        XMLTool.saveXml(document, path);

    }

    public static void updateCandidate(Candidate candidate)
            throws TransformerException {
        // Document document = XMLTool.getDocument(path);
        Document document = DB.getDoc();
        Node searchNode = XMLTool.getNode(document, "candidate", String.valueOf(candidate.getId()));
        if (searchNode != null) {
            NodeList nlist = searchNode.getChildNodes();
            for (int i = 0; i < nlist.getLength(); i++) {
                Node subnode = nlist.item(i);
                System.out.println(subnode.getNodeName() + ":" + subnode.getTextContent());
                if (subnode.getNodeName().equals("name")) {
                    subnode.setTextContent(candidate.getName());
                }
                if (subnode.getNodeName().equals("workExp")) {
                    subnode.setTextContent(String.valueOf(candidate.getWorkExperience()));
                }
                if (subnode.getNodeName().equals("eduLevel")) {
                    subnode.setTextContent(String.valueOf(candidate.getEducationLevel()));
                }
                if (subnode.getNodeName().equals("Gpa")) {
                    subnode.setTextContent(String.valueOf(candidate.getEducationLevel()));
                }
                if (subnode.getNodeName().equals("skills")) {
                    searchNode.removeChild(subnode);
                    // create element workExp
                    Element skillsEle = document.createElement("skills");
                    for (String s : candidate.getSkills()) {
                        Element aEle = document.createElement("a");
                        // set text value
                        aEle.setTextContent(s);
                        skillsEle.appendChild(aEle);
                    }
                    // add to parent node
                    searchNode.appendChild(skillsEle);
                }
            }
            // save xml
            XMLTool.saveXml(document, path);
        }

    }

    public static void updateStaff(SuitableStaff staff)
            throws TransformerException {
        // Document document = XMLTool.getDocument(path);
        Document document = DB.getDoc();
        Node searchNode = XMLTool.getNode(document, "Staff", String.valueOf(staff.getId()));
        // <Staff>
        //     <sId>24350</sId>
        //     <trained>false</trained>
        //     <name>Tamplate Staff</name>
        //     <workExp>false</workExp>
        //     <eduLevel>2</eduLevel>
        //     <Gpa>4.5</Gpa>
        //     <skills>
        //         <a>matlab</a>
        //         <a>excel</a>
        //         <a>academic writing</a>
        //         <a>programming</a>
        //     </skills>
        // </Staff>
        if (searchNode != null) {
            NodeList nlist = searchNode.getChildNodes();
            for (int i = 0; i < nlist.getLength(); i++) {
                Node subnode = nlist.item(i);
                System.out.println(subnode.getNodeName() + ":" + subnode.getTextContent());
                if (subnode.getNodeName().equals("name")) {
                    subnode.setTextContent(staff.getName());
                }
                if (subnode.getNodeName().equals("trained")) {
                    subnode.setTextContent(String.valueOf(staff.getIfTrained()));
                }
                if (subnode.getNodeName().equals("workExp")) {
                    subnode.setTextContent(String.valueOf(staff.getWorkExperience()));
                }
                if (subnode.getNodeName().equals("eduLevel")) {
                    subnode.setTextContent(String.valueOf(staff.getEducationLevel()));
                }
                if (subnode.getNodeName().equals("Gpa")) {
                    subnode.setTextContent(String.valueOf(staff.getEducationLevel()));
                }
                if (subnode.getNodeName().equals("skills")) {
                    searchNode.removeChild(subnode);
                    // create element workExp
                    Element skillsEle = document.createElement("skills");
                    for (String s : staff.getSkills()) {
                        Element aEle = document.createElement("a");
                        // set text value
                        aEle.setTextContent(s);
                        skillsEle.appendChild(aEle);
                    }
                    // add to parent node
                    searchNode.appendChild(skillsEle);
                }
            }
            // save xml
            XMLTool.saveXml(document, path);
        }

    }

    public static void updateRequirement(Requirement requirement)
            throws TransformerException{
        // Document document = XMLTool.getDocument(path);
        Document document = DB.getDoc();
        Node searchNode = XMLTool.getNode(document, "requirement", String.valueOf(requirement.getId()));
        if (searchNode != null) {
            NodeList nlist = searchNode.getChildNodes();
            for (int i = 0; i < nlist.getLength(); i++) {
                Node subnode = nlist.item(i);
                System.out.println(subnode.getNodeName() + ":" + subnode.getTextContent());
                if (subnode.getNodeName().equals("rCourse")) {
                    subnode.setTextContent(requirement.getCourse());
                }
                if (subnode.getNodeName().equals("rNum")) {
                    subnode.setTextContent(String.valueOf(requirement.getNum()));
                }
                if (subnode.getNodeName().equals("rWorkExp")) {
                    subnode.setTextContent(String.valueOf(requirement.getWorkExperience()));
                }
                if (subnode.getNodeName().equals("rEduLevel")) {
                    subnode.setTextContent(String.valueOf(requirement.getEducationLevel()));
                }
                if (subnode.getNodeName().equals("rGpa")) {
                    subnode.setTextContent(String.valueOf(requirement.getEducationLevel()));
                }
                if (subnode.getNodeName().equals("skills")) {
                    searchNode.removeChild(subnode);
                    // create element workExp
                    Element skillsEle = document.createElement("skills");
                    for (String s : requirement.getSkills()) {
                        Element aEle = document.createElement("a");
                        // set text value
                        aEle.setTextContent(s);
                        skillsEle.appendChild(aEle);
                    }
                    // add to parent node
                    searchNode.appendChild(skillsEle);
                }
            }
            // save xml
            XMLTool.saveXml(document, path);
        }

    }

    /**
     *
     * @param ID
     * @param TagName
     * "candidate" "requirement" “Staff”
     */
    public static  void deleteXML(int ID,String TagName) throws TransformerException {
        Document document = DB.getDoc();
        NodeList nlist = document.getElementsByTagName(TagName);
        for (int i = 0; i < nlist.getLength(); i++) {
            Node node = nlist.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                System.err.println("Error: Search node not of element type");
                System.exit(22);
            }
            NodeList sublist = node.getChildNodes();
            for (int j = 0; j < sublist.getLength(); j++) {
                Node subnode = sublist.item(j);
                if (subnode.getNodeType() == Node.ELEMENT_NODE) {
                    if (subnode.getTextContent().equals(String.valueOf(ID))) {
                        Node pNode = subnode.getParentNode();
                        pNode.getParentNode().removeChild(pNode);
                        System.out.println("delete ID" + subnode.getTextContent());
                        XMLTool.saveXml(document, path);
                        return;
                    }

                }
            }            
        }
        System.out.println("Delete failed, could not find ID " + ID+" in tag "+TagName);
    }
}