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

	public InterfaceUnit getUnit(String uc) {
		InterfaceUnit interfaceUnit = unitMap.get(uc);
		return interfaceUnit != null ? interfaceUnit : createUnit(uc);

	}

	private InterfaceUnit createUnit(String unitCode) {

		InterfaceUnit interfaceUnit;

		for (Element element : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("unitTable")
				.getChildren("unit"))
			if (unitCode.equals(element.getAttributeValue("unitId"))) {
				StudentUnitRecordList studentList;

				studentList = null;
				interfaceUnit = new Unit(element.getAttributeValue("unitId"), element.getAttributeValue("name"),
						Float.valueOf(element.getAttributeValue("ps")).floatValue(),
						Float.valueOf(element.getAttributeValue("cr")).floatValue(),
						Float.valueOf(element.getAttributeValue("di")).floatValue(),
						Float.valueOf(element.getAttributeValue("hd")).floatValue(),
						Float.valueOf(element.getAttributeValue("ae")).floatValue(),
						Integer.valueOf(element.getAttributeValue("assignment1Weight")).intValue(),
						Integer.valueOf(element.getAttributeValue("assignment2Weight")).intValue(),
						Integer.valueOf(element.getAttributeValue("examWeight")).intValue(),
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
		for (Element element : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("unitTable")
				.getChildren("unit")) {
			interfaceUnit = new UnitProxy(element.getAttributeValue("unitId"), element.getAttributeValue("name"));
			unitMap.put(interfaceUnit.getUnitCode(), interfaceUnit);
		} // unit maps are filled with PROXY units
		return unitMap;
	}

}
