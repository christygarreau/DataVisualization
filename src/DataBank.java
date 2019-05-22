import processing.core.PApplet;
import java.util.ArrayList;

public class DataBank implements Sortable{
    PApplet p;
    ArrayList<CarDatum> carBank;
    CarsPerYear carsPerYear = new CarsPerYear();

    public DataBank(PApplet p) {
        this.p = p;
        carBank = carsPerYear.getCars();
        sort();
        printBank(carBank.size(),carBank);
    }

    public void sort() {
        selectionSort(0, carBank);
    }

    private void selectionSort(int start, ArrayList<CarDatum> carBank) {
        if (start == 0) {
            System.out.print("Begin Selection Sort...");
        }
        if (start < carBank.size()) {
            int lowest = start;
            for (int i = start; i < carBank.size(); i++) {
                if (carBank.get(i).getCars() < (carBank.get(lowest).getCars())) {
                    lowest = i;
                }
            }
            CarDatum temp = carBank.get(start);
            carBank.set(start, carBank.get(lowest));
            carBank.set(lowest, temp);

            selectionSort(start+1, carBank);
        } else {
            System.out.println("End Selection Sort.");
        }
    }

    private void printBank(int number, ArrayList<CarDatum> carBank) {
        for (int i = 0; i < number; i++) {
            System.out.print("\"" + carBank.get(i).getCars() + "\", ");
            System.out.print("\"" + carBank.get(i).getPollution() + "\", ");
            System.out.print("\"" + carBank.get(i).getYear() + "\", ");
            System.out.println();
        }
        System.out.println();
    }
}