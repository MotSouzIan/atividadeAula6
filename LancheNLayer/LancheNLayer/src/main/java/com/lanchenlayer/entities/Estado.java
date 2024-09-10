package com.lanchenlayer.entities;

public class Estado {
    private int id;
    private String nome;
    private String ddd;
    private String imagem;

    public Estado(int id, String nome, String ddd, String imagem) {
        this.id = id;
        this.nome = nome;
        this.ddd = ddd;
        this.imagem = imagem;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDdd() { return ddd; }
    public void setDdd(String ddd) { this.ddd = ddd; }

    public String getImagem() { return imagem; }
    public void setImagem(String imagem) { this.imagem = imagem; }
}