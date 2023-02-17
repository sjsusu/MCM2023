import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class csvReader {
    public static void main(String[] args) {
        String filename = "wordle.csv";

        String[][] data = readFileInto2DArray(filename, 12);

        //Prints out the 2d array
        for (int i = 0; i < data.length; i++) {
            System.out.println(String.join(",", data[i]));
        }

        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        char[] letterCounts = new char[26];

        //Checks the column for each letter and prints out the number of times it appears
        for (int i = 0; i < 26; i++) {
            int count = Methods.checkColumn(data, 2, letters[i]);
            letterCounts[i] = (char) count;
            System.out.println(letters[i] + ": " + count);
        }

        //Checks the column for a word and prints out the number of times it appears
        String word = "rr";
        int count = Methods.checkColumn(data, 2, word);
        System.out.println(word+ ": " +count);

        //Checks the column for a letter at a specific index and prints out the number of times it appears
        for (char letter: letters) {
            count = Methods.checkIndex(data, 2, 3, letter);
            System.out.println(count);
        }
 

    }

    //csv to 2d String array source: https://youtu.be/hluNujCUigw
    public static String[][] readFileInto2DArray(String filepath, int amountofFields) {
        List<String> recordsList = new ArrayList<String>();

        String delimiter = ",";
        String currentLine;

        try {
            FileReader fr = new FileReader(filepath);
            try (BufferedReader br = new BufferedReader(fr)) {
                while ((currentLine = br.readLine()) != null) {
                    recordsList.add(currentLine);

                }
            }

            int recordCount = recordsList.size();

            String[][] arrayToReturn = new String[recordCount][amountofFields];
            String[] data;

            for (int i = 0; i < recordCount; i++) {
                data = recordsList.get(i).split(delimiter);

                for (int j = 0; j < data.length; j++) {
                    arrayToReturn[i][j] = data[j];

                }
            }

            return arrayToReturn;
            
        } catch (Exception e) {
            System.out.println(e);

            return null;
        }
    }
}