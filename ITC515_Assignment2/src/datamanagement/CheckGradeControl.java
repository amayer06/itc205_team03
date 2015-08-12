package datamanagement;

public class CheckGradeControl {

	CheckGradeUserInterface checkGradeUserInterface;
	String currentUnitCode = null;
	Integer currentStudentId = null;
	boolean isChanged = false;

	public CheckGradeControl() {
	}

	public void execute() {
		checkGradeUserInterface = new CheckGradeUserInterface(this);
		checkGradeUserInterface.setState1(false);

		checkGradeUserInterface.setState2(false);
		checkGradeUserInterface.setState3(false);
		checkGradeUserInterface.setState4(false);
		checkGradeUserInterface.setState5(false);
		checkGradeUserInterface.setState6(false);
		checkGradeUserInterface.Refresh3();

		ListUnitsControl listUnitsControl = new ListUnitsControl();
		listUnitsControl.listUnits(checkGradeUserInterface);
		checkGradeUserInterface.setVisible(true);
		checkGradeUserInterface.setState1(true);
	}

	public void unitSelected(String code) {

		if (code.equals("NONE"))
			checkGradeUserInterface.setState2(false);
		else {
			ListStudentsControl listStudentsControl = new ListStudentsControl();
			listStudentsControl.listStudents(checkGradeUserInterface, code);
			currentUnitCode = code;
			checkGradeUserInterface.setState2(true);
		}
		checkGradeUserInterface.setState3(false);
	}

	public void studentSelected(Integer idNo) {
		currentStudentId = idNo;
		if (currentStudentId.intValue() == 0) {
			checkGradeUserInterface.Refresh3();
			checkGradeUserInterface.setState3(false);
			checkGradeUserInterface.setState4(false);
			checkGradeUserInterface.setState5(false);
			checkGradeUserInterface.setState6(false);
		}

		else {
			InterfaceStudent student = StudentManager.get().getStudent(idNo);

			InterfaceStudentUnitRecord record = student.getUnitRecord(currentUnitCode);

			checkGradeUserInterface.setRecord(record);
			checkGradeUserInterface.setState3(true);
			checkGradeUserInterface.setState4(true);
			checkGradeUserInterface.setState5(false);
			checkGradeUserInterface.setState6(false);
			isChanged = false;

		}
	}

	public String checkGrade(float assignment1, float assignment2, float exam) {
		InterfaceUnit unit = UnitManager.UM().getUnit(currentUnitCode);
		String string = unit.getGrade(assignment1, assignment2, exam);
		checkGradeUserInterface.setState4(true);
		checkGradeUserInterface.setState5(false);
		if (isChanged) {
			checkGradeUserInterface.setState6(true);
		}
		return string;
	}

	public void enableChangeMarks() {
		checkGradeUserInterface.setState4(false);
		checkGradeUserInterface.setState6(false);
		checkGradeUserInterface.setState5(true);
		isChanged = true;
	}

	public void saveGrade(float assignment1, float assignment2, float exam) {

		InterfaceUnit unit = UnitManager.UM().getUnit(currentUnitCode);
		InterfaceStudent student = StudentManager.get().getStudent(currentStudentId);

		InterfaceStudentUnitRecord record = student.getUnitRecord(currentUnitCode);
		record.setAssignment1(assignment1);
		record.setAsg2(assignment2);
		record.setExam(exam);
		StudentUnitRecordManager.instance().saveRecord(record);
		checkGradeUserInterface.setState4(true);
		checkGradeUserInterface.setState5(false);
		checkGradeUserInterface.setState6(false);
	}
}
