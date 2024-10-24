/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastrobd;


import cadastro.model.util.PessoaFisica;
import cadastro.model.util.PessoaFisicaDAO;
import cadastro.model.util.PessoaJuridica;
import cadastro.model.util.PessoaJuridicaDAO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.SQLException;
/**1
 *
 * @author Temis
 */
public class CadastroBD {
    private static final PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
    private static final PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
    private static final BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception{
        CadastroBD cadastroBD = new CadastroBD();
        while(true){
            System.out.println("1-Incluir\n2-Alterar\n3-Excluir\n4-Obter\n5-Obter Todos\n0-Sair");
            int opcao = Integer.parseInt(entrada.readLine());
            if(opcao == 0)
                break;
            switch(opcao){
                case 1:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipoPessoaI = entrada.readLine();
                    if(tipoPessoaI.equals("F")){
                        System.out.println("Insira os dados...");
                        try{
                            System.out.print("Nome: ");
                            String nome = entrada.readLine();

                            System.out.print("CPF: ");
                            String cpf = entrada.readLine();

                            System.out.print("Logradouro: ");
                            String logradouro = entrada.readLine();

                            System.out.print("Cidade: ");
                            String cidade = entrada.readLine();

                            System.out.print("Estado: ");
                            String estado = entrada.readLine();

                            System.out.print("Telefone: ");
                            String telefone = entrada.readLine();

                            System.out.print("Email: ");
                            String email = entrada.readLine();

                            PessoaFisica novaPessoaFisica = new PessoaFisica(null, nome, logradouro, cidade, estado, telefone, email, cpf);
                            pessoaFisicaDAO.incluir(novaPessoaFisica);
                        }catch(Exception e){System.err.println(e);}
                    }else if(tipoPessoaI.equals("J")){
                        System.out.println("Insira os dados...");
                        try{
                            System.out.print("Nome: ");
                            String nome = entrada.readLine();

                            System.out.print("CNPJ: ");
                            String cnpj = entrada.readLine();

                            System.out.print("Logradouro: ");
                            String logradouro = entrada.readLine();

                            System.out.print("Cidade: ");
                            String cidade = entrada.readLine();

                            System.out.print("Estado: ");
                            String estado = entrada.readLine();

                            System.out.print("Telefone: ");
                            String telefone = entrada.readLine();

                            System.out.print("Email: ");
                            String email = entrada.readLine();

                            PessoaJuridica novaPessoaJuridica = new PessoaJuridica(null, nome, logradouro, cidade, estado, telefone, email, cnpj);
                            pessoaJuridicaDAO.incluir(novaPessoaJuridica);
                        }catch(Exception e){System.err.println(e);}
                    }
                    System.out.println("Dados adicionados...");
                    break;
                    
                case 2:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipoPessoaA = entrada.readLine();
                    if(tipoPessoaA.equals("F")){
                        System.out.println("Insira o id: ");
                        int pessoaId = Integer.parseInt(entrada.readLine());
                        try{
                            pessoaFisicaDAO.getPessoa(pessoaId).exibir();
                            System.out.println("======================");

                            System.out.println("Insira os dados...");

                            System.out.print("Nome: ");
                            String nome = entrada.readLine();

                            System.out.print("CPF: ");
                            String cpf = entrada.readLine();

                            System.out.print("Logradouro: ");
                            String logradouro = entrada.readLine();

                            System.out.print("Cidade: ");
                            String cidade = entrada.readLine();

                            System.out.print("Estado: ");
                            String estado = entrada.readLine();

                            System.out.print("Telefone: ");
                            String telefone = entrada.readLine();

                            System.out.print("Email: ");
                            String email = entrada.readLine();

                            PessoaFisica novaPessoaFisica = new PessoaFisica(pessoaId, nome, logradouro, cidade, estado, telefone, email, cpf);
                            pessoaFisicaDAO.alterar(novaPessoaFisica);
                        }catch(Exception e){System.err.println(e);}
                    }
                    else if(tipoPessoaA.equals("J")){
                        System.out.println("Insira o id: ");
                        int pessoaId = Integer.parseInt(entrada.readLine());
                        try{
                            pessoaJuridicaDAO.getPessoa(pessoaId).exibir();
                            System.out.println("======================");

                            System.out.println("Insira os dados...");

                            System.out.print("Nome: ");
                            String nome = entrada.readLine();

                            System.out.print("CNPJ: ");
                            String cnpj = entrada.readLine();

                            System.out.print("Logradouro: ");
                            String logradouro = entrada.readLine();

                            System.out.print("Cidade: ");
                            String cidade = entrada.readLine();

                            System.out.print("Estado: ");
                            String estado = entrada.readLine();

                            System.out.print("Telefone: ");
                            String telefone = entrada.readLine();

                            System.out.print("Email: ");
                            String email = entrada.readLine();

                            PessoaJuridica novaPessoaJuridica = new PessoaJuridica(pessoaId, nome, logradouro, cidade, estado, telefone, email, cnpj);
                            pessoaJuridicaDAO.alterar(novaPessoaJuridica);
                        }catch(Exception e){System.err.println(e);}
                    }
                    System.out.println("Dados alterados...");
                    break;
                    
                case 3:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipoPessoaEX = entrada.readLine();
                    if(tipoPessoaEX.equals("F")){
                        System.out.println("Insira o id: ");
                        int pessoaId = Integer.parseInt(entrada.readLine());
                        try{
                            pessoaFisicaDAO.excluir(pessoaId);
                        }catch(Exception e){System.err.println(e);}
                    }else if(tipoPessoaEX.equals("J")){
                        System.out.println("Insira o id: ");
                        int pessoaId = Integer.parseInt(entrada.readLine());
                        try{
                            pessoaJuridicaDAO.excluir(pessoaId);
                        }catch(Exception e){System.err.println(e);}
                    }
                    System.out.println("Pessoa removida...");
                    break;
                    
                case 4:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipoPessoaO = entrada.readLine();
                    if(tipoPessoaO.equals("F")){
                        System.out.println("Insira o id: ");
                        int pessoaId = Integer.parseInt(entrada.readLine());
                        try{
                            pessoaFisicaDAO.getPessoa(pessoaId).exibir();
                        }catch(Exception e){System.err.println(e);}
                    }else if(tipoPessoaO.equals("J")){
                        System.out.println("Insira o id: ");
                        int pessoaId = Integer.parseInt(entrada.readLine());
                        try{
                            pessoaJuridicaDAO.getPessoa(pessoaId).exibir();
                        }catch(Exception e){System.err.println(e);}
                    }
                    break;
                case 5:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipoPessoaOT = entrada.readLine();
                    if(tipoPessoaOT.equals("F")){
                        try{
                            pessoaFisicaDAO.getPessoas().forEach(pessoa -> pessoa.exibir());
                        }catch(Exception e){System.err.println(e);}
                    }else if(tipoPessoaOT.equals("J")){
                        try{
                            pessoaJuridicaDAO.getPessoas().forEach(pessoa -> pessoa.exibir());;
                        }catch(Exception e){System.err.println(e);}
                    }
                    break;
                    
                case 0:
                    System.out.println("Finalizando a execução...");
                    entrada.close();
                    return;
                
                default:
                    System.out.println("Escolha uma opção entre 0 a 5.");
                    break;
            }
        }
    } 
}
