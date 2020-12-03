
package com.cesar.quatropatas.projeto.ws.controller;

import com.cesar.quatropatas.projeto.ws.controller.model.Ong;
import com.cesar.quatropatas.projeto.ws.service.OngService;
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
 * @author Quatro patas
 */

@RestController
public class OngController {
    @Autowired
    OngService ongService;
    
    @RequestMapping(method=RequestMethod.POST,value="/ong",
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
     
    public ResponseEntity<Ong> cadastrar(@RequestBody Ong ong){
        Ong passedUser = ongService.cadastro(ong);
        return new ResponseEntity<>(passedUser,HttpStatus.CREATED);
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/ong",
            produces=MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<Collection<Ong>> procurar(){
        Collection<Ong> usuariosBuscados = ongService.busca();
        return new ResponseEntity<>(usuariosBuscados,HttpStatus.OK);
    }
    @RequestMapping(method=RequestMethod.DELETE,value="/ong/{id}")
    
    
    public ResponseEntity<Ong> deletarOng(@PathVariable Integer id){
        Ong finded = ongService.buscaId(id);
        if(finded==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ongService.excluir(finded);
        return new ResponseEntity<>(HttpStatus.OK);
        }

}
