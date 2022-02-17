package br.com.lojaonline.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

public class UserDTO {

    @NotBlank(message = "O campo name não pode ser nulo ou vazio.")
    private String name;
    @NotBlank(message = "O campo CPF não pode ser nulo ou vazio")
    @Size(min = 11, max = 14)
    private String cpf;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}
