
package com.cesar.quatropatas.projeto.ws.service;

import com.cesar.quatropatas.projeto.ws.controller.model.Conta;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author Quatro patas
 */

@Service
public class ContaService {
        
    Map<Integer,Conta> usuarios = new HashMap<>();
    Integer tempId =1;
    
    public Conta cadastro(Conta user){
        
        user.setId(tempId);
        tempId++;
        usuarios.put(user.getId(),user);
        return user;
    }
    public Collection<Conta> busca(){
        return usuarios.values();
    }
    
    public void excluir(Conta user){
        usuarios.remove(user.getId());
    }
    
    public Conta buscaId(Integer id){
        return usuarios.get(id);
    }
    
    public Conta mudarSenha(Conta user){
        return usuarios.put(user.getId(), user);
    }
}
