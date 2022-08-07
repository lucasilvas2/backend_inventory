package com.ufrn.imd.inventario_patrimonial.repository;

import com.ufrn.imd.inventario_patrimonial.models.Bem;
import com.ufrn.imd.inventario_patrimonial.models.Predio;
import com.ufrn.imd.inventario_patrimonial.models.TipoBem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface BemRepository extends JpaRepository<Bem, Long> {
    List<Bem> findByTipoBem(TipoBem tipoBem);
    List<Bem> findByValor(BigDecimal valor);
    List<Bem> findByPredio(Predio predio);
}
