package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHSpoilpoxScrivener extends Eintrag {

	public CHSpoilpoxScrivener() {
		name = "Spoilpox Scrivener";
        grundkosten = getPts("Spoilpox Scrivener") /*+ getPts("Plaguesword") + getPts("Distended maw") + getPts("Disgusting sneezes")*/;
        power = 3;   
       	
		complete();
	}

	@Override
	public void refreshen() {
		
	}

}