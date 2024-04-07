package com.mycompany.desenvolvimento_atividade5;

public class Departamento {

    int numero;
    private float vHora;

    public Departamento(int numero) {
        this.numero = numero;
        switch (numero) {
            case 1 -> this.setVHora(22);
            case 2 -> this.setVHora(12);
            default -> System.out.println("Opçao inválida!!!");
        }

    }

    public float getVHora() {
        return vHora;
    }

    public void setVHora(float valor) {
        this.vHora = valor;
    }
}
