package datamanagement;

public class ListUnitsControl {
	private UnitManager unitManager;

	public ListUnitsControl() {
		unitManager = UnitManager.UM();
	}

	public void listUnits(IUnitLister lister) {
		lister.clearUnits();
		UnitMap units = unitManager.getUnits();
		for (String subjects : units.keySet())
			lister.addUnit(units.get(subjects));
	}
}
