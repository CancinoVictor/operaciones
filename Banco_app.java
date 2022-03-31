package Banco;

/**
 *
 * @author Cancino
 */

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import Banco.Cuenta;

public class Banco_app {

    static final long TAM_REG = 116;
    static int contador = 0;

    public static void escribeArchivo(Cuenta c) {
        contador = contador + 1;
        try {
            RandomAccessFile rf = new RandomAccessFile("CuentasN.dat", "rw");
            rf.seek(TAM_REG * c.obtenerNumero());
            rf.writeLong(c.obtenerNumero());
            rf.writeUTF(c.obtenerNombre());
            rf.writeDouble(c.obtenerSaldo());
            rf.close();

        } catch (FileNotFoundException e) {

            System.out.println("El archivo no se encuentro" + e.toString());
        } catch (IOException ex) {
        }

    }

    public static Cuenta capturarDatos() {

        Scanner s = new Scanner(System.in);
        String nombre;
        long nc;
        double saldo;
        System.out.println("Nombre: ");
        nombre = s.nextLine();
        System.out.println("Numero de Cuenta: ");
        nc = s.nextLong();
        System.out.println("Saldo Inical");
        saldo = s.nextDouble();
        Cuenta c = new Cuenta(nombre, nc, saldo);
        return c;

    }

    public static void consultarCuenta(long n) {
        try {
            RandomAccessFile rf = new RandomAccessFile("CuentasN.dat", "r");
            rf.seek(TAM_REG * n);

            try {
                long nc = rf.readLong();
                System.out.println("Numero de la Cuenta: " + nc);
                System.out.println("Nombre del Cuenta Ambiente: " + rf.readUTF());
                System.out.println("Saldo: " + rf.readDouble());

            } catch (EOFException ex1) {
                System.out.println("Fin del archivo");
                rf.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("" + e.toString());
        } catch (IOException ex) {

        }
    }

    public static void eliminarCuenta(long n1) {

    }

    public static void modificarCuenta(long n2) {
    }

    public static void leerArchivo() {
        for (int i = 1; i <= contador; i++) {
            try {
                RandomAccessFile rf = new RandomAccessFile("CuentasN.dat", "r");
                rf.seek(TAM_REG * i);

                try {
                    long nc = rf.readLong();
                    System.out.println("Numero de la Cuenta: " + nc);
                    System.out.println("Nombre del Cuenta Ambiente: " + rf.readUTF());
                    System.out.println("Saldo: " + rf.readDouble());

                } catch (EOFException ex1) {
                    System.out.println("Fin del archivo");
                    rf.close();
                }
            } catch (FileNotFoundException e) {
                System.out.println("" + e.toString());
            } catch (IOException ex) {

            }

        }
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int continuar, opc;
        do {

            System.out.println("...........Opciones.............");
            System.out.println("1....Crear una Cuenta");
            System.out.println("2....Consultar Cuenta");
            System.out.println("3....Eliminar Cuenta");
            System.out.println("4....Modificar Cuenta");
            System.out.println("5....Ver Todo el Archivo");
            System.out.println("0....Salir");
            opc = s.nextInt();
            switch (opc) {
                case 1:
                    Cuenta c = capturarDatos();
                    escribeArchivo(c);

                    break;
                case 2:
                    System.out.println("Numero de Cuenta que deseas consultar: ");
                    long n = s.nextLong();
                    consultarCuenta(n);
                    break;
                case 3:
                    System.out.println("Numero de Cuenta que deseas Eliminar: ");
                    long n1 = s.nextLong();
                    eliminarCuenta(n1);
                    break;
                case 4:
                    System.out.println("Numero de Cuenta que deseas Modificar: ");
                    long n2 = s.nextLong();
                    modificarCuenta(n2);
                    break;
                case 5:
                    System.out.println("Leer todo el Archivo");
                    leerArchivo();

                    break;
                case 0:
                    continuar = 0;
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;

            }
            System.out.println("Si desea continuar escriba cualquier numero");
            continuar = s.nextInt();
        } while (continuar != 0);

    }

}
