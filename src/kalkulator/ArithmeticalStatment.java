package kalkulator;

import static javax.swing.JOptionPane.showMessageDialog;

public class ArithmeticalStatment {
    private static double applyOperator(char operand, double firstNum, double secondNum){
        switch (operand) {
            case '*':
                firstNum *= secondNum;
                break;
            case '/':
                if(secondNum!=0) firstNum /= secondNum;
                else showMessageDialog(null, "Don't divide by zero");
                break;
            case '+':
                firstNum = secondNum;
                break;
            case '-':
                firstNum = -secondNum;
                break;
        }
        return firstNum;
    }
    public static double calc(String str){
        double sum = 0;
        double lastApplyOpRes = 0;
        double lastNum = 0;
        int len = str.length();
        boolean point=false;
        int k =1;
        char prevOperator = '+';
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if(str.length()>6){
                if(str.charAt(0)=='s'&&str.charAt(1)=='q'&&str.charAt(2)=='r'&&str.charAt(3)=='t'&&str.charAt(4)=='('&&str.charAt(str.length()-1)==')'){
                    lastNum = calc(typedNumber(str,5,str.length()-1));
                    if(lastNum<0) {

                    }
                    else{
                        lastNum=Math.sqrt(lastNum);
                        continue;
                    }
                }
            }
            if(str.length()>5){
                if(str.charAt(0)=='s'&&str.charAt(1)=='i'&&str.charAt(2)=='n'&&str.charAt(3)=='('&&str.charAt(str.length()-1)==')'){
                    lastNum = Math.sin(calc(typedNumber(str,4,str.length()-1)));
                    if(lastNum<0.0000001&&lastNum>-0.000001) lastNum=0;
                    continue;
                }
                else if(str.charAt(0)=='c'&&str.charAt(1)=='o'&&str.charAt(2)=='s'&&str.charAt(3)=='('&&str.charAt(str.length()-1)==')'){
                    lastNum = Math.cos(calc(typedNumber(str,4,str.length()-1)));
                    if(lastNum<0.0000001&&lastNum>-0.000001) lastNum=0;

                    continue;
                }else if(str.charAt(0)=='c'&&str.charAt(1)=='t'&&str.charAt(2)=='g'&&str.charAt(3)=='('&&str.charAt(str.length()-1)==')'){
                    lastNum = 1/Math.tan(calc(typedNumber(str,4,str.length()-1)));
                    CalculatorPanel.tgAndCtg(lastNum);
                    continue;

                }

                else if(str.charAt(0)=='e'&&str.charAt(1)=='x'&&str.charAt(2)=='p'&&str.charAt(3)=='('&&str.charAt(str.length()-1)==')') {
                    lastNum = calc(typedNumber(str,4,str.length()-1));
                    if(lastNum-(int)lastNum!=0) {

                    }
                    else{
                        lastNum=Math.pow(Math.E,lastNum);
                        continue;
                    }
                }
            }
            if(str.length()>4){
                if(str.charAt(0)=='t'&&str.charAt(1)=='g'&&str.charAt(2)=='('&&str.charAt(str.length()-1)==')'){
                    lastNum = Math.tan(calc(typedNumber(str,3,str.length()-1)));
                    CalculatorPanel.tgAndCtg(lastNum);
                    continue;
                }
                else if(str.charAt(0)=='l'&&str.charAt(1)=='n'&&str.charAt(2)=='('&&str.charAt(str.length()-1)==')'){
                    lastNum = calc(typedNumber(str,3,str.length()-1));
                    if(lastNum>0){
                        lastNum=Math.log(lastNum);
                        continue;
                    }else{

                    }
                }
                else if(str.charAt(0)=='('&&str.charAt(str.length()-3)==')'&&str.charAt(str.length()-2)=='^') {
                    lastNum = calc(typedNumber(str,1,str.length()-3));
                    int power;
                    try {
                        power = Integer.parseInt(String.valueOf(str.charAt(str.length()-1)));
                        lastNum=Math.pow(lastNum,power);
                        continue;
                    }catch (Exception exception) {

                    }
                }
            }
            if(str.length()>3){
                if(str.charAt(0)=='('&&str.charAt(str.length()-2)==')'&&str.charAt(str.length()-1)=='!') {
                    lastNum = calc(typedNumber(str,1,str.length()-2));
                    if(lastNum-(int)lastNum!=0 || lastNum<0 ){

                    }
                    else {
                        lastNum = factorial((int) lastNum);
                        continue;
                    }

                }
            }
            if(str.length()>2){
                if(str.charAt(0)=='('&&str.charAt(str.length()-1)==')') {
                    lastNum = calc(typedNumber(str,1,str.length()-2));
                    continue;
                }
                else if(str.charAt(str.length()-2)=='^') {
                    lastNum = calc(typedNumber(str,0,str.length()-2));
                    int power;
                    try {
                        power = Integer.parseInt(String.valueOf(str.charAt(str.length()-1)));
                        lastNum=Math.pow(lastNum,power);
                        continue;
                    }catch (Exception exception) {

                    }
                }
            }
            if(str.length()>1){
                if(str.charAt(str.length()-1)=='!') {
                    lastNum = calc(typedNumber(str,0,str.length()-1));
                    if(lastNum-Math.floor(lastNum)!=0 || lastNum<0 ) {

                    }
                    else {
                        lastNum = factorial((int) lastNum);
                        continue;
                    }

                }else if(c=='p'&&str.charAt(i+1)=='i'){
                    lastNum = Math.PI;
                    continue;
                }
            }
            if(c=='e'||c=='E'){
                lastNum = Math.E;
                continue;
            }
            if (c=='.'||c==','){
                point=true;
                continue;
            }
            if (c >= '0' && c <= '9') {
                if(!point){
                    lastNum = lastNum * 10 + c - '0';
                }else{
                    lastNum+=(double) (c-'0')/(Math.pow(10,k));
                    k+=1;
                }
                continue;
            }
            point=false;
            k=1;
            lastApplyOpRes = applyOperator(prevOperator, lastApplyOpRes , lastNum);
            lastNum = 0;
            switch (c) {
                case '+':
                case '-':
                    sum += lastApplyOpRes;
                    lastApplyOpRes = 0;
                    break;
            }
            prevOperator = c;
        }
        lastApplyOpRes = applyOperator(prevOperator, lastApplyOpRes , lastNum);
        return sum + lastApplyOpRes;
    }
    public static String typedNumber(String str, int start, int end) {
        StringBuilder strbuild = new StringBuilder();
        for (int i = start; i<end;i++) strbuild.append(str.charAt(i));
        return String.valueOf(strbuild);
    }
    private static int factorial(int x) {
        if (x == 0) return 1;
        else if (x == 1) return 1;
        else return x * factorial(x - 1);
    }
}

