package net.smartcosmos.dto.metadata;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class MetadataQueryTest {

    @Test
    public void thatVersionIsSet() {
        MetadataQuery entity = MetadataQuery.builder().build();

        assertNotNull(entity.getVersion());
        assertEquals(1, entity.getVersion());
    }

    /**
     * This actually tests if Lombok is properly used.
     */
    @Test
    public void thatVersionHasNoSetter() {
        Method getVersion = null;
        try {
            getVersion = MetadataQuery.class.getDeclaredMethod("setVersion", int.class);
        } catch (NoSuchMethodException e) {
            // that's what we expect
        }
        assertNull(getVersion);
    }
}
