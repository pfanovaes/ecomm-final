package br.com.letscode.ecommvendasapi.repository;

import br.com.letscode.ecommvendasapi.domain.Vendas;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface VendasRepository extends ReactiveMongoRepository<Vendas, String> {

}

