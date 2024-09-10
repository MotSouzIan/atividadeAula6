package com.lanchenlayer.applications;

import com.lanchenlayer.entities.Estado;
import com.lanchenlayer.repositories.EstadoRepository;
import com.lanchenlayer.services.EstadoService;

import java.util.ArrayList;
import java.util.Scanner;

public class EstadoApplication {
    private EstadoRepository estadoRepository;
    private EstadoService estadoService;

    public EstadoApplication(EstadoRepository estadoRepository, EstadoService estadoService) {
        this.estadoRepository = estadoRepository;
        this.estadoService = estadoService;
    }

    public void adicionar(Estado estado) {
        estadoRepository.adicionar(estado);
        estadoService.salvarImagem(estado);
    }

    public void remover(int id) {
        Estado estado = estadoRepository.buscarPorId(id);
        if (estado != null) {
            estadoService.removerImagem(estado);
            estadoRepository.remover(id);
        }
    }

    public Estado buscarPorId(int id) {
        return estadoRepository.buscarPorId(id);
    }

    public ArrayList<Estado> buscarTodos() {
        return estadoRepository.buscarTodos();
    }

    public void atualizar(int id, String novoNome, String novoDDD, String novoCaminhoImagem) {
        Estado estado = estadoRepository.buscarPorId(id);
        if (estado != null) {
            estadoService.removerImagem(estado);
            estadoService.salvarImagem(new Estado(id, novoNome, novoDDD, novoCaminhoImagem));
            estadoRepository.atualizar(id, novoNome, novoDDD, novoCaminhoImagem);
        }
    }

    public Estado buscarPorDDD(String ddd) {
        return estadoRepository.buscarPorDDD(ddd);
    }
}