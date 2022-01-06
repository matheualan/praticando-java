package com.praticandospringboot.beanvalidation.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.Instant;

@Entity
@Table(name = "tb_clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo name deve conter mais de um caracter.")
    private String name;

    @PastOrPresent
    private Instant birthDate;

    @Email(message = "Digite um email válido.")
    private String email;

    @Size(min = 8, max = 16, message = "Telefone deve contar entre 8 a 16 digítos.")
    private String phone;

    @Pattern(regexp = "^\\d{5}$", message = "Senha deve contar letras, números e caracteres.")
    private String password;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Instant getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
