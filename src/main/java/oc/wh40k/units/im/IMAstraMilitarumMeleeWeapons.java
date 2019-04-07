package oc.wh40k.units.im;

import java.util.Vector;

import oc.BuildaVater;
import oc.OptionsGruppeEintrag;
import oc.RuestkammerElement;

public class IMAstraMilitarumMeleeWeapons extends RuestkammerElement {

    static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, String defaultWeaponCost, BuildaVater bv) {
        final Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
        addDefault(defaultWeapon, defaultWeaponCost, ogE, bv);
        addElement("Power axe [INDEX]", "Power axe (AM)", defaultWeapon, ogE, bv);
        addElement("Power maul [INDEX]", "Power maul (AM)", defaultWeapon, ogE, bv);
        addElement("Power sword", "Power sword (AM)", defaultWeapon, ogE, bv);
        addElement("Power fist", "Power fist (AM)", defaultWeapon, ogE, bv);
        return ogE;
    }
}
