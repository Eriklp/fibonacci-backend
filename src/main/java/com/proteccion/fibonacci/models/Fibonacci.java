package com.proteccion.fibonacci.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

public class Fibonacci {
    private int[] serie;
    private String status;

    @Autowired
    private JavaMailSender mailSender;

    public void calculateFibonacci(int x, int y, int n){
        serie = new int[n + 2];
        serie[0] = x;
        serie[1] = y;

        for (int i = 2; i < serie.length; i++) {
            serie[i] = serie[i - 1] + serie[i - 2];
        }
        setSerie(serie);

        String serieMessage = "La serie fibonacci para las semillas "+x+" y "+y+" con cantindad de "+n+" numeros es: "+serie;
        senEmail("didier.correa@proteccion.com.co", "Prueba tecnica - Erik Lopez", serieMessage);
    }

    public void setSerie(int[] ser){
        this.serie = ser;
    }

    public int[] getFibonacci(){
        return this.serie;
    }
    public void setStatus( String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }

    public Fibonacci(){
        //setSerie(int[] serie);
        setStatus("pending");
    }

    private void senEmail(String destiny, String title, String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(destiny);
        message.setSubject(title);
        message.setText(content);
        mailSender.send(message);
    }
    }