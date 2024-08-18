package clases;

import clases.DTFecha;

public class Usuario{
    private String nickname;
    private String  nombre;
    private String apellido;
    private String email;
    private DTFecha fechaNac;
    private String foto;

    public Usuario(String nickname, String nombre, String apellido, String email, DTFecha fechaNac, String foto){
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        this.foto = foto;
    }
}