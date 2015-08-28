package datamanagement;

import java.util.List;
import org.jdom.*;

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

	
	
	public InterfaceStudentUnitRecord getStudentUnitRecord(Integer studentId, String unitCode) {
		InterfaceStudentUnitRecord record = recordMap_.get(studentId.toString() + unitCode);
		if (record == null) {
			record = createStudentUnitRecord(studentId, unitCode);
		}
		return record;
	}

	
	
	private InterfaceStudentUnitRecord createStudentUnitRecord(Integer studentId, String unitCode) {
		InterfaceStudentUnitRecord record;
		
		Document document = XMLManager.getXML().getDocument();
		@SuppressWarnings("unchecked")
		List<Element> elements = (List<Element>) document.getRootElement()
									.getChild("studentUnitRecordTable").getChildren("record");
	
		for (Element element : elements) {
			if (studentId.toString().equals(element.getAttributeValue("sid"))
					&& unitCode.equals(element.getAttributeValue("uid"))) {
				record = new StudentUnitRecord(new Integer(element.getAttributeValue("sid")),
						element.getAttributeValue("uid"), new Float(element.getAttributeValue("asg1")).floatValue(),
						new Float(element.getAttributeValue("asg2")).floatValue(),
						new Float(element.getAttributeValue("exam")).floatValue());
				recordMap_.put(record.getStudentId().toString() + record.getUnitCode(), record);
				return record;
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
		
		Document document = XMLManager.getXML().getDocument();
		
		@SuppressWarnings("unchecked")
		List<Element> elements = (List<Element>) document.getRootElement()
									.getChild("studentUnitRecordTable").getChildren("record");
	
		for (Element element : elements) {
			if (unitCode.equals(element.getAttributeValue("uid"))){
				Integer studentId = new Integer(element.getAttributeValue("sid"));			
				StudentUnitRecordProxy studentProxy = new StudentUnitRecordProxy(studentId, unitCode);
				records.add(studentProxy);
			}
		}
		if (records.size() > 0) {
			recordsByUnit_.put(unitCode, records);  // be careful - this could be empty
		}
		return records;
	}

	
	
	public StudentUnitRecordList getRecordsByStudent(Integer studentId) {
		
		StudentUnitRecordList records = recordsByStudent_.get(studentId);
		
		if (records != null) {
			return records;
		}
		records = new StudentUnitRecordList();
		Document document = XMLManager.getXML().getDocument();
		@SuppressWarnings("unchecked")
		List<Element> elements = (List<Element>) document.getRootElement()
									.getChild("studentUnitRecordTable").getChildren("record");
		for (Element element : elements) {
			if (studentId.toString().equals(element.getAttributeValue("sid"))) {
				records.add(new StudentUnitRecordProxy(new Integer(element.getAttributeValue("sid")),
						element.getAttributeValue("uid")));
			}
		}
		if (records.size() > 0) {
			recordsByStudent_.put(studentId, records); // be careful - this could be empty
		}
		return records;
	}

	
	
	public void saveRecord(InterfaceStudentUnitRecord recordInterface) {
		Document document = XMLManager.getXML().getDocument();
		@SuppressWarnings("unchecked")
		List<Element> elements = (List<Element>) document.getRootElement()
									.getChild("studentUnitRecordTable").getChildren("record");
		for (Element element : elements) {
			if (recordInterface.getStudentId().toString().equals(element.getAttributeValue("sid"))
					&& recordInterface.getUnitCode().equals(element.getAttributeValue("uid"))) {
					element.setAttribute("asg1", new Float(recordInterface.getAssignment1Mark()).toString());
					element.setAttribute("asg2", new Float(recordInterface.getAssignment2Mark()).toString());
					element.setAttribute("exam", new Float(recordInterface.getExamMark()).toString());
					XMLManager.getXML().saveDocument(); // write out the XML file for continuous save
				return;
			}
		}
		throw new RuntimeException("DBMD: saveRecord : no such student record in data");
	}
}
