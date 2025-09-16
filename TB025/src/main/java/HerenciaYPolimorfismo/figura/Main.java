package main.java.HerenciaYPolimorfismo.figura;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Figura> figuras = new ArrayList<>();
        figuras.add(new Circulo(3));               // un círculo de radio 3
        figuras.add(new Cuadrado(5));              // un cuadrado de lado 5
        figuras.add(new Rectangulo(2, 4));  // un rectángulo de 2x4
        System.out.printf("El area total es: %f", areaTotal(figuras));
    }

    private static double areaTotal(List<Figura> figuras) {
        double total = 0;
        for (Figura f : figuras) {
            total += f.area();
        }
        return total;
    }
}

/*
- Pensar cuáles son las relaciones entre Figura, Círculo, Cuadrado y Rectángulo.
 ¿Figura debe ser una clase, una clase abstracta o una interfaz?
  Figura debe ser una clase abstracta o una interfaz porque no tiene sentido instanciar un objeto de tipo
  Figura genérico. Su propósito es definir un comportamiento común (el cálculo del área) que sus subclases
  deben implementar. Ambas opciones son válidas, pero una interfaz es a menudo la mejor opción si solo defines
  un contrato de comportamiento (como el metodo area()), sin ninguna implementación base. Una clase abstracta
  sería más útil si hubiera algún comportamiento o estado que todas las subclases compartieran.

- ¿Dónde hay comportamiento polimórfico? ¿De qué tipo es?
   Polimorfismo paramétrico: Ocurre en el metodo areaTotal. Este metodo acepta una lista que puede contener
   cualquier tipo de objeto que herede de Figura. El parámetro List<Figura> figuras es un ejemplo de este tipo
   de polimorfismo, ya que el metodo puede operar sobre una colección de diferentes tipos de objetos, siempre
   y cuando todos compartan la misma interfaz o clase base.

- Dibujar el diagrama de clases.
- Implementar. -> Listo
* */