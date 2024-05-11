package Banco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionBanco {
    private Map<String, Cliente> clientes;
    private List<SucursalBancaria> sucursales;

    public GestionBanco() {
        this.clientes = new HashMap<>();
        this.sucursales = new ArrayList<>();
    }

    public void agregarCliente(String nombre, String dni) {
        clientes.put(dni, new Cliente(nombre, dni));
    }

    public void agregarCuentaBancaria(String tipoCuenta, String numeroCuenta, String fechaApertura, double saldo, String dniCliente, double parametroEspecifico) {
        Cliente cliente = clientes.get(dniCliente);
        if (cliente != null) {
            if (tipoCuenta.equalsIgnoreCase("ahorro")) {
                CuentaAhorro cuentaAhorro = new CuentaAhorro(numeroCuenta, fechaApertura, saldo, cliente, parametroEspecifico);
            } else if (tipoCuenta.equalsIgnoreCase("corriente")) {
                CuentaCorriente cuentaCorriente = new CuentaCorriente(numeroCuenta, fechaApertura, saldo, cliente, parametroEspecifico);
            } else {
                System.out.println("Tipo de cuenta no válido.");
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public void agregarSucursal(String codigoSucursal, String codigoPostal) {
        sucursales.add(new SucursalBancaria(codigoSucursal, codigoPostal));
    }

    public List<CuentaBancaria> obtenerCuentasCliente(String dniCliente) {
        Cliente cliente = clientes.get(dniCliente);
        if (cliente != null) {
            return cliente.getCuentas();
        } else {
            System.out.println("Cliente no encontrado.");
            return new ArrayList<>();
        }
    }

    public List<CuentaAhorro> obtenerCuentasAhorroSucursal(String codigoSucursal) {
        for (SucursalBancaria sucursal : sucursales) {
            if (sucursal.getCodigoSucursal().equals(codigoSucursal)) {
                return sucursal.getCuentasAhorro();
            }
        }
        System.out.println("Sucursal no encontrada.");
        return new ArrayList<>();
    }

    public List<CuentaCorriente> obtenerCuentasCorrienteSucursal(String codigoSucursal) {
        for (SucursalBancaria sucursal : sucursales) {
            if (sucursal.getCodigoSucursal().equals(codigoSucursal)) {
                return sucursal.getCuentasCorriente();
            }
        }
        System.out.println("Sucursal no encontrada.");
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        GestionBanco banco = new GestionBanco();

        // Agregamos clientes
        banco.agregarCliente("Juan Perez", "12345678A");
        banco.agregarCliente("Maria Lopez", "87654321B");

        // Agregamos cuentas bancarias
        banco.agregarCuentaBancaria("ahorro", "0001", "01/01/2022", 1000, "12345678A", 1.5); // Cuenta de Juan Perez
        banco.agregarCuentaBancaria("corriente", "0002", "01/01/2022", 2000, "12345678A", 500); // Otra cuenta de Juan Perez
        banco.agregarCuentaBancaria("corriente", "0003", "01/01/2022", 1500, "87654321B", 1000); // Cuenta de Maria Lopez

        // Agregamos sucursales
        banco.agregarSucursal("001", "28001");
        banco.agregarSucursal("002", "28002");

        // Visualizamos cuentas de un cliente
        System.out.println("Cuentas de Juan Perez:");
        banco.obtenerCuentasCliente("12345678A").forEach(System.out::println);

        // Obtenemos cuentas de ahorro de una sucursal
        System.out.println("\nCuentas de ahorro de la sucursal 001:");
        banco.obtenerCuentasAhorroSucursal("001").forEach(System.out::println);

        // Obtenemos cuentas corrientes de una sucursal
        System.out.println("\nCuentas corrientes de la sucursal 002:");
        banco.obtenerCuentasCorrienteSucursal("002").forEach(System.out::println);
    }
}