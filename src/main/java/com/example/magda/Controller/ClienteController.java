package com.example.magda.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.magda.Entity.Cliente;
import com.example.magda.Service.ClienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService ClienteService;

    @GetMapping
    public List<Cliente> listarTodos() {
        return ClienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        Optional<Cliente> Cliente = ClienteService.buscarPorId(id);
        return Cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        return ClienteService.salvar(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        ClienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
