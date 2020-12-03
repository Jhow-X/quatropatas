
package com.cesar.quatropatas.projeto.ws.service;

import com.cesar.quatropatas.projeto.ws.controller.model.Animal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author Quatro patas
 */

@Service
public class AnimalService {
    
    Map<Integer,Animal> animais = new HashMap<>();
    Integer tempId =1;
    
    public Animal cadastro(Animal animal){
        
        animal.setId(tempId);
        tempId++;
        animais.put(animal.getId(),animal);
        return animal;
    }
    public Collection<Animal> busca(){
        return animais.values();
    }
    
    public void excluir(Animal animal){
        animais.remove(animal.getId());
    }
    
    public Animal buscaId(Integer id){
        return animais.get(id);
    }

}
