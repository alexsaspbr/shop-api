package tech.ada.shopapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.shopapi.dto.PedidoDTO;
import tech.ada.shopapi.model.Pedido;
import tech.ada.shopapi.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/criar")
    public void criar(@RequestBody PedidoDTO pedidoDTO) {

        this.pedidoService.criar(pedidoDTO);

    }


}
