package oc.wh40k.units.cs;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class CSChaosLandRaider extends Eintrag {

	RuestkammerStarter ausruestung;
	
	public CSChaosLandRaider() {
		name = "Chaos Land Raider";
		grundkosten = 230;

		add(ico = new oc.Picture("oc/wh40k/images/ChaosLandRaider.gif"));
		
		seperator();
		
		ausruestung = new RuestkammerStarter(ID, randAbstand, cnt, "CMFahrzeugruestkammer", "Ausr�stung");
		ausruestung.initKammer(true);
		ausruestung.setButtonText("Ausr�stung");
		add(ausruestung);
		
		complete();
	}

	@Override
	public void refreshen() {
	}

}