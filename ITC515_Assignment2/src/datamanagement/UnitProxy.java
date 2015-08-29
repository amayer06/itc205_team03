package datamanagement;

public class UnitProxy implements InterfaceUnit {
	private String unitCode_;
	private String unitName_;

	UnitManager unitManager;

	public UnitProxy(String unitCodeValue, String unitNameValue) {
		this.unitCode_ = unitCodeValue;
		this.unitName_ = unitNameValue;
		unitManager = UnitManager.unitManager();
	}

	
	
	public String getUnitCode() {
		return this.unitCode_;
	}

	
	
	public String getUnitName() {
		return this.unitName_;
	}

	
	
	public void setPassCutoff(float cutoff) {
		unitManager.getUnit(unitCode_).setPassCutoff(cutoff);
	}

	
	
	public float getPassCutoff() {
		return unitManager.getUnit(unitCode_).getPassCutoff();
	}

	
	
	public void setCreditCutoff(float cutoff) {
		unitManager.getUnit(unitCode_).setCreditCutoff(cutoff);
	}

	
	
	public float getCreditCutoff() {
		return unitManager.getUnit(unitCode_).getCreditCutoff();
	}

	
	
	public void setDistinctionCutoff(float cutoff) {
		unitManager.getUnit(unitCode_).setDistinctionCutoff(cutoff);
	}

	
	
	public float getDistinctionCuttoff() {
		return unitManager.getUnit(unitCode_).getDistinctionCuttoff();
	}

	
	
	public void setHighDistinctionCutoff(float cutoff) {
		unitManager.getUnit(unitCode_).setHighDistinctionCutoff(cutoff);
	}

	
	
	public float getHighDistinctionCutoff() {

		return unitManager.getUnit(unitCode_).getHighDistinctionCutoff();
	}

	
	
	public void setAdditionalExaminationCutoff(float cutoff) {
		unitManager.getUnit(unitCode_).setAdditionalExaminationCutoff(cutoff);
	}

	
	
	public float getAdditionalExaminationCutoff() {
		return unitManager.getUnit(unitCode_).getAdditionalExaminationCutoff();
	}

	
	
	public String getGrade(float float1, float float2, float float3) {
		return unitManager.getUnit(unitCode_).getGrade(float1, float2, float3);
	}

	
	
	public void addStudentRecord(InterfaceStudentUnitRecord record) {
		unitManager.getUnit(unitCode_).addStudentRecord(record);
	}

	
	
	public InterfaceStudentUnitRecord getStudentRecord(int s) {
		return unitManager.getUnit(unitCode_).getStudentRecord(s);
	}

	
	
	public StudentUnitRecordList listStudentRecords() {
		return unitManager.getUnit(unitCode_).listStudentRecords();
	}

	
	
	public int getAssignment1Weight() {
		return unitManager.getUnit(unitCode_).getAssignment1Weight();
	}

	
	
	public int getAssignment2Weight() {
		return unitManager.getUnit(unitCode_).getAssignment2Weight();
	}

	
	
	public int getExamWeight() {
		return unitManager.getUnit(unitCode_).getExamWeight();
	}

	
	
	public void setAssessmentWeights(int assignment1Weight, int assignment2Weight, int examWeight) {
		unitManager.getUnit(unitCode_).setAssessmentWeights(assignment1Weight, assignment2Weight, examWeight);
	}
} 
