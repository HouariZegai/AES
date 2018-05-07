package aes;

import java.util.ArrayList;
import java.util.List;

public class AES {

    private static final String[][] MIX_MATRICE = {
        {"02", "03", "01", "01"},
        {"01", "02", "03", "01"},
        {"01", "01", "02", "03"},
        {"03", "01", "01", "02"}};

    private static final String[][] S_BOX = {
        {"63", "7C", "77", "7B", "F2", "6B", "6F", "C5", "30", "01", "67", "2B", "FE", "D7", "AB", "76"},
        {"CA", "82", "C9", "7D", "FA", "59", "47", "F0", "AD", "D4", "A2", "AF", "9C", "A4", "72", "C0"},
        {"B7", "FD", "93", "26", "36", "3F", "F7", "CC", "34", "A5", "E5", "F1", "71", "D8", "31", "15"},
        {"04", "C7", "23", "C3", "18", "96", "05", "9A", "07", "12", "80", "E2", "EB", "27", "B2", "75"},
        {"09", "83", "2C", "1A", "1B", "6E", "5A", "A0", "52", "3B", "D6", "B3", "29", "E3", "2F", "84"},
        {"53", "D1", "00", "ED", "20", "FC", "B1", "5B", "6A", "CB", "BE", "39", "4A", "4C", "58", "CF"},
        {"D0", "EF", "AA", "FB", "43", "4D", "33", "85", "45", "F9", "02", "7F", "50", "3C", "9F", "A8"},
        {"51", "E3", "40", "BF", "92", "9D", "38", "F5", "BC", "B6", "DA", "21", "10", "FF", "F3", "D2"},
        {"CD", "0C", "13", "EC", "5F", "97", "44", "17", "C4", "A7", "7E", "3D", "64", "5D", "19", "73"},
        {"60", "81", "4F", "DC", "22", "2A", "90", "88", "46", "EE", "B8", "14", "DE", "5E", "0B", "DB"},
        {"E0", "32", "3A", "0A", "49", "06", "24", "5C", "C2", "D3", "AC", "62", "91", "95", "E4", "79"},
        {"E7", "C8", "37", "6D", "8D", "D5", "4E", "A9", "6C", "56", "F4", "EA", "65", "7A", "AE", "08"},
        {"BA", "78", "25", "2E", "1C", "16", "B4", "C6", "E8", "DD", "74", "1F", "4B", "BD", "8B", "8A"},
        {"70", "3E", "B5", "66", "48", "03", "F6", "0E", "61", "35", "57", "B9", "86", "C1", "1D", "9E"},
        {"E1", "F8", "98", "11", "69", "D9", "8E", "94", "9B", "1E", "87", "E9", "CE", "55", "28", "DF"},
        {"8C", "A1", "89", "0D", "BF", "E6", "42", "68", "41", "99", "2D", "0F", "B0", "54", "BB", "16"}
    };

    public String[][] encrypt(String input, String[][] key) {
        // This method doesn't finish (Demo)
        // This function ecnrypt the message

        String[][] msg = null;

        List<String> subInput = new ArrayList<>();

        while (input.length() % 16 != 0) {
            input += "0";
        }

        for (int i = 0; i < input.length() / 16; i++) {
            subInput.add(input.substring(i * 16, i * 16 + 16));
        }

        char in[] = subInput.get(0).toCharArray();

        for (char c : in) {
            System.out.print((int) c + " ");
        }

        //return mixColumn(shiftRow(subByte(addRoundKey(msg, key))));
        return null;
    }

    // Start AddRoundKey
    private String[][] addRoundKey(String[][] key, String[][] msg) {
        String[][] result = new String[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = getXOR(key[i][j], msg[i][j]);
            }
        }

