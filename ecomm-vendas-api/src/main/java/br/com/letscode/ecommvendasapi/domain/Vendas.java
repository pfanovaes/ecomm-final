package br.com.letscode.ecommvendasapi.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document(collection = "vendas")
public class Vendas {

    @Id
    private String id;
    private Long usuarioId;
    private Long carrinhoId;
    private Date date = new Date();
    private BigDecimal = valorTotal;

}
