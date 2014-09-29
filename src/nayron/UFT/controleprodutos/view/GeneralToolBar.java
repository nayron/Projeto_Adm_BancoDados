
package nayron.UFT.controleprodutos.view; 

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
  

public class GeneralToolBar extends JToolBar{
	
	private static final long serialVersionUID = -7029711809993519406L;	

	public GeneralToolBar(){
		super();
		setRollover(false);	
		setFloatable(false);
		setBackground(Color.LIGHT_GRAY);
		
		JButton jButtonCadastrar = new JButton("Cadastrar Item");
		jButtonCadastrar.setBackground(Color.LIGHT_GRAY);
		jButtonCadastrar.setForeground(Color.red);
		jButtonCadastrar.setIcon(new ImageIcon(getClass().getResource("/images/cadrastrar222.png")));
		jButtonCadastrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				viewCadastraItem();
			}			
		});
		
		JButton jButtonPesquisar = new JButton("Pesquisar Item");
		jButtonPesquisar.setBackground(Color.LIGHT_GRAY);
		jButtonPesquisar.setForeground(Color.red);
		jButtonPesquisar.setIcon(new ImageIcon(getClass().getResource("/images/pesquisar.png")));
		jButtonPesquisar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
                            try {
                                viewPesquisaItem();
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(GeneralToolBar.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}			
		});
		
		JButton jButtonEstoque = new JButton("Atualização de Estoque");
		jButtonEstoque.setBackground(Color.LIGHT_GRAY);
		jButtonEstoque.setForeground(Color.red);
		jButtonEstoque.setIcon(new ImageIcon(getClass().getResource("/images/estoque.png")));
		jButtonEstoque.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				viewEstoque();				
			}
			
		});
		
		JButton jButtonVendas = new JButton("Registrar Vendas");
		jButtonVendas.setBackground(Color.LIGHT_GRAY);
		jButtonVendas.setForeground(Color.red);
		jButtonVendas.setIcon(new ImageIcon(getClass().getResource("/images/vendas2.png")));
		jButtonVendas.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				 viewVendas(); 				
			}
			
		});
		
		JButton jButtonRelatorio = new JButton("Relatório das Vendas");
		jButtonRelatorio.setBackground(Color.LIGHT_GRAY);
		jButtonRelatorio.setForeground(Color.red);
		jButtonRelatorio.setIcon(new ImageIcon(getClass().getResource("/images/relatorio22.png")));
		jButtonRelatorio.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				 viewRelatorio(); 				
			}
			
		});
		
		JButton jButtonSair = new JButton("Sair");
		jButtonSair.setBackground(Color.LIGHT_GRAY);
		jButtonSair.setForeground(Color.red);
		jButtonSair.setIcon(new ImageIcon(getClass().getResource("/images/sair22.png")));
		jButtonSair.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				System.exit(0);					
			}
			
		});
		
		add(jButtonCadastrar);  		  		
  		add(jButtonPesquisar);		  		
  		add(jButtonEstoque); 
  		add(jButtonVendas);
  		add(jButtonRelatorio);
  		add(jButtonSair);
	}
	
	private void viewRelatorio() {
		PrincipalFrame.setView(new ReportPanel());
	}

	private void viewEstoque() {
		PrincipalFrame.setView(new StockPanel());		
	}

	private void viewVendas() {
		PrincipalFrame.setView(new SalesPanel());		
	}

	private void viewCadastraItem() {
		PrincipalFrame.setView(new AddItemPanel());		
	}
	
	private void viewPesquisaItem() throws ClassNotFoundException {
		PrincipalFrame.setView(new SearchPanel());		
	}
	

}
 
