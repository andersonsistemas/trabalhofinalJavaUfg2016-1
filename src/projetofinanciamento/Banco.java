/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinanciamento;

import java.io.Serializable;

/**
 *
 * @author GeekBox
 */
public class Banco implements Serializable{
    private int codigo;
    private String nome;

    
    @Override
    public String toString() {
        return this.nome;
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
}
