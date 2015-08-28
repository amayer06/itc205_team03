package datamanagement;

public class StudentProxy implements InterfaceStudent {
	private Integer studentId_;
	private String firstName_;
	private String lastName_;
	private StudentManager studentManagerMap_;

	
	
	public StudentProxy(Integer studentId, String firstName, String lastName) {
		this.studentId_ = studentId;
		this.firstName_ = firstName;
		this.lastName_ = lastName;
		this.studentManagerMap_ = StudentManager.get();
	}

	
	
	public Integer getID() {
		return studentId_;

	}

	
	
	public String getFirstName() {
		return firstName_;
	}

	
	
	public String getLastName() {
		return lastName_;
	}

	
	
	public void setFirstName(String firstName) {

		studentManagerMap_.getStudent(studentId_).setFirstName(firstName);
	}

	
	
	public void setLastName(String lastName) {

		studentManagerMap_.getStudent(studentId_).setLastName(lastName);
	}

	
	
	public void addUnitRecord(InterfaceStudentUnitRecord record) {
		studentManagerMap_.getStudent(studentId_).addUnitRecord(record);
	}

	
	
	public InterfaceStudentUnitRecord getUnitRecord(String unitCode) {

		return studentManagerMap_.getStudent(studentId_).getUnitRecord(unitCode);
	}

	
	
	public StudentUnitRecordList getUnitRecords() {
		return studentManagerMap_.getStudent(studentId_).getUnitRecords();
	}
}
