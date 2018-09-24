package oc.wh40k.units.in;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class INInquisitordesOrdoXenos extends Eintrag {

	OptionsEinzelUpgrade bp, cs;
	OptionsZaehlerGruppe o1;
    OptionsEinzelUpgrade psi;
    RuestkammerStarter relikte;
    
	public INInquisitordesOrdoXenos() {
		name = "Inquisitor des Ordo Xenos";
		grundkosten = 25;

		add(ico = new oc.Picture("oc/wh40k/images/GKInquisitordesOrdoXenos.jpg"));
		
		seperator();
		
		add(bp = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boltpistole", 0));
		add(cs = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kettenschwert", 0));
		bp.setSelected(true);
		cs.setSelected(true);
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Nadelpistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Scythianer-Giftkralle", 15));
		ogE.addElement(new OptionsGruppeEintrag("Konversionsstrahler", 45));
		ogE.addElement(new OptionsGruppeEintrag("Psischwert", 0));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

		add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Servo-Schädel", 3, 3));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Servorüstung", 8));
		ogE.addElement(new OptionsGruppeEintrag("Digitalwaffen", 5));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Verzerrer", "Ulumeathischer Plasma-Verzerrer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Strahlungsgranaten", 15));
		ogE.addElement(new OptionsGruppeEintrag("Psigasgranaten", 15));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 100));

        seperator();

		add(psi = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Meisterschaftsgrad 1", 30));

		seperator();
        
        relikte = new RuestkammerStarter(ID, randAbstand, cnt, "INRelikte", "");
		relikte.initKammer(true, false, false, false, false);
		relikte.setButtonText(BuildaHQ.translate("Relikte"));
		add(relikte);
		relikte.setAbwaehlbar(false);
		
		complete();
	}

	@Override
	public void refreshen() {

        o1.setAktiv("Psischwert", psi.isSelected());

        boolean legal=(o1.getAnzahl()+(cs.isSelected()?1:0)+(bp.isSelected()?1:0))==2;
        o1.setLegal(legal);
        bp.setLegal(legal);
        cs.setLegal(legal);
        
        if(((INRelikte)relikte.getKammer()).uniqueError){
			setFehlermeldung("Artefakt doppelt!");
		} else{
			setFehlermeldung("");
		}
        
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}

}
