package br.com.letscode.ecommusuariosapi.repository;

import br.com.letscode.ecommusuariosapi.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

}

