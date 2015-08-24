package datamanagement;

public class StudentUnitRecord implements InterfaceStudentUnitRecord {
	private Integer sid;
	private String uc;
	private float a1, a2, ex;

	public StudentUnitRecord(Integer id, String code, float asg1, float asg2,
			float exam) {
		this.sid = id;
		this.uc = code;
		this.setAssignment1(asg1);
		this.setAsg2(asg2);
		this.setExam(exam);
	}

	public Integer getStudentId() {
		return sid;
	}

	public String getUnitCode() {
		return uc;
	}

	public void setAssignment1(float a1) {
		if (a1 < 0 ||
			a1 > UnitManager.unitManager().getUnit(uc).getAssignment1Weight()) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.a1 = a1;
	}

	public float getAssignment1() {

		return a1;
	}

	public void setAsg2(float a2) {
		if (a2 < 0 ||
			a2 > UnitManager.unitManager().getUnit(uc).getAssignment2Weight()) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.a2 = a2;

	}

	public float getAssignment2() {
		return a2;
	}

	public void setExam(float ex) {
		if (ex < 0 ||
				ex > UnitManager.unitManager().getUnit(uc).getExamWeight()) {
				throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
			}
		this.ex = ex;
	}

	public float getExam() {
		return ex;
	}

	public float getTotal() {
		return a1 + a2 + ex;

	}
}
