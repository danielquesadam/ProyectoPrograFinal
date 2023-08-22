package BussinessLogic;

import Common.Usuario;

public class Seguridad {

    public Seguridad() {
        registroDeUsuarios();
    }

    public Usuario[] arregloUsuarios = new Usuario[5];

    public void registroDeUsuarios() {

        Usuario usuarioAdmin = new Usuario();
        usuarioAdmin.setVgNombreDeUsuario("Admin");
        usuarioAdmin.setVgPassword("123");

        Usuario usuarioClienteJohn = new Usuario("Daniel", "123");
        Usuario usuarioClienteSaul = new Usuario("Esteban", "123");
        Usuario usuarioClienteJenny = new Usuario("Dali", "123");
        Usuario usuarioClienteAndrey = new Usuario("Jose", "123");

        arregloUsuarios[0] = usuarioAdmin;
        arregloUsuarios[1] = usuarioClienteJohn;
        arregloUsuarios[2] = usuarioClienteSaul;
        arregloUsuarios[3] = usuarioClienteJenny;
        arregloUsuarios[4] = usuarioClienteAndrey;
    }

    public boolean buscarPorUsuarioClave(String vpUsuario, String vpClave) {
        for (int indice = 0; indice < arregloUsuarios.length; indice++) {

            String vlUsuario = arregloUsuarios[indice].getVgNombreDeUsuario();
            String vlClave = arregloUsuarios[indice].getVgPassword();

            if (vlClave.equals(vpClave) && vlUsuario.equals(vpUsuario)) {

                return true;
            }
        }

        return false;
    }

}
