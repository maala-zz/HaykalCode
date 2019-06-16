/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linking;

import java.util.HashMap;

/**
 *
 * @author ASUS
 */
public class Correlation {

    Post X, Y;
    HashMap<String, Integer> map = new HashMap<String, Integer>();

    public Correlation(Post X, Post Y) {
        this.X = X;
        this.Y = Y;
    }

    public int matchPostsWords() {
        int matching = 0;
        for (int i = 0; i < this.X.words.size(); ++i) {
            String temp = this.X.words.get(i);
            map.put(temp, 1);
        }
        for (int j = 0; j < this.Y.words.size(); ++j) {
            String temp = this.Y.words.get(j);
            if (map.containsKey(temp)) {
                matching++;
            }
        }
        return matching;
    }

    public void matchPostsPhrases() {
        int longestMatch = getLongestPhraseMatch();
        for (int i = 0; i < this.X.words.size(); ++i) {
            int count = 0;
            String similiarPhrase = "";
            for (int j = 0; j < this.Y.words.size() && i + count < this.X.words.size(); ++j) {
                String wordY = this.Y.words.get(j);
                String wordX = this.X.words.get(i + count);
                if (wordX.equalsIgnoreCase(wordY)) {
                    count++;
                    if (similiarPhrase.length() != 0) {
                        similiarPhrase += " ";
                    }
                    similiarPhrase += wordX;
                } else {
                    if (count == longestMatch) {
                        log(similiarPhrase);
                    }
                    count = 0;
                    similiarPhrase = "";
                }
            }
            if (count == longestMatch) {
                log(similiarPhrase);
            }
        }
    }

    private void log(String output) {
        System.out.println(output);
    }

    private int getLongestPhraseMatch() {
        int mx = 0;
        for (int i = 0; i < this.X.words.size(); ++i) {
            int count = 0;
            for (int j = 0; j < this.Y.words.size() && i + count < this.X.words.size(); ++j) {
                String wordY = this.Y.words.get(j);
                String wordX = this.X.words.get(i + count);
                if (wordX.equalsIgnoreCase(wordY)) {
                    count++;
                } else {
                    if (mx < count) {
                        mx = count;
                    }
                    count = 0;
                }
            }
            if (mx < count) {
                mx = count;
            }
        }
        return mx;
    }
}
