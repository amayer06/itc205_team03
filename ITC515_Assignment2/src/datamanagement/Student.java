package datamanagement;

public class Student implements IStudent {
	private Integer studentId;
	private String firstName;
	private String lastName;
	private StudentUnitRecordList studentUnit;

	public Student(Integer studentId, String firstName, String lastName, StudentUnitRecordList studentUnit) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentUnit = studentUnit == null ? new StudentUnitRecordList() : studentUnit;
	}

	public Integer getID() {
		return this.studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {

		this.lastName = lastName;
	}

	public void addUnitRecord(IStudentUnitRecord record) {
		studentUnit.add(record);
	}

	public IStudentUnitRecord getUnitRecord(String unitCode) {
		for (IStudentUnitRecord r : studentUnit)
			if (r.getUnitCode().equals(unitCode))
				return r;

		return null;

	}

	public StudentUnitRecordList getUnitRecords() {
		return studentUnit;
	}
}
