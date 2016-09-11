
package projetofinanciamento;


import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class ListaFinanciamentos extends  JFrame{
    
    JPanel painelFundo;
    JTable tabela;
    JScrollPane barraRolagem;

    public ListaFinanciamentos() throws HeadlessException {
    }
  
    public void criaJanela(JTable TABLE){
        
        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(1, 1));
        barraRolagem = new JScrollPane(TABLE);
        painelFundo.add(barraRolagem); 
        getContentPane().add(painelFundo);
        setSize(800, 400);
        setVisible(true);
        setTitle("Lista de Financiamentos");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
    
   

}
