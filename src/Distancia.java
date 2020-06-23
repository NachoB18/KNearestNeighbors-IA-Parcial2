import static java.lang.Math.sqrt;

public class Distancia {
    Persona persona1;
    Persona persona2;
    Integer distancia;

    public Distancia(Persona personaAsignado, Persona persona) {
        Integer x1 = persona.getDineroAdeudado();
        Integer y1 = persona.getSueldoMensual();
        Integer x2 = personaAsignado.getDineroAdeudado();
        Integer y2 = personaAsignado.getSueldoMensual();
        persona1 = persona;
        persona2 = personaAsignado;
        distancia  = (int) sqrt(((x2 - x1)*(x2 - x1))+((y2 - y1)*(y2 - y1)));
    }

    public int compareTo(Distancia o2) {
        return this.distancia - o2.getDistancia();
    }

    public Integer getDistancia() {
        return distancia;
    }

    public Persona getPersona2() {
        return persona2;
    }
}
