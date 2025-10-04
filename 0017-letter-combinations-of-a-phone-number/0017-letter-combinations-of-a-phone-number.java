class Solution {

    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) 
    {
        HashMap<Character,String> digitToLetters =  new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");
        if(digits==null || digits.length()==0) return res;
        combinations(digits,0,new StringBuilder(),digitToLetters);
        return res;
    }

    public void combinations(String digits,int index,StringBuilder comb,Map<Character,String> digitToLetters)
    {
        //  base case

        if(index==digits.length())
        {
            res.add(comb.toString());
            return;
        }

        String letters =digitToLetters.get(digits.charAt(index));
        
        for(char letter:letters.toCharArray())
        {
             comb.append(letter);
             combinations(digits,index+1,comb,digitToLetters);
             // backTrack
             
             comb.deleteCharAt(comb.length()-1);
        }
    }
}