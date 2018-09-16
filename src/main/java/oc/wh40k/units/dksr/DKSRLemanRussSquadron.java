package oc.wh40k.units.dksr;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DKSRLemanRussSquadron extends Eintrag {

	OptionsEinzelUpgrade oe1;
	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;

	public DKSRLemanRussSquadron() {
		name = "Leman Russ Squadron";
		grundkosten = 0;
		this.�berschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/IGLemanRussSquadron.jpg"));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo netting", 15));

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "DKSRLemanRuss", "", 1);
		t1.initKammer();
		t1.setButtonText("Leman Russ 1");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "DKSRLemanRuss", "", 1);
		t2.initKammer();
		t2.setButtonText("Leman Russ 2");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "DKSRLemanRuss", "", 1);
		t3.initKammer();
		t3.setButtonText("Leman Russ 3");
		add(t3);

		complete();
	}

	@Override
	public void refreshen() {
		t1.setAbwaehlbar(false);
		
		int tanks = (t1.isSelected() ? 1 : 0) + (t2.isSelected() ? 1 : 0) + (t3.isSelected() ? 1 : 0);

		oe1.setPreis(tanks * 15);
		oe1.setAktiv(tanks > 0);

	}

}