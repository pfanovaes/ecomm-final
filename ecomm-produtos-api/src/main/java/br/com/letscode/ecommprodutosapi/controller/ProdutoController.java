package br.com.letscode.ecommprodutosapi.controller;

import br.com.letscode.ecommprodutosapi.domain.Produto;
import br.com.letscode.ecommprodutosapi.repository.ProdutoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@Controller
@RequestMapping(path = "/produto")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Produto> addNewProduto(@RequestBody Produto produto){
        Produto persistedProduto = this.produtoRepository.save(produto);

        return ResponseEntity
                .created(URI.create(String.format("/produto/%s", persistedProduto.getId())))
                .body(persistedProduto);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Produto> getProduto(@PathVariable String id) {
        Optional<Produto> produto = this.produtoRepository.findById(id);

        if (produto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(produto.get());
    }
}
