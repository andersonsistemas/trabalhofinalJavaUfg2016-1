
package projetofinanciamento;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class TabelaFinanciamento extends  JFrame{
    
    JPanel painelFundo;
    JTable tabela;
    JScrollPane barraRolagem;

    public TabelaFinanciamento() throws HeadlessException {
    }
  
    public void criaJanela(JTable TABLE){
        
        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(1, 1));
       
        barraRolagem = new JScrollPane(TABLE);
        painelFundo.add(barraRolagem); 
        
        getContentPane().add(painelFundo);
        setSize(500, 300);
        setVisible(true);
        setTitle("Tabela de Financiamento");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
    
   

}
