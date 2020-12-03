package com.cesar.quatropatas.projeto.ws.controller;

import com.cesar.quatropatas.projeto.ws.controller.model.Campanha;
import com.cesar.quatropatas.projeto.ws.service.CampanhaService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author João Carlos
 */

@RestController
public class CampanhaController {
    @Autowired
    CampanhaService campanhaService;
    
    @RequestMapping(method=RequestMethod.POST,value="/campanha",
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    
    
    public ResponseEntity<Campanha> criar(@RequestBody Campanha campanha){
        Campanha passedUser = campanhaService.cadastro(campanha);
        return new ResponseEntity<>(passedUser,HttpStatus.CREATED);
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/campanha",
            produces=MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<Collection<Campanha>> procurar(){
        Collection<Campanha> campanhasBuscadas = campanhaService.busca();
        return new ResponseEntity<>(campanhasBuscadas,HttpStatus.OK);
    }
    @RequestMapping(method=RequestMethod.DELETE,value="/campanha/{id}")
    
    
    public ResponseEntity<Campanha> deletarCampanha(@PathVariable Integer id){
        Campanha finded = campanhaService.buscaId(id);
        if(finded==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        campanhaService.excluir(finded);
        return new ResponseEntity<>(HttpStatus.OK);
        }
}
