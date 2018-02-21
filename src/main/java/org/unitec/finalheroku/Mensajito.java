/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.finalheroku;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;

/**
 *
 * @author T-107
 */
public class Mensajito {
    @Id
    //Se cambio a string debido a angular
    private String id;
    private String titulo;
    private String Cuerpo;
    private LocalDate fecha;
    
    
public Mensajito(String id, String titulo, String Cuerpo) {
        this.id = id;
        this.titulo = titulo;
        this.Cuerpo = Cuerpo;
        fecha=LocalDate.now();
    }
    public Mensajito() {
    }
 public Mensajito(String id) {
        this.id = id;
      
    }
    public Mensajito(String titulo, String Cuerpo) {
        this.titulo = titulo;
        this.Cuerpo = Cuerpo;
        fecha=LocalDate.now();
    }

    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return Cuerpo;
    }

    public void setCuerpo(String Cuerpo) {
        this.Cuerpo = Cuerpo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
