package com.example.magda.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.magda.Entity.Produto;
import com.example.magda.Repositorio.ProdutoRepository;
import com.example.magda.Entity.Categoria;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public List<Produto> buscarPorCategoria(Long categoriaId) {
        return produtoRepository.findByCategoriaId(categoriaId);
    }

    public List<Produto> listarPorCategoria(Categoria categoria){
        return produtoRepository.findProdutoByCategoria(categoria);
    }

      public List<Produto> findByFaixaDePreco(BigDecimal min, BigDecimal max) {
        return produtoRepository.findByPrecoBetween(min, max);
    }

    public List<Produto> findDisponiveis() {
        return produtoRepository.findByQuantidadeEstoqueGreaterThan(0);
    }
    

    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

    
}
