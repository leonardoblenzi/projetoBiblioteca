
package Entities;



public class Cliente {
   private String Nome;
   private int Cpf;
   private int Telefone;
   private String Data_Aluguel;
   private String Data_Devolucao;
    private String data_devolucao;
   
   public Cliente(){
   }

    public Cliente(String nome, int cpf, int telefone, String data_aluguel, String data_devolucao) {
        this.Data_Aluguel = data_aluguel;
        this.Data_Devolucao = data_devolucao;
        this.Nome = nome;
        this.Cpf = cpf;
        this.Telefone = telefone;
    }

  

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getCpf() {
        return Cpf;
    }

    public void setCpf(int Cpf) {
        this.Cpf = Cpf;
    }

    public int getTelefone() {
        return Telefone;
    }

    public void setTelefone(int Telefone) {
        this.Telefone = Telefone;
    }

    public String getData_Aluguel() {
        return Data_Aluguel;
    }
   public String getData_Devolucao(){
       return Data_Devolucao;
   }
   
}
