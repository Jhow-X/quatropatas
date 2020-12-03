package com.cesar.quatropatas.projeto.ws.controller;

import com.cesar.quatropatas.projeto.ws.controller.model.Conta;
import com.cesar.quatropatas.projeto.ws.service.ContaService;
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
public class ContaController {
    
    @Autowired
    ContaService userService;
    
    @RequestMapping(method=RequestMethod.POST,value="/conta",
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    
    
    public ResponseEntity<Conta> cadastrar(@RequestBody Conta user){
        Conta passedUser = userService.cadastro(user);
        return new ResponseEntity<>(passedUser,HttpStatus.CREATED);
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/conta",
            produces=MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<Collection<Conta>> procurar(){
        Collection<Conta> usuariosBuscados = userService.busca();
        return new ResponseEntity<>(usuariosBuscados,HttpStatus.OK);
    }
    @RequestMapping(method=RequestMethod.DELETE,value="/conta/{id}")
    
    
    public ResponseEntity<Conta> deletarConta(@PathVariable Integer id){
        Conta finded = userService.buscaId(id);
        if(finded==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.excluir(finded);
        return new ResponseEntity<>(HttpStatus.OK);
        }
    @RequestMapping(method=RequestMethod.PUT,value="/conta",
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    
    
    public ResponseEntity<Conta> alterarSenha(@RequestBody Conta user){
        Conta senhaAlterada = userService.mudarSenha(user);
        return new ResponseEntity<>(senhaAlterada,HttpStatus.OK);
    }
}
