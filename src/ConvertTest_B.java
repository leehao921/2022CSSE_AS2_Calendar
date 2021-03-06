import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ConvertTest_B {

	CalendarSys test_F = null;
	CalendarSys test= null;
	@BeforeEach
	void setUp() throws Exception {
		test = new CalendarSys(2022);
	}

	@AfterEach
	void tearDown() throws Exception {
		test=null;
	}

	@Test
	void test() {
		
		String expectString = "2022是壬寅年，屬虎\n";
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(stream);
		PrintStream original_ps = System.out;
		
		System.setOut(ps);
		test.Convert(2022);
		System.setOut(original_ps);
		
		String output = new String(stream.toByteArray());
		assertEquals(expectString, output);

	}

}
