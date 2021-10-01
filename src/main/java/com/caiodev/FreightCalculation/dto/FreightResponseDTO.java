package com.caiodev.FreightCalculation.dto;

import com.caiodev.FreightCalculation.domain.Freight;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class FreightResponseDTO {

    private Integer id;
    private Double vlTotalFrete;
    private String cepDestino;
    private String cepOrigem;
    private String nomeDestinatario;
    private Double peso;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataPrevistaEntrega;

    public FreightResponseDTO(){

    }

    public FreightResponseDTO(Freight freight){
        id=freight.getId();
        cepOrigem=freight.getCepOrigem();
        cepDestino = freight.getCepDestino();
        nomeDestinatario=freight.getNomeDestinatario();
        peso=freight.getPeso();
        dataPrevistaEntrega = freight.getDataPrevistaEntrega();
        vlTotalFrete = freight.getVlTotalFrete();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getVlTotalFrete() {
        return vlTotalFrete;
    }

    public void setVlTotalFrete(Double vlTotalFrete) {
        this.vlTotalFrete = vlTotalFrete;
    }

    public String getCepDestino() {
        return cepDestino;
    }

    public void setCepDestino(String cepDestino) {
        this.cepDestino = cepDestino;
    }

    public String getCepOrigem() {
        return cepOrigem;
    }

    public void setCepOrigem(String cepOrigem) {
        this.cepOrigem = cepOrigem;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public LocalDateTime getDataPrevistaEntrega() {
        return dataPrevistaEntrega;
    }

    public void setDataPrevistaEntrega(LocalDateTime dataPrevistaEntrega) {
        this.dataPrevistaEntrega = dataPrevistaEntrega;
    }
}
