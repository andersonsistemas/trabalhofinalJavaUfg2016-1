
package projetofinanciamento;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.peer.ListPeer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;


public class CadastroFinanciamento extends javax.swing.JFrame {

    
    protected  static  ArrayList<Banco> listaBanco;
    protected  static  ArrayList<Pessoa> listaPessoa;
    protected  static  ArrayList<Financiamento> listaFinanciamento;
   
    
    public CadastroFinanciamento() {
               initComponents();
               timer.start();
               
           }
    
    Timer timer = new Timer(1000, new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        listaPessoa=lerPessoas();
        listaBanco=lerBancos();
        listaFinanciamento=lerFinanciamentos();
        preencheComboBancos();
        preencheComboPessoas();
       // JOptionPane.showMessageDialog(null, "Lido "+listaPessoa.size()+" Pessoas "+listaBanco.size()+" Bancos "+listaFinanciamento.size()+ " Financiamentos.");
       timer.stop();
      }
    });
   
    public void janelaNovoBanco(){   
                CadastroBanco janelabanco = CadastroBanco.getInstancia();
                janelabanco.setVisible(true);
                janelabanco.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                
                
           
     }
    
    
   public void janelaNovaPessoa(){
        
                CadastroPessoa janelapessoa = CadastroPessoa.getInstancia();
                janelapessoa.setVisible(true);
                janelapessoa.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                
                
   }
   
   public void gravarPessoas(ArrayList pessoas)throws IOException{
       
        try{
				
		FileOutputStream fout = new FileOutputStream("//home//anderson//Pessoas.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fout);   
		oos.writeObject(pessoas);
		oos.close();
		System.out.println("Gravado\n\n"+pessoas.size()+" Pessoas\n");
	   }catch(Exception ex){
		   ex.printStackTrace();
	   } 
	}
    public void gravarFinanciamentos(ArrayList financiamento)throws IOException{
       
        try{
				
		FileOutputStream fout = new FileOutputStream("//home//anderson//Financiamentos.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fout);   
		oos.writeObject(financiamento);
		oos.close();
		System.out.println(financiamento.size()+" Financiamentos\n");
	   }catch(Exception ex){
		   ex.printStackTrace();
	   } 
	}
    public void gravarBancos(ArrayList bancos) throws IOException{
       
        try{
				
		FileOutputStream fout = new FileOutputStream("//home//anderson//Bancos.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fout);   
		oos.writeObject(bancos);
		oos.close();
		System.out.println(bancos.size()+" Bancos\n");
	   }catch(Exception ex){
		   ex.printStackTrace();
	   } 
	}
    
   public ArrayList<Pessoa> lerPessoas(){
        try{
		   FileInputStream fin = new FileInputStream("//home//anderson//Pessoas.ser"); 
		   ObjectInputStream ois = new ObjectInputStream(fin);
                  ArrayList<Pessoa> listP = (ArrayList<Pessoa>) ois.readObject();
                ois.close();
                fin.close();
                return listP;
         } catch (Exception e) {
            e.printStackTrace();
         }
        return new ArrayList<Pessoa>();
    }
public ArrayList<Banco> lerBancos(){
        try{
		   FileInputStream fin = new FileInputStream("//home//anderson//Bancos.ser"); 
		   ObjectInputStream ois = new ObjectInputStream(fin);
                     ArrayList<Banco> listB = (ArrayList<Banco>) ois.readObject();
                ois.close();
                fin.close();
                return listB;
         } catch (Exception e) {
            e.printStackTrace();
         }
        return new ArrayList<Banco>();
   }
       
       public ArrayList<Financiamento> lerFinanciamentos(){
        try{
		   FileInputStream fin = new FileInputStream("//home//anderson//Financiamentos.ser"); 
		   ObjectInputStream ois = new ObjectInputStream(fin);
		   
                ArrayList<Financiamento> listF = (ArrayList<Financiamento>) ois.readObject();
                ois.close();
                fin.close();
                return listF;
         } catch (Exception e) {
            e.printStackTrace();
         }
        return new ArrayList<Financiamento>();
   }
   
   public int SistemaFinanciamento(){
     return jComboBoxSistemas.getSelectedIndex();
 }
   
   public JTable ListaDeFinanciamentos(){
        Object [] colunas = {"Nome", "CPF", "Telefone","Banco", "Valor do Emprestimo","Parcelas","Taxa"};
        Object[][] valores = new Object[listaFinanciamento.size()][7];
        for (int i = 0; i < listaFinanciamento.size(); i++) {
            valores[i][0] = listaFinanciamento.get(i).getPessoa().getNome();
            valores[i][1] = listaFinanciamento.get(i).getPessoa().getCpf();
            valores[i][2] = listaFinanciamento.get(i).getPessoa().getTelefone();
            valores[i][3] = listaFinanciamento.get(i).getBanco().getNome();
            valores[i][4] = listaFinanciamento.get(i).getValorfinanciado();
            valores[i][5] = listaFinanciamento.get(i).getParc();
            valores[i][6] = listaFinanciamento.get(i).getTaxa()+" %";
        }
        JTable tabelaFinanciamentos = new JTable(valores, colunas);
        return tabelaFinanciamentos;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBoxPessoa = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxBanco = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldValorFinanciado = new javax.swing.JTextField();
        jTextFieldParcelas = new javax.swing.JTextField();
        jTextFieldTaxa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxSistemas = new javax.swing.JComboBox<>();
        jButtonNovoBanco = new javax.swing.JButton();
        jButtonNovoBanco1 = new javax.swing.JButton();
        jButtonExcluirBanco = new javax.swing.JButton();
        jButtonExcluirPessoa = new javax.swing.JButton();
        jButtonBancoAlterar = new javax.swing.JButton();
        jButtonPessoaAlterar = new javax.swing.JButton();
        jButtonGravaFinanciamento = new javax.swing.JButton();
        jButton1FinanciamentoExibir1 = new javax.swing.JButton();
        jButtonGravaArquivo = new javax.swing.JButton();
        jButtonLoadFile = new javax.swing.JButton();
        jButtonListarTodosFinanciamentos = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulador de Financiamento");

        jComboBoxPessoa.setToolTipText("Selecione uma Pessoa");

        jLabel1.setText("Pessoa:");

        jLabel2.setText("Banco:");

        jComboBoxBanco.setToolTipText("Selecione um Banco");

        jLabel3.setText("Dados do Financiamento");

        jLabel4.setText("Valor Financiado:");

        jLabel5.setText("Parcelas:");

        jLabel6.setText("Taxa de juros:  % ");

        jComboBoxSistemas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sistema Price", "Sistema Sac" }));

        jButtonNovoBanco.setText("Novo");
        jButtonNovoBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoBancoActionPerformed(evt);
            }
        });

        jButtonNovoBanco1.setText("Novo");
        jButtonNovoBanco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoBanco1ActionPerformed(evt);
            }
        });

        jButtonExcluirBanco.setText("Excluir");
        jButtonExcluirBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirBancoActionPerformed(evt);
            }
        });

        jButtonExcluirPessoa.setText("Excluir");
        jButtonExcluirPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirPessoaActionPerformed(evt);
            }
        });

        jButtonBancoAlterar.setText("Alterar");
        jButtonBancoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBancoAlterarActionPerformed(evt);
            }
        });

        jButtonPessoaAlterar.setText("Alterar");
        jButtonPessoaAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPessoaAlterarActionPerformed(evt);
            }
        });

        jButtonGravaFinanciamento.setText("Gravar");
        jButtonGravaFinanciamento.setToolTipText("Gravação do Financiamento");
        jButtonGravaFinanciamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravaFinanciamentoActionPerformed(evt);
            }
        });

        jButton1FinanciamentoExibir1.setText("Simulação");
        jButton1FinanciamentoExibir1.setToolTipText("Tabela de Simulação");
        jButton1FinanciamentoExibir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1FinanciamentoExibir1ActionPerformed(evt);
            }
        });

        jButtonGravaArquivo.setText("Gravar Arquivo");
        jButtonGravaArquivo.setToolTipText("Grava Todos os Dados no Arquivo");
        jButtonGravaArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravaArquivoActionPerformed(evt);
            }
        });

        jButtonLoadFile.setText("Carregar Arquivo");
        jButtonLoadFile.setToolTipText("Carregar Todos os Dados do Arquivo");
        jButtonLoadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadFileActionPerformed(evt);
            }
        });

        jButtonListarTodosFinanciamentos.setText("Listar Financiamentos");
        jButtonListarTodosFinanciamentos.setToolTipText("Lista de Todos Financiamentos");
        jButtonListarTodosFinanciamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarTodosFinanciamentosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxBanco, 0, 224, Short.MAX_VALUE)
                            .addComponent(jComboBoxPessoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonNovoBanco1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPessoaAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonExcluirPessoa))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonNovoBanco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonBancoAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonExcluirBanco))))
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButtonLoadFile, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonGravaArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jButtonListarTodosFinanciamentos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1FinanciamentoExibir1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGravaFinanciamento, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldValorFinanciado, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxSistemas, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxSistemas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldValorFinanciado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGravaFinanciamento, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1FinanciamentoExibir1))
                .addGap(0, 39, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonNovoBanco)
                            .addComponent(jButtonExcluirBanco)
                            .addComponent(jButtonBancoAlterar))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBoxBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNovoBanco1)
                    .addComponent(jButtonPessoaAlterar)
                    .addComponent(jButtonExcluirPessoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLoadFile, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGravaArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonListarTodosFinanciamentos)
                .addGap(63, 63, 63))
        );

        jLabel7.setText("Simulador de Financiamento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoBancoActionPerformed
        janelaNovoBanco();
    }//GEN-LAST:event_jButtonNovoBancoActionPerformed

    private void jButtonNovoBanco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoBanco1ActionPerformed
        janelaNovaPessoa();
    }//GEN-LAST:event_jButtonNovoBanco1ActionPerformed

    private void jButtonExcluirBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirBancoActionPerformed
        listaBanco.remove(jComboBoxBanco.getSelectedIndex());
        preencheComboBancos();
    }//GEN-LAST:event_jButtonExcluirBancoActionPerformed

    private void jButtonBancoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBancoAlterarActionPerformed
        janelaNovoBanco();
        
    }//GEN-LAST:event_jButtonBancoAlterarActionPerformed

    private void jButtonPessoaAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPessoaAlterarActionPerformed
        janelaNovaPessoa();
    }//GEN-LAST:event_jButtonPessoaAlterarActionPerformed

    private void jButtonExcluirPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirPessoaActionPerformed
        listaPessoa.remove(jComboBoxPessoa.getSelectedIndex());
       preencheComboPessoas();
    }//GEN-LAST:event_jButtonExcluirPessoaActionPerformed

    private void jButtonGravaFinanciamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravaFinanciamentoActionPerformed
        if (!jTextFieldParcelas.getText().isEmpty()&&!jTextFieldValorFinanciado.getText().isEmpty()&&!jTextFieldTaxa.getText().isEmpty()){
        Financiamento fn = new Financiamento();
        fn.setBanco((Banco)listaBanco.get(jComboBoxBanco.getSelectedIndex()));
        fn.setPessoa((Pessoa)listaPessoa.get(jComboBoxPessoa.getSelectedIndex()));
        fn.setAtual(1);
        fn.setParc(Integer.parseInt(jTextFieldParcelas.getText()));
        fn.setValorfinanciado(Double.parseDouble(jTextFieldValorFinanciado.getText()));
        fn.setTaxa(Double.parseDouble(jTextFieldTaxa.getText()));
        listaFinanciamento.add(fn);
        }
        else
                JOptionPane.showMessageDialog(null, "Preencha todos os Dados Corretamente!");
       
        
        
    }//GEN-LAST:event_jButtonGravaFinanciamentoActionPerformed

    private void jButtonGravaArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravaArquivoActionPerformed
            try {
            gravarPessoas(listaPessoa);
            gravarBancos(listaBanco);
            gravarFinanciamentos(listaFinanciamento);
        } catch (IOException ex) {
            Logger.getLogger(CadastroFinanciamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButtonGravaArquivoActionPerformed

    private void jButtonListarTodosFinanciamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarTodosFinanciamentosActionPerformed
        ListaFinanciamentos lf = new ListaFinanciamentos();
        lf.criaJanela(ListaDeFinanciamentos());
    }//GEN-LAST:event_jButtonListarTodosFinanciamentosActionPerformed

    private void jButtonLoadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadFileActionPerformed
       listaPessoa=lerPessoas();
        listaBanco=lerBancos();
        listaFinanciamento=lerFinanciamentos();
        preencheComboBancos();
        preencheComboPessoas();
        JOptionPane.showMessageDialog(null, "Lido "+listaPessoa.size()+" Pessoas "+listaBanco.size()+" Bancos "+listaFinanciamento.size()+ " Financiamentos.");
    }//GEN-LAST:event_jButtonLoadFileActionPerformed

    private void jButton1FinanciamentoExibir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1FinanciamentoExibir1ActionPerformed
        if(!jTextFieldValorFinanciado.getText().isEmpty() && !jTextFieldParcelas.getText().isEmpty()&&!jTextFieldTaxa.getText().isEmpty()){
         Financiamento f = new Financiamento();
         f.setTaxa(Double.parseDouble(jTextFieldTaxa.getText()));
         f.setParc(Integer.parseInt(jTextFieldParcelas.getText()));
         f.setValorfinanciado(Double.parseDouble(jTextFieldValorFinanciado.getText()));
         f.setAtual(1);
         TabelaFinanciamento tf = new TabelaFinanciamento();
         if(jComboBoxSistemas.getSelectedIndex()==0)
         tf.criaJanela(f.TabelaPrice(f.getValorfinanciado(), f.getParc(), f.getAtual(), f.getTaxa()/100));
         else
         tf.criaJanela(f.TabelaSAC(f.getValorfinanciado(), f.getParc(), f.getAtual(), f.getTaxa()/100));  
        }
        else
        JOptionPane.showMessageDialog(null,"Existe Algum Campo Sem Preenchimento!");
    }//GEN-LAST:event_jButton1FinanciamentoExibir1ActionPerformed
    public void adicionaPessoas(Pessoa p){
        listaPessoa.add(p);
    }
    public void adicionaBancos(Banco b){
        listaBanco.add(b);
    }
    public void preencheComboPessoas() {        
	String[] nomesPessoas = new String[listaPessoa.size()];
	for(int i =0 ; i<listaPessoa.size();i++){
	nomesPessoas[i]=listaPessoa.get(i).toString();
        }
        jComboBoxPessoa.removeAllItems();
        for(int j=0; j<nomesPessoas.length;j++)
            jComboBoxPessoa.addItem(nomesPessoas[j]);   
        jComboBoxPessoa.updateUI();
}
    public void preencheComboBancos() {        
	String[] nomesBancos = new String[listaBanco.size()];
	for(int i =0 ; i<listaBanco.size();i++){
	nomesBancos[i]=listaBanco.get(i).toString();
        }
        jComboBoxBanco.removeAllItems();
        for(int j=0; j<nomesBancos.length;j++)
            jComboBoxBanco.addItem(nomesBancos[j]);
        jComboBoxBanco.updateUI();
    }
    public static void main(String args[]) {
       
        Banco b = new Banco();
        Pessoa p = new Pessoa();
        Financiamento f = new Financiamento();
        ArrayList<Banco> listab=new ArrayList<Banco>();
        ArrayList<Pessoa> listap=new ArrayList<Pessoa>();
        ArrayList<Financiamento> listaf=new ArrayList<Financiamento>();
              
       listaBanco=listab;
       listaPessoa=listap;
       listaFinanciamento=listaf;
       
        
        
        
            
        
        
      
      
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroFinanciamento().setVisible(true);
                
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1FinanciamentoExibir1;
    private javax.swing.JButton jButtonBancoAlterar;
    private javax.swing.JButton jButtonExcluirBanco;
    private javax.swing.JButton jButtonExcluirPessoa;
    private javax.swing.JButton jButtonGravaArquivo;
    private javax.swing.JButton jButtonGravaFinanciamento;
    private javax.swing.JButton jButtonListarTodosFinanciamentos;
    private javax.swing.JButton jButtonLoadFile;
    private javax.swing.JButton jButtonNovoBanco;
    private javax.swing.JButton jButtonNovoBanco1;
    private javax.swing.JButton jButtonPessoaAlterar;
    protected javax.swing.JComboBox<String> jComboBoxBanco;
    protected javax.swing.JComboBox<String> jComboBoxPessoa;
    private javax.swing.JComboBox<String> jComboBoxSistemas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldParcelas;
    private javax.swing.JTextField jTextFieldTaxa;
    private javax.swing.JTextField jTextFieldValorFinanciado;
    // End of variables declaration//GEN-END:variables
}
