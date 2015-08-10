package datamanagement;

public class ListStudentsControl {
	private StudentManager studentManager;

	public ListStudentsControl() {
		studentManager = StudentManager.get();
	}

	public void listStudents(InterfaceStudentLister lister, String unitCode) {
		lister.clearStudents();
		StudentMap students = studentManager.getStudentsByUnit(unitCode);
		for (Integer studentId : students.keySet())
			lister.addStudent(students.get(studentId));
	}
}
