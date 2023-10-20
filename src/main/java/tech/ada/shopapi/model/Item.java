package tech.ada.shopapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_item")
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quantidade;
    private String codigoBarra;
    private BigDecimal preco;
    @ManyToOne
    private Pedido pedido;

}
