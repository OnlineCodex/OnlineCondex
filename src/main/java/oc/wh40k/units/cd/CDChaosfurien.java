package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CDChaosfurien extends Eintrag {

	AnzahlPanel CDChaosfurien;
	OptionsUpgradeGruppe o1;

	public CDChaosfurien() {

		name = "Chaosfurien";

		grundkosten = 0;

		CDChaosfurien = new AnzahlPanel(ID, randAbstand, cnt, "Chaosfurien", 5, 20, 7);

		add(CDChaosfurien);

		add(ico = new oc.Picture("oc/wh40k/images/CDChaosgargoyle.gif"));
		
		ogE.addElement(new OptionsGruppeEintrag("D�mon des Khorne", "D�mon des Khorne", 2));
		ogE.addElement(new OptionsGruppeEintrag("D�mon des Tzeentch", "D�mon des Tzeentch", 1));
		ogE.addElement(new OptionsGruppeEintrag("D�mon des Nurgle", "D�mon des Nurgle", 2));
		ogE.addElement(new OptionsGruppeEintrag("D�mon des Slaanesh", "D�mon des Slaanesh", 2));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		complete();

	}

	@Override
	public void refreshen() {
		int count = CDChaosfurien.getModelle();
		o1.setPreis("D�mon des Khorne", 2 * count);
		o1.setPreis("D�mon des Tzeentch", 1 * count);
		o1.setPreis("D�mon des Nurgle", 2 * count);
		o1.setPreis("D�mon des Slaanesh", 2 * count);
	}
}