package oc.wh40k.units.apo;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class APOReaverBattleTitan extends Eintrag {

        OptionsZaehlerGruppe o1;
        OptionsZaehlerGruppe o2;

	public APOReaverBattleTitan() {
		name = "Reaver Battle Titan";
		grundkosten = 1450;

		add(ico = new oc.Picture("oc/wh40k/images/ReaverBattleTitan.gif"));
		
        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Turbolaser", "Doppell�ufiger Turbolaser-Annihilator", 0));
		ogE.addElement(new OptionsGruppeEintrag("Plasmagesch�tz", 0));
		ogE.addElement(new OptionsGruppeEintrag("Inferno-Gesch�tz", 0));
		ogE.addElement(new OptionsGruppeEintrag("Vulkan-Megabolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", "Apokalypse-Raketenwerfer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Warpfeldgranate", 0));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Multilaserkanone", 0));
        ogE.addElement(new OptionsGruppeEintrag("Gatlingblaster", 0));
        ogE.addElement(new OptionsGruppeEintrag("Meltergesch�tz", 0));
        ogE.addElement(new OptionsGruppeEintrag("Vulkangesch�tz", 0));
        ogE.addElement(new OptionsGruppeEintrag("Titanen-NKW", "Titanen-Nahkampfwaffe", 0));
		add(o2 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 2));

		complete();

	}

	public void refreshen() {
            o1.setLegal(o1.getAnzahl() == o1.getMaxAnzahl());
            o2.setLegal(o2.getAnzahl() == o2.getMaxAnzahl());
	}
}