package oc.wh40k.units.dh;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class DHCanoptekTombSentinel extends Eintrag {

    public DHCanoptekTombSentinel() {
        name = "Canoptek Tomb Sentinel";
        grundkosten = 195;

        add(ico = new oc.Picture("oc/wh40k/images/NETombStalker.jpg"));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sepulchral scarabs", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Gloom Prism", 15));

        complete();
    }

    @Override
    public void refreshen() {
    }

}
