package net.smartcosmos.dto.metadata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MetadataUpdateTest {

    @Test
    public void thatVersionIsSet() {
        MetadataUpdate entity = MetadataUpdate.builder().build();

        assertNotNull(entity.getVersion());
        assertEquals(1, entity.getVersion());
    }

    /**
     * This actually tests if Lombok is properly used.
     */
    @Test(expected = NoSuchMethodException.class)
    public void thatVersionHasNoSetter() throws Exception {
        MetadataUpdate.class.getDeclaredMethod("setVersion", int.class);
    }

    @Test
    public void thatObjectMapperIgnoresVersion() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        MetadataUpdate create = MetadataUpdate.builder()
            .ownerType("ownerType")
            .ownerUrn("ownerUrn")
            .key("someKey")
            .value("someValue")
            .build();

        assertNotEquals(0, create.getVersion());

        String jsonString = mapper.writeValueAsString(create);
        JSONObject jsonObject = new JSONObject(jsonString);

        assertFalse(jsonObject.has("version"));
    }

    @Test
    public void thatObjectMapperAcceptsNullValue() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        MetadataUpdate create = MetadataUpdate.builder()
            .ownerType("ownerType")
            .ownerUrn("ownerUrn")
            .key("someKey")
            .value(null)
            .build();

        assertNotEquals(0, create.getVersion());

        String jsonString = mapper.writeValueAsString(create);
        JSONObject jsonObject = new JSONObject(jsonString);

        assertFalse(jsonObject.has("version"));
        assertTrue(jsonObject.has("value"));
    }
}
