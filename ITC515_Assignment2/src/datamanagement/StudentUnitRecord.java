package datamanagement;

public class StudentUnitRecord implements InterfaceStudentUnitRecord {
	private Integer studentId_;
	private String unitCode_;
	private float assignment1Mark_;
	private float assignment2Mark_;
	private float examMark_;

	
	
	public StudentUnitRecord(Integer studentId, String unitCode, float assignment1, float assignment2, float examMark) {
		this.studentId_ = studentId;
		this.unitCode_ = unitCode;
		this.setAssignment1Mark(assignment1);
		this.setAssignment2Mark(assignment2);
		this.setExamMark(examMark);
	}

	
	
	public Integer getStudentId() {
		return studentId_;
	}

	
	
	public String getUnitCode() {
		return unitCode_;
	}

	
	
	public void setAssignment1Mark(float assignment1) {
		int assignment1Weight = UnitManager.UM().getUnit(unitCode_).getAsg1Weight();
		if (assignment1 < 0 || assignment1 > assignment1Weight) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.assignment1Mark_ = assignment1;
	}

	
	
	public float getAssignment1Mark() {
		return assignment1Mark_;
	}

	
	
	public void setAssignment2Mark(float assignment2) {
		int assignment2Weight = UnitManager.UM().getUnit(unitCode_).getAsg2Weight();
		if (assignment2 < 0 || assignment2 > assignment2Weight) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.assignment2Mark_ = assignment2;
	}

	
	
	public float getAssignment2Mark() {
		return assignment2Mark_;
	}

	
	
	public void setExamMark(float exam) {
		int examWeight = UnitManager.UM().getUnit(unitCode_).getExamWeight();
		if (exam < 0 || exam > examWeight) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.examMark_ = exam;
	}

	
	
	public float getExamMark() {
		return examMark_;
	}

	
	
	public float getTotalMark() {
		return assignment1Mark_ + assignment2Mark_ + examMark_;
	}
}
