package oc.wh40k.units.ch;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class CHWaffenkammerCD extends RuestkammerVater {

    OptionsUpgradeGruppe handwaffen = null;
    OptionsUpgradeGruppe fkwaffen = null;
    //boolean psyker = false; //Daemon Prince, if not Khorne
    
    OptionsEinzelUpgrade armourofScorn;
    OptionsEinzelUpgrade theCrimsonCrown;
    OptionsEinzelUpgrade argaththeKingofBlades;
    OptionsEinzelUpgrade skullreaver;
    OptionsEinzelUpgrade theEndlessGrimoire;
    OptionsEinzelUpgrade soulBane;
    OptionsEinzelUpgrade theImpossibleRobe;
    OptionsEinzelUpgrade theEverstave;
    OptionsEinzelUpgrade hornofNurglesRot;
    OptionsEinzelUpgrade theEntropicKnell;
    OptionsEinzelUpgrade corruption;
    OptionsEinzelUpgrade theForbiddenGem;
    OptionsEinzelUpgrade theMarkofExcess;
    OptionsEinzelUpgrade soulstealer;
    OptionsEinzelUpgrade slothfulClaws;
    
    public CHWaffenkammerCD() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
    	add(armourofScorn = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armour of Scorn", 0).setRelic(true));
    	add(theCrimsonCrown = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Crimson Crown", 0).setRelic(true));
    	add(argaththeKingofBlades = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "A'rgath, the King of Blades", 0).setRelic(true));
    	add(skullreaver = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Skullreaver", 0).setRelic(true));
    	add(theEndlessGrimoire = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Endless Grimoire", 0).setRelic(true));
    	add(soulBane = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Soul Bane", 0).setRelic(true));
    	add(theImpossibleRobe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Impossible Robe", 0).setRelic(true));
    	add(theEverstave = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Everstave", 0).setRelic(true));
    	add(hornofNurglesRot = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Horn of Nurgle's Rot", 0).setRelic(true));
    	add(theEntropicKnell = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Entropic Knell", 0).setRelic(true));
    	add(corruption = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Corruption", 0).setRelic(true));
    	add(theForbiddenGem = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Forbidden Gem", 0).setRelic(true));
    	add(theMarkofExcess = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Mark of Excess", 0).setRelic(true));
    	add(soulstealer = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Soulstealer", 0).setRelic(true));
    	add(slothfulClaws = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Slothful Claws", 0).setRelic(true));
    	
        setUeberschrift("Waffen");
        sizeSetzen();
    }

    @Override
    public void refreshen() {
    	checkBuildaVater();
        String army = buildaVater.getFormationType();
    	boolean undivided = keywords.contains(ALLEGIANCE) && (army.equals("CHAOS") || army.equals("Chaosdaemons"));
    	boolean khorne = army.equals("Khorne") || keywords.contains(KHORNE) || undivided;
    	boolean tzeentch = army.equals("Tzeentch") || keywords.contains(TZEENTCH) || undivided;
    	boolean nurgle = army.equals("Nurgle") || keywords.contains(NURGLE) || undivided;
    	boolean slaanesh = army.equals("Slaanesh") || keywords.contains(SLAANESH) || undivided;
    	
    	boolean blade_of_blood = true;
    	boolean hellforged_sword = true;
    	boolean axe_of_khorne = true;
    	boolean daemonic_axe = true;
    	boolean rod_of_sorcery = true;
    	boolean staff_of_change = true;
    	boolean plaguesword = true;
    	boolean witstealer_sword = true;
    	
    	armourofScorn.setAktiv((chosenRelic == null || armourofScorn.isSelected()) && khorne && keywords.contains(MONSTER));
    	theCrimsonCrown.setAktiv((chosenRelic == null || theCrimsonCrown.isSelected()) && khorne);
    	argaththeKingofBlades.setAktiv((chosenRelic == null || argaththeKingofBlades.isSelected()) && khorne && (blade_of_blood || hellforged_sword));
    	skullreaver.setAktiv((chosenRelic == null || skullreaver.isSelected()) && khorne && (axe_of_khorne || daemonic_axe));
    	theEndlessGrimoire.setAktiv((chosenRelic == null || theEndlessGrimoire.isSelected()) && tzeentch && keywords.contains(PSYKER));
    	soulBane.setAktiv((chosenRelic == null || soulBane.isSelected()) && keywords.contains(HERALD_OF_TZEENTCH));
    	theImpossibleRobe.setAktiv((chosenRelic == null || theImpossibleRobe.isSelected()) && tzeentch);
    	theEverstave.setAktiv((chosenRelic == null || theEverstave.isSelected()) && tzeentch  && (rod_of_sorcery || staff_of_change));
    	hornofNurglesRot.setAktiv((chosenRelic == null || hornofNurglesRot.isSelected()) && nurgle);
    	theEntropicKnell.setAktiv((chosenRelic == null || theEntropicKnell.isSelected()) && nurgle);
    	corruption.setAktiv((chosenRelic == null || corruption.isSelected()) && nurgle && plaguesword);
    	theForbiddenGem.setAktiv((chosenRelic == null || theForbiddenGem.isSelected()) && slaanesh);
    	theMarkofExcess.setAktiv((chosenRelic == null || theMarkofExcess.isSelected()) && slaanesh);
    	soulstealer.setAktiv((chosenRelic == null || soulstealer.isSelected()) && slaanesh && (witstealer_sword || hellforged_sword));
    	slothfulClaws.setAktiv((chosenRelic == null || slothfulClaws.isSelected()) && keywords.contains(HERALD_OF_SLAANESH));
    	
    	
//      A'rgath, the King of Blades - KHORNE with blade of blood or hellforged sword. Replace //TODO check if option
//      Skullreaver - KHORNE with axe of khorne or daemonic axe. Replace //TODO check if option   	
//      The Everstave - TZEENTCH with rod of sorcery or staff of change //TODO check if option
//      Corruption - NURGLE with plaguesword. Replace //TODO check if option	
//      Soulstealer - SLAANESH with witstealer sword or hellforged sword. Replace //TODO check if option
    	
    }

}
