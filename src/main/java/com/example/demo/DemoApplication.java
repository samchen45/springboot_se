package com.example.demo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

    public static int wordLadder(String head, String end, Set<String> dictionary){
        if ( head == null || end == null) return 0;
        if ( head.length() == 0 || end.length()== 0) return 0;
        if ( head.length() != end.length()) return 0;
        else {
            LinkedList<String> ladder = new LinkedList<String>();
            ladder.add(head);
            int len = 1;
            while (!ladder.isEmpty()) {
                int size = ladder.size();
                while (size > 0){
                    String word = ladder.poll();  // pop the top of the list
                    for (int i = 0 ; i < word.length() ; i++) {
                        char[] word_array = word.toCharArray();
                        for (char j = 'a' ; j <= 'z' ; j ++) {
                            word_array[i] = j;
                            String new_word = new String(word_array);
                            if (new_word.equals(end)) return (len + 1);
                            if (dictionary.contains(new_word)){
                                ladder.add(new_word);
                                dictionary.remove(new_word);
                            }
                        }
                    }
                    size --;
                }
                len ++;
            }
            return 0;
        }
    }

    @RequestMapping("/index")
    public String hello(){
        Set<String> dict = new HashSet<String>();
        dict.add("hit");
        dict.add("hot");
        dict.add("dog");
        dict.add("dot");
        dict.add("doc");
        int len = wordLadder("hit","doc",dict);
        String result = "The dict = {hit,hot,dog,dot,doc}\n";
        String m = "head = hit; end = doc;\n";
        return  (result + m + "the ladder length = " + len);
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
