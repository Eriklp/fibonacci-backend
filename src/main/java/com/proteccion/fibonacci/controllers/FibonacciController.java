package com.proteccion.fibonacci.controllers;

import com.proteccion.fibonacci.models.Fibonacci;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.MediaType;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/fibonacci")
public class FibonacciController {
    @PostMapping("/generate")
    public Fibonacci fibonacci(@RequestParam("time") String time){
        Fibonacci fibonacci = new Fibonacci();
         try {
            LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm:ss"));
            int x = localTime.getMinute() / 10; // Primer semilla (X)
            int y = localTime.getMinute() % 10; // Segunda semilla (Y)
            int n = localTime.getSecond(); // Número de términos a generar

            fibonacci.calculateFibonacci(x, y, n);
            fibonacci.setStatus("Ok");
        }catch (Exception e) {
            fibonacci.setStatus(e+" Invalid time format. Please use HH:mm:ss.");
        }
        return fibonacci;
    }
}