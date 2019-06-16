package linking;

import java.util.ArrayList;

public class Post {

    public String content;
    public ArrayList<String> words = new ArrayList<>();

    public Post(String content) {
        this.content = content;
        extractWords();
    }

    private void extractWords() {
        String tempWord = "";
        for (int i = 0; i < this.content.length(); ++i) {
            if(this.content.charAt(i) == ','||this.content.charAt(i) == '.'||this.content.charAt(i) == '\'')
                continue;
            if (this.content.charAt(i) != ' ') {
                tempWord += this.content.charAt(i);
            } else {
                if( !stopWord(tempWord.toLowerCase()) && !words.contains(tempWord.toLowerCase()) )
                words.add(tempWord.toLowerCase());
                tempWord = "";
            }
        }
        if (!tempWord.equals("")) {
            words.add(tempWord);
        }
//        for (int i = 0; i < words.size(); ++i) {
//            log(words.get(i));
//        }
    }

    private void log(String word) {
        System.out.println(word);
    }

    private boolean stopWord(String word) {
      return word.equals("a")||word.equals("the")||word.equals("and")||word.equals("is")||word.equals("are")
              ||word.equals("of")||word.equals("that");  
    }
}
