package numbers;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;
import static java.lang.System.exit;



public class Main {
    static void welcomeMsg(){
        System.out.print(
                "Welcome to Amazing Numbers!\n" +
                        "\n" +
                        "Supported requests:\n" +
                        "- enter a natural number to know its properties;\n" +
                        "- enter two natural numbers to obtain the properties of the list:\n" +
                        "  * the first parameter represents a starting number;\n" +
                        "  * the second parameter shows how many consecutive numbers are to be processed;\n" +
                        "- two natural numbers and properties to search for;\n" +
                        "- a property preceded by minus must not be present in numbers;\n" +
                        "- separate the parameters with one space;\n" +
                        "- enter 0 to exit.");

    }
    static void ifZero(long num){
        if(num == 0){
            System.out.print("\nGoodbye!");
            System.exit(0);
        }
    }
    static boolean ifEven(long num){
        if (num % 2 == 0) {
            return true;
        }
        return false;
    }
    static boolean ifDivisible(long num){
        if (num % 7 == 0) {
            return true;
        }
        return false;
    }
    static boolean ifEnd7(long num){
        if (num % 10 == 7) {
            return true;
        }
        return false;
    }
    static boolean ifBuzz(long num){
        if(ifDivisible(num) || ifEnd7(num)){
            return true;
        }
        return false;
    }
    static boolean ifDuck(long num){
        String sNum = Long.toString(num);
        for (int i = 0; i < sNum.length(); i++) {
            if (sNum.charAt(i) == '0') {
                return true;
            }
        }
        return false;
    }
    static boolean ifPalindromic(long num){
        String sNum = Long.toString(num);
        if(sNum.length() > 1) {
            byte[] byteArr = sNum.getBytes();
            byte[] rNum = new byte[byteArr.length];

            for (int i = 0; i < byteArr.length; i++) {
                rNum[i] = byteArr[byteArr.length - i - 1];
            }
            String srNum = new String(rNum);
            //long rnum = Long.parseLong(srNum);
            if (srNum.equals(sNum)) {
                return true;
            }
        }else{
            return true;
        }
        return false;
    }
    static boolean ifGapful(long num){
        String sNum = Long.toString(num);
        byte[] byteArr = sNum.getBytes();
        byte[] gNum = new byte[2];
        if(sNum.length() >= 3){
            gNum[0] = byteArr[0];
            gNum[1] = byteArr[byteArr.length - 1];
            String sgNum = new String(gNum);
            long gnum = Long.parseLong(sgNum);

            if(num % gnum == 0){
                return true;
            }
        }
        return false;
    }
    static boolean ifSpy(long num){
        String sNum = Long.toString(num);
        long sum = 0, product = 1;
        byte[] byteArr = sNum.getBytes();
        for(int i = 0; i < byteArr.length; i++){

            sum += (byteArr[i] - 48);//System.out.println("Sum =" + sum);
            //System.out.println(byteArr[i] - 48);
            product *= (byteArr[i] - 48);//System.out.println("pdt =" + product);

        }
        if(sum == product){
            return true;
        }
        return false;
    }
    static boolean ifSquare(long num){
        double sqroot = Math.round(Math.sqrt(num));
        //  System.out.println(Math.sqrt(num + 1) + " " + sqroot + " " + Math.pow(sqroot, 2));
        if(num == Math.pow(sqroot, 2)){
            return true;
        }
        return false;
    }
    static boolean ifSunny(long num){
        double sqroot = Math.round(Math.sqrt(num + 1));
        //  System.out.println(Math.sqrt(num + 1) + " " + sqroot + " " + Math.pow(sqroot, 2));
        if((num + 1) == Math.pow(sqroot, 2)){
            return true;
        }
        return false;
    }
    static boolean ifJumping(long num){
        if(num < 10){
            return true;
        }
        String snum = Long.toString(num);
        int[] numArr = new int[snum.length()];
        for(int i = 0; i < snum.length(); i++){
            numArr[i] = snum.charAt(i) - '0';
        }
        for(int i = 0; i < snum.length() - 1;i++){
            if(Math.abs(numArr[i] - numArr[i + 1]) != 1){
                return false;
            }
        }
        return true;
    }
    static boolean ifSad(long num){

        if(!ifHappy(num)){
            return true;
        }
        return false;
    }
    static boolean ifHappy(long num){
        long startingnum = num;
        int n = 0;
        if(num == 1){
            return true;
        }
        while(num != 1) {
            //System.out.println(num);
            long total = 0;
            String snum = Long.toString(num);
            int[] numArr = new int[snum.length()];
            for (int i = 0; i < snum.length(); i++) {
                numArr[i] = snum.charAt(i) - '0';
            }
            for(int i = 0; i < snum.length();i++){
                total += Math.pow(numArr[i], 2);
            }
            num = total;

            if(num == startingnum){
                break;
            }
            if(num == 1){
                return true;
            }
            if(n > 1000){
                break;
            }
            n++;
        }
        return false;
    }

