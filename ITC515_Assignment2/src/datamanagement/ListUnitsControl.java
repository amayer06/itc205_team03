package datamanagement;

public class ListUnitsControl {
	private UnitManager unitManager_;

	public ListUnitsControl() {
		unitManager_ = UnitManager.UM();
	}

	public void listUnits(IUnitLister lister) {
		lister.clearUnits();
		UnitMap units = unitManager_.getUnits();
		for (String subjects : units.keySet())
			lister.addUnit(units.get(subjects));
	}
}
