package datamanagement;

public class Student implements InterfaceStudent {
	private Integer studentId_;
	private String firstName_;
	private String lastName_;
	private StudentUnitRecordList studentUnits_;

	
	
	public Student(Integer studentId, String firstName, String lastName, StudentUnitRecordList studentUnit) {
		this.studentId_ = studentId;
		this.firstName_ = firstName;
		this.lastName_ = lastName;
		this.studentUnits_ = studentUnit == null ? new StudentUnitRecordList() : studentUnit;
	}

	
	
	public Integer getID() {
		return this.studentId_;
	}

	
	
	public String getFirstName() {
		return firstName_;
	}

	
	
	public void setFirstName(String firstName) {
		this.firstName_ = firstName;
	}

	
	
	public String getLastName() {
		return lastName_;
	}

	
	
	public void setLastName(String lastName) {

		this.lastName_ = lastName;
	}

	
	
	public void addUnitRecord(InterfaceStudentUnitRecord record) {
		studentUnits_.add(record);
	}

	
	
	public InterfaceStudentUnitRecord getUnitRecord(String unitCode) {
		for (InterfaceStudentUnitRecord record : studentUnits_)
			if (record.getUnitCode().equals(unitCode))
				return record;

		return null;

	}

	
	
	public StudentUnitRecordList getUnitRecords() {
		return studentUnits_;
	}
}
