package com.senac.br.mercado.Modolo;

public class produto {

    private String nome;
    private int quantidades;
    private String preco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public produto() {
    }

    public produto(String nome, int quantidades, String preco) {
        this.nome = nome;
        this.quantidades = quantidades;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidades() {
        return quantidades;
    }

    public void setQuantidades(int quantidades) {
        this.quantidades = quantidades;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "produto{" +
                "nome='" + nome + '\'' +
                ", quantidades=" + quantidades +
                ", preco='" + preco + '\'' +
                '}';
    }
}
