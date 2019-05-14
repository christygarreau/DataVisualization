import processing.data.Table;
import processing.data.TableRow;

import java.util.ArrayList;

public class PollutionPerYear {
    private ArrayList<PollutionDatum> pollution;

    public PollutionPerYear(){
        pollution = new ArrayList<PollutionDatum>();
        DataAnalysisApp app = DataAnalysisApp.getApp();

        Table table = app.loadTable("ElectricCars","header");
        for(TableRow row: table.rows()){
            int year = row.getInt("Years"); //get integer in first column
            float car = row.getFloat("Number of Electric Cars in the U.S. (in thousands)"); //get from second column
            pollution.add(new PollutionDatum(year,car));
        }
    }

}
