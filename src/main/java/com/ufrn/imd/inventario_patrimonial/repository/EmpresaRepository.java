package com.ufrn.imd.inventario_patrimonial.repository;

import com.ufrn.imd.inventario_patrimonial.models.Empresa;
import com.ufrn.imd.inventario_patrimonial.models.Endereco;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    List<Empresa> findByNome(String nome);
    List<Empresa> findByCpnj(String cnpj);
    List<Empresa> findByEndereco(Endereco endereco);
}
