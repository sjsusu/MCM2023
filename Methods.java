public class Methods {

    //Checks a column for a letter and returns the number of times it appears
    public static int checkColumn(String[][] array, int column, char letter) {
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            String word = array[i][column];
            char[] wordArray = word.toCharArray();
            for (int j = 0; j < wordArray.length; j++){
                if (wordArray[j] == letter) {
                    count++;
                }
            }

        }
        return count;
    }

    //Checks a column for a word and returns the number of times it appears
    public static int checkColumn(String[][] array, int column, String word) {
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            String wordToCheck = array[i][column];
            if (wordToCheck.contains(word)) {
                count++;
            }
        }
        return count;
    }

    //Checks a column for a letter at a specific index and returns the number of times it appears
    public static int checkIndex(String[][] array, int column, int index, char letter) {
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            String word = array[i][column];
            char[] wordArray = word.toCharArray();
            if (wordArray[index] == letter) {
                count++;
            }
        }
        return count;
    }

    //key provides value of each letter given position in a 5 character word
    //each row contains the ascii value of the letter (lowercase), the value of the letter in the first position, second position, third position, fourth position, and fifth position
    static double[][] key = {
        {97,7.799442897,13.37047354,11.97771588,8.635097493,2.506963788},
        {98,5.571030641,0.278551532,2.228412256,0.557103064,0},
        {99,9.192200557,1.39275766,2.506963788,5.292479109,1.39275766},
        {100,3.342618384,0.557103064,3.342618384,2.228412256,5.571030641},
        {101,2.78551532,7.799442897,8.356545961,11.97771588,20.33426184},
        {102,6.128133705,0,1.114206128,1.114206128,0.835654596},
        {103,4.735376045,0.557103064,2.506963788,4.456824513,1.949860724},
        {104,3.064066852,9.192200557,0.557103064,1.114206128,5.571030641},
        {105,2.78551532,6.406685237,12.25626741,6.406685237,0.557103064},
        {106,0.557103064,0.278551532,0.278551532,0,0},
        {107,0.835654596,0.278551532,1.114206128,3.064066852,4.456824513},
        {108,3.621169916,11.69916435,2.506963788,6.685236769,6.685236769},
        {109,5.571030641,1.671309192,1.949860724,4.178272981,1.949860724},
        {110,1.671309192,4.735376045,6.406685237,7.242339833,4.456824513},
        {111,1.114206128,14.20612813,13.9275766,4.735376045,3.064066852},
        {112,6.406685237,3.064066852,3.899721448,2.228412256,2.228412256},
        {113,0.835654596,0.557103064,0,0,0},
        {114,3.621169916,10.30640669,5.571030641,8.077994429,9.749303621},
        {115,14.20612813,1.114206128,2.228412256,5.849582173,0.835654596},
        {116,8.356545961,3.899721448,3.621169916,7.520891365,12.81337047},
        {117,2.228412256,4.735376045,7.799442897,2.78551532,0.278551532},
        {118,1.671309192,0.278551532,2.228412256,2.78551532,0},
        {119,3.064066852,1.671309192,1.39275766,1.39275766,0.835654596},
        {120,0,1.39275766,0,0.835654596,0},
        {121,0.557103064,0.557103064,2.228412256,0,13.64902507},
        {122,0.278551532,0,0,0.835654596,0.278551532}
    };

    //Calcuates the value of each word and returns an array of the values
    public static double[] stringValues(String[][] array, int column) {
        double[] values = new double[array.length - 1];
        for (int i = 1; i < array.length; i++) {
            String word = array[i][column];
            values[i - 1] = stringValue(word);
        }
        return values;
    }

    //Calculates the value of a word
    public static double stringValue(String word) {
        char[] wordArray = word.toCharArray();
        double value = 1;
        for (int j = 0; j < wordArray.length; j++) {
            char letter = wordArray[j];
            value *= letterValue(letter, j);
        }
        return value;
    }

    //Calculates the value of a letter given its position in a word
    public static double letterValue(char letter, int index) {
        double value = 0;
        int ascii = (int) letter;
        switch (index) {
            case 0:
                value = key[ascii - 97][1];
                break;
            case 1:
                value = key[ascii - 97][2];
                break;
            case 2:
                value = key[ascii - 97][3];
                break;
            case 3:
                value = key[ascii - 97][4];
                break;
            case 4:
                value = key[ascii - 97][5];
                break;
        }
        return value;
    }

}
