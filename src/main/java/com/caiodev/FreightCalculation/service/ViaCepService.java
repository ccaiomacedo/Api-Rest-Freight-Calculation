package com.caiodev.FreightCalculation.service;

import com.caiodev.FreightCalculation.dto.ViaCepDTO;
import com.caiodev.FreightCalculation.exceptions.AddressNotFoundException;
import com.caiodev.FreightCalculation.exceptions.InvalidFormatZipCodeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
@Service
public class ViaCepService {


    @Autowired
    private RestTemplate restTemplate;

    private String uri = "http://viacep.com.br/ws";
    private String type = "/json";
    private String payload = "";

    public ViaCepDTO findCep(String cep) {
        try {
            Map<String, String> params = new HashMap<>();
            params.put("cep", cep);
            ResponseEntity<ViaCepDTO> viaCepDTO = restTemplate.getForEntity(uri + "/{cep}" + type, ViaCepDTO.class, params);
            if (viaCepDTO.getStatusCodeValue() == 200 && viaCepDTO.getBody().getDdd() == null) {
                throw new AddressNotFoundException("Cep não existente :" + cep);
            }
            return viaCepDTO.getBody();
        } catch (HttpClientErrorException e) {
            payload = e.getResponseBodyAsString();
            throw new InvalidFormatZipCodeException(payload);
        }
    }
}


