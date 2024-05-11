package Banco;

abstract class CuentaBancaria {
    private String numeroCuenta;
    private String fechaApertura;
    private double saldo;
    private Cliente cliente;

    public CuentaBancaria(String numeroCuenta, String fechaApertura, double saldo, Cliente cliente) {
        this.numeroCuenta = numeroCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.cliente = cliente;
        cliente.agregarCuenta(this); // Agregar la cuenta al cliente
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public abstract void retirar(double monto);

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", fechaApertura='" + fechaApertura + '\'' +
                ", saldo=" + saldo +
                ", cliente=" + cliente.getNombre() +
                '}';
    }
}
