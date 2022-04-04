import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertTest_D {

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
		
		String expectString="往後 100 天是: 2022-07-13\n";
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(stream);
		PrintStream original_ps = System.out;
		
		System.setOut(ps);
		test.AddDay(100);
		System.setOut(original_ps);
		
		String output = new String(stream.toByteArray());
		assertEquals(expectString, output);

	}

}
