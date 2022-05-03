package life.domain;

/**
* Responsabilidades:
* - Representar una generación del juego de la vida en un
* mundo cuadrado con paredes.
* - Saber qué celdas están vivas o muertas.
* - Establecer si una celda está viva o muerta.
* - Crear la siguiente generación.
*/

public class Gen {
    
    private boolean[][] celdas;

    /**
    * Crea una generación sin celdas vivas en un mundo de
    * cuadrado size x size.
    */
    public Gen(int size) {
        celdas = new boolean[size][size];
    }

    /**
    * Devuelve el tamanio del mundo de esta generación.
    */
    public int size() {
        return celdas.length;
    }

    /**
    * Establece si la celda en la posición (x,y) está viva
    * o muerta. Los parámetros x e y deberán ser mayores o
    * iguales que 0 y menores que celdas.length.
    */
    public void set(int x, int y, boolean live) {
        celdas[x][y] = live;
    }

    /**
    * Dice si la celda en la posición (x,y) está viva.
    */
    public boolean live(int x, int y) {
        return celdas[x][y];
    }

    /**
    * Devuelve una nueva generación aplicando las reglas del
    * juego de la vida:
    * Una celda viva con menos de dos vecinas vivas morirá por subpoblación.
    * Una celda viva con más de tres vecinas vivas morirá por superpoblación.
    * Una celda viva con EXACTAMENTE dos o tres vecinas vivas se mantendrá viva.
    * Una celda muerta si y solo si con EXACTAMENTE tres vecinas vivas (re)vivirá.
    */
    public Gen next() {
        int tamanio = celdas.length;
        Gen nuevo = new Gen(tamanio);
        for(int i = 0; i < tamanio; i++){
            for(int j = 0; j < tamanio; j++){
                if (celdas[i][j] == true){ //Evalua cuantos vecinos vivos hay entorno a una casilla viva
                    int vecinosVivos = 0;
                    for(int k = i-1; k <= i+1; k++){
                        for(int l = j-1; l <= j+1; l++){
                            if(k >= 0 && k < tamanio && l >= 0 && l < tamanio){
                                if(celdas[k][l] == true && (k != i || l != j)){
                                    vecinosVivos++;
                                }
                            }
                        }
                    }
                    if(vecinosVivos == 2 || vecinosVivos == 3){
                        nuevo.celdas[i][j] = true;
                    }
                }
                else{ //Evalua cuantos vecinos vivos hay entorno a una casilla muerta
                    int vecinosVivos = 0;
                    for(int k = i-1; k <= i+1; k++){
                        for(int l = j-1; l <= j+1; l++){
                            if(k >= 0 && k < tamanio && l >= 0 && l < tamanio){
                                if(celdas[k][l] == true){
                                    vecinosVivos++;
                                }
                            }
                        }
                    }
                    if(vecinosVivos == 3){
                        nuevo.celdas[i][j] = true;
                    }
                }
            }
        }
        return nuevo;
    }

    /**
    * Decide si dos generaciones son iguales.
    */
    public boolean equals(Object o) {
        boolean igual = true;
        if(o instanceof Gen){
            Gen generacion2 = (Gen) o;
            if(celdas.length != generacion2.size()){
                igual = false;
            }
            else{
                int i = 0;
                while(i < celdas.length && igual){
                    int j = 0;
                    while(j < celdas.length && igual){
                        if (celdas[i][j] != generacion2.celdas[i][j]){
                            igual = false;
                        }
                        else{
                            j++;
                        }
                    }
                    i++;
                }
            } 
        }
        else{
            igual = false;
        } 
        return igual;
    }
}
