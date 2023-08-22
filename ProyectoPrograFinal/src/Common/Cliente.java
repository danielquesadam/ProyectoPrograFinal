package Common;

public class Cliente {

    private String vgNombre; //Se declara un atributo privado llamado vgNombre, que almacenará el nombre del cliente.
    private String vgApellido;
    private String vgIdentificacion;
    private String vgTelefono;

    public Cliente(){  //Se define un constructor público sin argumentos. Este constructor se utiliza para crear un objeto Cliente
        vgNombre = "";
        vgApellido = "";
        vgIdentificacion = "";
        vgTelefono = "";
    }

    public Cliente(String vpNombre, String vpApellido, String vpIdentificacion, String vpTelefono) {
        //Se define un constructor público con argumentos. Este constructor permite crear un objeto Cliente
        vgNombre = vpNombre;
        vgApellido = vpApellido;
        vgIdentificacion = vpIdentificacion;
        vgTelefono = vpTelefono;
    }

    public String getNombre() { //Este método público devuelve el valor almacenado en el atributo vgNombre.
        return vgNombre;
    }

    public String getApellido() {
        return vgApellido;
    }

    public String getIdentificacion() {
        return vgIdentificacion;
    }

    public String getTelefono() {
        return vgTelefono;
    }

    public void setNombre(String nombre) {
        vgNombre = nombre;
    }

    public void setApellido(String apellido) {
        vgApellido = apellido;
    }
    
    public void setIdentificacion(String identificacion) {
        vgIdentificacion = identificacion;
    }


    public void setTelefono(String telefono) {
        vgTelefono = telefono;
    }
// Esta línea tiene la tarea de construir y devolver una cadena de texto que contiene información detallada sobre un cliente
    public String getInformacion() {
        return "Nombre: " + getNombre() + " Apellido: " + getApellido() + " Identificacion: " + getIdentificacion() + "Telefono: " + getTelefono();
    }

}
