package oc;

public class Information {


    protected int modelle;

    protected int panzer;

    protected int ucms;


    public void addModelle(int i) {
        modelle += i;
    }

    public void addPanzer(int i) {
        panzer += i;
    }

    public void addUCMs(int i) {
        ucms += i;
    }


    public String getInformationText() {

        StringBuilder sb = new StringBuilder();


        sb.append(BuildaHQ.translate("Modelle insgesamt") + ": " + modelle);

        sb.append(BuildaHQ.translate("Panzer") + ": " + panzer);

        sb.append(BuildaHQ.translate("Unabhängige Charaktermodelle") + ": " + ucms);


        return sb.toString();

    }


}