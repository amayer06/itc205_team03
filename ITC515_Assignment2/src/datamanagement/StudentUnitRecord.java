package datamanagement;

public class StudentUnitRecord implements IStudentUnitRecord {
	private Integer studentId_;
	private String unitCode_;
	private float assignment1Mark_;
	private float assignment2Mark_;
	private float examMark_;

	
	
	public StudentUnitRecord(Integer id, String code, float asg1, float asg2, float exam) {
		this.studentId_ = id;
		this.unitCode_ = code;
		this.setAssignment1Mark(asg1);
		this.setAssignment2Mark(asg2);
		this.setExamMark(exam);
	}

	
	
	public Integer getStudentId() {
		return studentId_;
	}

	
	
	public String getUnitCode() {
		return unitCode_;
	}

	
	
	public void setAssignment1Mark(float a1) {
		int a1Weight = UnitManager.UM().getUnit(unitCode_).getAsg1Weight();
		if (a1 < 0 || a1 > a1Weight) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.assignment1Mark_ = a1;
	}

	
	
	public float getAssignment1Mark() {
		return assignment1Mark_;
	}

	
	
	public void setAssignment2Mark(float a2) {
		int a2Weight = UnitManager.UM().getUnit(unitCode_).getAsg2Weight();
		if (a2 < 0 || a2 > a2Weight) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.assignment2Mark_ = a2;
	}

	
	
	public float getAssignment2Mark() {
		return assignment2Mark_;
	}

	
	
	public void setExamMark(float ex) {
		int exWeight = UnitManager.UM().getUnit(unitCode_).getExamWeight();
		if (ex < 0 || ex > exWeight) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.examMark_ = ex;
	}

	
	
	public float getExamMark() {
		return examMark_;
	}

	
	
	public float getTotalMark() {
		return assignment1Mark_ + assignment2Mark_ + examMark_;
	}
}
