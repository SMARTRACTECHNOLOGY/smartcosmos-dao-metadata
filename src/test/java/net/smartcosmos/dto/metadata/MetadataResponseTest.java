package net.smartcosmos.dto.metadata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class MetadataResponseTest {

    @Test
    public void thatVersionIsSet() {
        MetadataResponse entity = MetadataResponse.builder()
            .metadata(new HashMap<>())
            .build();

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

        Map<String, Object> metadata = new HashMap<>();
        metadata.put("someKey", "someValue");

        MetadataResponse response = MetadataResponse.builder()
            .metadata(metadata)
            .ownerType("ownerType")
            .ownerId("ownerId")
            .id("id")
            .tenantId("tenantId")
            .build();

        assertNotEquals(0, response.getVersion());

        String jsonString = mapper.writeValueAsString(response);
        JSONObject jsonObject = new JSONObject(jsonString);

        assertFalse(jsonObject.has("version"));
    }
}
