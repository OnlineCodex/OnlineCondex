package oc.wh40k.units.ia;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IADominionSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;
	OptionsEinzelUpgrade o2;

	public IADominionSquad() {
		name = "Dominion Squad\n";
		grundkosten = 0;
		�berschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Dominator-Schwestern", 5, 10, 13);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ASDominatortrupp.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();
        
        add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Simulacrum Imperialis", 10));
        
        seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "IAPrioris", "Upgrade zur Prioris");
		rkBoss.initKammer(true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "IATransporterKammer", "Transporter");
		rkTransport.initKammer(true, true, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
        if(squad.getModelle() > 5) {
            o1.setMaxAnzahl(4);	
        } else {
        	o1.setMaxAnzahl(4 - (o2.isSelected()?1:0));
        }
	}

}