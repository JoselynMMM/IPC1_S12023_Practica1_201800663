package com.mycompany.rentavehiculosbytecar;

import java.util.InputMismatchException;
import java.util.Scanner;


public class RentaVehiculosByteCar {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        
        boolean salir = false;
        int opcion;
        
        while(!salir){
            
            System.out.println ("************Iniciar sesion************");
            System.out.println ("1.Ingrasar como Administrador");
            System.out.println ("2.Ingrasar como Cliente");
            System.out.println ("3.Salir");
            
            try{
                
                System.out.println ("Elegir sesion: ");
                 opcion = sn.nextInt();
                 
                  switch (opcion){
                       case 1:
                                inicioSesion sesion = new inicioSesion();
                                sesion.metodoSesion();
                             break;


                        case 2:
                                menuCliente cliente = new menuCliente();
                                 cliente.metodoCliente();
                             break;
                        case 3:
                             salir=true;
                             break;
                        default:
                             System.out.println("Las opciones son 1, 2 o 3.");
                 
                    }
                
               
           
            }catch(InputMismatchException e){
                System.out.println("Debes introducir un numero.");
                   sn.next();
                
            }
            
            
        }
        
        sn.close();
    }
}
