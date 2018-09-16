package oc.wh40k.units.da;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class DAChaplain extends Eintrag {

    RuestkammerStarter waffenUndReliquien;
    RuestkammerStarter spezialAusruestung;
    
	public DAChaplain() {
		name = "Chaplain";
		grundkosten = 90;

		add(ico = new oc.Picture("oc/wh40k/images/DAChaplain.gif"));
		
		seperator();
		
		waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "DAWaffenUndReliquien", "");
		// Kompaniemeister, Absolutionspriester, Ordenspriester, Skriptor, Techmarine, Techmarine
		waffenUndReliquien.initKammer(false, false, true, false, false, false);
		waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
		add(waffenUndReliquien);
		waffenUndReliquien.setAbwaehlbar(false);
		
		seperator();
		
		spezialAusruestung = new RuestkammerStarter(ID, randAbstand, cnt, "DASpezialausruestung", "");
		spezialAusruestung.initKammer(false, false, false);
		spezialAusruestung.setButtonText(BuildaHQ.translate("Spezielle Ausr�stung"));
		add(spezialAusruestung);
		

		addToInformationVector("DAHQ", 1);
		
		seperator(5);

		complete();
	}

	
	@Override
	public void deleteYourself() {
		addToInformationVector("DAHQ", -1);
		if(bikeBool){
			addToInformationVector("DABikeHQ", -1);
		}
		super.deleteYourself();
	}
	
	boolean bikeBool;
	
	@Override
	public void refreshen() {

        if(getCountFromInformationVector("Ravenwing Strike Force")>0)
        {
        	if(!spezialAusruestung.isSelected())spezialAusruestung.setSelected(true);
        	((DASpezialausruestung)spezialAusruestung.getKammer()).ravenwing = true;
        }
	}

}