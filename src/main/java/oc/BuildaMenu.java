package oc;import java.awt.Color;import java.awt.Font;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.awt.event.KeyEvent;import java.awt.event.KeyListener;import java.awt.event.WindowAdapter;import java.awt.event.WindowEvent;import java.awt.event.WindowListener;import java.util.prefs.Preferences;import javax.swing.JButton;import javax.swing.JCheckBox;import javax.swing.JFrame;import javax.swing.JLabel;import javax.swing.JOptionPane;import javax.swing.JTextArea;public class BuildaMenu extends JFrame implements BuildaSTK { 	private static final long serialVersionUID = 1L;		public static JCheckBox bilderAneigen = new JCheckBox("", true); // <-- Lamekhs Online Codex 	JTextArea tMausradSpeed = new JTextArea(String.valueOf(DEFAULT_MAUSWHEELLSPEED));	JLabel lMausradSpeed = new JLabel(BuildaHQ.translate("Geschwindigkeit des Mausrads:"));	JTextArea tPfeiltastenSpeed = new JTextArea(String.valueOf(DEFAULT_PFEILTASTENSPEED));	JLabel lPfeiltastenSpeed = new JLabel(BuildaHQ.translate("Geschwindigkeit der Pfeiltasten:"));	JCheckBox vertikalScrollen = new JCheckBox("", true);	JLabel lVertikalScrollen = new JLabel(BuildaHQ.translate("Scrollrichtung umdrehen"));	JCheckBox bildaz = new JCheckBox("", true);	JLabel lBildaz = new JLabel(BuildaHQ.translate("Bilder"));	//JButton cleanBuilda = new JButton(BuildaHQ.translate("Leere aktuelles Dokument"));	JButton ok = new JButton(BuildaHQ.translate("OK"));	//JCheckBox apo = new JCheckBox("", false);	//JLabel lApo = new JLabel(BuildaHQ.translate("Apokalypse"));	boolean apoSelected = false;	public BuildaMenu() {		super(BuildaHQ.translate("Einstellungen"));		this.setLayout(null);		this.setBounds(200, 200, 584, 320); // 404 210		this.getContentPane().setBackground(Color.WHITE);		this.setResizable(false);		this.setIconImage(BuildaHQ.oCLogo);		int XX = 15;		int cnt = 10;		lMausradSpeed.setBounds(XX, cnt, 190, 18);		tMausradSpeed.setBounds(XX + 195, cnt + 2, 35, 18);		cnt += 22;		lVertikalScrollen.setBounds(XX, cnt, 180, 18);		vertikalScrollen.setBounds(XX + 195 - 3, cnt, 30, 18);		cnt += 25;		lPfeiltastenSpeed.setBounds(XX, cnt, 190, 18);		tPfeiltastenSpeed.setBounds(XX + 195, cnt + 2, 35, 18);		if (OnlineCodex.getGame() == OnlineCodex.WH40K || OnlineCodex.getGame() == OnlineCodex.WH40K_LEGACY) cnt += 25;//		if (OnlineCodex.getGame() == OnlineCodex.WH40K || OnlineCodex.getGame() == OnlineCodex.WH40K_LEGACY) lApo.setBounds(XX, cnt, 190, 18);//		if (OnlineCodex.getGame() == OnlineCodex.WH40K || OnlineCodex.getGame() == OnlineCodex.WH40K_LEGACY) apo.setBounds(XX + 195 - 3, cnt, 30, 18);		String h1;		h1 = BuildaHQ.translate("Hier kann man verändern, wie schnell mit dem Mausrad gescrollt wird");		lMausradSpeed.setToolTipText(h1);		tMausradSpeed.setToolTipText(h1);		h1 = BuildaHQ.translate("Hier kann man verändern, wie schnell mit den Pfeiltasten gescrollt wird");		lPfeiltastenSpeed.setToolTipText(h1);		tPfeiltastenSpeed.setToolTipText(h1);		tMausradSpeed.setFont(new Font("arial", Font.PLAIN, 14));		tPfeiltastenSpeed.setFont(new Font("arial", Font.PLAIN, 14));		tMausradSpeed.addKeyListener(closeKeyListener);		tPfeiltastenSpeed.addKeyListener(closeKeyListener);//		if (OnlineCodex.getGame() == OnlineCodex.WH40K || OnlineCodex.getGame() == OnlineCodex.WH40K_LEGACY) apo.addKeyListener(closeKeyListener);//		if (OnlineCodex.getGame() == OnlineCodex.WH40K || OnlineCodex.getGame() == OnlineCodex.WH40K_LEGACY) lApo.addKeyListener(closeKeyListener);		vertikalScrollen.setBackground(Color.WHITE);//		if (OnlineCodex.getGame() == OnlineCodex.WH40K || OnlineCodex.getGame() == OnlineCodex.WH40K_LEGACY) apo.setBackground(Color.WHITE);		h1 = BuildaHQ.translate("<html>Dreht das scrollen mit dem Mausrad um. Normalerweise wird oben-unten, bei gedrückten STRG links-rechts gescrollt.<br>Wenn angehakt, wird links-rechts gescrollt, wenn STRG gedrückt ist, oben-unten.</html>");		vertikalScrollen.setToolTipText(h1);		lVertikalScrollen.setToolTipText(h1);		h1 = BuildaHQ.translate("Hier kann man einstellen, ob Apokalypse-Einheiten ausgewählt werden können oder nicht.");//		if (OnlineCodex.getGame() == OnlineCodex.WH40K || OnlineCodex.getGame() == OnlineCodex.WH40K_LEGACY) lApo.setToolTipText(h1);//		if (OnlineCodex.getGame() == OnlineCodex.WH40K || OnlineCodex.getGame() == OnlineCodex.WH40K_LEGACY) apo.setToolTipText(h1);		cnt += 25;		lBildaz.setBounds(XX, cnt, 180, 18);		bildaz.setBounds(XX + 195 - 3, cnt, 30, 18);		bildaz.setBackground(Color.WHITE);		h1 = BuildaHQ.translate("Es werden keine Bilder angezeigt. Verkleinert manche Einträge.");		bildaz.setToolTipText(h1);		lBildaz.setToolTipText(h1);		cnt += 31;		this.add(lMausradSpeed);		this.add(tMausradSpeed);		this.add(lVertikalScrollen);		this.add(vertikalScrollen);		this.add(lPfeiltastenSpeed);		this.add(tPfeiltastenSpeed);//		if (OnlineCodex.getGame() == OnlineCodex.WH40K || OnlineCodex.getGame() == OnlineCodex.WH40K_LEGACY) {//                    this.add(apo);//                    this.add(lApo);//                }		this.add(bildaz);		this.add(lBildaz);//		cleanBuilda.setBounds(XX - 1, cnt, 226 - XX - 40, 18);//		cleanBuilda.setMargin(new Insets(0, 0, 0, 0));//		cleanBuilda.setBorder(null);//		cleanBuilda.setFont(new Font("arial", Font.BOLD, 11));//		cleanBuilda.addActionListener(dokumentLeerenListener);//		cleanBuilda.setToolTipText(BuildaHQ.translate("Löscht alle Einträge des aktiven Volkes."));//		this.add(cleanBuilda);		ok.setBounds(this.getSize().width - 90, this.getSize().height - 77, 76, 17);		ok.setBorder(null);		this.add(ok);		this.getRootPane().setDefaultButton(ok); // reagiert dadurch auf die Tastendrücke auch wenn andere Buttons den Focus ham		ok.addKeyListener(closeKeyListener);		ok.addActionListener(closeActionListener);		JLabel ico = BuildaHQ.createPictureJLabel("oc/sysimages/smArtwork.gif"); // ACHTUNG BEI ÄNDERUNGEN AUCH IN BUILDAPANEL ANPASSEN!!!		ico.setLocation(260, 12);		this.add(ico);                                loadPrefs();	}	KeyListener closeKeyListener = new KeyListener() {		public void keyPressed(KeyEvent event) {			//System.out.println(getMousePosition());    zum GUI bauen^^			if (event.getKeyCode() == KeyEvent.VK_ENTER || event.getKeyCode() == KeyEvent.VK_ESCAPE) {				closeBuildaMenu();			}		}		public void keyReleased(KeyEvent event) {		}		public void keyTyped(KeyEvent event) {		}	};                WindowListener windowListener = new WindowAdapter() {            @Override            public void windowClosing(WindowEvent e) {                savePrefs();            }        };	ActionListener closeActionListener = new ActionListener() {		public void actionPerformed(ActionEvent event) {			closeBuildaMenu();		}	};	ActionListener dokumentLeerenListener = new ActionListener() {		public void actionPerformed(ActionEvent event) {			int choose = JOptionPane.showOptionDialog(				null, BuildaHQ.translate("Wollen Sie wirklich alle Einträge des aktiven Volkes löschen?"), BuildaHQ.translate("Wirklich löschen?"), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{BuildaHQ.translate("Ja"), BuildaHQ.translate("Nein")}, BuildaHQ.translate("Ja"));			if (choose == 0) {				OnlineCodex.getInstance().dokumentLeeren();				closeBuildaMenu();			}		}	};	public void closeBuildaMenu() {                this.setVisible(false);//                Apo();	}	public int getMausradSpeed() {		try {			return Integer.parseInt(tMausradSpeed.getText());		} catch (NumberFormatException e) {			tMausradSpeed.setText(String.valueOf(DEFAULT_MAUSWHEELLSPEED));			return DEFAULT_MAUSWHEELLSPEED;		}	}	public int getPfeiltastenSpeed() {		try {			return Integer.parseInt(tPfeiltastenSpeed.getText());		} catch (NumberFormatException e) {			tPfeiltastenSpeed.setText(String.valueOf(DEFAULT_PFEILTASTENSPEED));			return DEFAULT_PFEILTASTENSPEED;		}	}	public boolean isBildaz() {		return bildaz.isSelected();	}	public boolean isApo() {		//return apo.isSelected();		return true;	}	public boolean isVertikalScrolling() {		return vertikalScrollen.isSelected();	}	public BuildaMenu getInstance() {		return this;	}//    @SuppressWarnings({"static-access"})//        public void Apo() {//            if (OnlineCodex.getGame() == OnlineCodex.WH40K || OnlineCodex.getGame() == OnlineCodex.WH40K_LEGACY) {//                String save = null;//                if (apo.isSelected() && apoSelected == false) {//                    save = OnlineCodex.getInstance().getSaveText() + "_1H_4T_5T_1H_4T_5T";//                    apoSelected = true;//                    OnlineCodex.getInstance().load(save, true);//                }//                if (!apo.isSelected()) {//                    save = OnlineCodex.getInstance().getChooser().getSelectedObjects()[0].toString() + OnlineCodex.getInstance().SAVETEXT_UEBERSCHRIFTTRENNER2 + OnlineCodex.getInstance().getBuilder().getSaveTextApo();//                    apoSelected = false;//                    OnlineCodex.getInstance().load(save, true);//                }//            }//        }            public void savePrefs() {            Preferences prefs = OnlineCodex.getInstance().getPrefs();                        prefs.putBoolean(PREFERENCES_ENABLE_APOCALYPSE, isApo());            prefs.putBoolean(PREFERENCES_SHOW_PICTURES, isBildaz());            prefs.putBoolean(PREFERENCES_SCROLL_VERTICAL, isVertikalScrolling());            prefs.putInt(PREFERENCES_MOUSE_WHEEL_SPEED, getMausradSpeed());            prefs.putInt(PREFERENCES_ARROW_KEYS_SPEED, getPfeiltastenSpeed());        }            public void loadPrefs() {            Preferences prefs = OnlineCodex.getInstance().getPrefs();            //            apo.setSelected(prefs.getBoolean(PREFERENCES_ENABLE_APOCALYPSE, isApo()));            bildaz.setSelected(prefs.getBoolean(PREFERENCES_SHOW_PICTURES, isBildaz()));            vertikalScrollen.setSelected(prefs.getBoolean(PREFERENCES_SCROLL_VERTICAL, isVertikalScrolling()));            tMausradSpeed.setText(Integer.toString(prefs.getInt(PREFERENCES_MOUSE_WHEEL_SPEED, getMausradSpeed())));            tPfeiltastenSpeed.setText(Integer.toString(prefs.getInt(PREFERENCES_ARROW_KEYS_SPEED, getPfeiltastenSpeed())));        }}