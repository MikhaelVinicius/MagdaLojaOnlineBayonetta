package com.example.magda.Repositorio;



import  com.example.magda.Entity.Produto;
import  com.example.magda.Entity.Categoria;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    

    public List<Produto> findProdutoByCategoria(Categoria categoria);

    List<Produto> findByPrecoBetween(BigDecimal min, BigDecimal max);

    List<Produto> findByQuantidadeEstoqueGreaterThan(int quantidade);

  

}
