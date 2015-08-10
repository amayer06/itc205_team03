package datamanagement;

public class Student implements InterfaceStudent {
	private Integer studentId;
	private String firstName;
	private String lastName;
	private StudentUnitRecordList studentUnits;

	public Student(Integer studentId, String firstName, String lastName, StudentUnitRecordList studentUnit) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentUnits = studentUnit == null ? new StudentUnitRecordList() : studentUnit;
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

	public void addUnitRecord(InterfaceStudentUnitRecord record) {
		studentUnits.add(record);
	}

	public InterfaceStudentUnitRecord getUnitRecord(String unitCode) {
		for (InterfaceStudentUnitRecord record : studentUnits)
			if (record.getUnitCode().equals(unitCode))
				return record;

		return null;

	}

	public StudentUnitRecordList getUnitRecords() {
		return studentUnits;
	}
}
