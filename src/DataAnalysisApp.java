import processing.core.PApplet;

public class DataAnalysisApp extends PApplet{

    private static DataBank dataBank;
    public static DataAnalysisApp app;
    final int BOX_SIZE = 10; //amount dividing lines by -- just a constant
    public static boolean graphTable = false;

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
    }

    public void draw() {
        if(!graphTable){//graph
            background(255);
            visualizeGraph();
            fill(0);
            text("Press SPACE to switch to Table", width/2, 20);
            fill(255);
        } else if(graphTable){//table
            background(255);
            visualizeDataTable();
            fill(0);
            text("Press SPACE to switch to Graph", width/2, 20);
            fill(255);
        }
        noLoop();
    }

    public void keyPressed(){
        if(key == ' '){
            graphTable = !graphTable;
            redraw();
        }
    }

    private void visualizeGraph(){
        final int GRAPH_X = width/BOX_SIZE; //width of entire box
        final int GRAPH_Y = height/BOX_SIZE; //height of entire box
        final int BOX_WIDTH = (width-2*(GRAPH_X))/BOX_SIZE;
        final int BOX_HEIGHT = (height-2*(GRAPH_Y))/BOX_SIZE;

        stroke(0);
        textAlign(CENTER);
        rect(GRAPH_X, GRAPH_Y, width-2*(GRAPH_X), height-2*(GRAPH_Y));

        fill(180,0,0);
        text("Years", width/2, height - 10);
        fill(255, 191, 0);
        text("Annual\nGreenhouse\nGas\nIndex", 45, 25);
        fill(255,157,0);
        text("Size of\nBubble based\non Number\nof Electric\nCars by the\nThousands in\nthe U.S.", width-(width/20), height/8 );

        stroke(200);
        fill(0);
        for(int i = 1; i < BOX_SIZE; i++){
            line(GRAPH_X + (BOX_WIDTH*i),GRAPH_Y,GRAPH_X + (BOX_WIDTH*i),height-(GRAPH_Y));//generate verticals
            line(GRAPH_X,GRAPH_Y + (BOX_HEIGHT*i),width-(GRAPH_X),GRAPH_Y + (BOX_HEIGHT*i)); //generate horizontals
            text(dataBank.carsPerYear.getCars().get(BOX_SIZE-1-i).getPollution(), GRAPH_X-20, GRAPH_Y + (BOX_HEIGHT*i)+5);
            text(dataBank.carsPerYear.getCars().get(i-1).getYear(), GRAPH_X + (BOX_WIDTH*i), height-(GRAPH_Y)+20);
        }
        for(int i = 1; i < BOX_SIZE; i++){
            stroke(255-255*i/10,0+255*i/10,0);
            fill(200);
            ellipse(GRAPH_X+BOX_WIDTH*i,height-GRAPH_Y-BOX_HEIGHT*i,dataBank.carsPerYear.getCars().get(i-1).getCars()+10,dataBank.carsPerYear.getCars().get(i-1).getCars()+10);
            fill(255-255*i/10,0+255*i/10,0);
            ellipse(GRAPH_X+BOX_WIDTH*i,height-GRAPH_Y-BOX_HEIGHT*i,dataBank.carsPerYear.getCars().get(i-1).getCars(),dataBank.carsPerYear.getCars().get(i-1).getCars());
        }
    }

    private void visualizeDataTable(){
        final int GRAPH_X = width/BOX_SIZE; //width of entire box
        final int GRAPH_Y = height/BOX_SIZE; //height of entire box
        final int BOX_HEIGHT = (height-2*(height/BOX_SIZE))/9; //height of one box
        final int BOX_WIDTH = (width-2*(width/BOX_SIZE))/3; // width of one box
        //code to draw data table
        stroke(0);
        fill(0);
        textAlign(CENTER);

        text("YEARS",(width / BOX_SIZE) + (BOX_WIDTH/2),height / BOX_SIZE - 10);
        text("NUMBER OF ELECTRIC CARS",GRAPH_X + (BOX_WIDTH/2) + BOX_WIDTH,height / BOX_SIZE - 10);
        text("AGGI", GRAPH_X + (BOX_WIDTH/2) + 2*BOX_WIDTH, height / BOX_SIZE - 10);

        for(int i = 0; i < 10; i++){//generates horizontals
            line(GRAPH_X,GRAPH_Y + (BOX_HEIGHT*i),width-(GRAPH_X),GRAPH_Y + (BOX_HEIGHT*i));
            int y = height / BOX_SIZE + BOX_HEIGHT/2 + BOX_HEIGHT*i + 5;

            if(i<9) {
                fill(180,0,0);
                text(dataBank.carBank.get(i).getYear(), (width / BOX_SIZE) + (BOX_WIDTH/2), y);
                fill(170, 105, 0);
                text(dataBank.carBank.get(i).getCars(), GRAPH_X + (BOX_WIDTH/2) + BOX_WIDTH, y);
                fill(160, 139, 0);
                text(dataBank.carBank.get(i).getPollution(), GRAPH_X + (BOX_WIDTH/2) + 2*BOX_WIDTH, y);
            }
        }
        fill(0);
        for(int i = 0; i < 4; i++){//generates verticals
            line(GRAPH_X + (BOX_WIDTH*i),GRAPH_Y,GRAPH_X + (BOX_WIDTH*i),height-(GRAPH_Y));
        }
    }

    public static DataAnalysisApp getApp(){
        return app;
    }

}
