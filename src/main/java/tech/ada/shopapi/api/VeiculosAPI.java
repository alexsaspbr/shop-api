package tech.ada.shopapi.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tech.ada.shopapi.dto.MarcaDTO;
import tech.ada.shopapi.dto.ModeloDTO;
import tech.ada.shopapi.dto.ModeloResponseDTO;

import java.util.List;

@FeignClient(name = "veiculo-client", url = "https://parallelum.com.br")
public interface VeiculosAPI {

    @GetMapping("/fipe/api/v1/carros/marcas")
    public List<MarcaDTO> listarMarcas();

    @GetMapping("/fipe/api/v1/carros/marcas/{marca}/modelos")
    public ModeloResponseDTO listarModelos(@PathVariable("marca") Long marca);

    /*
    * Criar um endpoint para trazer as 3 primeiras Marcas,
    * com base nessa marcas, os 2 primeiros modelos
    * e com base nesses modelos os primeiros anos de cada modelo.
    *
    *
    * Deverão criar um novo endpoint para buscar os anos e criar um novo endpoint no Controler para devolver os dados
    * */


}
