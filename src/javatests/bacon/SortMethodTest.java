package bacon;

import junit.framework.TestCase;

public class SortMethodTest extends TestCase {
	public void test_getSortMethod() {
		String sortString = "A_TO_Z_ALPHABETICAL";
		assertEquals(SortMethod.SORT_BY_ALPHABETICAL, SortMethod.getSortMethod(sortString));
		sortString = "AUTHOR_NAME_A_TO_Z";
		assertEquals(SortMethod.SORT_BY_AUTHOR, SortMethod.getSortMethod(sortString));
		sortString = "DATE_LAST_UPDATED";
		assertEquals(SortMethod.SORT_BY_DATE, SortMethod.getSortMethod(sortString));
	}
	
	public void test_getSortMethod_badString() {
		assertNull(SortMethod.getSortMethod("NOT_A_SORT_METHOD"));
	}
	
	public void test_toString() {
		SortMethod sortMethod = SortMethod.SORT_BY_ALPHABETICAL;
		assertEquals("A_TO_Z_ALPHABETICAL", sortMethod.toString());
		sortMethod = SortMethod.SORT_BY_AUTHOR;
		assertEquals("AUTHOR_NAME_A_TO_Z", sortMethod.toString());
		sortMethod = SortMethod.SORT_BY_DATE;
		assertEquals("DATE_LAST_UPDATED", sortMethod.toString());
	}
}
