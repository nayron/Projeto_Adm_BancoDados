package nayron.UFT.controleprodutos.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.jvnet.substance.SubstanceLegacyDefaultLookAndFeel;
import org.jvnet.substance.skin.SubstanceRavenLookAndFeel;

import nayron.UFT.controleprodutos.components.LabelImage;
import org.jvnet.substance.skin.SubstanceEmeraldDuskLookAndFeel;
import org.jvnet.substance.skin.SubstanceMagmaLookAndFeel;
import org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel;
import org.jvnet.substance.skin.SubstanceOfficeSilver2007LookAndFeel;

public class PrincipalFrame extends JFrame{
	
	private static final long serialVersionUID = 2702265523125343626L;
	
	private static PrincipalFrame _instance;
	private static JPanel _jPanelMain;	
	private static GeneralMenuBar _generalMenuBar;
	private static GeneralToolBar _generalToolBar;
	
	
	public PrincipalFrame(){
		super("Controle de Estoque");
		setContentPane(getJPanelMain());
		setJMenuBar(getGeneralMenuBar());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);			
		setMinimumSize(new Dimension(800,600));
		LabelImage labelImage = new LabelImage("/images/Controle22.png");
		setView(labelImage);
		//labelImage.updateUI();
		setVisible(true);
		setLookAndFeel("OfficeBlue2007");
	}
	
	public static JFrame getInstance(){
		if(_instance == null){
			_instance = new PrincipalFrame();
		}
		return _instance;
	}
	
	private static JPanel getJPanelMain(){
		if(_jPanelMain == null){
			_jPanelMain = new JPanel();
			_jPanelMain.setLayout(new BorderLayout());
			_jPanelMain.add(getGeneralToolBar(), BorderLayout.SOUTH);
		}
		return _jPanelMain;
	}
	
	public static void setView(JPanel pane){
		getJPanelMain().removeAll();
		getJPanelMain().add(pane,BorderLayout.CENTER);
		getJPanelMain().add(getGeneralToolBar(), BorderLayout.SOUTH);
		getJPanelMain().updateUI();
	}
	
	private static GeneralToolBar getGeneralToolBar(){
		if(_generalToolBar == null){
			_generalToolBar = new GeneralToolBar();
		}
		return _generalToolBar;
	}
	
	private static GeneralMenuBar getGeneralMenuBar(){
		if(_generalMenuBar == null){
			_generalMenuBar = new GeneralMenuBar();
		}
		return _generalMenuBar;
	}
	
	public static void setLookAndFeel(String lookAndFeel){				
		setDefaultLookAndFeelDecorated(true);
	    try {
	    	if (lookAndFeel.equals("Esmeralda")){
                        UIManager.setLookAndFeel(new SubstanceEmeraldDuskLookAndFeel());
			}else if (lookAndFeel.equals("OfficeBlue2007")){
                        UIManager.setLookAndFeel(new SubstanceOfficeBlue2007LookAndFeel());
			}else if (lookAndFeel.equals("Legacy")){
		    	UIManager.setLookAndFeel(new SubstanceLegacyDefaultLookAndFeel());				
			}else if (lookAndFeel.equals("OfficeSilver2007")){
	    		UIManager.setLookAndFeel(new SubstanceOfficeSilver2007LookAndFeel());
			}else if (lookAndFeel.equals("Magma")){
				UIManager.setLookAndFeel(new SubstanceMagmaLookAndFeel());
			}else if (lookAndFeel.equals("Raven")){
		    		UIManager.setLookAndFeel(new SubstanceRavenLookAndFeel());
			}
	    } catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, 
					"Substance LookAndFeel failed to initialize!", 
					"Erro!", JOptionPane.WARNING_MESSAGE);
	    }
	}
	
	public static void setViewToPrint(PrintableInterface printable){
		getGeneralMenuBar().setJTableToPrint(printable);
	}
	
	public static void removeItemPrint(){
		getGeneralMenuBar().removeItemPrint();
	}
	
}
 
