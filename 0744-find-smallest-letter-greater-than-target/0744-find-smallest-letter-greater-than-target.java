class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ch = 'z'+1;
        char smallest = letters[0];
        boolean flag = false;
        for(int i=0; i<letters.length; i++) {
            if(letters[i] > target) {
                if(letters[i] < ch) {
                    ch = letters[i];
                    flag = true;
                }
                if(letters[i] < smallest) {
                    smallest = letters[i];
                }
            }
        }
        return flag ? ch : smallest;
    }
}