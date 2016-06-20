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
    @Test(expected = NoSuchMethodException.class)
    public void thatVersionHasNoSetter() throws Exception {
        MetadataResponse.class.getDeclaredMethod("setVersion", int.class);
    }

    @Test
    public void thatObjectMapperIgnoresVersion() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> metadata = new HashMap<>();
        metadata.put("someKey", "someValue");

        MetadataResponse response = MetadataResponse.builder()
            .metadata(metadata)
            .ownerType("ownerType")
            .ownerUrn("ownerUrn")
            .tenantUrn("tenantUrn")
            .build();

        assertNotEquals(0, response.getVersion());

        String jsonString = mapper.writeValueAsString(response);
        JSONObject jsonObject = new JSONObject(jsonString);

        assertFalse(jsonObject.has("version"));
    }

    @Test
    public void thatObjectMapperAcceptsNullMetadata() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        MetadataResponse response = MetadataResponse.builder()
            .metadata(null)
            .ownerType("ownerType")
            .ownerUrn("ownerUrn")
            .tenantUrn("tenantUrn")
            .build();

        assertNotEquals(0, response.getVersion());

        String jsonString = mapper.writeValueAsString(response);
        JSONObject jsonObject = new JSONObject(jsonString);

        assertFalse(jsonObject.has("version"));
    }
}
