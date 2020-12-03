
package com.cesar.quatropatas.projeto.ws.controller;

import com.cesar.quatropatas.projeto.ws.controller.model.Animal;
import com.cesar.quatropatas.projeto.ws.service.AnimalService;
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
public class AnimalController {
    
    @Autowired
    AnimalService animalService;
    
    @RequestMapping(method=RequestMethod.POST,value="/animal",
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    
    
    public ResponseEntity<Animal> registrar(@RequestBody Animal animal){
        Animal passedUser = animalService.cadastro(animal);
        return new ResponseEntity<>(passedUser,HttpStatus.CREATED);
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/animal",
            produces=MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<Collection<Animal>> procurar(){
        Collection<Animal> animaisBuscados = animalService.busca();
        return new ResponseEntity<>(animaisBuscados,HttpStatus.OK);
    }
    @RequestMapping(method=RequestMethod.DELETE,value="/animal/{id}")
    
    
    public ResponseEntity<Animal> deletarAnimal(@PathVariable Integer id){
        Animal finded = animalService.buscaId(id);
        if(finded==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        animalService.excluir(finded);
        return new ResponseEntity<>(HttpStatus.OK);
        }
}
