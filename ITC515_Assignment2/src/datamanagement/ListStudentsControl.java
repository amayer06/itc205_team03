package datamanagement;

public class ListStudentsControl {
	private StudentManager studentManager_;

	
	
	public ListStudentsControl() {
		studentManager_ = StudentManager.get();
	}

	
	
	public void listStudents(InterfaceStudentLister lister, String unitCode) {
		lister.clearStudents();
		StudentMap students = studentManager_.getStudentsByUnit(unitCode);
		for (Integer studentId : students.keySet())
			lister.addStudent(students.get(studentId));
	}
}
