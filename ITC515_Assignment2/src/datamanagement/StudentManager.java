package datamanagement;

import org.jdom.*;
import java.util.List;

public class StudentManager {
	private static StudentManager self = null;

	private StudentMap studentMap;
	private java.util.HashMap<String, StudentMap> um;

	public static StudentManager get() {
		if (self == null)

			self = new StudentManager();
		return self;
	}

	private StudentManager() {

		studentMap = new StudentMap();
		um = new java.util.HashMap<>();
	}

	public IStudent getStudent(Integer id) {
		IStudent is = studentMap.get(id);
		return is != null ? is : createStudent(id);
	}

	private Element getStudentElement(Integer id) {
		for (Element el : (List<Element>) XMLManager.getXML().getDocument()
				.getRootElement().getChild("studentTable")
				.getChildren("student"))
			if (id.toString().equals(el.getAttributeValue("sid")))
				return el;
		return null;
	}

	private IStudent createStudent(Integer id) {
		IStudent is;
		Element el = getStudentElement(id);
		if (el != null) {
			StudentUnitRecordList rlist = StudentUnitRecordManager.instance()
					.getRecordsByStudent(id);
			is = new Student(new Integer(el.getAttributeValue("sid")),
					el.getAttributeValue("fname"),
					el.getAttributeValue("lname"), rlist);

			studentMap.put(is.getID(), is);
			return is;
		}
		throw new RuntimeException("DBMD: createStudent : student not in file");
	}

	private IStudent createStudentProxy(Integer id) {
		Element studentElement = getStudentElement(id);

		if (studentElement != null)
			return new StudentProxy(id, studentElement.getAttributeValue("fname"),
					studentElement.getAttributeValue("lname"));
		throw new RuntimeException("DBMD: createStudent : student not in file");
	}

	public StudentMap getStudentsByUnit(String uc) {
		StudentMap student = um.get(uc);
		if (student != null) {

			return student;
		}

		student = new StudentMap();
		IStudent is;
		StudentUnitRecordList ur = StudentUnitRecordManager.instance()
				.getRecordsByUnit(uc);
		for (IStudentUnitRecord S : ur) {

			is = createStudentProxy(new Integer(S.getStudentID()));
			student.put(is.getID(), is);
		}
		um.put(uc, student);
		return student;
	}
}
