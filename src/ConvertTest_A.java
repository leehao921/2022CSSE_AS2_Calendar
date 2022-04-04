import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertTest_A {

	CalendarSys test= null;
	@BeforeEach
	void setUp() throws Exception {
		test = new CalendarSys("2022-04-02");
	}

	@AfterEach
	void tearDown() throws Exception {
		test=null;
	}

	@Test
	void test() {
		
		String expectString="Sun\tMon\tTue\tWed\tThu\tFri\tSat\n\t\t\t\t\t1\t2\t\n3	4	5	6	7	8	9\t\n10	11	12	13	14	15	16\t\n17	18	19	20	21	22	23\t\n24	25	26	27	28	29	30\t\n\n";
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(stream);
		PrintStream original_ps = System.out;
		
		System.setOut(ps);
		test.ShowCalendar();
		System.setOut(original_ps);
		
		String output = new String(stream.toByteArray());
		assertEquals(expectString, output);

	}

}
