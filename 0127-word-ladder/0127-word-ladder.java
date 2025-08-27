public class Pair
{
    String firstWord;
    int second;

    Pair(String firstWord, int second)
    {
        this.firstWord= firstWord;
        this.second= second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
         Set<String> set =  new HashSet<>(wordList);
         Queue<Pair>  q= new LinkedList<>();

         if(!set.contains(endWord)) return 0; // check target word exist or not
         if(set.contains(beginWord))
         {
            set.remove(beginWord);
         }

         q.add(new Pair(beginWord,1));  // add the source node 

         while(!q.isEmpty())
         {
            String word  =   q.peek().firstWord;
            int steps    = q.peek().second;
            q.remove();

            if(word.equals(endWord))  // if begin word equla to endWord
            {
                return steps;
            }

            for(int i=0;i<word.length(); i++)
            {

                for(char ch='a'; ch<='z';ch++)
                {
                    char[] replaced = word.toCharArray();
                    replaced[i]= ch;
                     String  newWord  = new String(replaced); // new Word formed hit->hot->tot

                     if(set.contains(newWord))
                     {
                        set.remove(newWord);
                        q.add(new Pair(newWord,steps+1));
                     }
                }
            }  

         }

         return 0;
    }
}