package oc.wh40k.units.ab;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ABLemanRuss extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
    OptionsUpgradeGruppe o4;

	public ABLemanRuss() {
		grundkosten = 0;
	}

  @Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Battle Tank", 150));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Exterminator", 150));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Conqueror", 150));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Annihilator", 150));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Vanquisher", 155));
		ogE.addElement(new OptionsGruppeEintrag("Leman Russ Eradicator", 160));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Lascannon", 15));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("2 heavy bolters", "Pair of heavy bolters", 20));
		ogE.addElement(new OptionsGruppeEintrag("2 heavy flamers", "Pair of heavy flamers", 20));
		ogE.addElement(new OptionsGruppeEintrag("2 multi-meltas", "Pair of multi-meltas", 30));
		ogE.addElement(new OptionsGruppeEintrag("2 plasma cannons","Pair of plasma cannons", 40));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Co-axial storm bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Co-axial heavy stubber", 10));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", 10));
		ogE.addElement(new OptionsGruppeEintrag("Storm bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("AA Heavy stubber","Anti-aircraft mount heavy stubber", 15));
		ogE.addElement(new OptionsGruppeEintrag("AA Storm bolter","Anti-aircraft mount storm bolter", 15));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozerblade", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Camo-netting", 20));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Mine plough", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Armoured track guards", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Improved comms", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Anti-grenade mesh", 15));
        
		sizeSetzen();
	}

  @Override
	public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();

        o4.setAktiv(o1.isSelected("Leman Russ Vanquisher"));

	}

}