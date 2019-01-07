package las;

class Punkty {
    /** Liczba zgromadzonych punktów na danynm poziomie*/
    public int points;
    /** Numer poziomu */
    public int level;
    /** Czas gry na danym poziomie*/
    public double time;

    /**
     * Zeruj parametry gry
     */
    public void reset(){
        points=0;
        //level=1;
        level=0;
        time=0.0;
    }//reset()
    /**
     * Zeruj licznę punktów
     */
    public void resetPoints(){
        points=0;
    }//resetPoints()
    /**
     * Zwiększ wskaźnik poziomu
     */
    public void nextLevel(){
        level++;
    }//nextLevel()
}