import processing.core.PApplet;
import java.util.ArrayList;

public class DataBank implements Sortable{
    PApplet p;
    ArrayList<CarDatum> carBank;
    ArrayList<PollutionDatum> pollutionBank;

    public DataBank(PApplet p) {
        this.p = p;
        sort();
    }

    public void sort() {
        String[] carArr = new String[carBank.size()];
        carArr = carBank.toArray(carArr);

        String[] pollutionArr = new String[carBank.size()];
        pollutionArr = pollutionBank.toArray(pollutionArr);

        selectionSort(0, carArr);
        selectionSort(0, pollutionArr);

        //carBank = new ArrayList<CarDatum>(Arrays.asList(carArr));
        //pollutionBank = new ArrayList<PollutionDatum>(Arrays.asList(pollutionArr));
    }

    private void selectionSort(int start, String[] arr) {
        if (start == 0) {
            System.out.print("Selection sorting");
        }
        if (start < arr.length) {
            int lowest = start;
            for (int i = start; i < arr.length; i++) {
                if (arr[i].compareTo(arr[lowest]) < 0) {
                    lowest = i;
                }
            }
            String temp = arr[start];
            arr[start] = arr[lowest];
            arr[lowest] = temp;


            if (start % (arr.length/15) == 0) { //every 15th
                System.out.print(".");
            }

            selectionSort(start+1, arr);
        } else {
            System.out.println(" Done!");
        }
    }

    private void printBank(int number, String[] arr) {
        for (int i = 0; i < number; i++) {
            System.out.print("\"" + arr[i] + "\", ");
        }
        System.out.println();
    }
}