    static void scanLine(){
        System.out.println("\nEnter a request:");
        long num = 0, num1 = 0, num2 = 0;
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();

        if(line.equals("")){
            welcomeMsg();
            scanLine();
        }

        List<Integer> spaceLst = new ArrayList<Integer>();
        int numOfSpace = 0;

        byte[] byteArr = line.getBytes();
        for(int i = 0; i < byteArr.length; i++){
            if(byteArr[i] == ' '){
                numOfSpace++;
                spaceLst.add(i);

            }
        }
        Integer[] spcIdx = spaceLst.toArray(new Integer[spaceLst.size()]);
        //  System.out.println(numOfSpace);

        if(numOfSpace >= 2){
            byte[] Num1 = new byte[spcIdx[0]];
            byte[] Num2 = new byte[spcIdx[1] - spcIdx[0] - 1];
            byte[] PNm = new byte[byteArr.length - spcIdx[1] - 1];
            for(int i = 0; i < spcIdx[0]; i++){
                Num1[i] = byteArr[i];
            }
            for(int j = 0; j < spcIdx[1] - spcIdx[0] - 1; j++){
                Num2[j] = byteArr[j + spcIdx[0] + 1];
            }
            for(int k = 0; k < byteArr.length - spcIdx[1] - 1; k++){
                PNm[k] = byteArr[k + spcIdx[1] + 1];
            }

            String sNum1 = new String(Num1);
            String sNum2 = new String(Num2);
            String pnm = new String(PNm);

            num1 = Long.parseLong(sNum1);
            num2 = Long.parseLong(sNum2);

            pnm.toUpperCase();
            String[] pnmArr = pnm.split(" "); // System.out.println(Arrays.toString(pnmArr));

            if(num1 == 0){
                ifZero(num);
            }
            if((num1 < 1) && (num2 < 1)){
                System.out.println("The first parameter should be a natural number or zero.");
                System.out.println("The second parameter should be a natural number.");

                scanLine();
            }else if(num1 < 1){
                System.out.println("The first parameter should be a natural number or zero.");

                scanLine();
            }else if(num2 < 1){
                System.out.println("The second parameter should be a natural number.");

                scanLine();
            }

            multivar(num1, num2, pnmArr);
        }

        if(numOfSpace == 1){
            byte[] Num1 = new byte[spcIdx[0]];
            byte[] Num2 = new byte[byteArr.length - spcIdx[0] - 1];
            for(int i = 0; i < spcIdx[0]; i++){
                Num1[i] = byteArr[i];
            }

            for(int j = 0; j < byteArr.length - spcIdx[0] - 1; j++){
                Num2[j] = byteArr[j + spcIdx[0] + 1];
            }
            String sNum1 = new String(Num1);
            String sNum2 = new String(Num2);

            num1 = Long.parseLong(sNum1);
            num2 = Long.parseLong(sNum2);
            if(num1 == 0){
                ifZero(num);
            }
            if((num1 < 1) && (num2 < 1)){
                System.out.println("The first parameter should be a natural number or zero.");
                System.out.println("The second parameter should be a natural number.");

                scanLine();
            }else if(num1 < 1){
                System.out.println("The first parameter should be a natural number or zero.");

                scanLine();
            }else if(num2 < 1){
                System.out.println("The second parameter should be a natural number.");

                scanLine();
            }

            doubleNum(num1, num2);
        }

        if(numOfSpace == 0){
            num = Long.parseLong(line);
            ifZero(num);
            if((floor(num) != num) || (num < 1)) {
                System.out.print("The first parameter should be a natural number or zero.\n\n");

                scanLine();

                ifZero(num);
            }
            while(num != 0) {

                singleNum(num);
            }
            ifZero(num);
        }

    }
    static void testConditions(long num){
        if (ifEven(num)) {
            System.out.print(" even");
        } else {
            System.out.print(" odd");
        }

        if(ifDivisible(num) || ifEnd7(num)){
            System.out.print(", buzz");
        }

        if(ifDuck(num)){
            System.out.print(", duck");
        }

        if(ifPalindromic(num)){
            System.out.print(", palindromic");
        }

        if(ifGapful(num)){
            System.out.print(", gapful");
        }

        if(ifSpy(num)){
            System.out.print(", spy");
        }

        if(ifSquare(num)){
            System.out.print(", square");
        }

        if(ifSunny(num)){
            System.out.print(", sunny");
        }

        if(ifJumping(num)){
            System.out.print(", jumping");
        }

        if(ifSad(num)){
            System.out.print(", sad");
        }

        if(ifHappy(num)){
            System.out.print(", happy");
        }
    }

