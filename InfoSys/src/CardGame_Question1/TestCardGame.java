package CardGame_Question1;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestCardGame {

//	@DisplayName("Playing game")
//	@Test
//	void testSingleSuccessTest() {
//		
//		String[] args = null;
//		
//		CardGameDemo.main(args);
//		
//		
//	}

	@DisplayName("Input value")
	@Test
	void testInputSuccessTest() {

		List<Integer> listInteger = new ArrayList<>(Arrays.asList(2,3,2,2));
		
		TestGameProcess testGameProcess = new TestGameProcess();
		testGameProcess.start(listInteger);
		

	}
}
