public class PollutionDatum {
    private int year;
    private float pollution;

    public PollutionDatum(int year, float pollution){
        this.year = year;
        this.pollution = pollution;
    }

    public int getYear(){
        return this.year;
    }

    public float getPollution(){
        return this.pollution;
    }

}
