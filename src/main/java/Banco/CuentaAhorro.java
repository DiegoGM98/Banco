package Banco;

class CuentaAhorro extends CuentaBancaria {
    private double tasaReajusteAnual;

    public CuentaAhorro(String numeroCuenta, String fechaApertura, double saldo, Cliente cliente, double tasaReajusteAnual) {
        super(numeroCuenta, fechaApertura, saldo, cliente);
        this.tasaReajusteAnual = tasaReajusteAnual;
    }

    public double getTasaReajusteAnual() {
        return tasaReajusteAnual;
    }

    public void reajustarSaldo() {
        double nuevoSaldo = getSaldo() * (1 + tasaReajusteAnual / 100);
        depositar(nuevoSaldo - getSaldo()); // Modificamos el saldo mediante un depósito
    }

    @Override
    public void retirar(double monto) {
        System.out.println("Los retiros no están permitidos en cuentas de ahorro.");
    }

    @Override
    public String toString() {
        return "CuentaAhorro{" +
                "tasaReajusteAnual=" + tasaReajusteAnual +
                "} " + super.toString();
    }
}
