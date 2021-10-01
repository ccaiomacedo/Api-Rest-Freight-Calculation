package com.caiodev.FreightCalculation.dto;

import com.caiodev.FreightCalculation.domain.Freight;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FreightRequestDTO {

    @NotEmpty(message = "Campo obrigatório!")
    private String cepOrigem;

    @NotEmpty(message = "Campo obrigatório!")
    private String cepDestino;

    @NotNull(message = "Campo obrigatório!")
    private Double peso;

    @NotEmpty(message = "Campo obrigatório!")
    private String nomeDestinatario;

    public FreightRequestDTO(){

    }

    public FreightRequestDTO(Freight freight){
        cepOrigem = freight.getCepOrigem();
        cepDestino = freight.getCepDestino();
        peso = freight.getPeso();
        nomeDestinatario = freight.getNomeDestinatario();
    }

    public String getCepOrigem() {
        return cepOrigem;
    }

    public void setCepOrigem(String cepOrigem) {
        this.cepOrigem = cepOrigem;
    }

    public String getCepDestino() {
        return cepDestino;
    }

    public void setCepDestino(String cepDestino) {
        this.cepDestino = cepDestino;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }
}
