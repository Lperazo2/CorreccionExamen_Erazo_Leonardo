package test;

import dominio.JubiladoDiscapacidad;
import dominio.JubiladoVejez;
import dominio.Jubilado;
import dominio.JubiladoPatron;
import java.util.ArrayList;
import java.util.Scanner;

public class TestJubilado {

    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Jubilado> jubilados = new ArrayList<>();

    public static void main(String[] args) {
        int op = 0;
        String cedula, nombres, enter;
        int anios;
        do {
            op = menu(op);
            if (op != 5 && op != 4) {
                entrada.nextLine();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.print("Ingrese Cedula: ");
                cedula = entrada.nextLine();
                System.out.print("Ingrese Nombres: ");
                nombres = entrada.nextLine();
                System.out.print("Anios Aporte:  ");
                anios = entrada.nextInt();
                datos(op, cedula, nombres, anios);

            }
            if (op == 4) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("--------- JUBILADO VEJES ----------");
                System.out.println("C.I:    NOMBRE:  AÑOS APORTE:   PENSION INICIAL:   PENSION FINAL: ");
                for (Jubilado jub : jubilados) {
                    jub.calculaPensioni();
                    jub.calcularPension();
                    if (jub instanceof JubiladoVejez) {
                        System.out.println(jub);
                    }
                }
                System.out.println("\n\n------ JUBILADO DISCAPACIDAD ------");
                System.out.println("C.I:   NOMBRE:   AÑOS APORTE:   PENSION INICIAL:  %DISCAPACIDAD:    PENSION FINAL: ");
                for (Jubilado jub : jubilados) {
                    jub.calculaPensioni();
                    jub.calcularPension();
                    if (jub instanceof JubiladoDiscapacidad) {
                        System.out.println(jub);
                    }
                }
                System.out.println("\n\n--------- JUBILADO PATRON ---------");
                System.out.println("C.I:   NOMBRE:   AÑOS APORTE:   PENSION INICIAL:   TIPO:   PENSION FINAL: ");
                for (Jubilado jub : jubilados) {
                    jub.calculaPensioni();
                    jub.calcularPension();
                    if (jub instanceof JubiladoPatron) {
                        ((JubiladoPatron) jub).bonoSueldo();
                        System.out.println(jub);
                    }
                }
                System.out.println("\n\nVolver al menu << C >>");
                enter = entrada.next();
            }
        } while (op != 5);
    }

    public static int menu(int op) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("----------------- MENU JUBILADO -----------------");
        System.out.print("1. Vejez\n2. Invalidez\n3. Patronal\n4. Reporte\n5. Salir\n\nEscoja una Opcion. -->  ");
        op = entrada.nextInt();
        return op;
    }

    public static void datos(int op, String cedula, String nombres, int anios) {
        double porcentaje;
        int tipo;
        switch (op) {
            case 1:
                jubilados.add(new JubiladoVejez(cedula, nombres, anios));
                break;
            case 2:
                System.out.print("Porcentaje de discapacidad:  ");
                porcentaje = entrada.nextDouble();
                jubilados.add(new JubiladoDiscapacidad(cedula, nombres, anios, porcentaje));
                break;
            case 3:
                System.out.print("Porcentaje de Inflacion:  ");
                porcentaje = entrada.nextDouble();
                System.out.print("Tipo Empresa <<1>> Publica <<2>> Privada: ");
                tipo = entrada.nextInt();
                jubilados.add(new JubiladoPatron(cedula, nombres, anios, porcentaje, tipo));
        }
    }
}
