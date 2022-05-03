package life.domain;

/**
 * Responsabilidades:
 *
 * - Tiene las responsabilidades de un modelo en MVC: mantener los
 *   datos principales de la aplicación.
 * - Mantener la historia de todas las generaciones hasta el momento
 *   (en la forma de una cadena enlazada).
 * - Avanzar y retroceder en la historia.
 * - Entender si la última generación es el fin del juego porque la
     siguiente será idéntica.
 */
public class LifeHistory {
  // Generación actual
  private Gen current;
  // Generaciones previas (cadena enlazada)
  private LifeHistory prev;

  /**
   * Crea una nueva historia sin historia previa y siendo gen la
   * generación actual (current).
   */
  public LifeHistory(Gen gen) {
    current = gen;
  }

  /**
   * Provoca que la historia evolucione a una nueva generación que
   * será la actual manteniendo la historia anterior.
   */
  public void evolve() {
    LifeHistory aux = prev;
    prev = new LifeHistory(current);
    prev.prev = aux;
    current = current.next();
  }

  /**
   * "Involuciona" eliminando la generación actual (current) y
   * recuperando la anterior.
   */
  public void undo() {
    if (prev != null){
      current = prev.current;
      prev = prev.prev;
    }
  }

  /**
   * Devuelve la generación más nueva de la historia (la actual).
   */
  public Gen current() {
    return current;
  }

  /**
   * Devuelve el número de generaciones en la historia.
   */
  public int generations() {
    int contador = 1;
    LifeHistory aux = prev;
    while(aux != null){
      contador++;
      aux = aux.prev;
    }
    return contador;
  }

  /**
   * Dice si la historia se ha acabado (la siguiente generación sería
   * igual a la actual).
   */
  public boolean endOfGame() {
    boolean end = false;
    if(prev != null && current.equals(prev.current)){
      end = true;
    }
    return end;
  }
}
