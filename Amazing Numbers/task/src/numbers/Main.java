package numbers;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static java.lang.Math.floor;
import static java.lang.System.exit;

public class Main {
    static void welcomeMsg(){
        System.out.print("Welcome to Amazing Numbers!\n\nSupported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameters show how many consecutive numbers are to be processed;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.\n\n");

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
    static void scanLine(){
        System.out.println("\nEnter a request:");
        long num = 0, num1 = 0, num2 = 0;
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();

        if(line.equals("")){
            welcomeMsg();
            line = s.nextLine();
        }

        boolean twonums = false;
        int spaceindex = 0;
        byte[] byteArr = line.getBytes();
        for(int i = 0; i < byteArr.length; i++){
            if(byteArr[i] == ' '){
                twonums = true;
                spaceindex = i;
            }
        }

        if(twonums){
            byte[] Num1 = new byte[spaceindex];
            byte[] Num2 = new byte[byteArr.length - spaceindex - 1];
            for(int i = 0; i < spaceindex; i++){
                Num1[i] = byteArr[i];
            }

            for(int j = 0; j < byteArr.length - spaceindex - 1; j++){
                Num2[j] = byteArr[j + spaceindex + 1];
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
        }else{
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
        boolean isEven = ifEven(num);
        boolean isDivisible = ifDivisible(num);
        boolean ends7 = ifEnd7(num);
        boolean isDuck = ifDuck(num);
        boolean isPalindromic = ifPalindromic(num);
        boolean isGapful = ifGapful(num);
        boolean isSpy = ifSpy(num);

        System.out.println("Properties of " + num);

        if(isEven){
            System.out.println("        even: true");
            System.out.println("         odd: false");
        }else{
            System.out.println("        even: false");
            System.out.println("         odd: true");
        }

        if (isDivisible || ends7) {
            System.out.println("        buzz: true");
        } else {
            System.out.println("        buzz: false");
        }

        if (isDuck) {
            System.out.println("        duck: true");
        } else {
            System.out.println("        duck: false");
        }

        if(isPalindromic){
            System.out.println(" palindromic: true");
        }else{
            System.out.println(" palindromic: false");
        }

        if(isGapful){
            System.out.println("      gapful: true");
        }else{
            System.out.println("      gapful: false");
        }

        if(isSpy){
            System.out.println("         spy: true");
        }else{
            System.out.println("         spy: false");
        }
        System.out.println("");

        scanLine();
    }

    public static void main(String[] args) {

        welcomeMsg();

        scanLine();
    }
}
