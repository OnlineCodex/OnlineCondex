package oc;

import org.w3c.dom.Element;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;

public class Chooser extends BuildaPanel implements ActionListener, BuildaSTK {

    private static ListCellRenderer defaultRenderer = new JComboBox().getRenderer(); // mein eigener Renderer "überschreibt" sozusagen den default renderer, indem er seine Methode aufruft und das reurnte verändert. Dafür muss ich diesen aber einmal haben
    BuildaVater buildaVater;
    boolean aktualisierungIgnorieren = false;
    private JComboBox myComboBox = new JComboBox();
    private JButton cloneButton = new JButton(BuildaHQ.translate("Clonen"));
    private String reflectionKennung;
    private Object[] statischeEinträge;
    private Vector<String> spezialEinträge;
    ListCellRenderer renderer = new ListCellRenderer() {

        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            ////System.out.println("Chooser - getListCellRendererComponent");
            Component c = defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);


            for (int i = 0; i < statischeEinträge.length; ++i) {
                if (statischeEinträge[i].equals(value)) {
                    c.setForeground(new Color(0, 0, 0));
                    break;
                }
            }

            for (int i = 0; i < spezialEinträge.size(); ++i) {
                if (spezialEinträge.get(i).equals((String) value)) {
                    c.setForeground(new Color(30, 205, 0));
                    break;
                }
            }

