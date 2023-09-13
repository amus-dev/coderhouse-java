package listar_personas;

import java.util.ArrayList;
import java.util.List;

public class Persona {

     // Atributos de la clase Persona
     private String nombre;
     private String apellido;

     // Metodos setters y getters para nombre y apellido
     public String getNombre() {
          return nombre;
     }

     public void setNombre(String nombre) {
          this.nombre = nombre;
     }

     public String getApellido() {
          return apellido;
     }

     public void setApellido(String apellido) {
          this.apellido = apellido;
     }

     public static void main(String[] args) {
          // Se crean las cinco personas de acuerdo al desafio
          Persona firstPersona = new Persona();
          Persona secondPersona = new Persona();
          Persona thirdPersona = new Persona();
          Persona fourPersona = new Persona();
          Persona fivePersona = new Persona();

          // Se setean los valores nombres y apellidos para las cinco personas
          firstPersona.setNombre("Alexander");
          firstPersona.setApellido("Urrutia");

          secondPersona.setNombre("Jimena");
          secondPersona.setApellido("Salazar");

          thirdPersona.setNombre("Constanza");
          thirdPersona.setApellido("Villanueva");

          fourPersona.setNombre("Carly");
          fourPersona.setApellido("Gonzalez");

          fivePersona.setNombre("Martina");
          fivePersona.setApellido("Urrutia");

          // Se crea la lista y luego se agregan las 5 personas antes definidas a la lista
          List<Persona> listPersonas = new ArrayList<>();
          listPersonas.add(firstPersona);
          listPersonas.add(secondPersona);
          listPersonas.add(thirdPersona);
          listPersonas.add(fourPersona);
          listPersonas.add(fivePersona);

          // Se ordenan por NOMBRE de acuerdo a esta funcion y luego se imprime
          sortByName(listPersonas);
          System.out.println("ORDEN POR NOMBRE");
          listPersonas.forEach(persona -> {
               System.out.println("Nombre y Apellido: " + persona.nombre + " " + persona.apellido);
          });

          // Se ordenan por APELLIDO de acuerdo a esta funcion y luego se imprime
          sortByApellido(listPersonas);
          System.out.println("ORDEN POR APELLIDO");
          listPersonas.forEach(persona -> {
               System.out.println("Apellido y Nombre: " + persona.apellido + " " + persona.nombre);
          });

          // Se ordenan por APELLIDO de manera INVERSA y luego se imprime
          sortByApellidoInverso(listPersonas);
          System.out.println("ORDEN POR APELLIDO INVERSAMENTE");
          listPersonas.forEach(persona -> {
               System.out.println("Apellido y Nombre: " + persona.apellido + " " + persona.nombre);
          });
     }

     private static void sortByName(List<Persona> listPersonas) {
          listPersonas.sort((o1, o2) -> o1.getNombre().compareTo(
                    o2.getNombre()));
     }

     private static void sortByApellido(List<Persona> listPersonas) {
          listPersonas.sort((o1, o2) -> o1.getApellido().compareTo(
                    o2.getApellido()));
     }

     private static void sortByApellidoInverso(List<Persona> listPersonas) {
          listPersonas.sort((o1, o2) -> o2.getApellido().compareTo(
                    o1.getApellido()));
     }
}