    static boolean condition(long num, String pnm){
        if(pnm.equalsIgnoreCase("EVEN")) {
            return ifEven(num);
        }
        if(pnm.equalsIgnoreCase("ODD")) {
            return !ifEven(num);
        }
        if(pnm.equalsIgnoreCase("BUZZ")) {
            return ifBuzz(num);
        }
        if(pnm.equalsIgnoreCase("DUCK")) {
            return ifDuck(num);
        }
        if(pnm.equalsIgnoreCase("PALINDROMIC")) {
            return ifPalindromic(num);
        }
        if(pnm.equalsIgnoreCase("GAPFUL")) {
            return ifGapful(num);
        }
        if(pnm.equalsIgnoreCase("SPY")) {
            return ifSpy(num);
        }
        if(pnm.equalsIgnoreCase("SQUARE")) {
            return ifSquare(num);
        }
        if(pnm.equalsIgnoreCase("SUNNY")) {
            return ifSunny(num);
        }
        if(pnm.equalsIgnoreCase("JUMPING")){
            return ifJumping(num);
        }
        if(pnm.equalsIgnoreCase("SAD")){
            return ifSad(num);
        }
        if(pnm.equalsIgnoreCase("HAPPY")){
            return ifHappy(num);
        }
        if(pnm.equalsIgnoreCase("-EVEN")) {
            return !ifEven(num);
        }
        if(pnm.equalsIgnoreCase("-ODD")) {
            return ifEven(num);
        }
        if(pnm.equalsIgnoreCase("-BUZZ")) {
            return !ifBuzz(num);
        }
        if(pnm.equalsIgnoreCase("-DUCK")) {
            return !ifDuck(num);
        }
        if(pnm.equalsIgnoreCase("-PALINDROMIC")) {
            return !ifPalindromic(num);
        }
        if(pnm.equalsIgnoreCase("-GAPFUL")) {
            return !ifGapful(num);
        }
        if(pnm.equalsIgnoreCase("-SPY")) {
            return !ifSpy(num);
        }
        if(pnm.equalsIgnoreCase("-SQUARE")) {
            return !ifSquare(num);
        }
        if(pnm.equalsIgnoreCase("-SUNNY")) {
            return !ifSunny(num);
        }
        if(pnm.equalsIgnoreCase("-JUMPING")){
            return !ifJumping(num);
        }
        if(pnm.equalsIgnoreCase("-SAD")){
            return !ifSad(num);
        }
        if(pnm.equalsIgnoreCase("-HAPPY")){
            return !ifHappy(num);
        }
        return false;
    }
    static void testmultiCases(long num1, long num2, String[] pnmArr){
        long num = 0;
        long maxLongValue = Long.MAX_VALUE;
        for (long i = num1; i < maxLongValue - num1; i++) {
            num = i;

            boolean matchedAll = false;

            for(int j = 0; j < pnmArr.length; j++) {
                //System.out.println(num + " " + pnmArr[j]);
                if (condition(num, pnmArr[j])) {
                    matchedAll = true;
                }else{
                    matchedAll = false;
                    break;
                }
            }

            if(matchedAll) {
                System.out.print(num + " is");
                testConditions(num);
                System.out.println("");
                num2--;
            }

            if (num2 == 0) {
                break;
            }
        }

    }
    static void multivar(long num1, long num2, String[] pnmArr){
        String arr1[] = {"EVEN", "ODD", "BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY", "JUMPING", "SAD", "HAPPY"};
        String arr[] = {"EVEN", "ODD", "BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY", "JUMPING", "SAD", "HAPPY",
                "-EVEN", "-ODD", "-BUZZ", "-DUCK", "-PALINDROMIC", "-GAPFUL", "-SPY", "-SQUARE", "-SUNNY", "-JUMPING", "-SAD", "-HAPPY"};

        List<String> list = new ArrayList<String>();

        int matchcase = 0;
        for(int j = 0; j < pnmArr.length; j++){
            boolean matchnocase = true;
            for(int i = 0; i < arr.length; i++) {
                //  System.out.println(pnmArr[j] + " " + arr[i]);
                if (pnmArr[j].equalsIgnoreCase(arr[i])) {
                    matchcase++;
                    matchnocase = false;
                }
            }
            if(matchnocase) {
                list.add(pnmArr[j]);
            }
        }
        String[] wrongCases =  list.toArray(new String[list.size()]);

        if(matchcase == pnmArr.length){
            for(int i = 0; i < pnmArr.length; i++) {
                for(int j = 0; j < pnmArr.length; j++) {
                    if (pnmArr[i].equalsIgnoreCase("EVEN") && pnmArr[j].equalsIgnoreCase("ODD")) {
                        System.out.println("The request contains mutually exclusive properties: "
                                + "[" + pnmArr[i] + ", " + pnmArr[j] + "]"
                                + "\nThere are no numbers with these properties.");
                        scanLine();
                    }
                    if (pnmArr[i].equalsIgnoreCase("-EVEN") && pnmArr[j].equalsIgnoreCase("-ODD")) {
                        System.out.println("The request contains mutually exclusive properties: "
                                + "[" + pnmArr[i] + ", " + pnmArr[j] + "]"
                                + "\nThere are no numbers with these properties.");
                        scanLine();
                    }
                    if (pnmArr[i].equalsIgnoreCase("-ODD") && pnmArr[j].equalsIgnoreCase("ODD")) {
                        System.out.println("The request contains mutually exclusive properties: "
                                + "[" + pnmArr[i] + ", " + pnmArr[j] + "]"
                                + "\nThere are no numbers with these properties.");
                        scanLine();
                    }
                    if (pnmArr[i].equalsIgnoreCase("EVEN") && pnmArr[j].equalsIgnoreCase("-EVEN")) {
                        System.out.println("The request contains mutually exclusive properties: "
                                + "[" + pnmArr[i] + ", " + pnmArr[j] + "]"
                                + "\nThere are no numbers with these properties.");
                        scanLine();
                    }
                    if (pnmArr[i].equalsIgnoreCase("DUCK") && pnmArr[j].equalsIgnoreCase("SPY")) {
                        System.out.println("The request contains mutually exclusive properties: "
                                + "[" + pnmArr[i] + ", " + pnmArr[j] + "]"
                                + "\nThere are no numbers with these properties.");
                        scanLine();
                    }
                    if (pnmArr[i].equalsIgnoreCase("-DUCK") && pnmArr[j].equalsIgnoreCase("-SPY")) {
                        System.out.println("The request contains mutually exclusive properties: "
                                + "[" + pnmArr[i] + ", " + pnmArr[j] + "]"
                                + "\nThere are no numbers with these properties.");
                        scanLine();
                    }
                    if (pnmArr[i].equalsIgnoreCase("-SPY") && pnmArr[j].equalsIgnoreCase("SPY")) {
                        System.out.println("The request contains mutually exclusive properties: "
                                + "[" + pnmArr[i] + ", " + pnmArr[j] + "]"
                                + "\nThere are no numbers with these properties.");
                        scanLine();
                    }
                    if (pnmArr[i].equalsIgnoreCase("DUCK") && pnmArr[j].equalsIgnoreCase("-DUCK")) {
                        System.out.println("The request contains mutually exclusive properties: "
                                + "[" + pnmArr[i] + ", " + pnmArr[j] + "]"
                                + "\nThere are no numbers with these properties.");
                        scanLine();
                    }
                    if (pnmArr[i].equalsIgnoreCase("SUNNY") && pnmArr[j].equalsIgnoreCase("SQUARE")) {
                        System.out.println("The request contains mutually exclusive properties: "
                                + "[" + pnmArr[i] + ", " + pnmArr[j] + "]"
                                + "\nThere are no numbers with these properties.");
                        scanLine();
                    }
                    if (pnmArr[i].equalsIgnoreCase("-SUNNY") && pnmArr[j].equalsIgnoreCase("-SQUARE")) {
                        System.out.println("The request contains mutually exclusive properties: "
                                + "[" + pnmArr[i] + ", " + pnmArr[j] + "]"
                                + "\nThere are no numbers with these properties.");
                        scanLine();
                    }
                    if (pnmArr[i].equalsIgnoreCase("-SUNNY") && pnmArr[j].equalsIgnoreCase("SUNNY")) {
                        System.out.println("The request contains mutually exclusive properties: "
                                + "[" + pnmArr[i] + ", " + pnmArr[j] + "]"
                                + "\nThere are no numbers with these properties.");
                        scanLine();
                    }
                    if (pnmArr[i].equalsIgnoreCase("SQUARE") && pnmArr[j].equalsIgnoreCase("-SQUARE")) {
                        System.out.println("The request contains mutually exclusive properties: "
                                + "[" + pnmArr[i] + ", " + pnmArr[j] + "]"
                                + "\nThere are no numbers with these properties.");
                        scanLine();
                    }
                    if (pnmArr[i].equalsIgnoreCase("SAD") && pnmArr[j].equalsIgnoreCase("HAPPY")) {
                        System.out.println("The request contains mutually exclusive properties: "
                                + "[" + pnmArr[i] + ", " + pnmArr[j] + "]"
                                + "\nThere are no numbers with these properties.");
                        scanLine();
                    }
                    if (pnmArr[i].equalsIgnoreCase("-SAD") && pnmArr[j].equalsIgnoreCase("-HAPPY")) {
                        System.out.println("The request contains mutually exclusive properties: "
                                + "[" + pnmArr[i] + ", " + pnmArr[j] + "]"
                                + "\nThere are no numbers with these properties.");
                        scanLine();
                    }
                    if (pnmArr[i].equalsIgnoreCase("-HAPPY") && pnmArr[j].equalsIgnoreCase("HAPPY")) {
                        System.out.println("The request contains mutually exclusive properties: "
                                + "[" + pnmArr[i] + ", " + pnmArr[j] + "]"
                                + "\nThere are no numbers with these properties.");
                        scanLine();
                    }
                    if (pnmArr[i].equalsIgnoreCase("SAD") && pnmArr[j].equalsIgnoreCase("-SAD")) {
                        System.out.println("The request contains mutually exclusive properties: "
                                + "[" + pnmArr[i] + ", " + pnmArr[j] + "]"
                                + "\nThere are no numbers with these properties.");
                        scanLine();
                    }
                    if (pnmArr[i].equalsIgnoreCase("GAPFUL") && pnmArr[j].equalsIgnoreCase("-GAPFUL")) {
                        System.out.println("The request contains mutually exclusive properties: "
                                + "[" + pnmArr[i] + ", " + pnmArr[j] + "]"
                                + "\nThere are no numbers with these properties.");
                        scanLine();
                    }
                    if (pnmArr[i].equalsIgnoreCase("PALINDROMIC") && pnmArr[j].equalsIgnoreCase("-PALINDROMIC")) {
                        System.out.println("The request contains mutually exclusive properties: "
                                + "[" + pnmArr[i] + ", " + pnmArr[j] + "]"
                                + "\nThere are no numbers with these properties.");
                        scanLine();
                    }
                    if (pnmArr[i].equalsIgnoreCase("JUMPING") && pnmArr[j].equalsIgnoreCase("-JUMPING")) {
                        System.out.println("The request contains mutually exclusive properties: "
                                + "[" + pnmArr[i] + ", " + pnmArr[j] + "]"
                                + "\nThere are no numbers with these properties.");
                        scanLine();
                    }
                    if (pnmArr[i].equalsIgnoreCase("BUZZ") && pnmArr[j].equalsIgnoreCase("-BUZZ")) {
                        System.out.println("The request contains mutually exclusive properties: "
                                + "[" + pnmArr[i] + ", " + pnmArr[j] + "]"
                                + "\nThere are no numbers with these properties.");
                        scanLine();
                    }
                }
            }
            testmultiCases(num1, num2, pnmArr);
            scanLine();
        }else if(wrongCases.length == 1){
            System.out.println("The property " + Arrays.toString(wrongCases).toUpperCase() + " is wrong.");
            System.out.println("Available properties: " + Arrays.toString(arr1));
            scanLine();
        }else{
            System.out.println("The properties " + Arrays.toString(wrongCases).toUpperCase() + " are wrong.");
            System.out.println("Available properties: " + Arrays.toString(arr1));
            scanLine();
        }
    }

