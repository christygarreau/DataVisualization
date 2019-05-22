import processing.core.PApplet;
import processing.data.Table;

import java.util.ArrayList;

public class DataAnalysisApp extends PApplet{

    private static DataBank dataBank;
    public static DataAnalysisApp app;

    public static void main(String[] args) {
        PApplet.main("DataAnalysisApp");
    }

    public DataAnalysisApp() {
        app = this;
    }

    public void settings() {
        size(1000,500);
    }

    public void setup() {
        background(255);
        textAlign(CENTER, CENTER);
        dataBank = new DataBank(this);
        dataBank.sort();
        visualize();
    }

    public void draw() {
        noLoop();
    }

    private void visualize(){
        stroke(0);
        fill(0);
        textAlign(CENTER);
        final int BOX_SIZE = 10;
        final int BOX_HEIGHT = (height-2*(height/BOX_SIZE))/9;
        final int BOX_WIDTH = (width-2*(width/BOX_SIZE))/3;

        text("YEARS",(width / BOX_SIZE) + (BOX_WIDTH/2),height / BOX_SIZE - 10);
        text("NUMBER OF ELECTRIC CARS",width/BOX_SIZE + (BOX_WIDTH/2) + BOX_WIDTH,height / BOX_SIZE - 10);
        text("AGGI", width/BOX_SIZE + (BOX_WIDTH/2) + 2*BOX_WIDTH, height / BOX_SIZE - 10);

        for(int i = 0; i < 10; i++){//generates horizontals
            line(width/BOX_SIZE,height/BOX_SIZE + (BOX_HEIGHT*i),width-(width/BOX_SIZE),height/BOX_SIZE + (BOX_HEIGHT*i));
            int y = height / BOX_SIZE + BOX_HEIGHT/2 + BOX_HEIGHT*i;

            if(i<9) {
                text(dataBank.carBank.get(i).getYear(), (width / BOX_SIZE) + (BOX_WIDTH/2), y);
                text(dataBank.carBank.get(i).getCars(), width/BOX_SIZE + (BOX_WIDTH/2) + BOX_WIDTH, y);
                text(dataBank.carBank.get(i).getPollution(), width/BOX_SIZE + (BOX_WIDTH/2) + 2*BOX_WIDTH, y);
            }
        }
        for(int i = 0; i < 4; i++){//generates verticals
            line(width/BOX_SIZE + (BOX_WIDTH*i),height/BOX_SIZE,width/BOX_SIZE + (BOX_WIDTH*i),height-(height/BOX_SIZE));
        }
    }

    public static DataAnalysisApp getApp(){
        return app;
    }

}
