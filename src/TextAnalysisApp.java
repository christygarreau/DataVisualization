import processing.core.PApplet;

import java.util.ArrayList;

public class TextAnalysisApp extends PApplet{

    private static DataBank wordBank;
    private ArrayList<Term> terms;
    private CarsPerYear carsPerYear;
    public static TextAnalysisApp app;

    public static void main(String[] args) {
        PApplet.main("TextAnalysisApp");
    }

    public TextAnalysisApp() {}

    public void settings() {
        size(1000,500);
    }

    public void setup() {
        textAlign(CENTER, CENTER);
        wordBank = new DataBank(this);
        wordBank.sort();
    }

    public void draw() {
        background(0);
        stroke(0);
        ArrayList<WordOccurrence> wordOccurrences = wordBank.getWordOccurrences();
        for(WordOccurrence wordOccurrence : wordOccurrences){
            float x = random(width);
            float y = random(height);
            float diameter = wordOccurrence.getOccurrences();
            System.out.println(diameter);
            noFill();
            //ellipse(x,y,diameter, diameter);

            textAlign(CENTER);
            textSize(diameter/50);
            fill(color(random(255),random(255),random(255)));
            text(wordOccurrence.getWord(),x,y);
        }
        noLoop();
    }
    public static TextAnalysisApp getApp(){
        return app;
    }

}
