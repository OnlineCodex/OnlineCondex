package oc.wh40k.units.in;

import oc.*;

public class INWalkuereKammer extends RuestkammerVater {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;

    public INWalkuereKammer() {
        grundkosten = 125;
        name = "Walküre";
    }

    @Override
    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/IGWalkuereKammer.jpg"));

        ogE.addElement(new OptionsGruppeEintrag("Multilaser", 0));
        ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 10));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Donnerkeilraketen", "Paar Donnerkeilraketen", 0));
        ogE.addElement(new OptionsGruppeEintrag("2 Salvenraketenwerfer", "Paar Salvenraketenwerfer", 10));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "2 Schwere Bolter", "Paar schwere Bolter", 1, 20));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fliegerass", 50));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }

}
