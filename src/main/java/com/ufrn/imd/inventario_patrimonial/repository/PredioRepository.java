package com.ufrn.imd.inventario_patrimonial.repository;

import com.ufrn.imd.inventario_patrimonial.models.Endereco;
import com.ufrn.imd.inventario_patrimonial.models.Predio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PredioRepository extends JpaRepository<Predio, Long> {
    List<Predio> findByEndereco(Endereco endereco);

}
