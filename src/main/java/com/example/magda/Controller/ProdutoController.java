package com.example.magda.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.magda.Entity.Produto;
import com.example.magda.Entity.Categoria;
import com.example.magda.Service.ProdutoService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        Optional<Produto> produto = produtoService.buscarPorId(id);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/produtos-categoria")
    public List<Produto> buscarPorCategoria(@RequestParam Categoria categoria) {
        return produtoService.listarPorCategoria(categoria);
    }

    @GetMapping("/faixa-preco")
    public ResponseEntity<List<Produto>> listarPorFaixaDePreco(
            @RequestParam BigDecimal min,
            @RequestParam BigDecimal max) {
        List<Produto> produtos = produtoService.findByFaixaDePreco(min, max);
        return produtos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(produtos);
    }

    @GetMapping("/disponiveis")
public ResponseEntity<List<Produto>> listarDisponiveis() {
    List<Produto> produtos = produtoService.findDisponiveis();
    return produtos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(produtos);
}


    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
