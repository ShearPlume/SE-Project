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
    private static DataBase DB;

    private static String path = System.getProperty("user.dir") + "\\Database.xml";

    public DBReader(DataBase DB) {
        this.DB = DB;
    }

    public void readFromDB() {

    }

    public static Object getSpecificObject(int ID,String TagName) {
        Document document = DB.getDoc();
        Node pNode = null;
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
                        pNode = subnode.getParentNode();
                        NodeList list = pNode.getChildNodes();
                        switch(TagName)
                        {
                            case "requirement":{
                                Requirement req=new Requirement();
                                for (int k = 0; k < list.getLength(); k++) {
                                    subnode = sublist.item(k);

                                    // <rId>1</rId><!--requirement
                                    // ID-->
                                    // <rCourse>Math</rCourse><!--requirement
                                    // course-->
                                    // <rNum>1</rNum><!--required
                                    // staff number-->
                                    // <rWorkExp>true</rWorkExp><!--required
                                    // work experience-->
                                    // <rEduLevel>3</rEduLevel><!--education
                                    // level: doctor > postgraduate > undergraduate-->
                                    // <rGpa>3.0</rGpa>
                                    // <skills><!--required
                                    //     skills-->
                                    //     <a>matlab</a>
                                    //     <a>excel</a>
                                    // </skills>
                                    if (subnode.getNodeType() == Node.ELEMENT_NODE) {
                                        // System.out.println(subnode.getNodeName() + ":" + subnode.getTextContent());
                                        if (subnode.getNodeName().equals("rId")) {
                                            req.setId(Integer.parseInt(subnode.getTextContent()));
                                        }
                                        if (subnode.getNodeName().equals("rCourse")) {
                                            req.setCourse(subnode.getTextContent());
                                        }
                                        if (subnode.getNodeName().equals("rWorkExp")) {
                                            req.setWorkExperience(Boolean.parseBoolean(subnode.getTextContent()));
                                        }
                                        if (subnode.getNodeName().equals("rEduLevel")) {
                                            req.setEducationLevel(Integer.parseInt(subnode.getTextContent()));
                                        }
                                        if (subnode.getNodeName().equals("rGpa")) {
                                            req.setGpa(Double.parseDouble(subnode.getTextContent()));
                                        }
        
                                        if (subnode.getNodeName().equals("skills")) {
                                            List<String> skillList = new ArrayList<>();
                                            if (subnode.hasChildNodes()) {
                                                NodeList skillNlist = subnode.getChildNodes();
                                                for (int o = 0; o < skillNlist.getLength(); o++) {
                                                    if (subnode.getNodeType() == Node.ELEMENT_NODE) {
                                                        Node skillNode = skillNlist.item(o);
                                                        if (skillNode.getNodeName().equals("a")) {
                                                            skillList.add(skillNode.getTextContent());
                                                        }
                                                    }
                                                }
                                            }
                                            req.setSkills(skillList);
                                        }
                                    }
        
        
                                }
                                return req;
                            }
                            case "candidate":{
                                Candidate can=new Candidate("", false,0, 0);
                                for (int k = 0; k < list.getLength(); k++) {
                                    subnode = sublist.item(k);
                                    if (subnode.getNodeType() == Node.ELEMENT_NODE) {
                                        // System.out.println(subnode.getNodeName() + ":" + subnode.getTextContent());
                                        if (subnode.getNodeName().equals("cId")) {
                                            can.setId(Integer.parseInt(subnode.getTextContent()));
                                        }
                                        if (subnode.getNodeName().equals("name")) {
                                            can.setName(subnode.getTextContent());
                                        }
                                        if (subnode.getNodeName().equals("workExp")) {
                                            can.setWorkExperience(Boolean.parseBoolean(subnode.getTextContent()));
                                        }
                                        if (subnode.getNodeName().equals("eduLevel")) {
                                            can.setEducationLevel(Integer.parseInt(subnode.getTextContent()));
                                        }
                                        if (subnode.getNodeName().equals("Gpa")) {
                                            can.setGpa(Double.parseDouble(subnode.getTextContent()));
                                        }
        
                                        if (subnode.getNodeName().equals("skills")) {
                                            List<String> skillList = new ArrayList<>();
                                            if (subnode.hasChildNodes()) {
                                                NodeList skillNlist = subnode.getChildNodes();
                                                for (int o = 0; o < skillNlist.getLength(); o++) {
                                                    if (subnode.getNodeType() == Node.ELEMENT_NODE) {
                                                        Node skillNode = skillNlist.item(o);
                                                        if (skillNode.getNodeName().equals("a")) {
                                                            skillList.add(skillNode.getTextContent());
                                                        }
                                                    }
                                                }
                                            }
                                            can.setSkills(skillList);
                                        }
                                    }
        
        
                                }
                                return can;

                            }
                            case "Staff":
                            {
                                SuitableStaff staff = new SuitableStaff(false, "", false, 0, 0);
                                for (int k = 0; k < list.getLength(); k++) {
                                    subnode = sublist.item(k);
                                    if (subnode.getNodeType() == Node.ELEMENT_NODE) {
                                        // System.out.println(subnode.getNodeName() + ":" + subnode.getTextContent());
                                        if (subnode.getNodeName().equals("sId")) {
                                            staff.setId(Integer.parseInt(subnode.getTextContent()) );
                                        }
                                        if (subnode.getNodeName().equals("name")) {
                                            staff.setName(subnode.getTextContent());
                                        }
                                        if (subnode.getNodeName().equals("workExp")) {
                                            staff.setWorkExperience(Boolean.parseBoolean(subnode.getTextContent()));
                                        }
                                        if (subnode.getNodeName().equals("eduLevel")) {
                                            staff.setEducationLevel(Integer.parseInt(subnode.getTextContent()));
                                        }
                                        if (subnode.getNodeName().equals("Gpa")) {
                                            staff.setGpa(Double.parseDouble(subnode.getTextContent()));
                                        }
                                        if (subnode.getNodeName().equals("trained")) {
                                            staff.setIftrained(Boolean.parseBoolean(subnode.getTextContent()));
                                        }
        
                                        if (subnode.getNodeName().equals("skills")) {
                                            List<String> skillList = new ArrayList<>();
                                            if (subnode.hasChildNodes()) {
                                                NodeList skillNlist = subnode.getChildNodes();
                                                for (int o = 0; o < skillNlist.getLength(); o++) {
                                                    if (subnode.getNodeType() == Node.ELEMENT_NODE) {
                                                        Node skillNode = skillNlist.item(o);
                                                        if (skillNode.getNodeName().equals("a")) {
                                                            skillList.add(skillNode.getTextContent());
                                                        }
                                                    }
                                                }
                                            }
                                            staff.setSkills(skillList);
                                        }
                                    }
        
        
                                }
                                return staff;
                            }

                        }
                        

                    }

                }
            }

        }
        System.out.println("get failed, could not find a staff with ID " + ID);
        return null;
    }

    public static List<Candidate> getCandidateList() throws ParserConfigurationException, IOException, SAXException {
        // Document document = XMLTool.getDocument(path);
        Document document = DB.getDoc();
        List<Candidate> candidateList = new ArrayList<>();
        NodeList nlist = document.getElementsByTagName("candidate");
        for (int i = 0; i < nlist.getLength(); i++) {
            Candidate candidate = new Candidate("", false, 0, 0);
            Node node = nlist.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                System.err.println("Error: Search node not of element type");
                System.exit(22);
            }

            // System.out.println(node.getNodeName());
            NodeList subNlist = node.getChildNodes();
            for (int j = 0; j < subNlist.getLength(); j++) {
                Node subnode = subNlist.item(j);
                if (subnode.getNodeType() == Node.ELEMENT_NODE) {
                    // System.out.println(subnode.getNodeName() + ":" + subnode.getTextContent());
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
                    if (subnode.getNodeName().equals("Gpa")) {
                        candidate.setGpa(Double.parseDouble(subnode.getTextContent()));
                    }

                    if (subnode.getNodeName().equals("skills")) {
                        List<String> skillList = new ArrayList<>();
                        if (subnode.hasChildNodes()) {
                            NodeList skillNlist = subnode.getChildNodes();
                            for (int o = 0; o < skillNlist.getLength(); o++) {
                                if (subnode.getNodeType() == Node.ELEMENT_NODE) {
                                    Node skillNode = skillNlist.item(o);
                                    if (skillNode.getNodeName().equals("a")) {
                                        skillList.add(skillNode.getTextContent());
                                    }
                                }
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

    public static List<Requirement> getRequirementList()
            throws ParserConfigurationException, IOException, SAXException {
        // Document document = XMLTool.getDocument(path);
        Document document = DB.getDoc();
        List<Requirement> requirementList = new ArrayList<>();
        NodeList nlist = document.getElementsByTagName("requirement");
        for (int i = 0; i < nlist.getLength(); i++) {
            Requirement requirement = new Requirement();
            Node node = nlist.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                System.err.println("Error: Search node not of element type");
                System.exit(22);
            }

            // System.out.println(node.getNodeName());
            NodeList subNlist = node.getChildNodes();
            for (int j = 0; j < subNlist.getLength(); j++) {
                Node subnode = subNlist.item(j);
                if (subnode.getNodeType() == Node.ELEMENT_NODE) {
                    // System.out.println(subnode.getNodeName() + ":" + subnode.getTextContent());
                    if (subnode.getNodeName().equals("rId")) {
                        requirement.setId(Integer.parseInt(subnode.getTextContent()));
                    }
                    if (subnode.getNodeName().equals("rCourse")) {
                        requirement.setCourse(subnode.getTextContent());
                    }
                    if (subnode.getNodeName().equals("rWorkExp")) {
                        requirement.setWorkExperience(Boolean.parseBoolean(subnode.getTextContent()));
                    }
                    if (subnode.getNodeName().equals("rEduLevel")) {
                        requirement.setEducationLevel(Integer.parseInt(subnode.getTextContent()));
                    }
                    if (subnode.getNodeName().equals("rGpa")) {
                        requirement.setGpa(Double.parseDouble(subnode.getTextContent()));
                    }

                    if (subnode.getNodeName().equals("skills")) {
                        List<String> skillList = new ArrayList<>();
                        if (subnode.hasChildNodes()) {
                            NodeList skillNlist = subnode.getChildNodes();
                            for (int o = 0; o < skillNlist.getLength(); o++) {
                                if (subnode.getNodeType() == Node.ELEMENT_NODE) {
                                    Node skillNode = skillNlist.item(o);
                                    if (skillNode.getNodeName().equals("a")) {
                                        skillList.add(skillNode.getTextContent());
                                    }
                                }
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
    public static List<SuitableStaff> getStaffList() throws ParserConfigurationException, IOException, SAXException {
        // Document document = XMLTool.getDocument(path);
        Document document = DB.getDoc();
        List<SuitableStaff> staffList = new ArrayList<>();
        NodeList nlist = document.getElementsByTagName("Staff");
        for (int i = 0; i < nlist.getLength(); i++) {
            SuitableStaff staff = new SuitableStaff( false,"",false, 0, 0);//Boolean ifTrained, String name, Boolean workExperience,int educationLevel, double gpa
            Node node = nlist.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                System.err.println("Error: Search node not of element type");
                System.exit(22);
            }

        //     <Staff>
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

            // System.out.println(node.getNodeName());
            NodeList subNlist = node.getChildNodes();
            for (int j = 0; j < subNlist.getLength(); j++) {
                Node subnode = subNlist.item(j);
                if (subnode.getNodeType() == Node.ELEMENT_NODE) {
                    // System.out.println(subnode.getNodeName() + ":" + subnode.getTextContent());
                    if (subnode.getNodeName().equals("sId")) {
                        staff.setId(Integer.parseInt(subnode.getTextContent()));
                    }
                    if (subnode.getNodeName().equals("trained")) {
                        staff.setIftrained(Boolean.parseBoolean(subnode.getTextContent()));
                    }
                    if (subnode.getNodeName().equals("name")) {
                        staff.setName(subnode.getTextContent());
                    }
                    if (subnode.getNodeName().equals("workExp")) {
                        staff.setWorkExperience(Boolean.parseBoolean(subnode.getTextContent()));
                    }
                    if (subnode.getNodeName().equals("eduLevel")) {
                        staff.setEducationLevel(Integer.parseInt(subnode.getTextContent()));
                    }
                    if (subnode.getNodeName().equals("Gpa")) {
                        staff.setGpa(Double.parseDouble(subnode.getTextContent()));
                    }

                    if (subnode.getNodeName().equals("skills")) {
                        List<String> skillList = new ArrayList<>();
                        if (subnode.hasChildNodes()) {
                            NodeList skillNlist = subnode.getChildNodes();
                            for (int o = 0; o < skillNlist.getLength(); o++) {
                                if (subnode.getNodeType() == Node.ELEMENT_NODE) {
                                    Node skillNode = skillNlist.item(o);
                                    if (skillNode.getNodeName().equals("a")) {
                                        skillList.add(skillNode.getTextContent());
                                    }
                                }
                            }
                        }
                        staff.setSkills(skillList);
                    }
                }
            }
            staffList.add(staff);
        }
        return staffList;
    }


}