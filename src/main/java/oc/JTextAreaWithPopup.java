package oc;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.event.*;


@SuppressWarnings("serial")
public class JTextAreaWithPopup extends JTextArea implements MouseListener, CaretListener, KeyListener {

    boolean kopierOption;
    boolean einfügOption;
    private JPopupMenu popup;
    private JMenuItem kopieren;
    private JMenuItem allesKopieren;
    private JMenuItem einfügen;
    private JMenuItem allesMarkieren;
    ActionListener menuActionListener = new ActionListener() {

        public void actionPerformed(ActionEvent event) {

            Object source = event.getSource();


            if (source == kopieren) {

                kopieren();
            }

            if (source == allesKopieren) {

                allesKopieren();
            } else if (source == einfügen) {

                einfügen();
            } else if (source == allesMarkieren) {

                allesMarkieren();
            }


        }

    };


    public JTextAreaWithPopup(boolean kopierOption, boolean einfügOption) {

        this.kopierOption = kopierOption;

        this.einfügOption = einfügOption;


        popup = new JPopupMenu();


        if (kopierOption) {

            kopieren = new JMenuItem("Kopieren");

            popup.add(kopieren);

            kopieren.setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_MASK));

            kopieren.addActionListener(menuActionListener);

            kopieren.setEnabled(false);


            allesKopieren = new JMenuItem("Alles Kopieren");

            popup.add(allesKopieren);

            allesKopieren.addActionListener(menuActionListener);
        }


        if (einfügOption) {

            einfügen = new JMenuItem("Einfügen");

            popup.add(einfügen);

            einfügen.setAccelerator(KeyStroke.getKeyStroke('V', InputEvent.CTRL_MASK));

            einfügen.addActionListener(menuActionListener);
        }


        allesMarkieren = new JMenuItem("Alles markieren");

        popup.add(allesMarkieren);

        allesMarkieren.setAccelerator(KeyStroke.getKeyStroke('A', InputEvent.CTRL_MASK));

        allesMarkieren.addActionListener(menuActionListener);


        this.addMouseListener(this);

        this.addKeyListener(this);

        this.addCaretListener(this);

    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }


    public void mouseReleased(MouseEvent e) {

        //if(e.isPopupTrigger()){

        //	popup.show(this, e.getX(), e.getY());}

    }


    public void caretUpdate(CaretEvent e) {

        if (kopierOption) {

            kopieren.setEnabled(e.getMark() != e.getDot());
        } // Text ist markiert

    }


    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }


    public void kopieren() {

        //this.getActionMap().get(this.getInputMap().get(KeyStroke.getKeyStroke("ctrl C"))).actionPerformed(null);		ACCES DENID!! Leider

    }

    public void allesKopieren() {

        allesMarkieren();

        //this.getActionMap().get(this.getInputMap().get(KeyStroke.getKeyStroke("ctrl C"))).actionPerformed(null);

    }


    public void einfügen() {

        //this.getActionMap().get(this.getInputMap().get(KeyStroke.getKeyStroke("ctrl V"))).actionPerformed(null);

    }


    public void allesMarkieren() {

        this.requestFocusInWindow();

        this.selectAll();

    }


}