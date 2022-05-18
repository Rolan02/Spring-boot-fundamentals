package com.fundamentos.spring.fundamentos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping //anotacion que nos sirve para aceptar todas las solicitudes dentro de este metodo
    @ResponseBody // responde un cuerpo a nivel del servicio
    public ResponseEntity<String> function(){
        return new ResponseEntity<>("Hello form controller", HttpStatus.OK);
    }
}
