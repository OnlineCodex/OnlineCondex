package oc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.util.Locale;

public class SaveTextWindow extends JDialog implements BuildaSTK {

    public static final String TOKEN = "###"; // Trennzeichen fuer Armeelistze in Maschinenformat und lesbares Format
    private static final long serialVersionUID = 1L;
    private String saveText = "";
    private String saveTextAllies = "";
    private String armyList; // enthaelt die Armeeliste in Menschenlesbarer form.
    private JFileChooser fc;

    public SaveTextWindow(JFrame owner, String currentDir) {
        super(owner, BuildaHQ.translate("Speichern"), true);

        if (BuildaHQ.getSprache() == Sprache.English) {
            Locale.setDefault(Locale.US);
        }

        fc = new JFileChooser(currentDir);

        fc.setDialogTitle(BuildaHQ.getSprache() == Sprache.German ? "Speichern" : "Save");
        fc.setApproveButtonText(BuildaHQ.getSprache() == Sprache.German ? "Speichern" : "Save");

        fc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith("." + BuildaPanel.getFileSuffix())
                        || f.isDirectory();
            }

            @Override
            public String getDescription() {
                return BuildaHQ.translate("oc Dateien");
            }
        });

        fc.setSelectedFile(BuildaHQ.getLastLoaded() == null ? new File("." + BuildaPanel.getFileSuffix()) : new File(BuildaHQ.getLastLoaded()));

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        fc.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if (JFileChooser.DIRECTORY_CHANGED_PROPERTY.equals(e.getPropertyName())) {
                    OnlineCodex.getInstance().getPrefs().put(PREFERENCES_SAVE_DIRECTORY, getCurrentDir());
                }
            }
        });
    }

    public String getCurrentDir() {
        return fc.getCurrentDirectory().getAbsolutePath();
    }

    public String getSaveText() {
        return saveText;
    }

    public void setSaveText(String saveText) {
        this.saveText = saveText;
    }

    public String getSaveTextAllies() {
        return saveTextAllies;
    }

    public void setSaveTextAllies(String saveText) {
        this.saveTextAllies = saveText;
    }

    public void setArmyList(String armyList) {
        this.armyList = armyList;
    }

    public void save() {
        int returnVal = fc.showSaveDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();

            String saveText = BuildaPanel.budget.getText() + ";" + getSaveTextAllies() + ";" + getSaveText() + TOKEN + armyList; // army list in both formats

            try {
                if (file.getName().endsWith("." + BuildaPanel.getFileSuffix())) {
                    Writer writer = new FileWriter(file);
                    writer.write(saveText);
                    writer.close();
                } else {
                    Writer writer = new FileWriter(file + "." + BuildaPanel.getFileSuffix());
                    writer.write(saveText);
                    writer.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, BuildaHQ.translate("Datei konnte nicht gespeichert werden."));
            }

//            writeXML();
        }

    }

    public void writeXML() {
        Element root = OnlineCodex.getInstance().getSaveElement();

        Document d = BuildaHQ.getXMLDocument();
        d.appendChild(root);

        Writer writer = null;
        try {
            File file = new File(fc.getSelectedFile().getAbsolutePath() + ".xml");
            writer = new OutputStreamWriter(new FileOutputStream(file), "UTF8");
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            DOMSource source = new DOMSource(d);
            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);

        } catch (TransformerConfigurationException ex) {
            ex.printStackTrace();
        } catch (TransformerException ex) {
            ex.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
            }
        }
    }
}