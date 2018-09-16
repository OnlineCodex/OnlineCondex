package oc.wh40k.units.dw;

import java.util.Vector;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerStarter;

public class DWVanguardVeterans extends Eintrag {//Sternguard

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1x;
	OptionsZaehlerGruppe o2x;
	OptionsZaehlerGruppe o2, o3;
	Vector<RuestkammerStarter> rk;

	public DWVanguardVeterans() {
		name = "Vanguard Veterans\n";
		grundkosten = 0;
		�berschriftSetzen = true;

		rk=new Vector<RuestkammerStarter>();
		
		for(int i=0;i<5;i++){
			rk.add(new RuestkammerStarter(ID, randAbstand, cnt, "DWVanguardVeteran", "Vanguard Veteran"));
			rk.lastElement().initKammer();
			rk.lastElement().setGrundkosten(25);
			add(rk.lastElement());	
		}
		
		for(int i=0;i<1;i++){
			rk.get(i).setAbwaehlbar(false);
		}
		
		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/SMProtektorgarde.jpg"));
		
		seperator();

		complete();
	}

	@Override
	public void refreshen() {

	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}

}