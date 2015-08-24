package datamanagement;
public class ListUnitsControl {
    private UnitManager um;
public ListUnitsControl() {
        um = UnitManager.unitManager();
}
            public void listUnits( InterfaceUnitLister lister ) {
lister.clearUnits();UnitMap units = um.getUnits();
        for (String s : units.keySet() )
            lister.addUnit(units.get(s));}}
