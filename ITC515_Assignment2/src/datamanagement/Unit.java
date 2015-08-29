package datamanagement;

public class Unit implements InterfaceUnit {
	private String unitCode_;
	private String unitName_;
	private float passCuttoff_;
	private float creditCuttoff_;
	private float distinctionCuttoff_;
	private float highDefinitionCuttoff_;
	private float additionalExaminationCutoff_;
	private int assignment1_, assignment2_, exam_;

	private StudentUnitRecordList recordStudent;

	
	
	public Unit(String unitCodeValue, String unitNameValue, float passCuttoff, float creditCuttoff,
			float distinctionCutoff, float highDistinctionCutoff, float additionalExaminationCutoff,
			int assignmentWeight1, int assignmentWeight2, int examWeight, StudentUnitRecordList recordList) {

		unitCode_ = unitCodeValue;
		unitName_ = unitNameValue;
		passCuttoff_ = passCuttoff;
		creditCuttoff_ = creditCuttoff;
		this.distinctionCuttoff_ = distinctionCutoff;
		highDefinitionCuttoff_ = highDistinctionCutoff;
		this.additionalExaminationCutoff_ = additionalExaminationCutoff;
		this.setAssessmentWeights(assignmentWeight1, assignmentWeight2, examWeight);
		recordStudent = recordList == null ? new StudentUnitRecordList() : recordList;
	}

	
	
	public String getUnitCode() {
		return this.unitCode_;
	}

	
	
	public String getUnitName() {
		return this.unitName_;
	}

	
	
	public void setPassCutoff(float cutoff) {
		this.passCuttoff_ = cutoff;
	}

	
	
	public float getPassCutoff() {
		return this.passCuttoff_;
	}

	
	
	public void setCreditCutoff(float cutoff) {
		this.creditCuttoff_ = cutoff;
	}

	
	
	public float getCreditCutoff() {
		return this.creditCuttoff_;
	}

	
	
	public void setDistinctionCutoff(float cutoff) {
		this.distinctionCuttoff_ = cutoff;
	}

	
	
	public float getDistinctionCuttoff() {
		return this.distinctionCuttoff_;
	}

	
	
	public void highDefinitionCutoff(float cutoff) {
		this.highDefinitionCuttoff_ = cutoff;
	}

	
	
	public void setHighDistinctionCutoff(float cutoff) {
		this.highDefinitionCuttoff_ = cutoff;
	}

	
	
	public float getHighDistinctionCutoff() {
		return this.highDefinitionCuttoff_;

	}

	
	
	public void setAdditionalExaminationCutoff(float cutoff) {
		this.additionalExaminationCutoff_ = cutoff;
	}

	
	
	public float getAdditionalExaminationCutoff() {
		return this.additionalExaminationCutoff_;
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
		return assignment1_;
	}

	
	
	@Override
	public int getAssignment2Weight() {
		return assignment2_;
	}

	
	
	@Override
	public int getExamWeight() {
		return exam_;
	}

	
	
	@Override
	public void setAssessmentWeights(int assigment1, int assignment2, int exam) {
		if (assigment1 < 0 || assigment1 > 100 || assignment2 < 0 || assignment2 > 100 || exam < 0 || exam > 100) {
			throw new RuntimeException("Assessment weights cant be less than zero or greater than 100");
		}
		if (assigment1 + assignment2 + exam != 100) {
			throw new RuntimeException("Assessment weights must add to 100");
		}
		this.assignment1_ = assigment1;
		this.assignment2_ = assignment2;
		this.exam_ = exam;
	}

	
	
	private void setCutoffs(float pass, float credit, float distinction, float highDestinction,
			float additionalExamination) {
		if (pass < 0 || pass > 100 || credit < 0 || credit > 100 || distinction < 0 || distinction > 100
				|| highDestinction < 0 || highDestinction > 100 || additionalExamination < 0
				|| additionalExamination > 100) {
			throw new RuntimeException("Assessment cutoffs cant be less than zero or greater than 100");
		}
		if (additionalExamination >= pass) {
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

		if (float1 < 0 || float1 > assignment1_ || float2 < 0 || float2 > assignment2_ || float3 < 0
				|| float3 > exam_) {
			throw new RuntimeException("marks cannot be less than zero or greater than assessment weights");
		}

		if (t < additionalExaminationCutoff_) {
			return "FL";
		} else if (t < passCuttoff_)
			return "AE";
		else if (t < creditCuttoff_)
			return "PS";
		else if (t < distinctionCuttoff_)
			return "CR";
		else if (t < highDefinitionCuttoff_)
			return "DI";
		else
			return "HD";
	}
} 
