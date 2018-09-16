package oc.wh40k.units.as;

import oc.Eintrag;

public class ASBelisariusCawl extends Eintrag {

	public ASBelisariusCawl() {
		name = "Belisarius Cawl";
		grundkosten = 200;

		add(ico = new oc.Picture("oc/wh40k/images/ASSanktCelestine.jpg"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}