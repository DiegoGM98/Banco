package Banco;

import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionBanco banco = new GestionBanco();

        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Agregar cuenta bancaria");
            System.out.println("3. Agregar sucursal");
            System.out.println("4. Ver cuentas de un cliente");
            System.out.println("5. Ver cuentas de ahorro de una sucursal");
            System.out.println("6. Ver cuentas corrientes de una sucursal");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de leer el número

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();
                    System.out.print("DNI del cliente: ");
                    String dniCliente = scanner.nextLine();
                    banco.agregarCliente(nombreCliente, dniCliente);
                    System.out.println("Cliente agregado correctamente.");
                    break;
                case 2:
                    System.out.print("Tipo de cuenta (ahorro/corriente): ");
                    String tipoCuenta = scanner.nextLine();
                    System.out.print("Número de cuenta: ");
                    String numeroCuenta = scanner.nextLine();
                    System.out.print("Fecha de apertura (dd/mm/aaaa): ");
                    String fechaApertura = scanner.nextLine();
                    System.out.print("Saldo inicial: ");
                    double saldoInicial = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea después de leer el saldo
                    System.out.print("DNI del cliente asociado: ");
                    String dniAsociado = scanner.nextLine();
                    if (tipoCuenta.equalsIgnoreCase("ahorro")) {
                        System.out.print("Tasa de reajuste anual (%): ");
                        double tasaReajuste = scanner.nextDouble();
                        scanner.nextLine(); // Consumir el salto de línea después de leer la tasa
                        banco.agregarCuentaBancaria("ahorro", numeroCuenta, fechaApertura, saldoInicial, dniAsociado, tasaReajuste);
                    } else if (tipoCuenta.equalsIgnoreCase("corriente")) {
                        System.out.print("Línea de sobregiro: ");
                        double lineaSobregiro = scanner.nextDouble();
                        scanner.nextLine(); // Consumir el salto de línea después de leer la línea de sobregiro
                        banco.agregarCuentaBancaria("corriente", numeroCuenta, fechaApertura, saldoInicial, dniAsociado, lineaSobregiro);
                    } else {
                        System.out.println("Tipo de cuenta no válido.");
                    }
                    System.out.println("Cuenta bancaria agregada correctamente.");
                    break;
                case 3:
                    System.out.print("Código de sucursal: ");
                    String codigoSucursal = scanner.nextLine();
                    System.out.print("Código postal: ");
                    String codigoPostal = scanner.nextLine();
                    banco.agregarSucursal(codigoSucursal, codigoPostal);
                    System.out.println("Sucursal agregada correctamente.");
                    break;
                case 4:
                    System.out.print("DNI del cliente: ");
                    String dniClienteBuscar = scanner.nextLine();
                    System.out.println("Cuentas del cliente:");
                    banco.obtenerCuentasCliente(dniClienteBuscar).forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("Código de la sucursal: ");
                    String codigoSucursalBuscarAhorro = scanner.nextLine();
                    System.out.println("Cuentas de ahorro de la sucursal:");
                    banco.obtenerCuentasAhorroSucursal(codigoSucursalBuscarAhorro).forEach(System.out::println);
                    break;
                case 6:
                    System.out.print("Código de la sucursal: ");
                    String codigoSucursalBuscarCorriente = scanner.nextLine();
                    System.out.println("Cuentas corrientes de la sucursal:");
                    banco.obtenerCuentasCorrienteSucursal(codigoSucursalBuscarCorriente).forEach(System.out::println);
                    break;
                case 7:
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
