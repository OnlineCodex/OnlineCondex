package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class IMLukastheTrickster extends Eintrag {
	
    RuestkammerStarter warlord;

    public IMLukastheTrickster() {
        name = "Lukas the Trickster";
        grundkosten = getPts("Lukas the Trickster");
        power = 6;

        seperator();
        
        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        add(warlord);
        
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
