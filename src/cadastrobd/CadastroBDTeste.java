/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastrobd;

import cadastro.model.util.ConectorBD;
import cadastro.model.util.PessoaFisica;
import cadastro.model.util.PessoaFisicaDAO;
import cadastro.model.util.PessoaJuridica;
import cadastro.model.util.PessoaJuridicaDAO;

/**
 *
 * @author Temis
 */
public class CadastroBDTeste {

     private final PessoaFisicaDAO pessoafisicaDAO;
    private final PessoaJuridicaDAO pessoajuridicaDAO;
    
    public CadastroBDTeste() {
        pessoafisicaDAO = new PessoaFisicaDAO();
        pessoajuridicaDAO = new PessoaJuridicaDAO();
    }
    
    private void run(){
        PessoaFisica pf = new PessoaFisica("1", "Ferdinando", "japiim", "manaus", "AM", "1111111111", "Ferdinando@gmail.com", "1593574862475319");
        try{
            pessoafisicaDAO.incluir(pf);
            System.out.println("============================");
            System.out.println("Pessoa Fisica id: " + pf.getId() + " adicionada com sucesso.");
            System.out.println("============================");
            pf.exibir();
            
            
            System.out.println("============================");
            pf.setCidade("Manaus");
            pf.setLogradouro("Rua 21, Japiim");
            pessoafisicaDAO.alterar(pf);
            System.out.println("Pessoa Fisica id: " + pf.getId() + " dados alterados com sucesso.");
            System.out.println("============================");
            pf.exibir();
            
            System.out.println("============================");
            System.out.println("Exibir Pessoas Fisicas.");
            System.out.println("============================");
            pessoafisicaDAO.getPessoas().forEach(pessoaF -> pessoaF.exibir());
            System.out.println("============================");
            pessoafisicaDAO.excluir(pf.getId());
            System.out.println("Pessoa Fisica id: " + pf.getId() + " excluida.");
        }catch(Exception e){
            System.err.println("F: " + e);
        }
        PessoaJuridica pj;
         pj = new PessoaJuridica("1", "Cagepa", "mangabeira", "João pessoa", "PB", "14725836", "Cagepa@gmail.com", "14715935789514");
        try{
            pessoajuridicaDAO.incluir(pj);
            System.out.println("============================");
            System.out.println("Pessoa Juridica id: " + pj.getId() + " adicionada com sucesso.");
            System.out.println("============================");
            pj.exibir();
            System.out.println("============================");
            pj.setCidade("João pessoa");
            pj.setLogradouro("Mangabeira");
            pessoajuridicaDAO.alterar(pj);
            System.out.println("Pessoa Juridica id: " + pj.getId() + " Dados alterados com sucesso.");
            System.out.println("============================");
            pj.exibir();
            System.out.println("============================");
            pessoajuridicaDAO.getPessoas().forEach(pessoaJ -> pessoaJ.exibir());
            System.out.println("============================");
            pessoajuridicaDAO.excluir(pj.getId());
            System.out.println("Pessoa Juridica id: " + pj.getId() + " excluida.");
        }catch(Exception e){
            System.err.println("J: " + e);
        }
    }
    
    public static void main(String[] args) throws SQLException, Exception{
        new CadastroBDTeste().run();
    }

    private static class SQLException extends Exception {

        public SQLException() {
        }
    }
}
