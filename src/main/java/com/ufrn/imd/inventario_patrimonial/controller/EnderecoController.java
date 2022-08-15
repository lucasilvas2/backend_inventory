package com.ufrn.imd.inventario_patrimonial.controller;

import com.ufrn.imd.inventario_patrimonial.Service.EnderecoService;
import com.ufrn.imd.inventario_patrimonial.models.Endereco;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/endereco")
public class EnderecoController {

    private EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Endereco endereco){
        Endereco enderecoSalvo = enderecoService.cadastrar(endereco);
        if(enderecoSalvo != null){
            return new ResponseEntity<>(enderecoSalvo, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping(value = "/buscar")
    public ResponseEntity<?> buscar(){
        List<Endereco> endereco_list = enderecoService.buscarTodosEnderecos();
        if(endereco_list != null){
            return new ResponseEntity<>(endereco_list, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(value = "/deletar/{endereco_id}")
    public ResponseEntity<?> deletar(@PathVariable Long endereco_id){
        Endereco enderecoSalvo = enderecoService.buscarEnderecoPorId(endereco_id);
        if(enderecoSalvo != null){
            enderecoService.deletar(endereco_id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/buscar/logradouro/{endereco_logradouro}")
    public ResponseEntity<?> buscarPorLogradouro(String endereco_logradouro){
        List<Endereco> endereco_list = enderecoService.buscarEnderecoPorLogradouro(endereco_logradouro);
        if(!endereco_list.isEmpty()){
            return new ResponseEntity<>(endereco_list, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/buscar/numero/{endereco_numero}")
    public ResponseEntity<?> buscarPorNumero(String endereco_numero){
        List<Endereco> endereco_list = enderecoService.buscarEnderecoPorNumero(endereco_numero);
        if(!endereco_list.isEmpty()){
            return new ResponseEntity<>(endereco_list, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/buscar/bairro/{endereco_bairro}")
    public ResponseEntity<?> buscarPorBairro(String endereco_bairro){
        List<Endereco> endereco_list = enderecoService.buscarEnderecoPorBairro(endereco_bairro);
        if(!endereco_list.isEmpty()){
            return new ResponseEntity<>(endereco_list, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/buscar/cep/{endereco_cep}")
    public ResponseEntity<?> buscarPorCep(String endereco_cep){
        List<Endereco> endereco_list = enderecoService.buscarEnderecoPorCep(endereco_cep);
        if(!endereco_list.isEmpty()){
            return new ResponseEntity<>(endereco_list, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
