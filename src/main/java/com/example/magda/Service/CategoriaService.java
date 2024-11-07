package com.example.magda.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.magda.Entity.Categoria;
import com.example.magda.Repositorio.CategoriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria salvar(Categoria produto) {
        return categoriaRepository.save(produto);
    }

    public void deletar(Long id) {
        categoriaRepository.deleteById(id);
    }
}
