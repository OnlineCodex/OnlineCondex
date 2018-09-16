package oc.wh40k.units.da;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DADeathwingKnights extends Eintrag{

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsEinzelZaehler o1a;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o3;
	RuestkammerStarter ot;
	
	boolean added = false;

	public DADeathwingKnights() {
		name = "Deathwing-Ritter";
		grundkosten = 10;
		�berschriftSetzen=true;
		neuzeile=true;
		

		add(ico = new oc.Picture("oc/wh40k/images/DADeathwingTerminatorSquad.gif"));

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Deathwing-Ritter", 5, 10, 45);
		add(squad);
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "D�steres Relikt der alten Legion", "D�steres Relikt", 15));
		
		seperator();
		
		ot = new RuestkammerStarter(ID, randAbstand, cnt, "DATransporterKammer", "Transporter");
		ot.initKammer(false, false, false, true, true,false);
		ot.setButtonText("Transporter");
		add(ot);
	}

	@Override
	public void refreshen() {
	}

	@Override
	public void deleteYourself() {

		super.deleteYourself();
	}
}