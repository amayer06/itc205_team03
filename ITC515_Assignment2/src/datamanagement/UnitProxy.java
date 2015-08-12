package datamanagement;

public class UnitProxy implements InterfaceUnit {
	private String unitCode;
	private String unitName;

	UnitManager unitManager;

	public UnitProxy(String unitCodeValue, String unitNameValue) {
		this.unitCode = unitCodeValue;
		this.unitName = unitNameValue;
		unitManager = UnitManager.UM();
	}

	public String getUnitCode() {
		return this.unitCode;
	}

	public String getUnitName() {
		return this.unitName;
	}

	public void setPassCutoff(float cutoff) {
		unitManager.getUnit(unitCode).setPassCutoff(cutoff);
	}

	public float getPassCutoff() {
		return unitManager.getUnit(unitCode).getPassCutoff();
	}

	public void setCreditCutoff(float cutoff) {
		unitManager.getUnit(unitCode).setCreditCutoff(cutoff);
	}

	public float getCreditCutoff() {
		return unitManager.getUnit(unitCode).getCreditCutoff();
	}

	public void setDistinctionCutoff(float cutoff) {
		unitManager.getUnit(unitCode).setDistinctionCutoff(cutoff);
	}

	public float getDistinctionCuttoff() {
		return unitManager.getUnit(unitCode).getDistinctionCuttoff();
	}

	public void setHighDistinctionCutoff(float cutoff) {
		unitManager.getUnit(unitCode).setHighDistinctionCutoff(cutoff);
	}

	public float getHighDistinctionCutoff() {

		return unitManager.getUnit(unitCode).getHighDistinctionCutoff();
	}

	public void setAdditionalExaminationCutoff(float cutoff) {
		unitManager.getUnit(unitCode).setAdditionalExaminationCutoff(cutoff);
	}

	public float getAdditionalExaminationCutoff() {
		return unitManager.getUnit(unitCode).getAdditionalExaminationCutoff();
	}

	public String getGrade(float float1, float float2, float float3) {
		return unitManager.getUnit(unitCode).getGrade(float1, float2, float3);
	}

	public void addStudentRecord(InterfaceStudentUnitRecord record) {
		unitManager.getUnit(unitCode).addStudentRecord(record);
	}

	public InterfaceStudentUnitRecord getStudentRecord(int s) {
		return unitManager.getUnit(unitCode).getStudentRecord(s);
	}

	public StudentUnitRecordList listStudentRecords() {
		return unitManager.getUnit(unitCode).listStudentRecords();
	}

	public int getAssignment1Weight() {
		return unitManager.getUnit(unitCode).getAssignment1Weight();
	}

	public int getAssignment2Weight() {
		return unitManager.getUnit(unitCode).getAssignment2Weight();
	}

	public int getExamWeight() {
		return unitManager.getUnit(unitCode).getExamWeight();
	}

	public void setAssessmentWeights(int assignment1Weight, int assignment2Weight, int examWeight) {
		unitManager.getUnit(unitCode).setAssessmentWeights(assignment1Weight, assignment2Weight, examWeight);

	}
}
