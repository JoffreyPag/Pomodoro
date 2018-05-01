
package com.joffr.model;

/**
 *
 * @author joffr
 */
public class Umidade {
    private Integer id;
    private double valor;

    public Umidade() {
    }

    public Umidade(Integer id, double valor) {
        this.id = id;
        this.valor = valor;
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
    
    
}