    static void doubleNum(long num1, long num2) {
        for (long i = num1; i < num1 + num2; i++){
            System.out.print(i + " is");
            testConditions(i);
            System.out.println("");
        }

        scanLine();
    }
    static void singleNum(long num){

        System.out.println("Properties of " + num);

        if(ifEven(num)){
            System.out.println("        even: true");
            System.out.println("         odd: false");
        }else{
            System.out.println("        even: false");
            System.out.println("         odd: true");
        }

        if (ifDivisible(num) || ifEnd7(num)) {
            System.out.println("        buzz: true");
        } else {
            System.out.println("        buzz: false");
        }

        if (ifDuck(num)) {
            System.out.println("        duck: true");
        } else {
            System.out.println("        duck: false");
        }

        if(ifPalindromic(num)){
            System.out.println(" palindromic: true");
        }else{
            System.out.println(" palindromic: false");
        }

        if(ifGapful(num)){
            System.out.println("      gapful: true");
        }else{
            System.out.println("      gapful: false");
        }

        if(ifSpy(num)){
            System.out.println("         spy: true");
        }else{
            System.out.println("         spy: false");
        }

        if(ifSquare(num)){
            System.out.println("      square: true");
        }else{
            System.out.println("      square: false");
        }

        if(ifSunny(num)){
            System.out.println("       sunny: true");
        }else{
            System.out.println("       sunny: false");
        }

        if(ifJumping(num)){
            System.out.println("     jumping: true");
        }else{
            System.out.println("     jumping: false");
        }
        if(ifSad(num)){
            System.out.println("         sad: true");
        }else{
            System.out.println("         sad: false");
        }
        if(ifHappy(num)){
            System.out.println("       happy: true");
        }else{
            System.out.println("       happy: false");
        }
        System.out.println("");

        scanLine();
    }

    public static void main(String[] args) {

        welcomeMsg();

        scanLine();
    }
}
