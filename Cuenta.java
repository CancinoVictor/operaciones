package Banco;

/**
 *
 * @author Cancino
 */
public class Cuenta {

    private String nom;
    private long cuen;
    private double saldo;

    public Cuenta(String nom, long cuen, double saldo) {
        this.nom = nom;
        this.cuen = cuen;
        this.saldo = saldo;
    }

    public void depositar(double cantidad) {
        if (cantidad < 0) {
            saldo += cantidad;
        } else {
            System.out.println("Verifique la cantidad");
        }
    }

    public void retirar(double cantidad) {
        if (saldo > cantidad) {
            saldo -= cantidad;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public String obtenerNombre() {
        return nom;
    }

    public long obtenerNumero() {
        return cuen;
    }

    public double obtenerSaldo() {
        return saldo;
    }

    public String obtenerDatos() {
        return "NOMBRE: " + nom + "\nNUMERO DE CUENTA: " + cuen + "\nSALDO: " + saldo;
    }
}
