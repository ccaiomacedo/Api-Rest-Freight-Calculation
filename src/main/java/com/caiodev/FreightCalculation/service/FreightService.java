package com.caiodev.FreightCalculation.service;

import com.caiodev.FreightCalculation.domain.Freight;
import com.caiodev.FreightCalculation.dto.FreightRequestDTO;
import com.caiodev.FreightCalculation.dto.FreightResponseDTO;
import com.caiodev.FreightCalculation.dto.ViaCepDTO;
import com.caiodev.FreightCalculation.exceptions.FreightNotFoundException;
import com.caiodev.FreightCalculation.repository.FreightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FreightService {


    public final Double VALOR_PARA_CADA_KG=1.00;
    public final Double VALOR_PARA_ACHAR_EM_KG= 1000.0;
    public final Double DESCONTO_DDD_IGUAL=0.5;
    public final Double DESCONTO_UF_IGUAL=0.75;


    @Autowired
    private FreightRepository freightRepository;


    @Transactional
    public FreightResponseDTO insert(FreightRequestDTO freightRequestDTO) throws Exception{
            Freight freight = new Freight();
            freight = freightDtoToFreight(freight,freightRequestDTO);
            freightRepository.save(freight);
            return new FreightResponseDTO(freight);
    }

    @Transactional
    public List<FreightResponseDTO> findFreight(String cepOrigem,String cepDestino,String nomeDestinatario){
        Optional<Freight> result = freightRepository.findByFreight(cepOrigem,cepDestino,nomeDestinatario);

        if(result.isEmpty()){
            throw new FreightNotFoundException("Frete não encontrado!");
        }
        result.ifPresent(x -> x.setDataConsulta(LocalDateTime.now()));
        return result.stream().map(x -> new FreightResponseDTO(x)).collect(Collectors.toList());
    }


    @Autowired
    private ViaCepService viaCepService;
    private Freight freightDtoToFreight(Freight freight, FreightRequestDTO freightRequestDTO){
        Double valorFrete=0.0;
        Double valorAux = 0.0;

        freight.setPeso(freightRequestDTO.getPeso());
        freight.setNomeDestinatario(freightRequestDTO.getNomeDestinatario());

        freight.setCepOrigem(freightRequestDTO.getCepOrigem());

        ViaCepDTO viaCepOrigem = viaCepService.findCep(freight.getCepOrigem());
        String dddOrigem = viaCepOrigem.getDdd();
        String ufOrigem = viaCepOrigem.getUf();

        freight.setCepDestino(freightRequestDTO.getCepDestino());

        ViaCepDTO viaCepDestino = viaCepService.findCep(freight.getCepDestino());
        String dddDestino = viaCepDestino.getDdd();
        String ufDestino = viaCepDestino.getUf();

        if(dddOrigem.equals(dddDestino) && ufOrigem.equals(ufDestino)){
            freight.setDataPrevistaEntrega(LocalDateTime.now().plusDays(1L));
            valorAux =(freight.getPeso()/VALOR_PARA_ACHAR_EM_KG)*VALOR_PARA_CADA_KG;
            valorFrete = valorAux-(valorAux *DESCONTO_DDD_IGUAL);
            freight.setVlTotalFrete(valorFrete);

        }

        if(ufOrigem.equals(ufDestino) && !dddOrigem.equals(dddDestino)){
            freight.setDataPrevistaEntrega(LocalDateTime.now().plusDays(3L));
            valorAux = (freight.getPeso()/VALOR_PARA_ACHAR_EM_KG)*VALOR_PARA_CADA_KG;
            valorFrete = valorAux - (valorAux*DESCONTO_UF_IGUAL);
            freight.setVlTotalFrete(valorFrete);
        }

        if (!ufOrigem.equals(ufDestino)){
            freight.setDataPrevistaEntrega(LocalDateTime.now().plusDays(10L));
            valorAux= (freight.getPeso()/VALOR_PARA_ACHAR_EM_KG)*VALOR_PARA_CADA_KG;
            freight.setVlTotalFrete(valorAux);
        }

        return freight;

    }

}
