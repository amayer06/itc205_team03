package datamanagement;

public interface InterfaceUnit {

	public String getUnitCode();

	public String getUnitName();

	public float getPassCutoff();

	public void setPassCutoff(float cutoff);

	public float getCreditCutoff();

	public void setCreditCutoff(float cutoff);

	public float getDistinctionCuttoff();

	public void setDistinctionCutoff(float cutoff);

	public float getHighDistinctionCutoff();

	public void setHighDistinctionCutoff(float cutoff);

	public float getAdditionalExaminationCutoff();

	public void setAdditionalExaminationCutoff(float cutoff);

	public int getAssignment1Weight();

	public int getAssignment2Weight();

	public int getExamWeight();

	public void setAssessmentWeights(int assignment1Weight, int assignment2Weight, int examWeight);

	public String getGrade(float assignment1, float assignment2, float exam);

	public void addStudentRecord(InterfaceStudentUnitRecord record);

	public InterfaceStudentUnitRecord getStudentRecord(int studentId);

	public StudentUnitRecordList listStudentRecords();
}
