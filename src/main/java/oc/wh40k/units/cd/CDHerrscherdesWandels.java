package oc.wh40k.units.cd;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CDHerrscherdesWandels extends Eintrag {

	OptionsZaehlerGruppe o1,o2,o3;
	RuestkammerStarter artefakte;
	
	public CDHerrscherdesWandels() {

		name = "Herrscher des Wandels";

		grundkosten = 230;

		add(ico = new oc.Picture("oc/wh40k/images/CDHerrscherdesWandels.gif"));
		
		addToInformationVector("CDD�monenprinz", 1);
		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("D�monenprinz des Tzeentch");
		BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("D�monenprinz des Tzeentch");
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Meisterschaftsgrad 3", 25));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Geringe Belohnungen", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
		ogE.addElement(new OptionsGruppeEintrag("M�chtige Belohnungen", 20));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		ogE.addElement(new OptionsGruppeEintrag("Erhabene Belohnungen", 30));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();
		
		//H�llengeschmiedeteArtefakte
		artefakte = new RuestkammerStarter(ID, randAbstand, cnt, "CDArtefakte", "");
		artefakte.initKammer();
		artefakte.setButtonText(BuildaHQ.translate("Artefakte"));
		add(artefakte);

		((CDArtefakte)artefakte.getKammer()).enableEntry(17);
		((CDArtefakte)artefakte.getKammer()).enableEntry(20);
		((CDArtefakte)artefakte.getKammer()).enableEntry(22);
		
		complete();

	}

	@Override
	public void refreshen() {
		int max = 50;
		int geringeBelohnung = 10;
		int m�chtigeBelohnung = 20;
		int erhabeneBelohnung = 30;
		
		int freePoints = max - o1.getAnzahl()*geringeBelohnung - o2.getAnzahl()*m�chtigeBelohnung - o3.getAnzahl()*erhabeneBelohnung;
		if(freePoints < erhabeneBelohnung){
			o3.setMaxAnzahl(o3.getAnzahl());
		} else {
			o3.setMaxAnzahl(freePoints/erhabeneBelohnung);
		}
		if(freePoints < m�chtigeBelohnung){
			o2.setMaxAnzahl(o2.getAnzahl());
		} else {
			o2.setMaxAnzahl(o2.getAnzahl() + freePoints/m�chtigeBelohnung);
		}
		if(freePoints < geringeBelohnung){
			o1.setMaxAnzahl(o1.getAnzahl());
		} else {
			o1.setMaxAnzahl(o1.getAnzahl() + freePoints/geringeBelohnung);
		}
		
		if(((CDArtefakte)artefakte.getKammer()).uniqueError){
			setFehlermeldung("Artefakt doppelt!");
		} else{
			setFehlermeldung("");
		}
	}
	
	@Override
	public void deleteYourself() {
		addToInformationVector("CDD�monenprinz", -1);
		if(getCountFromInformationVector("CDD�monenprinz")<1){
			BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("D�monenprinz des Tzeentch");
			BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("D�monenprinz des Tzeentch");
		}
		super.deleteYourself();
	}
}