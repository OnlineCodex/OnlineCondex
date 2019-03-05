package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DEATHWATCH;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.PSYKER;
import static oc.KeyWord.LIBRARIAN;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMDeathwatchLibrarian extends Eintrag {
	private final OptionsEinzelUpgrade jump;
	private final RuestkammerStarter psychicPowers;

    public IMDeathwatchLibrarian() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, DEATHWATCH, CHARACTER, INFANTRY, LIBRARIAN, PSYKER);
    	
        name = "Librarian";
        grundkosten = getPts("Librarian") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

        seperator();

        add(jump = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump Pack", getPts("Librarian with Jump Pack") - getPts("Librarian")));

        seperator();

        addWeapons(IMDeathwatchRuestkammer.class, true);
       
        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        if (!buildaVater.getFormationType().equals("Dark Angels") && !buildaVater.getFormationType().equals("Blood Angels"))
            ((PsychicPowers) psychicPowers.getKammer()).enableLibrarius();
        if (buildaVater.getFormationType().equals("Blood Angels"))
            ((PsychicPowers) psychicPowers.getKammer()).enableSanguinary();
        if (buildaVater.getFormationType().equals("Dark Angels"))
            ((PsychicPowers) psychicPowers.getKammer()).enableInterromancy();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(false);
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        power = 6 + (jump.isSelected() ? 1 : 0);
        
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}
