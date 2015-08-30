package datamanagement;

public interface InterfaceStudent {

	public Integer getID();

	public String getFirstName();

	public void setFirstName(String firstName);

	public String getLastName();

	public void setLastName(String lastName);

	public void addUnitRecord(InterfaceStudentUnitRecord record);

	public InterfaceStudentUnitRecord getUnitRecord(String unitCode);

	public StudentUnitRecordList getUnitRecords();
}
