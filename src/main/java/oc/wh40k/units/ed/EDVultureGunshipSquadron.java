package oc.wh40k.units.ed;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class EDVultureGunshipSquadron extends Eintrag {

	RuestkammerStarter v1;
	RuestkammerStarter v2;
	RuestkammerStarter v3;

	public EDVultureGunshipSquadron() {
		name = "Vendetta Gunship Squadron";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/ABVendettaGunshipSquadron.jpg"));

		v1 = new RuestkammerStarter(ID, randAbstand, cnt, "EDVulture", "Vulture");
		v1.initKammer();
        v1.setGrundkosten(105);
		add(v1);

		seperator();

		v2 = new RuestkammerStarter(ID, randAbstand, cnt, "EDVulture", "Vulture");
		v2.initKammer();
        v2.setGrundkosten(105);
		add(v2);

		seperator();

		v3 = new RuestkammerStarter(ID, randAbstand, cnt, "EDVulture", "Vulture");
		v3.initKammer();
        v3.setGrundkosten(105);
		add(v3);
		
		complete();
	}

	@Override
	public void refreshen() {
	}

}
