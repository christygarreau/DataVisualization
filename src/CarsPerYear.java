import processing.data.Table;
import processing.data.TableRow;

import java.util.ArrayList;

public class CarsPerYear {
    private ArrayList<CarDatum> cars;

    public CarsPerYear(){
        cars = new ArrayList<CarDatum>();
        TextAnalysisApp app = TextAnalysisApp.getApp();

        Table table = app.loadTable("ElectricCars","header");
        for(TableRow row: table.rows()){
            int year = row.getInt("Years"); //get integer in first column
            float car = row.getFloat("Number of Electric Cars in the U.S. (in thousands)"); //get from second column
            cars.add(new CarDatum(year,car));
        }
    }

}