            return c;
        }
    };
    private int kategorie;
    private boolean useActionPerformed = true;
    private Eintrag myEintrag = null;// = new LeererEintrag(0,0);
    private HashMap<String, String> multipleArmyClasses = new HashMap<String, String>();

    public Chooser(BuildaVater bv, int lX, int lY, String reflectionKennung, Object[] alleEinträge, int kategorie, ActionListener cloneListener) {  // ACHTUNG: wenn mehr oder weniger als 2 Hauptsachen zum panel geaddet werden, muss aktuellenEintragLöschen geändert werden! weil dann der index falsch ist, an dem irgendwas ins panel geaddet ist.
        //System.out.println("Chooser-Konstruktor");
        this.buildaVater = bv;
        this.kategorie = kategorie;
        this.panel.setLocation(lX, lY);
        this.reflectionKennung = reflectionKennung;

        myComboBox = new JComboBox(alleEinträge);

        myComboBox.setBounds(0, 0, auswahlBreite - 60, 20);
        myComboBox.addActionListener(this);
        myComboBox.setFocusable(false); // sie hat nie den Focus und wird deshalb nie durch die Pfeil-Unten-Taste geöffnet
        BuildaHQ.newGUIComponent(myComboBox);
        myComboBox.setBackground(Color.WHITE);
        //myComboBox.setMaximumRowCount(25);
        //System.out.println((BILDSCHIRMHÖHE-100)/20);
        myComboBox.setMaximumRowCount((BILDSCHIRMHÖHE - 150) / 20);
        myComboBox.setEditable(false);
        myComboBox.setRenderer(renderer);
        myComboBox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        //myComboBox.setEditable(true); Lustig!^^ man kann den ausgewählten Namen direkt eingeben. Mit enter lädt der entsprechende Eintrag auch! d.h. Carnifexe, Todesboten und Land Raider gleichzeitig^^ die laden/speichern Funktion funktioniert dabei sogar!

        panel.add(myComboBox);

        cloneButton.setBounds(auswahlBreite - 55, 0, 65, 20);
        cloneButton.addActionListener(cloneListener);

        BuildaHQ.newGUIComponent(cloneButton);

        cloneButton.setBorder(BuildaHQ.createBorder(new Color(134, 201, 218)));
        cloneButton.setFont(new Font("tahoma", Font.PLAIN, 12));
        cloneButton.setToolTipText("Clont diesen Eintrag mit all seinen Einstellungen und Rüstkammern.");
        panel.add(cloneButton);

        // panel.add V_O_R_S_I_C_H_T! siehe eintragLöschen

        sizeSetzen();

        cloneButton.repaint();
        panel.repaint();

        new RefreshListener((byte) 9) {
            @Override
            public void refresh() {
                //System.out.print("");
                sizeSetzen();
                //System.out.print("");
            }  // guckstu ende erstelleEintrag()  wenn du das hier ämndern willst
        };
    }

    public int getKategorie() {
        //System.out.println("Chooser-getKategorie");
        return this.kategorie;
    }

    public Eintrag getEintrag() {
        //System.out.println("Chooser-getEintrag");
        return this.myEintrag;
    }

    public JButton getCloneButton() {
        //System.out.println("Chooser-getCloneButton");
        return cloneButton;
    }

    public JComboBox getComboBox() {
        //System.out.println("Chooser-getComboBox");
        return this.myComboBox;
    }

    public double getKosten() {
        //System.out.println("Chooser-getKosten");
        try {
            return ((Eintrag) myEintrag).getKosten();
        } catch (Exception e) {
            return 0;
        }
    }

    public Chooser setStatischeEinträge(Object[] sE) {
        //System.out.println("Chooser-setStatistischeEinträge");
        this.statischeEinträge = sE;
        return this;
    } // muss extra gemacht werden, weil als Parameter dem Kosntruktor auch alle Spezialauswahlen mitgegeben werden, ich aber für den Renderer die Info brauch was statisch ist...

    public Chooser setSpezialEinträge(Vector<String> sE) {
        //System.out.println("Chooser-setSpezialEinträge");
        this.spezialEinträge = sE;
        return this;
    }

    public void sizeSetzen() {
        //System.out.println("Chooser-sizeSetzen");
        int x = myComboBox.getSize().width;
        int y = myComboBox.getSize().height;

        if (myEintrag != null) {
            x = BuildaHQ.wasIstHoeher(x, ((Eintrag) myEintrag).getBreite());
            y = ((Eintrag) myEintrag).getHöhe();

            x += ((Eintrag) myEintrag).getPanel().getLocation().getX();
            y += ((Eintrag) myEintrag).getPanel().getLocation().getY();
        }

        panel.setSize(x, y + randAbstand);
    }

    @SuppressWarnings("rawtypes")
    public void setAuswahlen(Vector v) {
        //System.out.println("Chooser-setAuswahlen");
        useActionPerformed = false;
        String currentSelected = selectedEntry();

        // leeren und neufüllen der Liste
        myComboBox.removeAllItems();
        for (int i = 0; i < v.size(); i++) {
            myComboBox.addItem(v.elementAt(i));
        }

        myComboBox.setSelectedItem(currentSelected);

//	    System.out.println("myComboBox.size "+myComboBox.getComponentCount());
//	    System.out.println("selectedEntry() "+selectedEntry());
//	    System.out.println("currentSelected "+currentSelected);

        if (!selectedEntry().equals(currentSelected)) {
            myEintrag.deleteYourself();
        } //  myEintrag hat sich bis jetzt noch nicht geändert, weil ich useActionPerformed auf false geschaltet hab.

        useActionPerformed = true;
    }

    @SuppressWarnings("rawtypes")
    public void erstelleEintrag(String name) {
        //System.out.println("Chooser-erstelleEintrag name: "+name+" reflection: "+reflectionKennung);
        String umgeformterName = BuildaHQ.formZuKlassenName(name);
        if (umgeformterName.equals("")) {
            erstelleLeerenEintrag();
        } else {
            String finalClassName = "";
            try {
                // Determine whether to use a WHFB or a Wh40k Army-Class
                String armyPackage = OnlineCodex.armyPackage;

                // Check if the requested class is used by multiple armies
                if (this.multipleArmyClasses.containsKey(name)) {
                    finalClassName = this.multipleArmyClasses.get(name);
                } else {
                    finalClassName = reflectionKennung + umgeformterName;
                }
                finalClassName = finalClassName.replaceAll("\\[[\\w ]{1,}\\]", ""); // Remove "Forgeworld" label from class name

                try {
                    //System.out.println("Chooser-erstelleEintrag class(try1): "+armyPackage + "units." + finalClassName);
                    Class myClass = Class.forName(armyPackage + "units." + finalClassName);

                    aktuellenEintragLöschen(); // wird auch in erstelleLeerenEintrag() aufgerufen...

                    myEintrag = (Eintrag) (myClass.newInstance());
                } catch (Exception e) {

                    try {
                        if (reflectionKennung == "") {
                            //System.out.println("Chooser-erstelleEintrag class(try2): "+armyPackage + "units." + reflectionKennung.toLowerCase() + "." + finalClassName);
                            Class myClass = Class.forName(armyPackage + "units." + umgeformterName.substring(0, 2).toLowerCase() + "." + finalClassName);

                            aktuellenEintragLöschen(); // wird auch in erstelleLeerenEintrag() aufgerufen...

                            myEintrag = (Eintrag) (myClass.newInstance());
                        } else {
                            //System.out.println("Chooser-erstelleEintrag class(try2): "+armyPackage + "units." + reflectionKennung.toLowerCase() + "." + finalClassName);
                            Class myClass = Class.forName(armyPackage + "units." + reflectionKennung.toLowerCase() + "." + finalClassName);

                            aktuellenEintragLöschen(); // wird auch in erstelleLeerenEintrag() aufgerufen...

                            myEintrag = (Eintrag) (myClass.newInstance());
                        }

                    } catch (Exception ex) {
                        if (reflectionKennung == "") { //Fall für Einheiten in APO
                            //System.out.println("Chooser-erstelleEintrag class(try2): "+armyPackage + "units." + reflectionKennung.toLowerCase() + "." + finalClassName);
                            Class myClass = Class.forName(armyPackage + "units." + umgeformterName.substring(0, 3).toLowerCase() + "." + finalClassName);

                            aktuellenEintragLöschen(); // wird auch in erstelleLeerenEintrag() aufgerufen...

                            myEintrag = (Eintrag) (myClass.newInstance());
                        } else {
                            //System.out.println("Chooser-erstelleEintrag class(try3): "+armyPackage + "units." + umgeformterName);
                            Class myClass = Class.forName(armyPackage + "units." + umgeformterName);

                            aktuellenEintragLöschen(); // wird auch in erstelleLeerenEintrag() aufgerufen...

                            myEintrag = (Eintrag) (myClass.newInstance());
                        }

                    }
                }

                if (umgeformterName.startsWith("Requiriert")) {
                    myEintrag.setName(name); // Requirierte Einheiten
                }

                myEintrag.getPanel().setLocation(0, 30);
                myEintrag.setKategorie(kategorie);
                myEintrag.setBuildaVater(buildaVater);
                panel.add(myEintrag.getPanel());
            } catch (ClassNotFoundException e) {
                OnlineCodex.getInstance().fehler("Klasse \"" + finalClassName + "\" nicht gefunden.\nBitte melden!!");
                //System.out.println("Klasse \"" + finalClassName+"\" nicht gefunden. Bitte melden!!");
                erstelleLeerenEintrag();
                //System.out.println(e.getStackTrace());
            } catch (ClassCastException e) {
                //System.out.println(e.toString());
            } catch (InstantiationException e) {
                //System.out.println(e.toString());
            } catch (IllegalAccessException e) {
                //System.out.println(e.toString());
            }
        }

        RefreshListener.fireRefresh();  // fireRefresh macht SizeSetzen()
        //System.out.println("Chooser-erstelleEintrag myEintrag instanceof LeererEintrag: "+(myEintrag instanceof LeererEintrag));
        cloneButton.setVisible(!(myEintrag instanceof LeererEintrag));

    }

    public String selectedEntry() {
        //System.out.println("Chooser-selectedEntry");
        return ((String) (myComboBox.getSelectedObjects()[0]));
    }

    public void actionPerformed(ActionEvent event) {
        //System.out.println("Chooser-actionPerformed");
        if (useActionPerformed) {
            erstelleEintrag(selectedEntry());
        }
    }

    public void aktuellenEintragLöschen() {
        //System.out.println("Chooser-aktuellenEintragLöschen");
        if (myEintrag != null) {
            myEintrag.deleteYourself();
            RefreshListener.remove(myEintrag.getID());
            myEintrag = null;
            try {
                panel.remove(2);
            } catch (Exception e) {
                e.printStackTrace();
            }  // zahl ändern wenn mehr oder weniger Components aufem Panel sind!
        }
    }

    public void erstelleLeerenEintrag() {
        //System.out.println("Chooser-erstelleLeerenEintrag");
        aktuellenEintragLöschen();
        myEintrag = new LeererEintrag(0, 0);
        myEintrag.getPanel().setLocation(0, 30);
        panel.add(myEintrag.getPanel());
    }

    public String getText() {
        //System.out.println("Chooser-getText");
        try {
            return myEintrag.getText();
        } catch (Exception e) {
            return "";
        }
    }

    public String getSaveText(String trenner) {
        //System.out.println("Chooser-getSaveText");
        try {
            return myEintrag.getSaveText(trenner);
        } catch (Exception e) {
            return "";
        }
    }

    public Element getSaveElement() {
        //System.out.println("Chooser-getSaveElement");
        if (getComboBox().getSelectedObjects()[0].toString().trim().equals("")) return null;

        Element root = myEintrag.getSaveElement();
        root.setAttribute("selection", getComboBox().getSelectedObjects()[0].toString());

//    	Element root = BuildaHQ.getNewXMLElement("Eintrag");
//    	root.setAttribute("selection", getComboBox().getSelectedObjects()[0].toString());
//
//    	root.appendChild(myEintrag.getSaveElement());

        return root;
    }

    public void load(String s, String s2) {
        //System.out.println("Chooser-load");
        myEintrag.load(s, s2);
    }

    public void loadElement(Element e) {
        //System.out.println("Chooser-loadElement");
        myEintrag.loadElement(e);
    }

    public void selectEntry(String s) {//Feste Auswahl für eine Formation
        myComboBox.setSelectedItem(s);
        myComboBox.setEnabled(false);
        cloneButton.setEnabled(false);
    }

    public void selectEntryNotLocked(String s) {//Tauschbare Auswahl für eine Formation
        myComboBox.setSelectedItem(s);
    }

    public void removeEmptyEntry() {//Entfernt den leeren Eintrag am Anfang, damit die Einheit nicht abgewählt werden kann
        myComboBox.remove(0);
    }

    public void changeEntries(String[] units) { //Tauscht den Inhalt der Combobox aus
        //System.out.println("Chooser-setAuswahlen");
        useActionPerformed = false;

        // leeren und neufüllen der Liste
        myComboBox.removeAllItems();
        for (int i = 0; i < units.length; i++) {
            myComboBox.addItem(units[i]);
        }

        useActionPerformed = true;

        myComboBox.setSelectedItem(units[0]);
    }

    public void setReflectionKennung(String s) {
        reflectionKennung = s;
    }

}
