package com.ufrn.imd.inventario_patrimonial.Service;

import com.ufrn.imd.inventario_patrimonial.models.Endereco;
import com.ufrn.imd.inventario_patrimonial.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco cadastrar(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public void deletar(Long id){
        enderecoRepository.deleteById(id);
    }

    public List<Endereco> buscarTodosEnderecos(){
        return enderecoRepository.findAll();
    }

    public Endereco buscarEnderecoPorId(Long id){
        return enderecoRepository.findById(id).isPresent() ? enderecoRepository.findById(id).get() : null;
    }

    public List<Endereco> buscarEnderecoPorLogradouro(String logradouro){
        return enderecoRepository.findByLogradouro(logradouro);
    }
    public List<Endereco> buscarEnderecoPorBairro(String bairro){
        return enderecoRepository.findByBairro(bairro);
    }
    public List<Endereco> buscarEnderecoPorNumero(String numero){
        return enderecoRepository.findByNumero(numero);
    }
    public List<Endereco> buscarEnderecoPorCep(String cep){
        return enderecoRepository.findByCep(cep);
    }
}
