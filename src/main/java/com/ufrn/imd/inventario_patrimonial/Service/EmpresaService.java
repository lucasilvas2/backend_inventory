package com.ufrn.imd.inventario_patrimonial.Service;

import com.ufrn.imd.inventario_patrimonial.models.Empresa;
import com.ufrn.imd.inventario_patrimonial.models.Endereco;
import com.ufrn.imd.inventario_patrimonial.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final EnderecoService enderecoService;

    public EmpresaService(EmpresaRepository empresaRepository, EnderecoService enderecoService) {
        this.empresaRepository = empresaRepository;
        this.enderecoService = enderecoService;
    }

    public Empresa cadastrar(Empresa empresa, Long id_endereco) {
        empresa.setEndereco(enderecoService.buscarEnderecoPorId(id_endereco));
        return empresaRepository.save(empresa);
    }

    public void deletar(Long id) {
        empresaRepository.deleteById(id);
    }

    public List<Empresa> buscarTodasEmpresas() {
        return empresaRepository.findAll();
    }

    public Empresa buscarPorId(Long id){
        return empresaRepository.findById(id).isPresent() ? empresaRepository.findById(id).get() : null;
    }

    public List<Empresa> buscarPorNome(String nome){
        return empresaRepository.findByNome(nome);
    }

    public List<Empresa> buscarPorCnpj(String cnpj){
        return empresaRepository.findByCpnj(cnpj);
    }

    public List<Empresa> buscarPorEndereco(Long endereco_id){
        Endereco endereco = enderecoService.buscarEnderecoPorId(endereco_id);
        return empresaRepository.findByEndereco(endereco);
    }
}
