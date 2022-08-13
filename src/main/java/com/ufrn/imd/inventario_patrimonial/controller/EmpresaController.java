package com.ufrn.imd.inventario_patrimonial.controller;

import com.ufrn.imd.inventario_patrimonial.Service.EmpresaService;
import com.ufrn.imd.inventario_patrimonial.models.Empresa;
import com.ufrn.imd.inventario_patrimonial.models.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Empresa empresa, @PathVariable Long endereco_id){
        Empresa empresaSalva = empresaService.cadastrar(empresa, endereco_id);
        if(empresa != null){
            return new ResponseEntity<>(empresaSalva, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping(value = "/buscar")
    public ResponseEntity<?>  buscar(){
        List<Empresa> empresas = empresaService.buscarTodasEmpresas();
        if(empresas != null){
            return new ResponseEntity<>(empresas, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping(value = "/deletar/{empresa_id}")
    public ResponseEntity<?> deletar(@PathVariable Long empresa_id){
        Empresa empresaSalva = empresaService.buscarPorId(empresa_id);
        if(empresaSalva != null){
            empresaService.deletar(empresa_id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/buscar/nome/{empresa_nome}")
    public ResponseEntity<?> buscarPorNome(@PathVariable String empresa_nome){
        List<Empresa> empresa_list = empresaService.buscarPorNome(empresa_nome);
        if(!empresa_list.isEmpty()){
            return new ResponseEntity<>(empresa_list, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/buscar/cnpj/{empresa_nome}")
    public ResponseEntity<?> buscarPorCnpj(@PathVariable String empresa_cnpj){
        List<Empresa> empresa_list = empresaService.buscarPorCnpj(empresa_cnpj);
        if(!empresa_list.isEmpty()){
            return new ResponseEntity<>(empresa_list, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/buscar/endereco/{endereco_id}")
    public ResponseEntity<?> buscarPorEndereco(@PathVariable Long endereco_id){
        List<Empresa> empresa_list = empresaService.buscarPorEndereco(endereco_id);
        if(!empresa_list.isEmpty()){
            return new ResponseEntity<>(empresa_list, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
