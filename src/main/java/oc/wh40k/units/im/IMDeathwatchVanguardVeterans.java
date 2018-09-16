package oc.wh40k.units.im;

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

public class IMDeathwatchVanguardVeterans extends Eintrag {//Sternguard

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1x;
	OptionsZaehlerGruppe o2x;
	OptionsZaehlerGruppe o2, o3;
	Vector<RuestkammerStarter> rk;

	public IMDeathwatchVanguardVeterans() {
		name = "Vanguard Veterans\n";
		grundkosten = 0;
		�berschriftSetzen = true;

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melta bombs", getPts("Melta bombs")));

		seperator();
		
		rk=new Vector<RuestkammerStarter>();
		
		for(int i=0;i<10;i++){
			rk.add(new RuestkammerStarter(ID, randAbstand, cnt, "DeathWatchKammer", "Vanguard Veteran"));
			((DeathWatchKammer)rk.get(i).getKammer()).setType("Vanguard Veteran");
			rk.lastElement().initKammer();
			rk.lastElement().setGrundkosten(getPts("Vanguard Veteran Squad with Jump Packs"));
			add(rk.lastElement());	
		}
		
		for(int i=0;i<1;i++){
			rk.get(i).setAbwaehlbar(false);
		}
		
		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/SMProtektorgarde.jpg"));
		
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