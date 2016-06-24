package net.smartcosmos.dao.metadata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortOrderTest {

    @Test
    public void testToString() throws Exception {
        assertEquals("asc", SortOrder.ASC.toString());
        assertEquals("desc", SortOrder.DESC.toString());
    }

    @Test
    public void testFromString() throws Exception {
        assertEquals(SortOrder.ASC, SortOrder.fromString("asc"));
        assertEquals(SortOrder.DESC, SortOrder.fromString("desc"));
    }

    @Test
    public void testFromStringFallbackToAsc() throws Exception {
        assertEquals(SortOrder.ASC, SortOrder.fromString("bogus"));
    }

    @Test
    public void testFromStringIgnoresCase() throws Exception {
        assertEquals(SortOrder.ASC, SortOrder.fromString("ASC"));
        assertEquals(SortOrder.DESC, SortOrder.fromString("DESC"));
    }
}
