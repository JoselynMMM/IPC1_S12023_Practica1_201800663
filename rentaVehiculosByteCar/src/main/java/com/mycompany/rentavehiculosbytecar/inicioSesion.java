/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentavehiculosbytecar;

import java.util.Scanner;

/**
 *
 * @author Joselyn Mendoza
 */
public class inicioSesion extends RentaVehiculosByteCar{
    
    static Vehiculo[] inventario = new Vehiculo[100]; // Tamaño máximo del inventario
    static int cantidadVehiculos = 0;
    static int diasMinimoDescuento = 0; // Número de días mínimo para aplicar el descuento
    static int porcentajeDescuento = 0; // Porcentaje de descuento
    
    void metodoSesion() {
        Scanner sn = new Scanner(System.in);

                String usuarioValido = "admin_201800663";
                String contraseñaValida = "201800663";
                
                boolean inicioSesionExitoso = false;

                while (!inicioSesionExitoso) {
                    System.out.println("***************Administrador***************");
                   System.out.print("Ingrese el nombre de usuario: ");
                    String usuarioIngresado = sn.nextLine();

                    if (usuarioIngresado.equals(usuarioValido)) {
                        System.out.print("Ingrese la contraseña: ");
                        String contraseñaIngresada = sn.nextLine();

                        if (contraseñaIngresada.equals(contraseñaValida)) {
                            System.out.println("Inicio de sesión exitoso");
                            inicioSesionExitoso = true;
                        } else {
                            System.out.println("Contraseña incorrecta");
                        }
                    } else {
                        System.out.println("Usuario incorrecto");
                    } 
                }
                
                while (true) {
                    System.out.println("*****************Administrador******************");
                    System.out.println("*****************Menú Principal*****************");
                    System.out.println("1. Agregar nuevos vehículos al inventario");
                    System.out.println("2. Agregar descuentos especiales");
                    System.out.println("3. Realizar reportes");
                    System.out.println("4. Mostrar usuarios");
                    System.out.println("5. Cerrar sesión");

                    System.out.print("Seleccione una opción: ");
                    int opcion = sn.nextInt();
                    sn.nextLine(); // Consumir la nueva línea después de leer el número

                    switch (opcion) {
                        case 1:
                            agregarVehiculos();
                            break;
                        case 2:
                            agregarDescuentos();
                            break;
                        case 3:
                            realizarReportes();
                            break;
                        case 4:
                            mostrarUsuarios();
                            break;
                        case 5:
                            System.out.println("Saliendo del programa...");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Opción no válida. Inténtelo de nuevo.");
                    }
                }
            }

        private void agregarVehiculos(){
        
            Scanner sn = new Scanner(System.in);
        
        
            System.out.println("*****************Agregar Vehiculos*****************");
            

            while (true) {
                System.out.println("Ingrese los datos del vehículo:");
                System.out.print("Marca: ");
                String marca = sn.nextLine();

                System.out.print("Línea: ");
                String linea = sn.nextLine();

                System.out.print("Modelo: ");
                int modelo = sn.nextInt();
                sn.nextLine();

                System.out.print("Placa: ");
                String placa = sn.nextLine();

                // Verificar si la placa ya existe
                if (placaExistente(placa)) {
                    System.out.println("La placa ya existe en el sistema.");
                    continue; // Reiniciar el ciclo para ingresar datos nuevamente
                }

                System.out.print("Costo por día de alquiler (en quetzales): ");
                double costoPorDia = sn.nextDouble();

                // Verificar costo válido
                if (costoPorDia <= 0) {
                    System.out.println("El costo debe ser mayor a 0.");
                    continue; // Reiniciar el ciclo para ingresar datos nuevamente
                }

                Vehiculo nuevoVehiculo = new Vehiculo(marca, linea, modelo, placa, costoPorDia);
                inventario[cantidadVehiculos] = nuevoVehiculo;
                cantidadVehiculos++;

                System.out.println("Vehículo agregado exitosamente.");

                // Preguntar si desea guardar otro vehículo o salir
                System.out.print("¿Desea agregar otro vehículo? (si/no): ");
                String respuesta = sn.next();
                sn.nextLine(); // Consumir la nueva línea después de leer la respuesta

                if (respuesta.equalsIgnoreCase("no")) {
                    break; // Salir del ciclo de agregar vehículos
                }
            }
        }

        public static boolean placaExistente(String placa) {
            for (int i = 0; i < cantidadVehiculos; i++) {
                if (inventario[i] != null && inventario[i].getPlaca().equals(placa)) {
                    return true;
                }
            }
            return false;
        }

    private void agregarDescuentos() {
        Scanner sn = new Scanner(System.in);
        
        System.out.println("*****************Agregar descuentos especiales /n"
                + " según la cantidad de días que se arrende un\n" +
"vehículo*****************");

        while (true) {
            System.out.print("Ingrese el número de días mínimo de alquiler: ");
            int minimoDias = sn.nextInt();

            if (minimoDias <= 0) {
                System.out.println("El número de días debe ser mayor a 0.");
                continue; // Reiniciar el ciclo para ingresar datos nuevamente
            }

            System.out.print("Ingrese el porcentaje de descuento: ");
            int descuento = sn.nextInt();

            if (descuento <= 0 || descuento >= 100) {
                System.out.println("El porcentaje de descuento debe estar entre 0 y 100.");
                continue; // Reiniciar el ciclo para ingresar datos nuevamente
            }

            // Aplicar el descuento solo si es el mayor descuento hasta ahora
            if (minimoDias > diasMinimoDescuento) {
                diasMinimoDescuento = minimoDias;
                porcentajeDescuento = descuento;
                System.out.println("Descuento aplicado exitosamente.");
            } else {
                System.out.println("El descuento no es mayor que el descuento actual.");
            }

            // Preguntar si desea agregar otro descuento o salir
            System.out.print("¿Desea agregar otro descuento? (si/no): ");
            String respuesta = sn.next();
            sn.nextLine(); // Consumir la nueva línea después de leer la respuesta

            if (respuesta.equalsIgnoreCase("no")) {
                break; // Salir del ciclo de agregar descuentos
            }
        }
    
        
    }

    private void realizarReportes() {
        System.out.println("***************Realizar reporte***************");
        
    }

    private void mostrarUsuarios() {
        System.out.println("***************Mostrar usuarios***************");
    }

   
    }

    class Vehiculo {
        private String marca;
        private String linea;
        private int modelo;
        private String placa;
        private double costoPorDia;

        public Vehiculo(String marca, String linea, int modelo, String placa, double costoPorDia) {
            this.marca = marca;
            this.linea = linea;
            this.modelo = modelo;
            this.placa = placa;
            this.costoPorDia = costoPorDia;
        }

        public String getPlaca() {
            return placa;
        }
    
       
         
    

}
