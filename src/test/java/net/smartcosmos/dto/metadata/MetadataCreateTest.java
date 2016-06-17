package net.smartcosmos.dto.metadata;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;
import org.junit.*;

import static org.junit.Assert.*;

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
            .ownerId("ownerId")
            .metadata(metadata)
            .build();

        assertNotEquals(0, create.getVersion());

        String jsonString = mapper.writeValueAsString(create);
        JSONObject jsonObject = new JSONObject(jsonString);

        assertFalse(jsonObject.has("version"));
    }

}
