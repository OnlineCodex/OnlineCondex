package oc.wh40k.units.fo;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class FOSacristanForgeshrine extends Eintrag {


	public FOSacristanForgeshrine() {
		name = "Sacristan Forgeshrine";
		grundkosten = getPts("Sacristan Forgeshrine");
		power = 4;

		complete();
	}

	//@OVERRIDE
	public void refreshen() {

	}
}