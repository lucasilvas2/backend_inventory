package com.ufrn.imd.inventario_patrimonial.repository;

import com.ufrn.imd.inventario_patrimonial.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco> findByLogradouro(String logradouro);
    List<Endereco> findByBairro(String bairro);
    List<Endereco> findByNumero(String numero);
    List<Endereco> findByCep(String cep);
}
