
package Common; //Establecer el paquete al que pertenece la clase "Perfil".//

public class Perfil { // Definir la clase "Perfil"//

    public String vgNombre; // Declarar una variable pública de tipo String llamada "vgNombre"//

    public String vgIdentificacion; // Declarar una variable pública de tipo String llamada "vgIdentificacion"//

    public Perfil() {
        // Dentro del constructor, inicializa la variable vgNombre con una cadena vacía
        // (""). //
        // Esto establece un valor predeterminado para el atributo "vgNombre" cuando se
        // crea un objeto "Perfil"//
        vgNombre = "";

        // Similar al paso anterior, inicializa la variable "vgIdentificacion" con una
        // cadena vacía
        vgIdentificacion = "";
    }
}
