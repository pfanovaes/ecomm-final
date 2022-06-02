package br.com.letscode.ecommvendasapi.handler;

import br.com.letscode.ecommvendasapi.domain.Vendas;
import br.com.letscode.ecommvendasapi.repository.VendasRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class VendasHandler {

    private final VendasRepository vendasRepository;

    public VendasHandler(VendasRepository vendasRepository) {
        this.vendasRepository = vendasRepository;
    }

    public Mono<ServerResponse> adicionaVenda(ServerRequest request) {
       return request.bodyToMono(Vendas.class)
               //.flatMap(vendasService::adicionaVenda)
               .flatMap(vendasRepository::save)
               .flatMap(vendas -> ServerResponse
                       .created(URI.create(String.format("vendas/%s", vendas.getId())))
                       .bodyValue(vendas))
               .switchIfEmpty(ServerResponse.unprocessableEntity().bodyValue("Usuário inválido. Por favor verifique."));


    }

    public Mono<ServerResponse> getVendasbyUsuario(ServerRequest request) {
        return null;
    }
}
