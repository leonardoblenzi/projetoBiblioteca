package Entities;

public class Livro {
    private int Codigo;
    private String Nome;
    private String Autor;
    private String Genero;
    private String Descricao;
    private double Valor;
    private String Estoque;
    private int Quantidade;

    public Livro() {
    }
    //construtor não conterá Estoque pois sera usado um método pra atribuir
    public Livro(int codigo, String nome, String autor, String genero, String descricao, double valor, int quantidade) {
        this.Codigo = codigo;
        this.Nome = nome;
        this.Autor = autor;
        this.Genero = genero;
        this.Descricao = descricao;
        this.Valor = valor;
        this.Quantidade = quantidade;
        verificaEstoque(quantidade);
    }
    
    //metodo que atribui disponivel ou não no estoque
    public void verificaEstoque(int quantidade){
        if(quantidade <= 0){
          this.Estoque = "INDÍSPONIVEL";
        }
        else if(quantidade > 0){
            this.Estoque = "DÍSPONIVEL";
        }
    }
    
    public void devolveLivro(){
        this.Quantidade += 1;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public Integer getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.Quantidade += quantidade;
    }
    //estoque
    public String getEstoque(){
        return Estoque;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }
    
    
    
}