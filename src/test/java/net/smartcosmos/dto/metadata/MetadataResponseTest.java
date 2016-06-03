package net.smartcosmos.dto.metadata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class MetadataResponseTest {

    @Test
    public void thatVersionIsSet() {
        MetadataResponse entity = MetadataResponse.builder().build();

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
            getVersion = MetadataResponse.class.getDeclaredMethod("setVersion", int.class);
        } catch (NoSuchMethodException e) {
            // that's what we expect
        }
        assertNull(getVersion);
    }

    @Test
    public void thatObjectMapperIgnoresVersion() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        MetadataResponse response = MetadataResponse.builder()
            .dataType("type")
            .entityReferenceType("entityReferenceType")
            .referenceUrn("referenceUrn")
            .rawValue("rawValue")
            .lastModifiedTimestamp(123L)
            .urn("urn")
            .build();

        assertNotEquals(0, response.getVersion());

        String jsonString = mapper.writeValueAsString(response);
        JSONObject jsonObject = new JSONObject(jsonString);

        assertFalse(jsonObject.has("version"));
    }
}
