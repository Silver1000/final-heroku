/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.finalheroku;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class ControladorMensajes {
    @Autowired RepositorioMensajito repoMensa;//conecta repositorios
    //Buscar todos
    @CrossOrigin
    @RequestMapping(value="/mensajito",
            method=RequestMethod.GET,headers=("Accept=application/json"))
    public ArrayList<Mensajito> hola(){
    //Mensajito mensa=new Mensajito ("hola","Me asustan los temblores!");
    //return mensa;
   //Regresa informacion de la base de datos al destinatario 
    return (ArrayList<Mensajito>)repoMensa.findAll();
    }
    //Buscar por id
    @CrossOrigin
    @RequestMapping(value="/mensajito/{id}",
            method=RequestMethod.GET,headers=("Accept=application/json"))
    public Mensajito hola(@PathVariable String id){
    return repoMensa.findOne(id);
    }
    
    //Actualizar
    //Envia informacion del destinario a la base de datos 
    @CrossOrigin
    @RequestMapping(value="/mensajito/{id}/{titulo}/{cuerpo}"/*direccion de url*/, method=RequestMethod.PUT,
            headers={"Accept=application/json"})
    public Estatus actualizar(@PathVariable String id,@PathVariable String titulo,@PathVariable/*Variable de ruta*/ String cuerpo){
    repoMensa.save(new Mensajito(id,titulo,cuerpo));
    return new Estatus (true,"Actualizado con exito");
    }
    //Guardar
    @CrossOrigin
    @RequestMapping(value="/mensajito/{titulo}/{cuerpo}"/*direccion de url*/, method=RequestMethod.POST,
            headers={"Accept=application/json"})
    public Estatus guardar(@PathVariable String titulo,@PathVariable/*Variable de ruta*/ String cuerpo){
    repoMensa.save(new Mensajito(titulo,cuerpo));
    return new Estatus (true,"Guardado con exito");
    }
    
    //Borrar
    @CrossOrigin
    @RequestMapping(value="/mensajito/(id)", method =RequestMethod.DELETE,
            headers={"Accept=application/json"})
    public Estatus borrarMensaje(@PathVariable String id){
    Estatus estatus=new Estatus (true,"Borrado con exito");
    repoMensa.delete(new Mensajito(id));
    return estatus;
    }
    
}
