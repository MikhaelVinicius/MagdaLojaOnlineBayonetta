package com.example.magda.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.magda.Entity.ItemPedido;
import com.example.magda.Service.ItemPedidoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/itemPedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public List<ItemPedido> listarTodos() {
        return itemPedidoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> buscarPorId(@PathVariable Long id) {
        Optional<ItemPedido> itemPedido = itemPedidoService.buscarPorId(id);
        return itemPedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ItemPedido salvar(@RequestBody ItemPedido item) {
        return itemPedidoService.salvar(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        itemPedidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
