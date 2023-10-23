package tech.ada.shopapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.ada.shopapi.dto.ModeloDTO;
import tech.ada.shopapi.dto.PedidoDTO;
import tech.ada.shopapi.model.Pedido;
import tech.ada.shopapi.service.PedidoService;
import tech.ada.shopapi.service.VeiculoService;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("/criar")
    public void criar(@RequestBody PedidoDTO pedidoDTO) {

        this.pedidoService.criar(pedidoDTO);

    }

    @GetMapping("/marcas")
    public List<String>  marcas() {
        return veiculoService.listarMarcas();
    }

    @GetMapping("/modelo-por-marca/{marca}")
    public List<ModeloDTO> marcas(@PathVariable("marca") Long marca) {
        return veiculoService.listarModeloPorMarca(marca);
    }

}
