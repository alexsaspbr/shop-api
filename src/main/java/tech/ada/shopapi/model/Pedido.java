package tech.ada.shopapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_pedido")
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@OneToOne - Um pra Um
    //@OneToMany - Um pra Muitos
    //@ManyToOne - Muitos pra Um
    //@ManyToMany - Muitos pra Muitos
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> itens;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataHora;
    private BigDecimal total;

}
