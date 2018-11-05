package oc;

public class InformationNecrons extends Information {


    private int necrons;


    public void addNecrons(int i) {
        necrons += i;
    }

    public int getNecrons() {
        return necrons;
    }


    @Override

    public String getInformationText() {

        String main = super.getInformationText();

        return main + BuildaHQ.translate("Necrons") + ": " + necrons;

    }


}