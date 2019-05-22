import processing.data.Table;
import processing.data.TableRow;

import java.util.ArrayList;

public class CarsPerYear {
    private ArrayList<CarDatum> cars;
    DataAnalysisApp app = DataAnalysisApp.getApp();

    public CarsPerYear(){
        cars = new ArrayList<CarDatum>();

        Table table = app.loadTable("ElectricCars.csv", "header");
        for(TableRow row: table.rows()){
            int year = row.getInt("Years");
            int car = row.getInt("Number of Electric Cars in the U.S. (in thousands)");
            int pollution = row.getInt("Annual Greenhouse Gas Index");
            cars.add(new CarDatum(year,car,pollution));
        }
    }

    public ArrayList<CarDatum> getCars(){
        return this.cars;
    }

}