package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class TACommanderinXV8CrisisBattlesuit extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o5;
	RuestkammerStarter ob;

	public TACommanderinXV8CrisisBattlesuit() {
		name = "Commander";
		grundkosten = getPts("Commander in XV8 Crisis Battlesuit");

		�berschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/Commander.gif"));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("MV1 Gun Drone", getPts("MV1 Gun Drone")));
		ogE.addElement(new OptionsGruppeEintrag("MV4 Shield Drone", getPts("MV4 Shield Drone")));
		ogE.addElement(new OptionsGruppeEintrag("MV7 Marker Drone", getPts("MV7 Marker Drone")));
		add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "XV8-02 Iridium Battlesuit", getPts("XV8-02 Crisis Iridium battlesuite")));
		
		seperator();

		ob = new RuestkammerStarter(ID, randAbstand, cnt, "TAKampfanzugKammer", "Commander in XV8 Crisis Battlesuit");
		ob.setGrundkosten(0);
		ob.initKammer(true, false, false, false, false, false, false);
		ob.setButtonText("R�stkammer");
		add(ob);
		
		complete();
	}

	//@OVERRIDE
	public void refreshen() {
		power = 7;
		if (o5.isSelected()) {
			power++;
		}
	}

	//@OVERRIDE
	public void deleteYourself() {
		super.deleteYourself();
	}

}