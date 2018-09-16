package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ORBigMekonWarbike extends Eintrag {

	OptionsEinzelUpgrade grotoiler;
    RuestkammerStarter waffen;
    
    boolean megaBool=false;
    boolean gazzBool=false;

    public ORBigMekonWarbike() {
        kategorie = 1;
        name = "Big Mek on Warbike";
        grundkosten = getPts("Big Mek on Warbike") + getPts("Stikkbombs");
        power = 6;

        add(ico = new oc.Picture("oc/wh40k/images/Bigmek.gif"));
        
        waffen = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "");
        ((ORWaffenUndGeschenke)waffen.getKammer()).setKillsawNK(true);
        waffen.initKammer(true,false,true,true,true,true);
        waffen.setButtonText("Waffen und Geschenke");
        add(waffen);
        waffen.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {}

}