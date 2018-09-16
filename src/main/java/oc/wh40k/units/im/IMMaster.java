package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IMMaster extends Eintrag {
	OptionsEinzelUpgrade jump;
	RuestkammerStarter waffenUndReliquien;

	public IMMaster() {
		name = "Master";
		grundkosten = getPts("Master") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

		seperator();

		add(jump = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump Pack", getPts("Master with Jump Pack") - getPts("Master")));

		seperator();

		waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceMarinesRuestkammer", "");
		((IMSpaceMarinesRuestkammer)waffenUndReliquien.getKammer()).setType("Captain");
		waffenUndReliquien.initKammer();
		waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
		add(waffenUndReliquien);
		waffenUndReliquien.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void refreshen() {
		power = 5 + (jump.isSelected()?1:0);
	}
}