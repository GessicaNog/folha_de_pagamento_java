package com.mycompany.desenvolvimento_atividade5;

public class Funcionario {

    private String nome;
    private Departamento departamento;
    private float horasTrabalhadas;

    public Funcionario(String nome, int numeroDepartamento, float horasTrabalhadas) {
        this.setNome(nome);
        this.setDepartamento(new Departamento(numeroDepartamento));
        this.setHorasTrabalhadas(horasTrabalhadas);
    }

    public float getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(float valor) {
        if (valor >= 0) {
            this.horasTrabalhadas = valor;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String valor) {
        if (!valor.isEmpty()) {
            this.nome = valor;
        }
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento valor) {
        if (valor.numero == 1 || valor.numero == 2) {
            this.departamento = valor;
        }
    }
}
