package br.com.letscode.ecommprodutosapi.repository;

import br.com.letscode.ecommprodutosapi.domain.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<Produto, String> {

}
