package com.caiodev.FreightCalculation.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Freight implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Double peso;
    private String cepOrigem;
    private String cepDestino;
    private String nomeDestinatario;

    private LocalDateTime dataPrevistaEntrega;

    private LocalDateTime dataConsulta;

    private Double vlTotalFrete;

    public Freight(){

    }

    public Freight(Integer id, Double peso, String cepOrigem, String cepDestino, String nomeDestinatario, LocalDateTime dataPrevistaEntrega, LocalDateTime dataConsulta, Double vlTotalFrete) {
        this.id = id;
        this.peso = peso;
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.nomeDestinatario = nomeDestinatario;
        this.dataPrevistaEntrega = dataPrevistaEntrega;
        this.dataConsulta = dataConsulta;
        this.vlTotalFrete = vlTotalFrete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
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

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public LocalDateTime getDataPrevistaEntrega() {
        return dataPrevistaEntrega;
    }

    public void setDataPrevistaEntrega(LocalDateTime dataPrevistaEntrega) {
        this.dataPrevistaEntrega = dataPrevistaEntrega;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Double getVlTotalFrete() {
        return vlTotalFrete;
    }

    public void setVlTotalFrete(Double vlTotalFrete) {
        this.vlTotalFrete = vlTotalFrete;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }


}
