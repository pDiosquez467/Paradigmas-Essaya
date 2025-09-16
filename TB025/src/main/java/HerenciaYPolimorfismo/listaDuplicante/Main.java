package main.java.HerenciaYPolimorfismo.listaDuplicante;

public class Main {
    public static void main(String[] args) {
        // ----------------------------------------------------
        // Testeando ListaDuplicanteHerencia
        // ----------------------------------------------------
        System.out.println("--- Testeando ListaDuplicanteHerencia ---");
        ListaDuplicanteHerencia<Integer> listaHerencia = new ListaDuplicanteHerencia<>();

        // 1. Caso inicial: lista vacía
        System.out.println("Lista vacía - Tamaño: " + listaHerencia.size());
        System.out.println("¿Está vacía? " + listaHerencia.isEmpty());

        // 2. Agregando elementos
        System.out.println("\nAgregando elementos (1, 2, 3)...");
        listaHerencia.add(1);
        listaHerencia.add(2);
        listaHerencia.add(3);

        // 3. Verificando el tamaño después de agregar
        System.out.println("Tamaño después de agregar: " + listaHerencia.size());

        // 4. Accediendo a los elementos
        System.out.println("Primer elemento: " + listaHerencia.get(0));
        System.out.println("Segundo elemento: " + listaHerencia.get(1));
        System.out.println("Tercer elemento: " + listaHerencia.get(2));
        System.out.println("Cuarto elemento: " + listaHerencia.get(3));
        System.out.println("Quinto elemento: " + listaHerencia.get(4));
        System.out.println("Sexto elemento: " + listaHerencia.get(5));

        // 5. Caso de borde: índice fuera de rango
        try {
            System.out.println("\nIntentando acceder a un índice fuera de rango (6)...");
            System.out.println("Elemento en índice 6: " + listaHerencia.get(6));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("¡Error capturado! " + e.getMessage());
        }

        // ----------------------------------------------------
        // Testeando ListaDuplicanteComposicion
        // ----------------------------------------------------
        System.out.println("\n--- Testeando ListaDuplicanteComposicion ---");
        ListaDuplicanteComposicion<String> listaComposicion = new ListaDuplicanteComposicion<>();

        // 1. Caso inicial: lista vacía
        System.out.println("Lista vacía - Tamaño: " + listaComposicion.size());

        // 2. Agregando elementos
        System.out.println("\nAgregando elementos ('a', 'b')...");
        listaComposicion.add("a");
        listaComposicion.add("b");

        // 3. Verificando el tamaño
        System.out.println("Tamaño después de agregar: " + listaComposicion.size());

        // 4. Accediendo a los elementos
        System.out.println("Primer elemento: " + listaComposicion.get(0));
        System.out.println("Segundo elemento: " + listaComposicion.get(1));
        System.out.println("Tercer elemento: " + listaComposicion.get(2));
        System.out.println("Cuarto elemento: " + listaComposicion.get(3));

        // 5. Caso de borde: índice negativo
        try {
            System.out.println("\nIntentando acceder a un índice negativo (-1)...");
            System.out.println("Elemento en índice -1: " + listaComposicion.get(-1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("¡Error capturado! " + e.getMessage());
        }
    }
}
