/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.quatropatas.projeto.ws.service;

import com.cesar.quatropatas.projeto.ws.controller.model.Campanha;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author João Carlos
 */

@Service
public class CampanhaService {
    Map<Integer,Campanha> campanhas = new HashMap<>();
    Integer tempId =1;
    
    public Campanha cadastro(Campanha campanha){
        
        campanha.setId(tempId);
        tempId++;
        campanhas.put(campanha.getId(),campanha);
        return campanha;
    }
    public Collection<Campanha> busca(){
        return campanhas.values();
    }
    
    public void excluir(Campanha campanha){
        campanhas.remove(campanha.getId());
    }
    
    public Campanha buscaId(Integer id){
        return campanhas.get(id);
    }

}
