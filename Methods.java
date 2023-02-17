public class Methods {

    //Checks a column for a letter and returns the number of times it appears
    public static int checkColumn(String[][] array, int column, char letter) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
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
        for (int i = 0; i < array.length; i++) {
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
        for (int i = 0; i < array.length; i++) {
            String word = array[i][column];
            char[] wordArray = word.toCharArray();
            if (wordArray[index] == letter) {
                count++;
            }
        }
        return count;
    }




}
