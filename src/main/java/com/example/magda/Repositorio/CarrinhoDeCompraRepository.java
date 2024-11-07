package com.example.magda.Repositorio;



import com.example.magda.Entity.CarrinhoDeCompras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoDeCompraRepository extends JpaRepository<CarrinhoDeCompras, Long> {
    
}
