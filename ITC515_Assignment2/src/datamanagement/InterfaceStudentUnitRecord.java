package datamanagement;

public interface InterfaceStudentUnitRecord {

    public Integer getStudentId();
    public String getUnitCode();

    public void setAssignment1(float mark);
    public float getAssignment1();

    public void setAsg2(float mark);
    public float getAssignment2();

    public void setExam(float mark);
    public float getExam();

    public float getTotal();
}
