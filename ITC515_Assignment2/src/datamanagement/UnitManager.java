package datamanagement;

import java.util.List;
import org.jdom.*;

public class UnitManager {

	private static UnitManager self_ = null;

	private UnitMap unitMap_;

	public static UnitManager unitManager() {
		if (self_ == null)
			self_ = new UnitManager();
		return self_;
	}

	private UnitManager() {
		unitMap_ = new UnitMap();
	}

	public InterfaceUnit getUnit(String unitCode) {
		InterfaceUnit interfaceUnit = unitMap_.get(unitCode);
		return interfaceUnit != null ? interfaceUnit : createUnit(unitCode);
	}

	private InterfaceUnit createUnit(String unitCode) {

		InterfaceUnit interfaceUnit;

		for (Element element : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("unitTable")
				.getChildren("unit"))
			if (unitCode.equals(element.getAttributeValue("uid"))) {
				StudentUnitRecordList studentList;

				studentList = null;
				interfaceUnit = new Unit(element.getAttributeValue("uid"), element.getAttributeValue("name"),
						Float.valueOf(element.getAttributeValue("ps")).floatValue(),
						Float.valueOf(element.getAttributeValue("cr")).floatValue(),
						Float.valueOf(element.getAttributeValue("di")).floatValue(),
						Float.valueOf(element.getAttributeValue("hd")).floatValue(),
						Float.valueOf(element.getAttributeValue("ae")).floatValue(),
						Integer.valueOf(element.getAttributeValue("asg1wgt")).intValue(),
						Integer.valueOf(element.getAttributeValue("asg2wgt")).intValue(),
						Integer.valueOf(element.getAttributeValue("examwgt")).intValue(),
						StudentUnitRecordManager.instance().getRecordsByUnit(unitCode));
				unitMap_.put(interfaceUnit.getUnitCode(), interfaceUnit);
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
			interfaceUnit = new UnitProxy(element.getAttributeValue("uid"), element.getAttributeValue("name"));
			unitMap.put(interfaceUnit.getUnitCode(), interfaceUnit);
		} // unit maps are filled with PROXY units
		return unitMap;
	}
}
