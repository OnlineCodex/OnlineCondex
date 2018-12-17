package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMCaptaininCataphractiiArmour extends Eintrag {

    RuestkammerStarter waffenUndReliquien;

    public IMCaptaininCataphractiiArmour() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, TERMINATOR, CAPTAIN);
    	
        name = "Captain in Cataphractii Armour";
        grundkosten = getPts("Captain in Cataphractii Armour");
        power = 8;

        seperator();
        
        addWeapons(IMSpaceMarinesRuestkammer.class, true);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
