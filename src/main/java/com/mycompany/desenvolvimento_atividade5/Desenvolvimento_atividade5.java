package com.mycompany.desenvolvimento_atividade5;

import java.text.NumberFormat;
import java.util.Scanner;

public class Desenvolvimento_atividade5 {

    static int PLANO_SAUDE = 20;

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Funcionario funcionarios[] = new Funcionario[5];

        for (int i = 0; i < funcionarios.length; i++) {
            System.out.println("Cadastro de um novo funcionario");
            System.out.println("Informe o nome:");
            String nome = ler.nextLine();
            System.out.println("Informe o departamento(1 ou 2):");
            int numeroDepartamento = ler.nextInt();
            ler.nextLine();
            System.out.println("Informe as horas trabalhadas:");
            float horasTrabalhadas = ler.nextFloat();
            ler.nextLine();
            Funcionario funcionario1 = new Funcionario(nome, numeroDepartamento, horasTrabalhadas);
            System.out.println("Funcionario: " + funcionario1.getNome());
            System.out.println("Departamento: " + funcionario1.getDepartamento().numero);
            System.out.println("Horas Trabalhadas: " + funcionario1.getHorasTrabalhadas());

            funcionarios[i] = funcionario1;
        }

        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%5s %10s %10s %10s %10s %10s %10s %10s %10s %10s", "Ordem", "Nome", "Salario Base", "Hora Extra", "Insalubridade", "Bonificacao", "INSS", "IR", "Plano de saude", "Salario Liquido");
        System.out.println();
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < funcionarios.length; i++) {
            Funcionario funcionario = funcionarios[i];
            System.out.format("%5d %10s %10s %10s %10s %10s %10s %10s %10s %10s", i + 1, funcionario.getNome(), calculaSalario(funcionario),
                    horasExtras(funcionario), insalubridade(funcionario), bonificacao(funcionario), NumberFormat.getCurrencyInstance().format(INSS(funcionario)),
                    NumberFormat.getCurrencyInstance().format(impostoRenda(funcionario)), PLANO_SAUDE, NumberFormat.getCurrencyInstance().format(salarioLiquido(funcionario)));
            System.out.println();
        }
        System.out.println(
                "-----------------------------------------------------------------------------");

    }

    public static float calculaSalario(Funcionario funcionario) {
        return funcionario.getHorasTrabalhadas() * funcionario.getDepartamento().getVHora();

    }

    public static float horasExtras(Funcionario funcionario) {
        if (funcionario.getHorasTrabalhadas() > 40) {
            return funcionario.getDepartamento().getVHora() * 2 * (funcionario.getHorasTrabalhadas() - 40);

        } else {
            return 0;
        }
    }

    public static double insalubridade(Funcionario funcionario) {
        if (funcionario.getDepartamento().numero == 2) {
            return calculaSalario(funcionario) * 0.15;
        } else {
            return 0;
        }
    }

    public static double bonificacao(Funcionario funcionario) {
        if (funcionario.getDepartamento().numero == 1) {
            float salario = calculaSalario(funcionario);
            if (funcionario.getHorasTrabalhadas() > 20 && funcionario.getHorasTrabalhadas() <= 30) {
                return salario * 0.03;
            } else if (funcionario.getHorasTrabalhadas() > 30 && funcionario.getHorasTrabalhadas() < 40) {
                return salario * 0.05;
            } else if (funcionario.getHorasTrabalhadas() >= 40) {
                return salario * 0.10;
            }
            return 0;
        } else {
            return 0;
        }
    }

    public static double salarioBruto(Funcionario funcionario) {
        return calculaSalario(funcionario) + insalubridade(funcionario) + bonificacao(funcionario) + horasExtras(funcionario);
    }

    public static double INSS(Funcionario funcionario) {
        return salarioBruto(funcionario) * 0.07;
    }

    public static double impostoRenda(Funcionario funcionario) {
        return salarioBruto(funcionario) * 0.12;
    }

    public static double salarioLiquido(Funcionario funcionario) {
        return salarioBruto(funcionario) - INSS(funcionario) - impostoRenda(funcionario) - PLANO_SAUDE;
    }
}
