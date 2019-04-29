import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Arrays;

public class DataBank implements Searchable, Sortable{
    PApplet p;
    ArrayList<String> dataBank;
    private ArrayList<WordOccurrence> wordOccurrences;

    public DataBank(PApplet p) {
        this.p = p;
        dataBank = generateDataBank();
        sort();
        wordOccurrences = generateWordOccurrences();
    }

    public int find(String key) {
        int linear = linearSearch(key);
        int binary = binarySearch(key);

        System.out.println("Linear search found '" + key + "' at " + linear);
        System.out.println("Matches?                            " + (linear==binary));

        return binary;
    }

    public void sort() {
        String[] arr = new String[dataBank.size()];
        arr = dataBank.toArray(arr);
        mergeSort(arr);
        //selectionSort(0);
        //insertionSort();
        dataBank = new ArrayList<>(Arrays.asList(arr));
    }

    private int linearSearch(String key) {
        int i = 0;
        boolean found = false;
        int position = -1;
        while(i < dataBank.size() && !found){
            if(dataBank.get(i).equals(key)){
                position = i;
                found = true;
            }
            i++;
        }
        return position;
    }

    private int binarySearch(String key) {
        System.out.print("Binary searching");
        key = key.toLowerCase();
        int low = 0;
        int high = dataBank.size() - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            System.out.print(".");
            String current = dataBank.get(mid);

            if(current.equals(key)) {
                System.out.println(" Done! Key found at " + mid + ".");
                return mid;
            } else if(current.compareTo(key) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(" Key not found.");
        return -1;
    }

    private void selectionSort(int start) {
        if (start == 0) {
            System.out.print("Selection sorting");
        }
        if (start < dataBank.size()) {
            int lowest = start;
            for (int i = start; i < dataBank.size(); i++) {
                if (dataBank.get(i).compareTo(dataBank.get(lowest)) < 0) {
                    lowest = i;
                }
            }
            String temp = dataBank.get(start);
            dataBank.set(start, dataBank.get(lowest));
            dataBank.set(lowest, temp);


            if (start % (dataBank.size()/15) == 0) { //every 15th
                System.out.print(".");
            }

            selectionSort(start+1);
        } else {
            System.out.println(" Done!");
        }
    }

    private void insertionSort() {
        for (int i = 1; i < dataBank.size(); i++) {
            String current = dataBank.get(i);
            int curIndex = i-1;
            while ( curIndex > -1 && dataBank.get(curIndex).compareTo(current) > 0) {
                dataBank.set(curIndex+1, dataBank.get(curIndex));
                curIndex--;
            }
            dataBank.set(curIndex+1, current);
        }
    }

    private void mergeSort(String[] arr) {
        if (arr.length <= 1) {
            return;
        }

        String[] firstHalf = new String[arr.length / 2];
        String[] secondHalf = new String[arr.length - firstHalf.length];
        System.arraycopy(arr, 0, firstHalf, 0, firstHalf.length);
        System.arraycopy(arr, firstHalf.length, secondHalf, 0, secondHalf.length);

        mergeSort(firstHalf);
        mergeSort(secondHalf);

        merge(firstHalf, secondHalf, arr);
    }
    private void merge(String[] firstHalf, String[] secondHalf, String [] result) {
        int firstIndex=0; int secondIndex = 0; int resultIndex = 0;

        while (firstIndex < firstHalf.length && secondIndex < secondHalf.length) {
            if (firstHalf[firstIndex].compareTo(secondHalf[secondIndex]) < 0) {
                result[resultIndex] = firstHalf[firstIndex];
                firstIndex++;
            }
            else {
                result[resultIndex] = secondHalf[secondIndex];
                secondIndex++;
            }
            resultIndex++;
        }
        System.arraycopy(firstHalf, firstIndex, result, resultIndex, firstHalf.length - firstIndex);
        System.arraycopy(secondHalf, secondIndex, result, resultIndex, secondHalf.length - secondIndex);
    }

    private void printBank(int number) {
        for (int i = 0; i < number; i++) {
            System.out.print("\"" + dataBank.get(i) + "\", ");
        }
        System.out.println();
    }

    private ArrayList<String> generateDataBank() {
        String[] rawtext = p.loadStrings("data/ElectricCars.csv");
        String everything = p.join(rawtext, " ");
        everything = everything.toLowerCase();

        String delimiters = " ,.?!;:[](){}'\"\\/’‘“_#*-@$%^&—";
        String[] allwords = p.splitTokens(everything, delimiters);

        ArrayList<String> mysteryBank = new ArrayList<String>();
        for (int i = 0; i < allwords.length; i++) {
            if (allwords[i].length() > 5 && allwords[i].length() < 10) {
                String s = allwords[i];
                mysteryBank.add(s);
            }
        }
        return mysteryBank;
    }

    public ArrayList<WordOccurrence> getWordOccurrences() {
        return wordOccurrences;
    }

    public ArrayList<WordOccurrence> generateWordOccurrences() {
        ArrayList<WordOccurrence> words = new ArrayList<WordOccurrence>();
        for(int i = 0; i< dataBank.size(); i++){
            String word = dataBank.get(i);
            int wordOccurrences = 1;
            for(int j = 0; j< dataBank.size(); j++){
                if(dataBank.get(i).compareToIgnoreCase(word) == 0){
                    wordOccurrences++;
                }
            }
            WordOccurrence occurrenceOfWord = new WordOccurrence(word, wordOccurrences);
            words.add(occurrenceOfWord);
        }
        return words;
    }

}