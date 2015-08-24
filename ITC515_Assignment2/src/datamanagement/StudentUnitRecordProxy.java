package datamanagement;

public class StudentUnitRecordProxy implements IStudentUnitRecord {
	private Integer studentID_;
	private String unitCode_;
	private StudentUnitRecordManager recordManager_;

	
	
	public StudentUnitRecordProxy(Integer id, String code) {
		this.studentID_ = id;
		this.unitCode_ = code;
		this.recordManager_ = StudentUnitRecordManager.instance();
	}

	
	
	public Integer getStudentId() {
		return studentID_;
	}

	
	
	public String getUnitCode() {
		return unitCode_;
	}

	
	
	public void setAssignment1Mark(float mark) {
		recordManager_.getStudentUnitRecord(studentID_, unitCode_).setAssignment1Mark(mark);
	}

	
	
	public float getAssignment1Mark() {
		return recordManager_.getStudentUnitRecord(studentID_, unitCode_).getAssignment1Mark();
	}

	
	
	public void setAssignment2Mark(float mark) {
		recordManager_.getStudentUnitRecord(studentID_, unitCode_).setAssignment2Mark(mark);
	}

	
	
	public float getAssignment2Mark() {
		return recordManager_.getStudentUnitRecord(studentID_, unitCode_).getAssignment2Mark();
	}

	
	
	public void setExamMark(float mark) {
		recordManager_.getStudentUnitRecord(studentID_, unitCode_).setExamMark(mark);
	}

	
	
	public float getExamMark() {
		return recordManager_.getStudentUnitRecord(studentID_, unitCode_).getExamMark();
	}

	
	
	public float getTotalMark() {
		return recordManager_.getStudentUnitRecord(studentID_, unitCode_).getTotalMark();
	}
}
