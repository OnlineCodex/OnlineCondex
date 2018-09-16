package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMPurifierSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1def,o2def;
	OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o3;
    RuestkammerStarter rkBoss;
	RuestkammerStarter psychicPowers;
	
	public IMPurifierSquad() {
		name = "Purificator-Trupp\n";
		grundkosten = 0;
		�berschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Purifier", 5, 10, getPts("Purifier Squad"));
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/GKPurificatorTrupp.jpg"));
		

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Nemesis force sword", getPts("Nemesis force sword")));
        add(o1def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("Nemesis force halberd", getPts("Nemesis force halberd")));
		ogE.addElement(new OptionsGruppeEintrag("Nemesis daemon hammer", getPts("Nemesis daemon hammer")));
		ogE.addElement(new OptionsGruppeEintrag("Nemesis warding stave", getPts("Nemesis warding stave")));
		ogE.addElement(new OptionsGruppeEintrag("Two Nemesis falchions", getPts("Two Nemesis falchions")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));
        add(o2def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("Incinerator", getPts("Incinerator")));
		ogE.addElement(new OptionsGruppeEintrag("Psilencer", getPts("Psilencer")));
		ogE.addElement(new OptionsGruppeEintrag("Psycannon", getPts("Psycannon")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "IMJusticar", "Knight of the Flame");
		rkBoss.initKammer();
        rkBoss.setButtonText("Upgrade zum Knight of the Flame", false);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);
		
		seperator();
		
		psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers)psychicPowers.getKammer()).setNumberOfPowers(1);
		((PsychicPowers)psychicPowers.getKammer()).enableSanctic();
		psychicPowers.initKammer();
		psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
		add(psychicPowers);
		psychicPowers.setAbwaehlbar(true);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);

        int subtractor = 1; // last one is the boss

        o1.setMaxAnzahl(squad.getModelle() - subtractor); // heavy weapon
        o1def.setMaxAnzahl(squad.getModelle() - o1.getAnzahl() - o2.getAnzahl() - subtractor);
        o1def.setAnzahl(0, squad.getModelle() - o1.getAnzahl() - o2.getAnzahl() - subtractor);

        o2.setMaxAnzahl((int) Math.floor(squad.getModelle() / 5)*2);
        o2def.setMaxAnzahl(squad.getModelle() - o2.getAnzahl() - 1); // last one is the boss
        o2def.setAnzahl(0, squad.getModelle() - o2.getAnzahl() - 1); // last one is the boss
        
        power = 9;
        if(squad.getModelle() == 10) power += 9;
	}

}