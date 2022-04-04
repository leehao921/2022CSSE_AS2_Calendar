import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertTest_C {

	CalendarSys test= null;
	@BeforeEach
	void setUp() throws Exception {
		test = new CalendarSys();// today is April,4
	}

	@AfterEach
	void tearDown() throws Exception {
		test=null;
	}

	@Test
	void test() {
		
		String expectString="2022-05-22 距離今天還有: 48 天\n";
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(stream);
		PrintStream original_ps = System.out;
		
		System.setOut(ps);
		test.SearchDate("2022-05-22");
		System.setOut(original_ps);
		
		String output = new String(stream.toByteArray());
		assertEquals(expectString, output);

	}

}
