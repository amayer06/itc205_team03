package datamanagement;
public class ListUnitsControl {
    private UnitManager unitManager;
public ListUnitsControl() {
        unitManager = UnitManager.unitManager();
}
            public void listUnits( InterfaceUnitLister lister ) {
lister.clearUnits();UnitMap units = unitManager.getUnits();
        for (String s : units.keySet() )
            lister.addUnit(units.get(s));}}
