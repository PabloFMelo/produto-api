package com.example.produto_api.controller;

import com.example.produto_api.model.Produto;
import com.example.produto_api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.produto_api.exception.RecursoNaoEncontradoException;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    // GET /api/produtos -> lista todos os produtos
    @GetMapping
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado com id: " + id));
    }

    // POST /api/produtos -> cria um novo produto
    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto produto) {
        Produto salvo = produtoRepository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    // PUT /api/produtos/{id} -> atualiza um produto existente
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto dados) {
        Produto produtoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado com id: " + id));

        produtoExistente.setNome(dados.getNome());
        produtoExistente.setDescricao(dados.getDescricao());
        produtoExistente.setPreco(dados.getPreco());
        produtoExistente.setQuantidadeEstoque(dados.getQuantidadeEstoque());

        return produtoRepository.save(produtoExistente);
    }

    // DELETE /api/produtos/{id} -> remove um produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado com id: " + id));

        produtoRepository.delete(produto);
        return ResponseEntity.noContent().build();
    }
}