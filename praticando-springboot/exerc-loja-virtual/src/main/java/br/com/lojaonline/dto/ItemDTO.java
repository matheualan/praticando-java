package br.com.lojaonline.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ItemDTO {

    @NotBlank(message = "O campo não pode ser nulo ou vazio.")
    @Size(min = 3, max = 155)
    private String name;
    @NotBlank(message = "O campo não pode ser nulo ou vazio.")
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
