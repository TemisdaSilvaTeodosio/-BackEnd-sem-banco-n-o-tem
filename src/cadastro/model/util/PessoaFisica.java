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
public class PessoaFisica extends Pessoa{
    private String cpf;

    public PessoaFisica(String cpf, int id, String nome, String logradouro, String cidade, String estado, String telefone, String email) {
        super(id, nome, logradouro, cidade, estado, telefone, email);
        this.cpf = cpf;
    }

    public PessoaFisica(Object object, String nome, String logradouro, String cidade, String estado, String telefone, String email, String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String exibir() {
        return super.exibir() + "CPF: " + cpf + "\n";
    }

    // Getters e Setters
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

}
