package tech.ada.shopapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarcaDTO {

    private Long codigo;
    @JsonProperty("nome")
    private String marca;

}
