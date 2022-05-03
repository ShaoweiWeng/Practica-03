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
    // TODO: implementar el constructor
  }

  /**
   * Provoca que la historia evolucione a una nueva generación que
   * será la actual manteniendo la historia anterior.
   */
  public void evolve() {
    // TODO: implementar el modificador
  }

  /**
   * "Involuciona" eliminando la generación actial (current) y
   * recuperando la anterior.
   */
  public void undo() {
    // TODO: implementar el modificador
  }

  /**
   * Devuelve la generación más nueva de la historia (la actual).
   */
  public Gen current() {
    // TODO: implementar el observador
  }

  /**
   * Devuelve el número de generaciones en la historia.
   */
  public int generations() {
    // TODO: implementar el observador
  }

  /**
   * Dice si la historia se ha acabado (la siguiente generación sería
   * igual a la actual).
   */
  public boolean endOfGame() {
    // TODO: implementar el observador
  }
}
