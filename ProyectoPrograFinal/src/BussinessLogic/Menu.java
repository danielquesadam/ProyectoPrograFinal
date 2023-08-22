package BussinessLogic;

import java.util.Scanner;

import Common.Cliente;
import Common.Mesa;

public class Menu {

    private Mesa[] vgArregloDeMesas = new Mesa[10];

    final String vgEstadoDisponible = "Disponible";

    final String vgEstadoReservada = "Reservada";

    public Menu() {

        inicializarMesas();

        login();

    }

    public void inicializarMesas() {
        for (int indice = 0; vgArregloDeMesas.length > indice; indice++) { 
            vgArregloDeMesas[indice] = new Mesa(indice + 1, 4); 
        }
    }

    public void login() {

        Scanner entrada = new Scanner(System.in);

        String vlUsuario = "";
        String vlClave = "";

        System.out.println("Por favor ingrese sus credenciales");
        System.out.println("Ingrese su usuario");
        vlUsuario = entrada.next();
        System.out.println("Por favor ingrese su contraseña");
        vlClave = entrada.next();

        Seguridad vlSeguridad = new Seguridad();

        Boolean vlResultado = vlSeguridad.buscarPorUsuarioClave(vlUsuario, vlClave);

        if (vlResultado) {
            System.out.println("Bienvenido!");
            MostrarOpciones();
        } else {
            System.out.println("Credenciales incorrectas!");

        }

        entrada.close();

    }

    public void MostrarOpciones() {

        Scanner entrada = new Scanner(System.in);

        int opcion = 0;

        do {

            System.out.println("=== Menú ===");
            System.out.println("1. Consulta de mesas disponibles");
            System.out.println("2. Reservar mesa");
            System.out.println("3. Consulta de mesas reservadas");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    getMesasPorEstado(vgEstadoDisponible);
                    break;
                case 2:

                    Cliente vlCliente = new Cliente();

                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = entrada.next();
                    System.out.print("Ingrese el apellido del cliente: ");
                    String apellido = entrada.next();
                    System.out.print("Ingrese la identificación del cliente: ");
                    String identificacion = entrada.next();
                    System.out.print("Ingrese el teléfono del cliente: ");
                    String telefono = entrada.next();
                    int vlNumeroMesa = 0;
                    System.out.print("Ingrese el número de mesa: ");
                    vlNumeroMesa = entrada.nextInt();
                    String vlFecha = "";
                    System.out.print("Ingrese la fecha: ");
                    vlFecha = entrada.next();
                    String vlHora = "";
                    System.out.print("Ingrese la hora: ");
                    vlHora = entrada.next();

                    vlCliente = new Cliente(nombre, apellido, identificacion, telefono);

                    reservarMesa(vlCliente, vlNumeroMesa, vlFecha, vlHora);

                    break;
                case 3:
                    getMesasPorEstado(vgEstadoReservada);

                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
                    break;
            }

        } while (opcion != 4);

        entrada.close();
    }

    public void getMesasPorEstado(String vpEstado) {
        System.out.println("Lista de mesas : " + vpEstado);

        for (int indice = 0; vgArregloDeMesas.length > indice; indice++) {
            String vlEstado = vgArregloDeMesas[indice].getVgEstado();

            if (vlEstado.equals(vpEstado)) {
                System.out.println("Mesa #" + vgArregloDeMesas[indice].getVgNumeroDeLasMesas());
            }
        }
    }

    public void reservarMesa(Cliente vpCliente, int vpNumeroMesa, String vpFecha, String vpHora) {

        for (int indice = 0; vgArregloDeMesas.length > indice; indice++) {

            Mesa vlMesaDelCiclo = vgArregloDeMesas[indice];

            String vlEstado = vlMesaDelCiclo.getVgEstado();
            int vlNumeroMesa = vlMesaDelCiclo.getVgNumeroDeLasMesas();

            if (vlNumeroMesa == vpNumeroMesa && vlEstado.equals(vgEstadoDisponible)) {

                System.out.println("La mesa #" + vpNumeroMesa + ", fue reservada de forma exitosa!");

                vgArregloDeMesas[indice].setVgEstado(vgEstadoReservada);
                vgArregloDeMesas[indice].setVgCliente(vpCliente);
                vgArregloDeMesas[indice].setFecha(vpFecha);
                vgArregloDeMesas[indice].setHora(vpHora);

                MostrarOpciones();

                return;
            }
        }

        System.out.println("El numero de mesa: " + vpNumeroMesa + " no esta disponible!");
    }

}