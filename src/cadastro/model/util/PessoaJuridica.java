/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.util;

import cadastro.model.util.Pessoa;

/**
 *
 * @author Temis
 */
public class PessoaJuridica extends Pessoa {
    private String cnpj;

    public PessoaJuridica(String cnpj, int id, String nome, String logradouro, String cidade, String estado, String telefone, String email) {
        super(id, nome, logradouro, cidade, estado, telefone, email);
        this.cnpj = cnpj;
    }

    public PessoaJuridica(Object object, String nome, String logradouro, String cidade, String estado, String telefone, String email, String cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String exibir() {
        return super.exibir() + "CNPJ: " + cnpj + "\n";
    }

    // Getters e Setters
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
}
