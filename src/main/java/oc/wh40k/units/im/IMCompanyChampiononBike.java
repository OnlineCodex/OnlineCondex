package oc.wh40k.units.im;

import oc.Eintrag;

public class IMCompanyChampiononBike extends Eintrag {

	public IMCompanyChampiononBike() {
		name = "Company Champion on Bike";
		grundkosten = getPts("Company Champion on Bike") + 
					  getPts("Frag grenade (SM)") + 
					  getPts("Krak grenade (SM)") + 
					  getPts("Bolt pistol (SM)") + 
					  getPts("Master-crafted power sword") + 
					  getPts("Twin boltgun");
		power = 5;

		complete();
	}

		public void refreshen() {
		}
}