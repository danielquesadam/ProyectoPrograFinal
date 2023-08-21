package Common;  // Definir el paquete al que pertenece la clase Usuario

public class Usuario {  // Definir la clase Usuario

    private String vgNombreDeUsuario;  // Atributo privado para el nombre de usuario
    private String vgPassword;  // Atributo privado para la contraseña

    public Usuario() {  // Constructor sin argumentos
        vgNombreDeUsuario = "";  // Inicializa el nombre de usuario con una cadena vacía
        vgPassword = "";  // Inicializar la contraseña con una cadena vacía
    }

    public Usuario(String vpNombreDeUsuario, String vpPassword) {  // Constructor con argumentos
        this.vgNombreDeUsuario = vpNombreDeUsuario;  // Asignar el valor del parámetro al nombre de usuario
        this.vgPassword = vpPassword;  // Asignar el valor del parámetro a la contraseña
    }

    public String getVgNombreDeUsuario() {  // Método para obtener el nombre de usuario
        return vgNombreDeUsuario;
    }

    public void setVgNombreDeUsuario(String vgNombreDeUsuario) {  // Método para establecer el nombre de usuario
        this.vgNombreDeUsuario = vgNombreDeUsuario;
    }

    public String getVgPassword() {  // Método para obtener la contraseña
        return vgPassword;
    }

    public void setVgPassword(String vgPassword) {  // Método para establecer la contraseña
        this.vgPassword = vgPassword;
    }
}
