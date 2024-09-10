package com.lanchenlayer.repositories;

import com.lanchenlayer.entities.Estado;

import java.util.ArrayList;


public class EstadoRepository {
    private ArrayList<Estado> estados = new ArrayList<>();

    public void adicionar(Estado estado) {
        estados.add(estado);
    }

    public void remover(int id) {
        estados.removeIf(estado -> estado.getId() == id);
    }

    public Estado buscarPorId(int id) {
        return estados.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public ArrayList<Estado> buscarTodos() {
        return estados;
    }

    public Estado buscarPorDDD(String ddd) {
        return estados.stream().filter(e -> e.getDdd().equals(ddd)).findFirst().orElse(null);
    }

    public void atualizar(int id, String novoNome, String novoDDD, String novaImagem) {
        Estado estado = buscarPorId(id);
        if (estado != null) {
            estado.setNome(novoNome);
            estado.setDdd(novoDDD);
            estado.setImagem(novaImagem);
        }
    }
}
