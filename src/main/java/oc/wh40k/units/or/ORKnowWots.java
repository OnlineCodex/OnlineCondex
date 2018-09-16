package oc.wh40k.units.or;

import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class ORKnowWots extends RuestkammerVater {

	public boolean megaruestung = false;
	public boolean greentide = false;
	OptionsEinzelUpgrade warbike;
	
	public ORKnowWots() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Troph�'enstang�", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Cybork-K�rpa", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Gitsucha", 5));
		add(warbike = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Warbike", 25)); //falls keine Megar�stung
		
		setUeberschrift("Spezielle Ausr�stung");
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		warbike.setAktiv(!megaruestung && !greentide);
	}

}