        return result;
    }

    // End AddRoundKey
    // Start SubByte
    private String[][] subByte(String[][] input) {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int ligne = -1;
                int column = -1;

                switch (input[i][j].charAt(0)) {
                    case '0':
                        ligne = 0;
                        break;
                    case '1':
                        ligne = 1;
                        break;
                    case '2':
                        ligne = 2;
                        break;
                    case '3':
                        ligne = 3;
                        break;
                    case '4':
                        ligne = 4;
                        break;
                    case '5':
                        ligne = 5;
                        break;
                    case '6':
                        ligne = 6;
                        break;
                    case '7':
                        ligne = 7;
                        break;
                    case '8':
                        ligne = 8;
                        break;
                    case '9':
                        ligne = 9;
                        break;
                    case 'A':
                        ligne = 10;
                        break;
                    case 'B':
                        ligne = 11;
                        break;
                    case 'C':
                        ligne = 12;
                        break;
                    case 'D':
                        ligne = 13;
                        break;
                    case 'E':
                        ligne = 14;
                        break;
                    case 'F':
                        ligne = 15;
                        break;
                }

                switch (input[i][j].charAt(1)) {
                    case '0':
                        column = 0;
                        break;
                    case '1':
                        column = 1;
                        break;
                    case '2':
                        column = 2;
                        break;
                    case '3':
                        column = 3;
                        break;
                    case '4':
                        column = 4;
                        break;
                    case '5':
                        column = 5;
                        break;
                    case '6':
                        column = 6;
                        break;
                    case '7':
                        column = 7;
                        break;
                    case '8':
                        column = 8;
                        break;
                    case '9':
                        column = 9;
                        break;
                    case 'A':
                        column = 10;
                        break;
                    case 'B':
                        column = 11;
                        break;
                    case 'C':
                        column = 12;
                        break;
                    case 'D':
                        column = 13;
                        break;
                    case 'E':
                        column = 14;
                        break;
                    case 'F':
                        column = 15;
                        break;
                }
                input[i][j] = S_BOX[ligne][column];

            }
        }

        return input;
    }

    // End SubByte

    // Start ShiftRow
    
    private String[][] shiftRow(String[][] input) {
        String c;

        for (int i = 1; i < 4; i++) {
            for (int k = 0; k < i; k++) {

                c = input[i][0];
                for (int j = 1; j < 4; j++) {
                    input[i][j - 1] = input[i][j];
                }

                input[i][3] = c;
            }

        }

        return input;
    }

    // End ShiftRow
    
    // Start Mix Column
    
    private String[][] mixColumn(String input[][]) {
        String result[][] = new String[4][4];
        String c;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                c = "";
                for (int k = 0; k < 4; k++) {
                    c += getMulTable(MIX_MATRICE[i][k], input[k][j]) + "+";
                }
                result[i][j] = getXORList(c);
            }
        }

        return result;
    }

    private String getMulTable(String a, String b) {
        if (a.equals("01")) {
            return b;
        }

        if (a.equals("02")) {
            int[] binary = getBinary(b);
            boolean need1B = false;
            if (binary[0] == 1) {
                need1B = true;
            }

            for (int i = 1; i < 8; i++) {
                binary[i - 1] = binary[i];
            }
            binary[7] = 0;

            return (need1B) ? getXOR("1B", getHexa(binary)) : getHexa(binary);
        }

        if (a.equals("03")) {
            int[] binary = getBinary(b);
            boolean need1B = false;
            if (binary[0] == 1) {
                need1B = true;
            }

            for (int i = 1; i < 8; i++) {
                binary[i - 1] = binary[i];
            }
            binary[7] = 0;

            String result = (need1B) ? getXOR("1B", getHexa(binary)) : getHexa(binary);

            return result + "+" + b;
        }

        return null;
    }

    private String getXORList(String input) {
        String result = "";

        String[] inputTable = input.split("\\+");

        result = inputTable[0];

        for (int i = 1; i < inputTable.length; i++) {
            result = getXOR(result, inputTable[i]);
        }

        return result;
    }

    // End Mix Column
    
    private String getXOR(String a, String b) {
        int[] a1 = getBinary(a);
        int[] b1 = getBinary(b);

        for (int i = 0; i < 8; i++) {
            a1[i] = (a1[i] == b1[i]) ? 0 : 1;
        }

        return getHexa(a1);
    }

    private static int[] getBinary(String hexaDecimal) {
        int[] binary = new int[8];

        switch (hexaDecimal.charAt(0)) {
            case '0':
                binary[0] = 0;
                binary[1] = 0;
                binary[2] = 0;
                binary[3] = 0;
                break;
            case '1':
                binary[0] = 0;
                binary[1] = 0;
                binary[2] = 0;
                binary[3] = 1;
                break;
            case '2':
                binary[0] = 0;
                binary[1] = 0;
                binary[2] = 1;
                binary[3] = 0;
                break;
            case '3':
                binary[0] = 0;
                binary[1] = 0;
                binary[2] = 1;
                binary[3] = 1;
                break;
            case '4':
                binary[0] = 0;
                binary[1] = 1;
                binary[2] = 0;
                binary[3] = 0;
                break;
            case '5':
                binary[0] = 0;
                binary[1] = 1;
                binary[2] = 0;
                binary[3] = 1;
                break;
            case '6':
                binary[0] = 0;
                binary[1] = 1;
                binary[2] = 1;
                binary[3] = 0;
                break;
            case '7':
                binary[0] = 0;
                binary[1] = 1;
                binary[2] = 1;
                binary[3] = 1;
                break;
            case '8':
                binary[0] = 1;
                binary[1] = 0;
                binary[2] = 0;
                binary[3] = 0;
                break;
            case '9':
                binary[0] = 1;
                binary[1] = 0;
                binary[2] = 0;
                binary[3] = 1;
                break;
            case 'A':
                binary[0] = 1;
                binary[1] = 0;
                binary[2] = 1;
                binary[3] = 0;
                break;
            case 'B':
                binary[0] = 1;
                binary[1] = 0;
                binary[2] = 1;
                binary[3] = 1;
                break;
            case 'C':
                binary[0] = 1;
                binary[1] = 1;
                binary[2] = 0;
                binary[3] = 0;
                break;
            case 'D':
                binary[0] = 1;
                binary[1] = 1;
                binary[2] = 0;
                binary[3] = 1;
                break;
            case 'E':
                binary[0] = 1;
                binary[1] = 1;
                binary[2] = 1;
                binary[3] = 0;
                break;
            case 'F':
                binary[0] = 1;
                binary[1] = 1;
                binary[2] = 1;
                binary[3] = 1;
                break;
        }

        switch (hexaDecimal.charAt(1)) {
            case '0':
                binary[4] = 0;
                binary[5] = 0;
                binary[6] = 0;
                binary[7] = 0;
                break;
            case '1':
                binary[4] = 0;
                binary[5] = 0;
                binary[6] = 0;
                binary[7] = 1;
                break;
            case '2':
                binary[4] = 0;
                binary[5] = 0;
                binary[6] = 1;
                binary[7] = 0;
                break;
            case '3':
                binary[4] = 0;
                binary[5] = 0;
                binary[6] = 1;
                binary[7] = 1;
                break;
            case '4':
                binary[4] = 0;
                binary[5] = 1;
                binary[6] = 0;
                binary[7] = 0;
                break;
            case '5':
                binary[4] = 0;
                binary[5] = 1;
                binary[6] = 0;
                binary[7] = 1;
                break;
            case '6':
                binary[4] = 0;
                binary[5] = 1;
                binary[6] = 1;
                binary[7] = 0;
                break;
            case '7':
                binary[4] = 0;
                binary[5] = 1;
                binary[6] = 1;
                binary[7] = 1;
                break;
            case '8':
                binary[4] = 1;
                binary[5] = 0;
                binary[6] = 0;
                binary[7] = 0;
                break;
            case '9':
                binary[4] = 1;
                binary[5] = 0;
                binary[6] = 0;
                binary[7] = 1;
                break;
            case 'A':
                binary[4] = 1;
                binary[5] = 0;
                binary[6] = 1;
                binary[7] = 0;
                break;
            case 'B':
                binary[4] = 1;
                binary[5] = 0;
                binary[6] = 1;
                binary[7] = 1;
                break;
            case 'C':
                binary[4] = 1;
                binary[5] = 1;
                binary[6] = 0;
                binary[7] = 0;
                break;
            case 'D':
                binary[4] = 1;
                binary[5] = 1;
                binary[6] = 0;
                binary[7] = 1;
                break;
            case 'E':
                binary[4] = 1;
                binary[5] = 1;
                binary[6] = 1;
                binary[7] = 0;
                break;
            case 'F':
                binary[4] = 1;
                binary[5] = 1;
                binary[6] = 1;
                binary[7] = 1;
                break;
        }

        return binary;
    }

    public static int[] getBinary(int asciiCode) {
        int[] binary = new int[8];

        int count = 7;

        while (asciiCode > 0) {
            binary[count--] = asciiCode % 2;
            asciiCode /= 2;
        }

        return binary;
    }

    private static String getHexa(int[] binary) {
        String hexaDecimal = "";

        String binary4Bit = binary[0] + "" + binary[1] + "" + binary[2] + "" + binary[3];

        switch (binary4Bit) {
            case "0000": ;
                hexaDecimal = "0";
                break;
            case "0001": ;
                hexaDecimal = "1";
                break;
            case "0010": ;
                hexaDecimal = "2";
                break;
            case "0011": ;
                hexaDecimal = "3";
                break;
            case "0100": ;
                hexaDecimal = "4";
                break;
            case "0101": ;
                hexaDecimal = "5";
                break;
            case "0110": ;
                hexaDecimal = "6";
                break;
            case "0111": ;
                hexaDecimal = "7";
                break;
            case "1000": ;
                hexaDecimal = "8";
                break;
            case "1001": ;
                hexaDecimal = "9";
                break;
            case "1010": ;
                hexaDecimal = "A";
                break;
            case "1011": ;
                hexaDecimal = "B";
                break;
            case "1100": ;
                hexaDecimal = "C";
                break;
            case "1101": ;
                hexaDecimal = "D";
                break;
            case "1110": ;
                hexaDecimal = "E";
                break;
            case "1111": ;
                hexaDecimal = "F";
                break;
        }

        binary4Bit = binary[4] + "" + binary[5] + "" + binary[6] + "" + binary[7];

        switch (binary4Bit) {
            case "0000": ;
                hexaDecimal += "0";
                break;
            case "0001": ;
                hexaDecimal += "1";
                break;
            case "0010": ;
                hexaDecimal += "2";
                break;
            case "0011": ;
                hexaDecimal += "3";
                break;
            case "0100": ;
                hexaDecimal += "4";
                break;
            case "0101": ;
                hexaDecimal += "5";
                break;
            case "0110": ;
                hexaDecimal += "6";
                break;
            case "0111": ;
                hexaDecimal += "7";
                break;
            case "1000": ;
                hexaDecimal += "8";
                break;
            case "1001": ;
                hexaDecimal += "9";
                break;
            case "1010": ;
                hexaDecimal += "A";
                break;
            case "1011": ;
                hexaDecimal += "B";
                break;
            case "1100": ;
                hexaDecimal += "C";
                break;
            case "1101": ;
                hexaDecimal += "D";
                break;
            case "1110": ;
                hexaDecimal += "E";
                break;
            case "1111": ;
                hexaDecimal += "F";
                break;
        }

        return hexaDecimal;
    }

}
