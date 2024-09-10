package com.lanchenlayer.services;

import com.lanchenlayer.entities.Estado;

public class EstadoService {
    private String caminhoDestino = "C:\\Users\\aluno\\EstadosNLayer\\images\\";

    public static String getFileExtension(String filePath) {
        String fileName = new File(filePath).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "No extension" : fileName.substring(dotIndex + 1);
    }

    public boolean salvarImagem(Estado estado) {
        Path path = Paths.get(estado.getImagem());
        Path pastaDestino = Paths.get(caminhoDestino + estado.getId() + "." + getFileExtension(estado.getImagem()));

        if (Files.exists(path)) {
            try {
                Files.copy(path, pastaDestino, StandardCopyOption.REPLACE_EXISTING);
                estado.setImagem(pastaDestino.getFileName().toString());
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
        return false;
    }

    public boolean removerImagem(Estado estado) {
        Path imagemPath = Paths.get(caminhoDestino + estado.getImagem());
        try {
            return Files.deleteIfExists(imagemPath);
        } catch (Exception e) {
            return false;
        }
    }
}