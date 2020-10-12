import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dnaSequence = scanner.nextLine();
        double gcCount = 0;
        for (int i = 0; i < dnaSequence.length(); i++) {
            String dnaBase = String.valueOf(dnaSequence.charAt(i));
            gcCount = (dnaBase.equalsIgnoreCase("g") || dnaBase.equalsIgnoreCase("c")) ?
                    gcCount + 1 : gcCount + 0;
        }
        System.out.println(gcCount / dnaSequence.length() * 100);
    }
}