package br.com.letscode.ecommvendasapi.config;

import br.com.letscode.ecommvendasapi.handler.VendasHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RequestPredicates.*;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.logging.Handler;
import static org.springframework.http.MediaType.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> route(VendasHandler vendasHandler) {
        return RouterFunctions
                .route(POST("/vendas/add").and(contentType(APPLICATION_JSON)), vendasHandler::adicionaVenda)
                .andRoute(GET("/vendas/{usuarioId}").and(contentType(APPLICATION_JSON)), vendasHandler::getVendasbyUsuario);

    }
}
