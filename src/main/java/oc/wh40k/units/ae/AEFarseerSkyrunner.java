package oc.wh40k.units.ae;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;


public class AEFarseerSkyrunner extends Eintrag {

	private final RuestkammerStarter psychicPowers;

    public AEFarseerSkyrunner() {
    	super(AELDARI, ASURYANI, CHARACTER, INFANTRY, PSYKER, FARSEER, FARSEER_SKYRUNNER, BIKER);
    	
        name = "Farseer Skyrunner";
        grundkosten = getPts("Farseer Skyrunner") + getPts("Twin shuriken catapult");
        power = 9;

        seperator();

        addWeapons(AECraftworldRuestkammer.class, true);

        seperator();
        
        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableRunesOfFate();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}

