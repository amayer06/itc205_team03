package datamanagement;

import java.util.List;
import org.jdom.*;
import org.jdom.Document;

public class StudentUnitRecordManager {

	private static StudentUnitRecordManager studentUnitRecordManager_ = null;
	private StudentUnitRecordMap recordMap_;
	private java.util.HashMap<String, StudentUnitRecordList> recordsByUnit_;
	private java.util.HashMap<Integer, StudentUnitRecordList> recordsByStudent_;

	
	
	public static StudentUnitRecordManager instance() {
		if (studentUnitRecordManager_ == null) {
			studentUnitRecordManager_ = new StudentUnitRecordManager();
		}
		return studentUnitRecordManager_;
	}
	
	
	
	private StudentUnitRecordManager() {
		recordMap_ = new StudentUnitRecordMap();
		recordsByUnit_ = new java.util.HashMap<>();
		recordsByStudent_ = new java.util.HashMap<>();
	}

	
	
	public InterfaceStudentUnitRecord getStudentUnitRecord(Integer studentID, String unitCode) {
		InterfaceStudentUnitRecord record = recordMap_.get(studentID.toString() + unitCode);
		if (record == null) {
			record = createStudentUnitRecord(studentID, unitCode);
		}
		return record;
	}

	
	
	private InterfaceStudentUnitRecord createStudentUnitRecord(Integer studentId, String unitCode) {
		InterfaceStudentUnitRecord ir;
		
		Document doc = XMLManager.getXML().getDocument();
		@SuppressWarnings("unchecked")
		List<Element> elements = (List<Element>) doc.getRootElement()
									.getChild("studentUnitRecordTable").getChildren("record");
	
		for (Element el : elements) {
			if (studentId.toString().equals(el.getAttributeValue("sid"))
					&& unitCode.equals(el.getAttributeValue("uid"))) {
				ir = new StudentUnitRecord(new Integer(el.getAttributeValue("sid")),
						el.getAttributeValue("uid"), new Float(el.getAttributeValue("asg1")).floatValue(),
						new Float(el.getAttributeValue("asg2")).floatValue(),
						new Float(el.getAttributeValue("exam")).floatValue());
				recordMap_.put(ir.getStudentId().toString() + ir.getUnitCode(), ir);
				return ir;
			}
		}
		throw new RuntimeException("DBMD: createStudent : student unit record not in file");
	}

	
	
	public StudentUnitRecordList getRecordsByUnit(String unitCode) {
		StudentUnitRecordList records = recordsByUnit_.get(unitCode);
		if (records != null) {
			return records;
		}
		records = new StudentUnitRecordList();
		
		Document doc = XMLManager.getXML().getDocument();
		@SuppressWarnings("unchecked")
		List<Element> elements = (List<Element>) doc.getRootElement()
									.getChild("studentUnitRecordTable").getChildren("record");
	
		for (Element el : elements) {
			if (unitCode.equals(el.getAttributeValue("uid"))){
				Integer studentId = new Integer(el.getAttributeValue("sid"));			
				StudentUnitRecordProxy studentProxy = new StudentUnitRecordProxy(studentId, unitCode);
				records.add(studentProxy);
			}
		}
		if (records.size() > 0) {
			recordsByUnit_.put(unitCode, records);  // be careful - this could be empty
		}
		return records;
	}

	
	
	public StudentUnitRecordList getRecordsByStudent(Integer studentID) {
		StudentUnitRecordList recs = recordsByStudent_.get(studentID);
		if (recs != null) {
			return recs;
		}
		recs = new StudentUnitRecordList();
		
		Document doc = XMLManager.getXML().getDocument();
		@SuppressWarnings("unchecked")
		List<Element> elements = (List<Element>) doc.getRootElement()
									.getChild("studentUnitRecordTable").getChildren("record");
	
		for (Element el : elements) {
			if (studentID.toString().equals(el.getAttributeValue("sid"))) {
				recs.add(new StudentUnitRecordProxy(new Integer(el.getAttributeValue("sid")),
						el.getAttributeValue("uid")));
			}
		}
		if (recs.size() > 0) {
			recordsByStudent_.put(studentID, recs); // be careful - this could be empty
		}
		return recs;
	}

	
	
	public void saveRecord(InterfaceStudentUnitRecord irec) {
		
		Document doc = XMLManager.getXML().getDocument();
		@SuppressWarnings("unchecked")
		List<Element> elements = (List<Element>) doc.getRootElement()
									.getChild("studentUnitRecordTable").getChildren("record");
		for (Element el : elements) {
			if (irec.getStudentId().toString().equals(el.getAttributeValue("sid"))
					&& irec.getUnitCode().equals(el.getAttributeValue("uid"))) {
					el.setAttribute("asg1", new Float(irec.getAssignment1Mark()).toString());
					el.setAttribute("asg2", new Float(irec.getAssignment2Mark()).toString());
					el.setAttribute("exam", new Float(irec.getExamMark()).toString());
					XMLManager.getXML().saveDocument(); // write out the XML file for continuous save
				return;
			}
		}
		throw new RuntimeException("DBMD: saveRecord : no such student record in data");
	}
}
