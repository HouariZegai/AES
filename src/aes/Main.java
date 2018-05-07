package aes;

public class Main {

    private static void printTable(String[][] table) {
        for (String[] row : table) {
            for (String c : row) {
                System.out.print(c + " | ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String key[][] = {
            {"A0", "88", "23", "2A"},
            {"FA", "54", "A3", "6C"},
            {"FE", "2C", "39", "76"},
            {"17", "B1", "39", "05"}};

        String msg[][] = {
            {"EA", "04", "65", "85"},
            {"83", "45", "5D", "96"},
            {"5C", "33", "98", "B0"},
            {"F0", "2D", "AD", "C5"}};
        
    }
}
