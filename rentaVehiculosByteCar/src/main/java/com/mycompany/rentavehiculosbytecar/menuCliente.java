
package com.mycompany.rentavehiculosbytecar;

import java.util.Scanner;


public class menuCliente extends RentaVehiculosByteCar{
    static Cliente[] clientes = new Cliente[100]; // Tamaño máximo de clientes
    static int cantidadClientes = 0; // Cantidad actual de clientes registrados

    
    
    public void metodoCliente() {
        
        Scanner sn = new Scanner(System.in);

        while (true) {
            System.out.println("***************Cliente***************");
            System.out.println("Menú Principal:");
            System.out.println("1.Registrarse");
            System.out.println("2.Iniciar sesión");
            System.out.println("3.Realizar reservas");
            System.out.println("4.Cerrar sesión");

            System.out.print("Seleccione una opción: ");
            int opcion = sn.nextInt();
            sn.nextLine(); // Consumir la nueva línea después de leer el número

            switch (opcion) {
                case 1:
                    registrarse();
                    break;
                case 2:
                   iniciarSesion();
                    break;
                case 3:
                    reserva();
                    break;
                case 4:
                     System.out.println("Saliendo del programa...");
                    System.exit(0);
                    return;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }


    public static void registrarse() {
            Scanner sn = new Scanner(System.in);

            System.out.println("Registrarse:");
            System.out.print("Nombre: ");
            String nombre = sn.nextLine();

            System.out.print("Apellido: ");
            String apellido = sn.nextLine();

            System.out.print("NIT: ");
            String nit = sn.next();
            sn.nextLine(); // Consumir la nueva línea después de leer el NIT
            
            // Verificar longitud del NIT
            if (nit.length() >= 9) {
                System.out.println("El NIT debe ser menor de 9 dígitos.");
                return;
            }

            // Verificar si el NIT ya está registrado
            if (nitExistente(nit)) {
                System.out.println("Ya existe un usuario con el mismo NIT.");
                return;
            }

            Cliente nuevoCliente = new Cliente(nombre, apellido, nit);
            clientes[cantidadClientes] = nuevoCliente;
            cantidadClientes++;

            System.out.println("Cliente registrado exitosamente.");

            // Preguntar si desea salir o continuar registrando
            System.out.print("¿Desea salir? (si/no): ");
            String respuesta = sn.next();
            sn.nextLine(); // Consumir la nueva línea después de leer la respuesta

            if (respuesta.equalsIgnoreCase("si")) {
                return; // Salir del registro
            }
        }

        public static boolean nitExistente(String nit) {
            for (int i = 0; i < cantidadClientes; i++) {
                if (clientes[i] != null && clientes[i].getNit().equals(nit)) {
                    return true;
                }
            }
            return false;
        }

    private void iniciarSesion() {
         Scanner sn = new Scanner(System.in);
         

            System.out.println("Iniciar Sesión:");
            System.out.print("NIT: ");
            String nit = sn.next();
            sn.nextLine(); // Consumir la nueva línea después de leer el NIT

            Cliente clienteEncontrado = buscarClientePorNit(nit);

            if (clienteEncontrado != null) {
                System.out.println("Iniciando sesión como " + clienteEncontrado.getNombre() + " " + clienteEncontrado.getApellido());
            } else {
                System.out.println("No se encontró ningún usuario con el NIT ingresado.");
                System.out.print("¿Desea registrarse? (si/no): ");
                String respuesta = sn.next();
                sn.nextLine(); // Consumir la nueva línea después de leer la respuesta

                if (respuesta.equalsIgnoreCase("si")) {
                    registrarse();
                }
        

        while (true) {
            System.out.println("***************Cliente***************");
            System.out.println("Menú Principal:");
            System.out.println("1.Realizar reservas");
            System.out.println("2.Cerrar sesión");

            System.out.print("Seleccione una opción: ");
            int opcion = sn.nextInt();
            sn.nextLine(); // Consumir la nueva línea después de leer el número

            switch (opcion) {
                case 1:
                    reserva();
                    break;
               
                case 2:
                     System.out.println("Saliendo del programa...");
                    System.exit(0);
                    return;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
        
    }
    }       

    private void reserva() {
        inicioSesion datos = new inicioSesion();
        datos.metodoSesion();
        
        
        System.out.println("*************************Vehiculos disponibles************************");
        System.out.println(" ");
        System.out.println("***********Descuentos aplicados segun dias de arrendamiento***********");
    }

    private Cliente buscarClientePorNit(String nit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }
    

    class Cliente {
        private String nombre;
        private String apellido;
        private String nit;

        public Cliente(String nombre, String apellido, String nit) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.nit = nit;
        }

        public String getNit() {
            return nit;
        }

        String getNombre() {
            return nombre;    
        }

        String getApellido() {
            return apellido;
        }
        
    }
    
    

