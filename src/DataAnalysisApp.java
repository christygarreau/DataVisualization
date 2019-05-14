import processing.core.PApplet;

import java.util.ArrayList;

public class DataAnalysisApp extends PApplet{

    private static DataBank dataBank;
    public static DataAnalysisApp app;

    public static void main(String[] args) {
        PApplet.main("DataAnalysisApp");
    }

    public DataAnalysisApp() {}

    public void settings() {
        size(1000,500);
    }

    public void setup() {
        textAlign(CENTER, CENTER);
        dataBank = new DataBank(this);
        dataBank.sort();
    }

    public void draw() {
        background(255);
        stroke(0);
        noLoop();
    }
    public static DataAnalysisApp getApp(){
        return app;
    }

}
