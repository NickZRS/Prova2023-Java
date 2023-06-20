package com.fatec.empresas.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.empresas.entities.Empresas;
import com.fatec.empresas.services.EmpresasService;

@CrossOrigin
@RequestMapping("empresas")
@RestController
public class EmpresasController {

    @Autowired
    private EmpresasService empresasService;

    @GetMapping("{id}")
    public ResponseEntity<Empresas> getEmpresas(@PathVariable int id) {
        Empresas empresas = empresasService.getEmpresasById(id);
        return ResponseEntity.ok().body(empresas);
    }

    @GetMapping
    public ResponseEntity<List<Empresas>> getClients() {
        List<Empresas> empresas = empresasService.getEmpresas();
        return ResponseEntity.ok().body(empresas);
    }

    @PostMapping
    public ResponseEntity<Empresas> saveClient(@RequestBody Empresas empresas) {
        Empresas newEmpresas = empresasService.save(empresas);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{​​id}​​")
                .buildAndExpand(empresas.getId())
                .toUri();

        return ResponseEntity.created(location).body(newEmpresas);
    }

}
