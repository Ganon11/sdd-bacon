package bacon;

import junit.framework.Test;
import junit.framework.TestSuite;

public class BaconTestSuite extends TestSuite {
	public static Test suite() {
		@SuppressWarnings("rawtypes")
		Class[] testClasses = {
				ComicDatabaseTest.class,
				ComicSiteTest.class,
				DateUtilsTest.class,
				LocalPrefReaderTest.class,
				SortMethodTest.class
		};
		TestSuite suite = new TestSuite(testClasses);
		return suite;
	}
}
