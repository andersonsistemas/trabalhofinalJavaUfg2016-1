/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinanciamento;

import java.util.InputMismatchException;

/**
 *
 * @author anderson
 */
public class TratamentoDeExcecoes extends InputMismatchException{
    
    
    public TratamentoDeExcecoes(String Erro){
        super(Erro);
    }
}
