import java.util.ArrayList;

public class KNNDemo {
    static int k = 3;
    
    public static void main(String[] args){
        ArrayList<Persona> personasConPrestamoAsignado = cargarPersonasConDatos();
        ArrayList<Persona> personasSinPrestamoAsignado = cargarPersonasAEstudiar();
        for(Persona persona: personasSinPrestamoAsignado) {
            System.out.print(
                    "Las siguientes k personas son aquellas que se encuentran a menor de la distancia de aquella con DNI "
                            + persona.getDNI() + ".\n");
            determinarAprobaciónPrestamo(personasConPrestamoAsignado, persona, k);
        }
    }

    private static void determinarAprobaciónPrestamo(ArrayList<Persona>prestamoAsignado, Persona persona, int k) {
        ArrayList<Distancia> distancias = new ArrayList<>();
        for(Persona personaAsignado: prestamoAsignado){
            Distancia distancia = new Distancia(personaAsignado, persona);
            distancias.add(distancia);
        }
        distancias.sort((o1, o2) -> o1.compareTo(o2));
        ArrayList<Distancia> masCercanos = new ArrayList<Distancia>();
        int aceptados = 0, rechazados = 0;
        for(int i = 0; i < k; i++) {
            masCercanos.add(distancias.get(i));
            System.out.print("DNI: " + distancias.get(i).getPersona2().getDNI() + " Prestamo: "
                    + distancias.get(i).getPersona2().getPrestamoAceptado() + " Distancia: "
                    + distancias.get(i).getDistancia() + "\n");
            if(distancias.get(i).persona2.getPrestamoAceptado() == Prestamo.Aceptado){
                aceptados++;
            } else {
                rechazados++;
            }
        }
        if(aceptados > rechazados){
            if(rechazados == 1){
                System.out.print("Al existir mayor cantidad de prestamos aceptados (" + aceptados + " a comparación de " +
                        rechazados + " rechazado) asumimos que al usuario con DNI " + persona.getDNI() +
                        " se le aceptara el prestamo\n\n");
            } else {
                System.out.print("Al existir mayor cantidad de prestamos aceptados (" + aceptados + " a comparación de los " +
                        rechazados + " rechazados) asumimos que al usuario con DNI " + persona.getDNI() +
                        " se le aceptara el prestamo\n\n");
            }
            persona.setPrestamoAceptado(Prestamo.Aceptado);
        }else if (rechazados > aceptados){
            if(aceptados == 1){
                System.out.print("Al existir mayor cantidad de prestamos rechazados (" + rechazados + " a comparación de " +
                        aceptados + " aceptado) asumimos que al usuario con DNI " + persona.getDNI() +
                        " se le rechazara el prestamo\n\n");
            } else {
                System.out.print("Al existir mayor cantidad de prestamos rechazados (" + rechazados + " a comparación de los " +
                        aceptados + " aceptados) asumimos que al usuario con DNI " + persona.getDNI() +
                        " se le rechazara el prestamo\n\n");
            }
            persona.setPrestamoAceptado(Prestamo.Rechazado);
        }else{
            System.out.print("Al existir la misma cantidad de prestamos aceptados y rechazados (" + aceptados +
                    ") no es posible determinar que decisión se tomara con respecto al prestamo\n\n");
        }

    }

    public static ArrayList<Persona> cargarPersonasConDatos(){
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Persona("41781965",9058,1044,"Aceptado"));
        personas.add(new Persona("24433887",4048,478,"Rechazado"));
        personas.add(new Persona("34345349",15310,5612,"Aceptado"));
        personas.add(new Persona("54455445",6768,15231,"Rechazado"));
        personas.add(new Persona("45453451",17522,19827,"Aceptado"));
        personas.add(new Persona("22616121",46299,29865,"Aceptado"));
        personas.add(new Persona("37829412",9158,18724,"Rechazado"));
        personas.add(new Persona("20177923",7823,7240,"Rechazado"));
        return personas;
    }
    public static ArrayList<Persona> cargarPersonasAEstudiar(){
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Persona("31454563",12543,7689));
        personas.add(new Persona("33675167",19886,30543));
        return personas;
    }




}
