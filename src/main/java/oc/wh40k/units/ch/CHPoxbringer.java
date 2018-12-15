package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableSet;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHPoxbringer extends Eintrag {

    RuestkammerStarter psychicPowers;

    public CHPoxbringer() {
        name = "Poxbringer";
        grundkosten = getPts("Poxbringer") /*+ getPts("Balesword")*/;
        power = 4;
        setKeywords(ImmutableSet.of(CHAOS, NURGLE, DAEMON, CHARACTER, INFANTRY, PLAGUEBEARER, PSYKER, HERALD_OF_NURGLE, POXBRINGER));
        
        seperator();
        
        addWeapons(CHWaffenkammerCD.class, false);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        ((PsychicPowers) psychicPowers.getKammer()).enableNurgle();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();
        
        addWarlordTraits("", true, NURGLE);

        complete();
    }
}
