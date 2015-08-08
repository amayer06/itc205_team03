package datamanagement;

public class ListUnitsCTL {
	private UnitManager unitManager;

	public ListUnitsCTL() {
		unitManager = UnitManager.UM();
	}

	public void listUnits(IUnitLister lister) {
		lister.clearUnits();
		UnitMap units = unitManager.getUnits();
		for (String subjects : units.keySet())
			lister.addUnit(units.get(subjects));
	}
}
