/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinanciamento;

/**
 *
 * @author GeekBox
 */
public interface InterfaceCalculo{
    
    public double PrestacaoSac(double valorfinanciado,int parcelas, int atual, double taxa);
    public double JurosSac(double valorfinanciado,int parcelas,int atual, double taxa);
    public double AmortizaçãoSac(double valorfinanciado,int parcelas);
    
    public double PrestacaoPrice(double valorfinanciado,int parcelas, int atual, double taxa);
    public double JurosPrice(double valorfinanciado,int parcelas, int atual, double taxa);
    public double AmortizaçãoPrice(double valorfinanciado,int parcelas, int atual, double taxa);
        
}
