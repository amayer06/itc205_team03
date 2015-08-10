package datamanagement;

import org.jdom.*;
import java.util.List;

public class StudentManager {
	private static StudentManager self = null;

	private StudentMap studentMap;
	private java.util.HashMap<String, StudentMap> unitMap;

	public static StudentManager get() {
		if (self == null)

			self = new StudentManager();
		return self;
	}

	private StudentManager() {

		studentMap = new StudentMap();
		unitMap = new java.util.HashMap<>();
	}

	public InterfaceStudent getStudent(Integer id) {
		InterfaceStudent studentInterface = studentMap.get(id);
		return studentInterface != null ? studentInterface : createStudent(id);
	}

	private Element getStudentElement(Integer id) {
		for (Element el : (List<Element>) XMLManager.getXML().getDocument()
				.getRootElement().getChild("studentTable")
				.getChildren("student"))
			if (id.toString().equals(el.getAttributeValue("sid")))
				return el;
		return null;
	}

	private InterfaceStudent createStudent(Integer id) {
		InterfaceStudent studentId;
		Element element = getStudentElement(id);
		if (element != null) {
			StudentUnitRecordList recordsList = StudentUnitRecordManager.instance()
					.getRecordsByStudent(id);
			studentId = new Student(new Integer(element.getAttributeValue("sid")),
					element.getAttributeValue("fname"),
					element.getAttributeValue("lname"), recordsList);

			studentMap.put(studentId.getID(), studentId);
			return studentId;
		}
		throw new RuntimeException("DBMD: createStudent : student not in file");
	}

	private InterfaceStudent createStudentProxy(Integer studentId) {
		Element studentElement = getStudentElement(studentId);

		if (studentElement != null)
			return new StudentProxy(studentId, studentElement.getAttributeValue("fname"),
					studentElement.getAttributeValue("lname"));
		throw new RuntimeException("DBMD: createStudent : student not in file");
	}

	public StudentMap getStudentsByUnit(String unitCode) {
		StudentMap student = unitMap.get(unitCode);
		if (student != null) {

			return student;
		}

		student = new StudentMap();
		InterfaceStudent studentId;
		StudentUnitRecordList unitRecord = StudentUnitRecordManager.instance()
				.getRecordsByUnit(unitCode);
		for (InterfaceStudentUnitRecord S : unitRecord) {

			studentId = createStudentProxy(new Integer(S.getStudentId()));
			student.put(studentId.getID(), studentId);
		}
		unitMap.put(unitCode, student);
		return student;
	}
}
