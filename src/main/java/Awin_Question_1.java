class Awin_Question_1{

    int findExtraSwitchCombination(int oldNum, int newNum){
        Double oldCombinations = Math.pow(2, oldNum);
        Double newCombinations = Math.pow(2, newNum);

        double v = newCombinations - oldCombinations;
        return Double.valueOf(v).intValue();
    }
}
