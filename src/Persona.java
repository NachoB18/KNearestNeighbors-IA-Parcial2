public class Persona {
    String DNI;
    Integer sueldoMensual;
    Integer dineroAdeudado;
    Prestamo prestamoAceptado;

    Persona (String DNI, Integer sueldoMensual, Integer dineroAdeudado, String prestamo) {
        this.DNI = DNI;
        this.sueldoMensual = sueldoMensual;
        this.dineroAdeudado = dineroAdeudado;
        if(prestamo == "Aceptado"){
            prestamoAceptado = Prestamo.Aceptado;
        } else {
            prestamoAceptado = Prestamo.Rechazado;
        }
    }
    Persona (String DNI, Integer sueldoMensual, Integer dineroAdeudado) {
        this.DNI = DNI;
        this.sueldoMensual = sueldoMensual;
        this.dineroAdeudado = dineroAdeudado;
    }

    public String getDNI() {
        return DNI;
    }

    public Integer getSueldoMensual() {
        return sueldoMensual;
    }

    public Integer getDineroAdeudado() {
        return dineroAdeudado;
    }

    public Prestamo getPrestamoAceptado() {
        return prestamoAceptado;
    }

    public void setPrestamoAceptado(Prestamo prestamoAceptado) {
        this.prestamoAceptado = prestamoAceptado;
    }
}
