package datamanagement;

public class StudentProxy implements InterfaceStudent {
	private Integer studentId;
	private String firstName;

	private String lastName;
	private StudentManager studentManagerMap;

	public StudentProxy(Integer studentId, String firstName, String lastName) {
		this.studentId = studentId;
		this.firstName = firstName;

		this.lastName = lastName;
		this.studentManagerMap = StudentManager.get();
	}

	public Integer getID() {
		return studentId;

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {

		studentManagerMap.getStudent(studentId).setFirstName(firstName);
	}

	public void setLastName(String lastName) {

		studentManagerMap.getStudent(studentId).setLastName(lastName);
	}

	public void addUnitRecord(InterfaceStudentUnitRecord record) {
		studentManagerMap.getStudent(studentId).addUnitRecord(record);
	}

	public InterfaceStudentUnitRecord getUnitRecord(String unitCode) {

		return studentManagerMap.getStudent(studentId).getUnitRecord(unitCode);
	}

	public StudentUnitRecordList getUnitRecords() {
		return studentManagerMap.getStudent(studentId).getUnitRecords();
	}
}
