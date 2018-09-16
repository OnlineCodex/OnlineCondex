package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class ORBurnaBoyz extends Eintrag {

	AnzahlPanel boyz;
	RuestkammerStarter Spanner1;
	RuestkammerStarter Spanner2;
	RuestkammerStarter Spanner3;
	
	public ORBurnaBoyz() {

		kategorie = 1;

		name = "Boyz";
		grundkosten = 0;
		add(boyz = new AnzahlPanel(ID, randAbstand, cnt, "Burna Boyz", 5, 15, getPts("Burna Boyz") + getPts("Burna") + getPts("Stikkbombs")));
		add(ico = new oc.Picture("oc/wh40k/images/Moschaboy.gif"));
		
		seperator();

		Spanner1 = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "Spanner");
        ((ORWaffenUndGeschenke)Spanner1.getKammer()).setKillsawNK(true);
        Spanner1.initKammer(false,false,true,false,false,false);
        Spanner1.setGrundkosten(getPts("Spanner"));
        add(Spanner1);
        
        seperator();

		Spanner2 = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "Spanner");
        ((ORWaffenUndGeschenke)Spanner2.getKammer()).setKillsawNK(true);
        Spanner2.initKammer(false,false,true,false,false,false);
        Spanner2.setGrundkosten(getPts("Spanner"));
        add(Spanner2);
        
        seperator();

		Spanner3 = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "Spanner");
        ((ORWaffenUndGeschenke)Spanner3.getKammer()).setKillsawNK(true);
        Spanner3.initKammer(false,false,true,false,false,false);
        Spanner3.setGrundkosten(getPts("Spanner"));
        add(Spanner3);

		complete();
	}
	

	@Override
	public void refreshen() {
		power = 5 + (boyz.getModelle()-10)/10 * 4 + (boyz.getModelle()%10 > 0 ? 1 : 0) * 4;
	}
}