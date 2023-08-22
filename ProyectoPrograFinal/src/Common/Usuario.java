package Common; 

public class Usuario {  

    private String vgNombreDeUsuario;  
    private String vgPassword;  

    public Usuario() { 
        vgNombreDeUsuario = "";  
        vgPassword = "";  
    }

    public Usuario(String vpNombreDeUsuario, String vpPassword) {  
        this.vgNombreDeUsuario = vpNombreDeUsuario;  
        this.vgPassword = vpPassword;  
    }

    public String getVgNombreDeUsuario() {  
        return vgNombreDeUsuario;
    }

    public void setVgNombreDeUsuario(String vgNombreDeUsuario) {  
        this.vgNombreDeUsuario = vgNombreDeUsuario;
    }

    public String getVgPassword() {  
        return vgPassword;
    }

    public void setVgPassword(String vgPassword) {  
        this.vgPassword = vgPassword;
    }
}
