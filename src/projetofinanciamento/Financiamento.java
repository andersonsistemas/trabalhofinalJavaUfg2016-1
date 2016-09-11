
package projetofinanciamento;

import java.io.Serializable;
import javax.swing.JTable;

/**
 *
 * @author GeekBox
 */
public class Financiamento implements InterfaceCalculo,Serializable{
    private Banco banco;
    private Pessoa pessoa;
    private double valorfinanciado,taxa;
    private int parc, atual;
    

   

    @Override
    public double JurosSac(double valorfinanciado,int parc, int atual, double taxa) {
        return (valorfinanciado-(AmortizaçãoSac(valorfinanciado, parc)*atual))*taxa;
    }

    @Override
    public double AmortizaçãoSac(double valorfinanciado,int parc) {
     return valorfinanciado/parc;
    }
 @Override
    public double PrestacaoSac(double valorfinanciado,int parc,int atual, double taxa) {
        return AmortizaçãoSac(valorfinanciado, parc)+JurosSac(valorfinanciado, parc, atual, taxa);
    }
    @Override
    public double PrestacaoPrice(double valorfinanciado,int parcelas, int atual, double taxa) {
      double prestacao;
      prestacao= valorfinanciado*(taxa*Math.pow(1+taxa, parcelas))/(Math.pow(1+taxa, parcelas)-1);
      return prestacao;
    }

    @Override
    public double JurosPrice(double valorfinanciado,int parcelas, int atual, double taxa) {
      return PrestacaoPrice(valorfinanciado, parcelas, atual, taxa)*(1-(Math.pow(1+taxa, (atual-parcelas-1))));
    }

    @Override
    public double AmortizaçãoPrice(double valorfinanciado,int parcelas, int atual, double taxa) {
        return PrestacaoPrice(valorfinanciado, parcelas, atual, taxa)-JurosPrice(valorfinanciado, parcelas, atual, taxa);
        
    }
    public JTable TabelaPrice(double valorfinanciado,int parcelas, int atual, double taxa){
        Object [] colunas = {"t", "Juros", "Amortização","Prestação", "Saldo Devedor"};
        Object[][] valores = new Object[parcelas+1][5];
        double saldodevedor=valorfinanciado;
        Financiamento c = new Financiamento();
        for (int i = 0; i <= parcelas; i++) {
        if(i==0)
            {
            valores[i][0] = "    -    ";
            valores[i][1] = "    -    ";
            valores[i][2] = "    -    ";
            valores[i][3] = "    -    ";
            valores[i][4] = saldodevedor;
            }
        else
            {
            valores[i][0] = i;
            valores[i][1] = String.format("%.2f",c.JurosPrice(valorfinanciado, parcelas, i, taxa));
            valores[i][2] =String.format("%.2f",c.AmortizaçãoPrice(valorfinanciado, parcelas, i, taxa));
            valores[i][3] = String.format("%.2f", c.PrestacaoPrice(valorfinanciado, parcelas, i, taxa));
            if(saldodevedor-c.AmortizaçãoPrice(valorfinanciado, parcelas, i, taxa)<0)
                valores[i][4] =0;
            else
            valores[i][4] = String.format("%.2f",saldodevedor-c.AmortizaçãoPrice(valorfinanciado, parcelas, i, taxa));
                saldodevedor = saldodevedor-c.AmortizaçãoPrice(valorfinanciado, parcelas, i, taxa);
            }
        }
      
        
        JTable tabelaPrice = new JTable(valores, colunas);
        return tabelaPrice;
    }
    
    public JTable TabelaSAC(double valorfinanciado,int parcelas, int atual, double taxa){
        Object [] colunas = {"t", "Juros", "Amortização","Prestação", "Saldo Devedor"};
        Object[][] valores = new Object[parcelas+1][5];
        double saldodevedor=valorfinanciado;
        Financiamento c = new Financiamento();
        for (int i = 0; i <= parcelas; i++) {
        if(i==0)
            {
            valores[i][0] = "   -   ";
            valores[i][1] = "   -   ";
            valores[i][2] = "   -   ";
            valores[i][3] = "   -   ";
            valores[i][4] = saldodevedor;
            }
        else
            {
            valores[i][0] = i;
            valores[i][1] =String.format("%.2f",c.JurosSac(valorfinanciado, parcelas, i, taxa));
            valores[i][2] =String.format("%.2f",c.AmortizaçãoSac(valorfinanciado, parcelas));
            valores[i][3] =String.format("%.2f",c.AmortizaçãoSac(valorfinanciado, parcelas)+c.JurosSac(valorfinanciado, parcelas, i, taxa));
            valores[i][4] =String.format("%.2f", (parcelas-i)*c.AmortizaçãoSac(valorfinanciado, parcelas));
            }
        }      
        JTable tabelaSac = new JTable(valores, colunas);
        return tabelaSac;
    }
    
    
    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public double getValorfinanciado() {
        return valorfinanciado;
    }

    public void setValorfinanciado(double valorfinanciado) {
        this.valorfinanciado = valorfinanciado;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public int getParc() {
        return parc;
    }

    public void setParc(int parc) {
        this.parc = parc;
    }

    public int getAtual() {
        return atual;
    }

    public void setAtual(int atual) {
        this.atual = atual;
    }


}
