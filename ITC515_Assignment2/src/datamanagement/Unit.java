package datamanagement;

public class Unit implements InterfaceUnit {
	private String unitCode;
	private String unitName;
	private float passCuttoff;
	private float creditCuttoff;
	private float distinctionCuttoff;
	private float highDefinitionCuttoff;
	private float aeCutoff;
	private int assignment1, assignment2, exam;

	private StudentUnitRecordList recordStudent;

	public Unit(String unitCodeValue, String unitNameValue, float float1, float float2, float float3, float float4,
			float float5, int integer1, int integer2, int integer3, StudentUnitRecordList recordList) {

		unitCode = unitCodeValue;
		unitName = unitNameValue;
		passCuttoff = float1;
		creditCuttoff = float2;
		this.distinctionCuttoff = float3;
		highDefinitionCuttoff = float4;
		this.aeCutoff = float5;
		this.setAssessmentWeights(integer1, integer2, integer3);
		recordStudent = recordList == null ? new StudentUnitRecordList() : recordList;
	}

	public String getUnitCode() {
		return this.unitCode;
	}

	public String getUnitName() {

		return this.unitName;
	}

	public void setPassCutoff(float cutoff) {
		this.passCuttoff = cutoff;
	}

	public float getPassCutoff() {
		return this.passCuttoff;
	}

	public void setCreditCutoff(float cutoff) {
		this.creditCuttoff = cutoff;
	}

	public float getCreditCutoff() {
		return this.creditCuttoff;
	}

	public void setDistinctionCutoff(float cutoff) {
		this.distinctionCuttoff = cutoff;
	}

	public float getDistinctionCuttoff() {
		return this.distinctionCuttoff;
	}

	public void HDCutoff(float cutoff) {
		this.highDefinitionCuttoff = cutoff;
	}

	public void setHighDistinctionCutoff(float cutoff) {
		this.highDefinitionCuttoff = cutoff;
	}

	public float getHighDistinctionCutoff() {
		return this.highDefinitionCuttoff;

	}

	public void setAeCutoff(float cutoff) {
		this.aeCutoff = cutoff;
	}

	public float getAeCutoff() {
		return this.aeCutoff;
	}

	public void addStudentRecord(InterfaceStudentUnitRecord record) {
		recordStudent.add(record);
	}

	public InterfaceStudentUnitRecord getStudentRecord(int studentId) {
		for (InterfaceStudentUnitRecord record : recordStudent) {
			if (record.getStudentId() == studentId)
				return record;
		}
		return null;
	}

	public StudentUnitRecordList listStudentRecords() {
		return recordStudent;
	}

	@Override
	public int getAssignment1Weight() {
		return assignment1;
	}

	@Override
	public int getAssignment2Weight() {
		return assignment2;
	}

	@Override
	public int getExamWeight() {
		return exam;
	}

	@Override
	public void setAssessmentWeights(int assigment1, int assignment2, int exam) {
		if (assigment1 < 0 || assigment1 > 100 || assignment2 < 0 || assignment2 > 100 || exam < 0 || exam > 100) {
			throw new RuntimeException("Assessment weights cant be less than zero or greater than 100");
		}
		if (assigment1 + assignment2 + exam != 100) {
			throw new RuntimeException("Assessment weights must add to 100");
		}
		this.assignment1 = assigment1;
		this.assignment2 = assignment2;
		this.exam = exam;
	}

	private void setCutoffs(float pass, float credit, float distinction, float highDestinction, float ae) {
		if (pass < 0 || pass > 100 || credit < 0 || credit > 100 || distinction < 0 || distinction > 100
				|| highDestinction < 0 || highDestinction > 100 || ae < 0 || ae > 100) {
			throw new RuntimeException("Assessment cutoffs cant be less than zero or greater than 100");
		}
		if (ae >= pass) {
			throw new RuntimeException("AE cutoff must be less than PS cutoff");
		}
		if (pass >= credit) {
			throw new RuntimeException("PS cutoff must be less than CR cutoff");
		}
		if (credit >= distinction) {
			throw new RuntimeException("CR cutoff must be less than DI cutoff");
		}
		if (distinction >= highDestinction) {
			throw new RuntimeException("DI cutoff must be less than HD cutoff");
		}

	}

	public String getGrade(float float1, float float2, float float3) {
		float t = float1 + float2 + float3;

		if (float1 < 0 || float1 > assignment1 || float2 < 0 || float2 > assignment2 || float3 < 0 || float3 > exam) {
			throw new RuntimeException("marks cannot be less than zero or greater than assessment weights");
		}

		if (t < aeCutoff) {
			return "FL";
		} else if (t < passCuttoff)
			return "AE";
		else if (t < creditCuttoff)
			return "PS";
		else if (t < distinctionCuttoff)
			return "CR";
		else if (t < highDefinitionCuttoff)
			return "DI";
		else
			return "HD";
	}

}