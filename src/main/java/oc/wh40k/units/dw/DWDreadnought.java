package oc.wh40k.units.dw;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class DWDreadnought extends Eintrag {

	RuestkammerStarter rkD1;
	RuestkammerStarter rkPod;
        
    boolean siegeForce;
        
	public DWDreadnought() {
		name = "Dreadnoughts";
		
        rkD1 = new RuestkammerStarter(ID, randAbstand, cnt, "DWDreadnoughtKammer", "Dreadnought");
        rkD1.initKammer(true);
        add(rkD1);
      
        seperator();
        
        rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "DWDropPodKammer", "Landungskapsel");
        rkPod.initKammer(true);
        rkPod.setButtonText("Landungskapsel");
        rkPod.setSeperator(0);
        add(rkPod);
            
		complete();
	}

	@Override
	public void refreshen() {
		rkD1.setAbwaehlbar(false);
		
		rkPod.getPanel().setLocation(
				(int) rkPod.getPanel().getLocation().getX(),
				(int) rkD1.getPanel().getLocation().getY() + rkD1.getPanel().getSize().height + 5
				);

	}
	
	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}
}