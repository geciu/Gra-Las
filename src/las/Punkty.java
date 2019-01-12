package las;

/** Klasa odpowiadająca za punkty oraz poziom gry */
class Punkty {

    /** Liczba zgromadzonych punktów na danynm poziomie*/
    public int points;
    /** Numer poziomu */
    public int poziom;
    /** Czas gry na danym poziomie*/
    public double czas;


    /** Metoda odpowiadająca za resetowanie parametrów gry*/
    public void reset(){
        points=0;
        poziom =0;
        czas =0.0;
    }


    /** Metoda resetująca liczbę punktów */
    public void resetPoints(){
        points=0;
    }


    /** Metoda zwiększająca nmer poziomu */
    public void nextLevel(){
        poziom++;
    }

    public void twojePunkty(){
        this.points=points;
    }
}