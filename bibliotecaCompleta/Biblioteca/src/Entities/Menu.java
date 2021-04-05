
package Entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Menu {    
    private List<Livro> ListaLivros = new ArrayList<>();
    private List<Cliente> InfoCliente = new ArrayList<>();
    private int codigoLivro = 0;
    
    public void Start(){
        printMenu();
    }
    
    private void printMenu(){
        Scanner scan = new Scanner(System.in);        
        int telaSelecionada;
        
        System.out.println("+=======================================+");         
        System.out.println("|                  MENU                 |");         
        System.out.println("+=======================================+");         
        System.out.println("| 1. CADASTRAR LIVRO                    |");                 
        System.out.println("| 2. ALUGAR LIVRO                       |");                         
        System.out.println("| 3. DEVOLVER LIVRO                     |");                                 
        System.out.println("+=======================================+");  
        
        
        telaSelecionada = scan.nextInt();
        
        if(telaSelecionada == 1){
            printCadastrarLivro();
        }
        else if(telaSelecionada == 2){
            printLivrosCadastrados();
        } else if(telaSelecionada == 3){
            DevolveLivros();
        }else {
           printTelaNaoEncontrada();
        }
                
        
        printMenu();
        scan.close();
    }

    private void printCadastrarLivro(){        
        Scanner scan = new Scanner(System.in);        
        this.codigoLivro++;
                  
        System.out.println("+=======================================+");         
        System.out.println("|           CADASTRAR LIVRO             |");         
        System.out.println("+=======================================+");         
        
        //BUSCANDO OS VALORES DOS CAMPOS
        System.out.print("| NOME: ");                 
        String nome = scan.nextLine();
        System.out.print("| AUTOR: ");                         
        String autor = scan.nextLine();
        System.out.print("| GENERO: ");                 
        String genero = scan.nextLine();
        System.out.print("| DESCRIÇÃO: ");
        String descricao = scan.nextLine();
        System.out.print("| VALOR: ");                 
        double valor = scan.nextDouble();
        System.out.print("| QUANTIDADE: ");
        int quantidade = scan.nextInt();
        System.out.println("+=======================================+");         
        ListaLivros.add(new Livro(codigoLivro, nome, autor, genero, descricao, valor, quantidade));
        
    }    
    
    private void printTelaNaoEncontrada(){        
        System.out.println("+=======================================+");         
        System.out.println("|   ERRO!   TELA NÃO ENCONTRADA!        |");         
        System.out.println("+=======================================+");                 
    }
    
    private void printLivrosCadastrados(){
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i<ListaLivros.size(); i++){
            System.out.println("Códido de referencia: " + ListaLivros.get(i).getCodigo());
            System.out.println("Nome: " + ListaLivros.get(i).getNome());
            System.out.println("Autor: " + ListaLivros.get(i).getAutor());
            System.out.println("Gênero: " + ListaLivros.get(i).getGenero());
            System.out.println("Valor: " + ListaLivros.get(i).getValor());
            System.out.println("Estoque: " + ListaLivros.get(i).getEstoque());
            System.out.println("//////////////////////////");
        }
      alugaLivro();
    }
    
    public void alugaLivro(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Selecione o livro que deseja: ");
        int ref = scan.nextInt();
        //-=1 para corrigir a lista que começa em 0 e selecionar o valor correto
        ref -= 1;
       
        System.out.println("+=======================================+");         
        System.out.println("|           CADASTRAR CLIENTE           |");         
        System.out.println("+=======================================+");
        scan.nextLine();
        
        System.out.print("| NOME: ");
        String nome = scan.nextLine();
        System.out.print("| CPF: ");
        int cpf = scan.nextInt();
        System.out.print("| TELEFONE: ");
        int telefone = scan.nextInt();
        System.out.print("| DIAS PARA ALUGAR: ");
        int data_dev = scan.nextInt(); // Digite os dias para alugar o livro
        
        Date data_teste = new Date();
        Calendar c = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String data_aluguel = df.format(c.getTime());
        //altera valor de data_teste
        c.setTime(data_teste);
        //adicionar valor de data_dev à data_teste
        c.add(Calendar.DATE, data_dev);
        data_teste = c.getTime();
        //converte para dd/mm/aaa
        String data_devolucao = df.format(data_teste);

        InfoCliente.add(new Cliente(nome, cpf, telefone, data_aluguel, data_devolucao));
        
        System.out.println("-------CADASTRADO COM SUCESSO-------");
        
        System.out.println("+=======================================+");         
        System.out.println("|           NOTA FISCAL                 |");         
        System.out.println("+=======================================+");
        
        System.out.println("--------LIVRO SELECIONADO----------");
        System.out.println("Nome: "+ListaLivros.get(ref).getNome());
        System.out.println("Autor: "+ListaLivros.get(ref).getAutor());
        System.out.println("Valor: "+ListaLivros.get(ref).getValor());
   
        System.out.println("--------CLIENTE----------");
        System.out.println("NOME: " + InfoCliente.get(0).getNome());
        System.out.println("CPF: " + InfoCliente.get(0).getCpf());
        System.out.println("TELEFONE: " + InfoCliente.get(0).getTelefone());
        System.out.println("DATA DE ALUGUEL: " + InfoCliente.get(0).getData_Aluguel());
        System.out.println("DATA DE DEVOLUÇÃO: "+InfoCliente.get(0).getData_Devolucao());
        	
        System.out.println("+=======================================+");         
        System.out.println("+=======================================+");
    }
    
    
    public void DevolveLivros(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite a Ref. do livro que deseja devolver: ");
        int ref = scan.nextInt();
        ref -= 1;
        
        
        System.out.println("+=======================================+");         
        System.out.println("|           DEVOLVER LIVRO              |");         
        System.out.println("+=======================================+");
        
        System.out.println("--------LIVRO SELECIONADO----------");
        System.out.println("Nome: "+ListaLivros.get(ref).getNome());
        System.out.println("Autor: "+ListaLivros.get(ref).getAutor());
        System.out.println("Valor: "+ListaLivros.get(ref).getValor());
        //+1 na quantidade
        ListaLivros.get(ref).setQuantidade(1);
        
        System.out.println("--------CLIENTE----------");
        System.out.println("NOME: " + InfoCliente.get(0).getNome());
        System.out.println("CPF: " + InfoCliente.get(0).getCpf());
        System.out.println("TELEFONE: " + InfoCliente.get(0).getTelefone());
        System.out.println("DATA ALUGADA: " + InfoCliente.get(0).getData_Aluguel());
        System.out.println("DATA DEVOLVIDA: "+InfoCliente.get(0).getData_Devolucao());
       
    }
    
    
}


