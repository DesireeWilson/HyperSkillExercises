package readability;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Readability readability = new Readability();
        try(Scanner scanner = new Scanner(new File(args[0]));) {
            while(scanner.hasNextLine()){
                String input = scanner.nextLine();

                readability.storeInput(input);
                readability.updateCharacterCount(input);
                readability.updateWordCount(input);
                readability.updateSentenceCount(input);

                for (String word : input.split("\\s")) {
                    readability.updateSyllabeCount(word);
                    readability.updatePolysyllableCount(word);
                }
            }
            System.out.println();
            readability.calculateARIScore();
            readability.calculateFKRTScore();
            readability.calculateSMOGScore();
            readability.calculateCLScore();
            //System.out.println(readability);
            scanner.close();
            UI(readability);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void UI(Readability readability){
        Scanner scan = new Scanner(System.in);
        //prompt:
        String input = "";
        String output = "The text is: \n" + readability.retrieveInput() + "\n\n" +
                readability.toString();

        System.out.println(output);
        System.out.println("Enter the score you want to calculate " +
                "(ARI, FK, SMOG, CL, all): ");

        input = scan.nextLine();

        String statement = "";
        double score = 0;
        int age = 0;
        switch(input){
            case "ARI":
                score = readability.getScoreARI();
                age = readability.getAge(score);
                statement = "Automated Readability Index: " +
                        String.format("%.2f", score) + " (about " +
                        age + "-year-olds).";
                break;
            case "FK":
                score = readability.getScoreFKRT();
                age = readability.getAge(score);
                statement = "Flesch-Kincaid readability tests: " +
                        String.format("%.2f", score) + " (about " +
                        age + "-year-olds).";
                break;
            case "SMOG":
                score = readability.getScoreSMOG();
                age = readability.getAge(score);
                statement = "Simple Measure of Gobbledygook: " +
                        String.format("%.2f", score) + " (about " +
                        age + "-year-olds).";
                break;
            case "CL":
                score = readability.getScoreCL();
                age = readability.getAge(score);
                statement = "Flesch-Kincaid readability tests: " +
                        String.format("%.2f", score) + " (about " +
                        age + "-year-olds).";
                break;
            case "all":
                double score1 = readability.getScoreARI();
                double score2 = readability.getScoreFKRT();
                double score3 = readability.getScoreSMOG();
                double score4 = readability.getScoreCL();;
                int age1 = readability.getAge(score1);
                int age2 = readability.getAge(score2);
                int age3 = readability.getAge(score3);
                int age4 = readability.getAge(score4);
                String statement1 = "Automated Readability Index: " +
                        String.format("%.2f", score1) + " (about " +
                        age1 + "-year-olds).\n";
                String statement2 = "Flesch-Kincaid readability tests: " +
                        String.format("%.2f", score2) + " (about " +
                        age2 + "-year-olds).\n";
                String statement3 = "Simple Measure of Gobbledygook: " +
                        String.format("%.2f", score3) + " (about " +
                        age3 + "-year-olds).\n";
                String statement4 = "Coleman-Liau index: " +
                        String.format("%.2f", score4) + " (about " +
                        age4 + "-year-olds).\n";
                String statement5 = "This text should be understood in average by "+
                        ((age1 + age2 + age3 + age4)/4.0) + "-year-olds.";
                statement = statement1 + statement2 + statement3 + statement4 +
                        "\n" + statement5;
                break;
        }
        System.out.println(statement);
    }

}
