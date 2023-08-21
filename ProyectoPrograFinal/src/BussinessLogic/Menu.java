package BussinessLogic; //Esta línea especifica el nombre del paquete para la clase Java.

import java.util.Scanner; //Esta línea importa la clase Scanner del paquete java.util. 
                        //La clase Scanner se utiliza para leer la entrada del usuario desde la consola.
import Common.Cliente;//Esta línea importa la clase Cliente desde el paquete llamado Common.
import Common.Mesa; // Esta línea importa la clase Mesa desde el mismo paquete Common

public class Menu { //indica que estás declarando una clase pública llamada "Menu". En Java

    private Mesa[] vgArregloDeMesas = new Mesa[10]; // declara una variable de instancia llamada vgArregloDeMesas que es
                                                  // un arreglo de objetos de tipo Mesa, con capacidad para almacenar
                                                  // hasta 10 objetos Mesa
    final String vgEstadoDisponible = "Disponible"; // define una constante llamada vgEstadoDisponible de tipo String que
                                                  // tiene un valor fijo y no se puede modificar después de su
                                                  // inicialización.
    final String vgEstadoReservada = "Reservada";// lo mismo pero cambia el nombre de la variable y el valor de esta a
                                               // "Reservada"

    public Menu() { // Inicio del metodo

        inicializarMesas(); // Llamamos al metodo "inicializarMesas"

        login(); // Llamamos al metodo login para que el usuario ingrese sus credenciales

    }

    public void inicializarMesas() { // El método inicializarMesas crea y asigna instancias de la clase Mesa al
                                     // arreglo ArregloDeMesas, llenando el arreglo con mesas predefinidas, cada una
                                     // con un número único y 4 espacios.
        for (int indice = 0; vgArregloDeMesas.length > indice; indice++) { // Inicia un bucle for que se ejecutará mientras la variable 
                                                                            //indice sea menor que la longitud del arreglo vgArregloDeMesas.
            vgArregloDeMesas[indice] = new Mesa(indice + 1, 4); //Asigna una nueva instancia de la clase Mesa al elemento del 
                                                                                    //arreglo vgArregloDeMesas en la posición indice.

        }
    }

    public void login() {// Metodo para que el Usuario se logee

        Scanner entrada = new Scanner(System.in);

        // Solicitar los valores al usuario
        String vlUsuario = ""; //Se declara una variable local llamada vlUsuario de tipo String, asignando el valor inicial de una cadena vacía
        String vlClave = "";

        System.out.println("Por favor ingrese sus credenciales");
        System.out.println("Ingrese su usuario");
        vlUsuario = entrada.next();
        System.out.println("Por favor ingrese su contraseña");
        vlClave = entrada.next();

        Seguridad vlSeguridad = new Seguridad();
        //Seguridad vlSeguridad: declara una variable llamada vlSeguridad que se utilizará para hacer referencia a un objeto de tipo Seguridad
        //new Seguridad(): Esta parte del código crea una nueva instancia (objeto) de la clase Seguridad.

        Boolean vlResultado = vlSeguridad.buscarPorUsuarioClave(vlUsuario, vlClave);
        // Llama al método llamado buscarPorUsuarioClave en el objeto vlSeguridad, y le pasa dos argumentos: vlUsuario y vlClave
        // El resultado de esta búsqueda será un valor booleano, es decir, si se encontró el usuario y clave (verdadero) o no (falso).
        if (vlResultado) {
            System.out.println("Bienvenido!"); //Si la variable local es verdadera se imprime el texto y se llama al metodo MostrarOpciones
            MostrarOpciones();
        } else {
            System.out.println("Credenciales incorrectas!");//Si la variable local es false, imprime el texto

        }

        entrada.close();

    }

    public void MostrarOpciones() { // Inicio metodo para mostrar las opciones del menu en pantalla

        Scanner entrada = new Scanner(System.in);

        int opcion = 0; //Declara la variable  opcion y se le asigna el valor numérico 0.

        do {//se inicia un bucle "do", para ejecutar el menu interactivo

            System.out.println("=== Menú ===");
            System.out.println("1. Consulta de mesas disponibles");
            System.out.println("2. Reservar mesa");
            System.out.println("3. Consulta de mesas reservadas");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            opcion = entrada.nextInt(); //el número ingresado se almacena en la variable opcion.

            switch (opcion) {
                case 1:
                    getMesasPorEstado(vgEstadoDisponible);
                    break;
                case 2:

                Cliente vlCliente = new Cliente(); //Crea una instancia del objeto de la clase Cliente y asignándola a la variable vlCliente

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

                // Crea una instancia del objeto de la clase Cliente y asigna valores específicos a sus atributos
                vlCliente = new Cliente(nombre, apellido, identificacion, telefono);

                reservarMesa(vlCliente, vlNumeroMesa, vlFecha, vlHora);//Se llama al método reservarMesa y se pasan los 4 argumentos:

                    break;
                case 3:
                    getMesasPorEstado(vgEstadoReservada); //Se llama al metodo getMesasPorEstado

                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
                    break;
            }
            System.out.println();

        } while (opcion != 4);

        entrada.close();
    }

    // Metodo para obtener las mesas, dependiendo de su estado y mostrarlas en la
    // opcion del menu.
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

        /**
         * Paso 1: Creamos un for para recorrer el arregle de mesas -->
         * tiene el objetivo de buscar y verificar si la mesa seleccionada para la reserva esta disponible.
         */
        for (int indice = 0; vgArregloDeMesas.length > indice; indice++) {

            /**
             * Creamos un condicional por medio de un if para ir verificando cada
             * posicion del arreglo hasta encontrar la mesa donde su numero se igual al suministrado por el usuario.
             * para esto revisamos el arreglo en cada recorrido del for.
             * Se comparar dos atributos del la mesa numero de mesa y el estado.
             */

            /**
             * Paso 2.1 obtener el valor de la mesa que pertenece al indice del ciclo y
             * asignarlo a una variable
             */
            Mesa vlMesaDelCiclo = vgArregloDeMesas[indice];
            
            String vlEstado = vlMesaDelCiclo.getVgEstado(); //Para obtener el estado utilizamos el metodo getVgEstado()
            int vlNumeroMesa = vlMesaDelCiclo.getVgNumeroDeLasMesas(); //Para obtener el numero de mesa utilizamos el metodo getVgNumeroDeMesa */


            if (vlNumeroMesa == vpNumeroMesa && vlEstado.equals(vgEstadoDisponible)) { // Comparamos los valores de la
                                                                                     // mesa que va en el ciclo contra
                                                                                     // los parametros suministrados al
                                                                                     // metodo

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