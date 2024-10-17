package org.example.fake;

public class Transacao {
    private double valor;
    private String tipo; // "DEPOSITO" ou "SAQUE"

    public Transacao(double valor, String tipo) {
        this.valor = valor;
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }
}