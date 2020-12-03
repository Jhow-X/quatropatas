
package com.cesar.quatropatas.projeto.ws.service;

import com.cesar.quatropatas.projeto.ws.controller.model.Ong;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author Quatro patas
 */

@Service
public class OngService {
    Map<Integer,Ong> ongs = new HashMap<>();
    Integer tempId =1;
    
    public Ong cadastro(Ong ong){
        
        ong.setId(tempId);
        tempId++;
        ongs.put(ong.getId(),ong);
        return ong;
    }
    public Collection<Ong> busca(){
        return ongs.values();
    }
    
    public void excluir(Ong ong){
        ongs.remove(ong.getId());
    }
    
    public Ong buscaId(Integer id){
        return ongs.get(id);
    }

}
