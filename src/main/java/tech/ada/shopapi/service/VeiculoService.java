package tech.ada.shopapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.shopapi.api.VeiculosAPI;
import tech.ada.shopapi.dto.MarcaDTO;
import tech.ada.shopapi.dto.ModeloDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    @Autowired
    private VeiculosAPI veiculosAPI;

    public List<String> listarMarcas() {

        /*RestTemplate restTemplate = new RestTemplate();

        MarcaDTO[] marcaDTOS = restTemplate.getForObject("https://parallelum.com.br/fipe/api/v1/carros/marcas", MarcaDTO[].class);*/

        return veiculosAPI.listarMarcas().stream().map(MarcaDTO::getMarca).collect(Collectors.toList());
    }

    public List<ModeloDTO> listarModeloPorMarca(Long marca) {
        return veiculosAPI.listarModelos(marca).modelos();
    }

}

