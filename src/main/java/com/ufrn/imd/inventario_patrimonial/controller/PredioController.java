package com.ufrn.imd.inventario_patrimonial.controller;

import com.ufrn.imd.inventario_patrimonial.Service.PredioService;
import com.ufrn.imd.inventario_patrimonial.models.Empresa;
import com.ufrn.imd.inventario_patrimonial.models.Predio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/predio")
public class PredioController {
    @Autowired
    private PredioService predioService;

    @GetMapping(value = "/buscar")
    public ResponseEntity<?> buscar() {
        List<Predio> predioList = predioService.buscarTodosOsPredios();
        if (!predioList.isEmpty()) {
            return new ResponseEntity<>(predioList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/cadastrar/{empresa_id}")
    public ResponseEntity<?> cadastrar(@RequestBody Predio predio, Long empresa_id) {
        Predio predioSalvo = predioService.cadastrar(predio, empresa_id);
        if (predioSalvo != null) {
            return new ResponseEntity<>(predioSalvo, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping(value = "/buscar/{predio_id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long predio_id) {
        Predio predioSalvo = predioService.buscarPredioPorId(predio_id);
        if (predioSalvo != null) {
            return new ResponseEntity<>(predioSalvo, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping(value = "/deletar")
    public ResponseEntity<?> deletar(@PathVariable Long predio_id){
        Predio predioSalvo = predioService.buscarPredioPorId(predio_id);
        if(predioSalvo != null){
            predioService.deletar(predio_id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/buscar/endereco/{endereco_id}")
    public ResponseEntity<?> buscarPorEndereco(@PathVariable Long endereco_id){
        List<Predio> predioList = predioService.buscarPorEndereco(endereco_id);
        if(!predioList.isEmpty()){
            return new ResponseEntity<>(predioList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
