package tech.ada.shopapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tech.ada.shopapi.dto.ItemDTO;
import tech.ada.shopapi.dto.PedidoDTO;
import tech.ada.shopapi.dto.ProdutoDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    public void criar(PedidoDTO pedidoDTO) {

        RestTemplate restTemplate = new RestTemplate();

        List<ItemDTO> itemDTOs = pedidoDTO.getItens().stream().map(itemDTO -> {

                    ProdutoDTO produtoDTO = restTemplate.getForObject("http://localhost:8080/produto/por/{codigoBarra}", ProdutoDTO.class, itemDTO.getCodigoBarra());
                    itemDTO.setPreco(produtoDTO.getPreco());

                    return itemDTO;
                })
                .collect(Collectors.toList());

        itemDTOs.forEach(item -> {
            System.out.println(item.getCodigoBarra());
            System.out.println(item.getPreco());
        });

    }

}
