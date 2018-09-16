package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class IMWolfGuardBattleLeaderonThunderwolf extends Eintrag {


	OptionsUpgradeGruppe o3;
	OptionsUpgradeGruppe o4;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
    RuestkammerStarter termiWaffen;
    RuestkammerStarter waffenUndArtefakte;
    RuestkammerStarter spezialAusruestung;
    boolean fenrisSupp = false;

	public IMWolfGuardBattleLeaderonThunderwolf() {
		name = "Wolf Guard Battle Leader on Thunderwolf";
		grundkosten = getPts("Wolf Guard Battle Leader on Thunderwolf");
		power = 6;
		seperator();
		
		waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "");
		((IMSpaceWolvesRuestkammer)waffenUndArtefakte.getKammer()).setType("Wolf Guard Battle Leader");
		waffenUndArtefakte.initKammer();
		waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen"));
		add(waffenUndArtefakte);
		waffenUndArtefakte.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void refreshen() {
	}

}