public class CarDatum {
    private int year;
    private int cars;
    private int pollution;

    public CarDatum(int year, int cars, int pollution){
        this.year = year;
        this.cars = cars;
        this.pollution = pollution;
    }

    public int getYear(){
        return this.year;
    }

    public int getPollution(){
        return this.pollution;
    }

    public int getCars(){
        return this.cars;
    }

}
