package net.smartcosmos.dto.metadata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MetadataCreateTest {

    @Test
    public void thatVersionIsSet() {
        MetadataCreate entity = MetadataCreate.builder().build();

        assertNotNull(entity.getVersion());
        assertEquals(1, entity.getVersion());
    }

    /**
     * This actually tests if Lombok is properly used.
     */
    @Test(expected = NoSuchMethodException.class)
    public void thatVersionHasNoSetter() throws Exception {
        MetadataCreate.class.getDeclaredMethod("setVersion", int.class);
    }

    @Test
    public void thatObjectMapperIgnoresVersion() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> metadata = new HashMap<>();
        metadata.put("someKey", "someValue");

        MetadataCreate create = MetadataCreate.builder()
            .ownerType("ownerType")
            .ownerUrn("ownerUrn")
            .metadata(metadata)
            .build();

        assertNotEquals(0, create.getVersion());

        String jsonString = mapper.writeValueAsString(create);
        JSONObject jsonObject = new JSONObject(jsonString);

        assertFalse(jsonObject.has("version"));
    }

    @Test
    public void thatObjectMapperAcceptsNullMetadata() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        MetadataCreate create = MetadataCreate.builder()
            .ownerType("ownerType")
            .ownerUrn("ownerUrn")
            .metadata(null)
            .build();

        assertNotEquals(0, create.getVersion());

        String jsonString = mapper.writeValueAsString(create);
        JSONObject jsonObject = new JSONObject(jsonString);

        assertFalse(jsonObject.has("version"));
        assertTrue(jsonObject.has("metadata"));
        assertNotNull(jsonObject.get("metadata"));
    }

}
