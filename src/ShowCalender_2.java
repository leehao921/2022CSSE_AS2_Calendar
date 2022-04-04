import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShowCalender_2 {

	CalendarSys test= null;
	@BeforeEach
	void setUp() throws Exception {
		test = new CalendarSys("2000-11-15");
	}

	@AfterEach
	void tearDown() throws Exception {
		test=null;
	}

	@Test
	void test() {

		String expectString="Sun\tMon\tTue\tWed\tThu\tFri\tSat\n" +
				"\t\t\t1\t2\t3\t4\t\n" +
				"5\t6\t7\t8\t9\t10\t11\t\n" +
				"12\t13\t14\t15\t16\t17\t18\t\n" +
				"19\t20\t21\t22\t23\t24\t25\t\n" +
				"26\t27\t28\t29\t30\t\n\n";
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
