package com.caiodev.FreightCalculation.controller;

import com.caiodev.FreightCalculation.dto.FreightRequestDTO;
import com.caiodev.FreightCalculation.dto.FreightResponseDTO;
import com.caiodev.FreightCalculation.service.FreightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/fretes")
public class FreightController {

    @Autowired
    private FreightService freightService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<FreightResponseDTO> insert(@Valid @RequestBody FreightRequestDTO freightRequestDTO) throws Exception{
        return ResponseEntity.ok().body(freightService.insert(freightRequestDTO));
    }

    @RequestMapping(value = "/{nomeDestinatario}",method = RequestMethod.GET)
    public ResponseEntity<List<FreightResponseDTO>> findByName(@PathVariable String nomeDestinatario){
        return ResponseEntity.ok().body(freightService.findByName(nomeDestinatario));
    }
    @RequestMapping(value = "/{cepOrigem}/{cepDestino}",method = RequestMethod.GET)
    public ResponseEntity<List<FreightResponseDTO>> findByCep(@PathVariable String cepOrigem,@PathVariable String cepDestino){
        return ResponseEntity.ok().body(freightService.findByCep(cepOrigem,cepDestino));
    }


}
