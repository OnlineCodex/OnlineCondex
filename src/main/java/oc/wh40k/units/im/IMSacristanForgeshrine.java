package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;

public class IMSacristanForgeshrine extends Eintrag {

    public IMSacristanForgeshrine() {
        name = "Sacristan Forgeshrine";
        grundkosten = getPts("Sacristan Forgeshrine");
        power = 4;

        complete();
    }
}