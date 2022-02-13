package br.com.lojaonline.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tb_address")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 10)
    private String cep;
    @Column(nullable = false, length = 170)
    private String rua;
    @Column(nullable = false, length = 50)
    private String bairro;
    @Column(nullable = false, length = 30)
    private String cidade;
    @Column(nullable = false, length = 2)
    private String estado;
    @Column(length = 60)
    private String complemento;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
