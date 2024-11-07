package com.example.magda.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.magda.Entity.CarrinhoDeCompras;
import com.example.magda.Service.CarrinhoDeComprasService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carrinho")
public class CarrinhoDeComprasController {

    @Autowired
    private CarrinhoDeComprasService carrinhoService;

    @GetMapping
    public List<CarrinhoDeCompras> listarTodos() {
        return carrinhoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoDeCompras> buscarPorId(@PathVariable Long id) {
        Optional<CarrinhoDeCompras> carrinho = carrinhoService.buscarPorId(id);
        return carrinho.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CarrinhoDeCompras salvar(@RequestBody CarrinhoDeCompras produto) {
        return carrinhoService.salvar(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        carrinhoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

