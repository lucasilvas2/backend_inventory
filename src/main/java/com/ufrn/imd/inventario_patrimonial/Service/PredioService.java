package com.ufrn.imd.inventario_patrimonial.Service;

import com.ufrn.imd.inventario_patrimonial.models.Empresa;
import com.ufrn.imd.inventario_patrimonial.models.Endereco;
import com.ufrn.imd.inventario_patrimonial.models.Predio;
import com.ufrn.imd.inventario_patrimonial.repository.PredioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredioService {

    private final PredioRepository predioRepository;
    private final EnderecoService enderecoService;

    public PredioService(PredioRepository predioRepository, EnderecoService enderecoService) {
        this.predioRepository = predioRepository;
        this.enderecoService = enderecoService;
    }

    public Predio cadastrar(Predio predio, Long endereco_id){
        predio.setEndereco(enderecoService.buscarEnderecoPorId(endereco_id));
        return predioRepository.save(predio);
    }
    public List<Predio> buscarTodosOsPredios(){
        return predioRepository.findAll();
    }
    public Predio buscarPredioPorId(Long id){
        return predioRepository.findById(id).isPresent() ? predioRepository.findById(id).get() : null;
    }
    public void deletar(Long id){
        predioRepository.deleteById(id);
    }

    public List<Predio> buscarPorEndereco(Long endereco_id){
        Endereco endereco = enderecoService.buscarEnderecoPorId(endereco_id);
        return predioRepository.findByEndereco(endereco);
    }
}
