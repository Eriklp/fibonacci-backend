package com.proteccion.fibonacci.models;

public class Fibonacci {
    private int[] serie;
    private String status;

    public void calculateFibonacci(int x, int y, int n){
        serie = new int[n + 2];
        serie[0] = x;
        serie[1] = y;

        for (int i = 2; i < serie.length; i++) {
            serie[i] = serie[i - 1] + serie[i - 2];
        }
        setSerie(serie);
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
    }