package tech.ada.shopapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.shopapi.api.VeiculosAPI;
import tech.ada.shopapi.dto.AnoDTO;
import tech.ada.shopapi.dto.MarcaDTO;
import tech.ada.shopapi.dto.ModeloDTO;
import tech.ada.shopapi.dto.VeiculoDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    @Autowired
    private VeiculosAPI veiculosAPI;

    public List<MarcaDTO> listarMarcas() {

        /*RestTemplate restTemplate = new RestTemplate();

        MarcaDTO[] marcaDTOS = restTemplate.getForObject("https://parallelum.com.br/fipe/api/v1/carros/marcas", MarcaDTO[].class);*/

        return veiculosAPI.listarMarcas();
    }

    public List<ModeloDTO> listarModeloPorMarca(Long marca) {
        return veiculosAPI.listarModelos(marca).modelos();
    }

    public List<VeiculoDTO> veiculos() {

        List<VeiculoDTO> veiculoDTOS = new ArrayList<>();

        List<MarcaDTO> tresPrimeirasMarcas = this.listarMarcas().stream().limit(3).collect(Collectors.toList());

        tresPrimeirasMarcas.forEach(marca -> {
            List<ModeloDTO> doisPrimeirosModelos = this.listarModeloPorMarca(marca.getCodigo()).stream().limit(2).collect(Collectors.toList());
            doisPrimeirosModelos.forEach(modelo -> {
                VeiculoDTO veiculoDTO = new VeiculoDTO();
                veiculoDTO.setMarca(marca.getMarca());
                veiculoDTO.setModelo(modelo.getNome());

                try {
                    AnoDTO anoDTO = this.buscarAnoPorModelo(marca.getCodigo(), modelo.getCodigo());
                    veiculoDTO.setAno(anoDTO.getNome());
                } catch (Exception e) {
                    veiculoDTO.setAno(e.getMessage());
                }

                veiculoDTOS.add(veiculoDTO);

            });
        });

        return veiculoDTOS;

    }

    public AnoDTO buscarAnoPorModelo(Long marca, Long modelo) {
        List<AnoDTO> anoDTOs = this.veiculosAPI.listarAnoPorModelo(marca, modelo);
        return anoDTOs.stream().findFirst().orElseThrow(() -> new RuntimeException("Ano nao encontrado"));
    }
}

