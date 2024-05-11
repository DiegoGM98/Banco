package Banco;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class SucursalBancaria {
    private String codigoSucursal;
    private String codigoPostal;
    private List<CuentaAhorro> cuentasAhorro;
    private List<CuentaCorriente> cuentasCorriente;

    public SucursalBancaria(String codigoSucursal, String codigoPostal) {
        this.codigoSucursal = codigoSucursal;
        this.codigoPostal = codigoPostal;
        this.cuentasAhorro = new ArrayList<>();
        this.cuentasCorriente = new ArrayList<>();
    }

    public String getCodigoSucursal() {
        return codigoSucursal;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public List<CuentaAhorro> getCuentasAhorro() {
        return cuentasAhorro;
    }

    public List<CuentaCorriente> getCuentasCorriente() {
        return cuentasCorriente;
    }

    public void agregarCuentaAhorro(CuentaAhorro cuenta) {
        cuentasAhorro.add(cuenta);
    }

    public void agregarCuentaCorriente(CuentaCorriente cuenta) {
        cuentasCorriente.add(cuenta);
    }

    @Override
    public String toString() {
        return "SucursalBancaria{" +
                "codigoSucursal='" + codigoSucursal + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", cuentasAhorro=" + cuentasAhorro +
                ", cuentasCorriente=" + cuentasCorriente +
                '}';
    }
}
