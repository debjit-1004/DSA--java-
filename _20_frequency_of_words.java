import java.util.HashMap; 
public class _20_frequency_of_words {
    public static void main(String args[]){
        String sentence  = "Hashing are important in programming and hashmaps are efficient";
        String[] words = sentence.toLowerCase().split(" ");
        HashMap<String, Integer> wordcount = new HashMap<>();

        //very important format hehe see this 
        for (String word : words){
            //note the usage 
            wordcount.put(word, wordcount.getOrDefault(word,0)+1);
        }

        System.out.println("Word Frequencies:"+ wordcount);
    }
    
}
