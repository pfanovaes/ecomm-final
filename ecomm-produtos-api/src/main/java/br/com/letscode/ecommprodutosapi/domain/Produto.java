package br.com.letscode.ecommprodutosapi.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "produto")
public class Produto {

    @Id
    private String id;
    private String nome;
    private String categoria;
    private Double preco;

    @Field
    private Set<Long> listaDeProdutos = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Set<Long> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public void setListaDeProdutos(Set<Long> listaDeProdutos) {
        this.listaDeProdutos = listaDeProdutos;
    }
}
