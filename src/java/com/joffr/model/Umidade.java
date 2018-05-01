
package com.joffr.model;

/**
 *
 * @author joffr
 */
public class Umidade {
    private Integer id;
    private double valor;
    private String data, hora;

    public Umidade() {
    }

    public Umidade(Integer id, double valor, String data, String hora) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.hora = hora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
}
