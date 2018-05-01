package com.example.demo;
import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
		Set<String> dict = new HashSet<String>();
		DemoApplication testladder = new DemoApplication();
        dict.add("hit");
        dict.add("hot");
        dict.add("dog");
        dict.add("dot");
        dict.add("doc");
        assertEquals(4, testladder.wordLadder("hit","doc",dict));
	}

}
