/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author Alberto Jimenez
 */
public class ProfileDTO {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Calendar fechaDeNacimiento;
    private String foto;
    private String email;
    private String genero;
    private String pais;
    private String telefono;
    private String celular;
    private String direccion;
    private String edad;

    public ProfileDTO() {
    }

    public ProfileDTO(String nombre, String apellidoPaterno, String pais) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.pais = pais;
    }

    public ProfileDTO(String nombre, String apellidoPaterno, String apellidoMaterno, Calendar fechaDeNacimiento, String foto, String email, String genero, String pais, String telefono, String celular, String direccion, String edad) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.foto = foto;
        this.email = email;
        this.genero = genero;
        this.pais = pais;
        this.telefono = telefono;
        this.celular = celular;
        this.direccion = direccion;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Calendar getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Calendar fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + Objects.hashCode(this.apellidoPaterno);
        hash = 29 * hash + Objects.hashCode(this.apellidoMaterno);
        hash = 29 * hash + Objects.hashCode(this.fechaDeNacimiento);
        hash = 29 * hash + Objects.hashCode(this.foto);
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.genero);
        hash = 29 * hash + Objects.hashCode(this.pais);
        hash = 29 * hash + Objects.hashCode(this.telefono);
        hash = 29 * hash + Objects.hashCode(this.celular);
        hash = 29 * hash + Objects.hashCode(this.direccion);
        hash = 29 * hash + Objects.hashCode(this.edad);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProfileDTO other = (ProfileDTO) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidoPaterno, other.apellidoPaterno)) {
            return false;
        }
        if (!Objects.equals(this.apellidoMaterno, other.apellidoMaterno)) {
            return false;
        }
        if (!Objects.equals(this.foto, other.foto)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        if (!Objects.equals(this.pais, other.pais)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.celular, other.celular)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.edad, other.edad)) {
            return false;
        }
        return Objects.equals(this.fechaDeNacimiento, other.fechaDeNacimiento);
    }

    @Override
    public String toString() {
        return "ProfileDTO{" + "nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", fechaDeNacimiento=" + fechaDeNacimiento + ", foto=" + foto + ", email=" + email + ", genero=" + genero + ", pais=" + pais + ", telefono=" + telefono + ", celular=" + celular + ", direccion=" + direccion + ", edad=" + edad + '}';
    }   
}
