package readability;

import java.util.Locale;

public class Readability {
    private String input = "";
    private int numOfCharacters;
    private int numOfWords;
    private int numOfSentences;
    private int numOfSyllables;
    private int numOfPolysyllables;
    private double scoreARI;
    private double scoreFKRT;
    private double scoreSMOG;
    private double scoreCL;

    public Readability() {}

    public void storeInput(String input){
        this.input += input;
    }

    public String retrieveInput() {
        return this.input;
    }

    public int countCharacters(String input) {
        return input.replaceAll("\\s", "").toCharArray().length;
    }

    public int countWords(String input) {
        String[] inputArray = input.split("\\s");
        return inputArray.length;
    }

    public int countSentences(String input) {
        String[] inputArray = input.split("\\.|\\?|!");
        return inputArray.length;
    }

    public int countSyllables(String word) {
        int count = 0;
        //words will be the input
        String changedWord = word.toLowerCase(Locale.ROOT)
                .replaceAll("e\\b", "")
                .replaceAll("you", "a")
                .replaceAll("[aeiouy]{2}", "a")
                .replaceAll(" th "," a ")
                .replaceAll(",","");
        for (char letter : changedWord.toCharArray()) {
            if("aeiouy".contains(String.valueOf(letter))){
                count++;
            }
        }
        if(count == 0) {
            count = 1;
        }
        return count;
    }

    public int countPolysyllables(String word) {
        int count = 0;
        //words will be the input
        if(countSyllables(word) >= 3){
            count++;
        }
        return count;
    }

    public void updateSyllabeCount(String word){
        this.numOfSyllables += countSyllables(word);
    }

    public void updatePolysyllableCount(String word){
        this.numOfPolysyllables += countPolysyllables(word);
    }

    public void updateCharacterCount(String input) {
        this.numOfCharacters += countCharacters(input);
    }

    public void updateWordCount(String input) {
        this.numOfWords += countWords(input);
    }

    public void updateSentenceCount(String input) {
        this.numOfSentences += countSentences(input);
    }

    public void calculateARIScore() {
        this.scoreARI = 4.71 * (1.0 * numOfCharacters/numOfWords) +
                0.5 * (1.0 * numOfWords/numOfSentences) - 21.43;
    }

    public void calculateFKRTScore() {
        this.scoreFKRT = 0.39 * (1.0 * numOfWords/numOfSentences) +
                11.8 * (1.0 * numOfSyllables/numOfWords) - 15.59;
    }

    public void calculateSMOGScore() {
        double discriminant = numOfPolysyllables * (1.0 * 30/numOfSentences);
        this.scoreSMOG = 1.043 * Math.pow(discriminant, 0.5) + 3.1292;
    }

    public void calculateCLScore() {
        double L = 100 * (1.0 * numOfCharacters/numOfWords);
        double S = 100 * (1.0 * numOfSentences/numOfWords);
        this.scoreCL = 0.0588 * L - 0.296 * S - 15.8;
    }

    public double getScoreARI() {
        return scoreARI;
    }

    public double getScoreFKRT() {
        return scoreFKRT;
    }

    public double getScoreSMOG() {
        return scoreSMOG;
    }

    public double getScoreCL() {
        return this.scoreCL;
    }

    public int getAge(double score) {
        int result = 0;
        switch ((int)Math.round(score)){
            case 1:
                result = 6;
                break;
            case 2:
                result = 7;
                break;
            case 3:
                result = 9;
                break;
            case 4:
                result = 10;
                break;
            case 5:
                result = 11;
                break;
            case 6:
                result = 12;
                break;
            case 7:
                result = 13;
                break;
            case 8:
                result = 14;
                break;
            case 9:
                result = 15;
                break;
            case 10:
                result = 16;
                break;
            case 11:
                result = 17;
                break;
            case 12:
                result = 18;
                break;
            case 13:
                result = 24;
                break;
            case 14:
                result = 25;
                break;
            default:
                result = -1;
        }
        return result;
    }

    @Override
    public String toString() {
        String output = "";
        output = "Words: " + numOfWords + "\n" +
                "Sentences: " + numOfSentences + "\n" +
                "Characters: " + numOfCharacters + "\n" +
                "Syllables: " + numOfSyllables + "\n" +
                "Polysyllables: " + numOfPolysyllables + "\n";
        return output;
    }
}
