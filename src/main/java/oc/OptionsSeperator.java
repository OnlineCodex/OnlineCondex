package oc;

import org.w3c.dom.Element;

import java.awt.event.MouseEvent;


public class OptionsSeperator extends OptionsVater {


    private int höhe = 0;

    public OptionsSeperator(int höhe) {

        this.höhe = höhe;
    }

    public String getText() {
        return "";
    }

    public String getSaveText() {
        return "";
    }

    public Element getSaveElement() {
        return null;
    }

    public void load(String s) {
    }

    public void loadElement(Element e) {
    }

    public boolean isLegal() {
        return true;
    }

    public void setLegal(boolean b) {
    }

    public double getKosten() {
        return 0;
    }

    public boolean isSelected() {
        return false;
    }

    public String getLabel() {
        return "";
    }

    public void mouseReleased(MouseEvent event) {
    }

    @Override

    public int getHoehe() {

        return höhe;

    }


}