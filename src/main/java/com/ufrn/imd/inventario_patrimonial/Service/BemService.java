package com.ufrn.imd.inventario_patrimonial.Service;

import com.ufrn.imd.inventario_patrimonial.models.Bem;
import com.ufrn.imd.inventario_patrimonial.models.Endereco;
import com.ufrn.imd.inventario_patrimonial.models.Predio;
import com.ufrn.imd.inventario_patrimonial.models.TipoBem;
import com.ufrn.imd.inventario_patrimonial.repository.BemRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BemService {
    private final BemRepository bemRepository;
    private final PredioService predioService;

    public BemService(BemRepository bemRepository, PredioService predioService) {
        this.bemRepository = bemRepository;
        this.predioService = predioService;
    }

    public Bem cadastrar(Bem bem, Long predio_id){
        bem.setPredio(predioService.buscarPredioPorId(predio_id));
        return bemRepository.save(bem);
    }

    public void deletar(Long id){
         bemRepository.deleteById(id);
    }
    public List<Bem> buscarTodosBens(){
        return bemRepository.findAll();
    }
    public Bem buscarPorId(Long id){
        return bemRepository.findById(id).isPresent() ? bemRepository.findById(id).get() : null;
    }

    public List<Bem> buscarTodosPorValor(BigDecimal valor){
        return bemRepository.findByValor(valor);
    }

    public List<Bem> buscarPorPredio(Long predio_id){
        Predio predio= predioService.buscarPredioPorId(predio_id);
        return bemRepository.findByPredio(predio);
    }

    //list por tipo de item
}
