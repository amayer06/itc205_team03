package datamanagement;

import java.util.List;
import org.jdom.*;

public class UnitManager {

	private static UnitManager self = null;

	private UnitMap unitMap;

	public static UnitManager unitManager() {
		if (self == null)
			self = new UnitManager();
		return self;
	}

	private UnitManager() {
		unitMap = new UnitMap();
	}

	public InterfaceUnit getUnit(String unitCode) {
		InterfaceUnit interfaceUnit = unitMap.get(unitCode);
		return interfaceUnit != null ? interfaceUnit : createUnit(unitCode);

	}

	private InterfaceUnit createUnit(String unitCode) {

		InterfaceUnit interfaceUnit;

		for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("unitTable")
				.getChildren("unit"))
			if (unitCode.equals(el.getAttributeValue("uid"))) {
				StudentUnitRecordList studentList;

				studentList = null;
				interfaceUnit = new Unit(el.getAttributeValue("uid"), el.getAttributeValue("name"),
						Float.valueOf(el.getAttributeValue("ps")).floatValue(),
						Float.valueOf(el.getAttributeValue("cr")).floatValue(),
						Float.valueOf(el.getAttributeValue("di")).floatValue(),
						Float.valueOf(el.getAttributeValue("hd")).floatValue(),
						Float.valueOf(el.getAttributeValue("ae")).floatValue(),
						Integer.valueOf(el.getAttributeValue("asg1wgt")).intValue(),
						Integer.valueOf(el.getAttributeValue("asg2wgt")).intValue(),
						Integer.valueOf(el.getAttributeValue("examwgt")).intValue(),
						StudentUnitRecordManager.instance().getRecordsByUnit(unitCode));
				unitMap.put(interfaceUnit.getUnitCode(), interfaceUnit);
				return interfaceUnit;
			}

		throw new RuntimeException("DBMD: createUnit : unit not in file");
	}

	public UnitMap getUnits() {

		UnitMap unitMap;
		InterfaceUnit interfaceUnit;

		unitMap = new UnitMap();
		for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("unitTable")
				.getChildren("unit")) {
			interfaceUnit = new UnitProxy(el.getAttributeValue("uid"), el.getAttributeValue("name"));
			unitMap.put(interfaceUnit.getUnitCode(), interfaceUnit);
		} // unit maps are filled with PROXY units
		return unitMap;
	}

}
