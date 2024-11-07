package com.example.magda.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.magda.Entity.CarrinhoDeCompras;

import com.example.magda.Repositorio.CarrinhoDeCompraRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoDeComprasService {

    @Autowired
    private CarrinhoDeCompraRepository CarrinhoDeComprasRepository;

    public List<CarrinhoDeCompras> listarTodos() {
        return CarrinhoDeComprasRepository.findAll();
    }

    public Optional<CarrinhoDeCompras> buscarPorId(Long id) {
        return CarrinhoDeComprasRepository.findById(id);
    }

    public CarrinhoDeCompras salvar(CarrinhoDeCompras produto) {
        return CarrinhoDeComprasRepository.save(produto);
    }

    public void deletar(Long id) {
        CarrinhoDeComprasRepository.deleteById(id);
    }
}
