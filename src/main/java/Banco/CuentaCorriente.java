package Banco;

class CuentaCorriente extends CuentaBancaria {
    private double lineaSobregiro;

    public CuentaCorriente(String numeroCuenta, String fechaApertura, double saldo, Cliente cliente, double lineaSobregiro) {
        super(numeroCuenta, fechaApertura, saldo, cliente);
        this.lineaSobregiro = lineaSobregiro;
    }

    public double getLineaSobregiro() {
        return lineaSobregiro;
    }

    @Override
    public void retirar(double monto) {
        if (getSaldo() - monto >= -lineaSobregiro) {
            depositar(-monto); // Modificamos el saldo mediante un depósito
        } else {
            System.out.println("No se puede retirar. Sobregiro excedido.");
        }
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" +
                "lineaSobregiro=" + lineaSobregiro +
                "} " + super.toString();
    }
}