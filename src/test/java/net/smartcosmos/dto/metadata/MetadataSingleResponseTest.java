package net.smartcosmos.dto.metadata;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.*;

import static org.junit.Assert.*;

public class MetadataSingleResponseTest {

    @Test
    public void thatVersionIsSet() {

        MetadataSingleResponse entity = MetadataSingleResponse.builder()
            .build();

        assertNotNull(entity.getVersion());
        assertEquals(1, entity.getVersion());
    }

    /**
     * This actually tests if Lombok is properly used.
     */
    @Test(expected = NoSuchMethodException.class)
    public void thatVersionHasNoSetter() throws Exception {

        MetadataSingleResponse.class.getDeclaredMethod("setVersion", int.class);
    }

    @Test
    public void thatObjectMapperIgnoresVersion() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> metadata = new HashMap<>();
        metadata.put("someKey", "someValue");

        MetadataSingleResponse response = MetadataSingleResponse.builder()
            .key("key")
            .dataType("dataType")
            .value("value")
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
    public void thatObjectMapperAcceptsNullValue() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> metadata = new HashMap<>();
        metadata.put("someKey", "someValue");

        MetadataSingleResponse response = MetadataSingleResponse.builder()
            .key("key")
            .dataType("dataType")
            .value(null)
            .ownerType("ownerType")
            .ownerUrn("ownerUrn")
            .tenantUrn("tenantUrn")
            .build();

        assertNotEquals(0, response.getVersion());

        String jsonString = mapper.writeValueAsString(response);
        JSONObject jsonObject = new JSONObject(jsonString);

        assertFalse(jsonObject.has("version"));
        assertTrue(jsonObject.has("value"));
        assertEquals(JSONObject.NULL, jsonObject.get("value"));
    }

    @Test
    public void thatBuilderEmptyWorks() {

        MetadataSingleResponse metadata = MetadataSingleResponse.builder()
            .build();
        assertNotNull(metadata);
    }

    @Test
    public void thatBuilderKeyWorks() {

        final String key = "key";

        MetadataSingleResponse metadata = MetadataSingleResponse.builder()
            .key(key)
            .build();
        assertNotNull(metadata);
        assertEquals(key, metadata.getKey());
    }

    @Test
    public void thatBuilderDataTypeWorks() {

        final String dataType = "dataType";

        MetadataSingleResponse metadata = MetadataSingleResponse.builder()
            .dataType(dataType)
            .build();
        assertNotNull(metadata);
        assertEquals(dataType, metadata.getDataType());
    }

    @Test
    public void thatBuilderOwnerUrnWorks() {

        final String ownerUrn = "ownerUrn";

        MetadataSingleResponse metadata = MetadataSingleResponse.builder()
            .ownerUrn(ownerUrn)
            .build();
        assertNotNull(metadata);
        assertEquals(ownerUrn, metadata.getOwnerUrn());
    }

    @Test
    public void thatBuilderOwnerTypeWorks() {

        final String ownerType = "ownerType";

        MetadataSingleResponse metadata = MetadataSingleResponse.builder()
            .ownerType(ownerType)
            .build();
        assertNotNull(metadata);
        assertEquals(ownerType, metadata.getOwnerType());
    }

    @Test
    public void thatBuilderValueStringWorks() {

        final Object value = "String";

        MetadataSingleResponse metadata = MetadataSingleResponse.builder()
            .value(value)
            .build();
        assertNotNull(metadata);
        assertEquals(value, metadata.getValue());
    }

    @Test
    public void thatBuilderValueBooleanWorks() {

        final Object value = true;

        MetadataSingleResponse metadata = MetadataSingleResponse.builder()
            .value(value)
            .build();
        assertNotNull(metadata);
        assertEquals(value, metadata.getValue());
    }

    @Test
    public void thatBuilderValueNumberWorks() {

        final Object value = 123;

        MetadataSingleResponse metadata = MetadataSingleResponse.builder()
            .value(value)
            .build();
        assertNotNull(metadata);
        assertEquals(value, metadata.getValue());
    }

    @Test
    public void thatBuilderValueNumberNegativeWorks() {

        final Object value = -123;

        MetadataSingleResponse metadata = MetadataSingleResponse.builder()
            .value(value)
            .build();
        assertNotNull(metadata);
        assertEquals(value, metadata.getValue());
    }

    @Test
    public void thatBuilderValueNumberCommaWorks() {

        final Object value = 123.45;

        MetadataSingleResponse metadata = MetadataSingleResponse.builder()
            .value(value)
            .build();
        assertNotNull(metadata);
        assertEquals(value, metadata.getValue());
    }

    @Test
    public void thatBuilderValueJsonArrayWorks() {

        final Object value = new JSONArray();

        MetadataSingleResponse metadata = MetadataSingleResponse.builder()
            .value(value)
            .build();
        assertNotNull(metadata);
        assertEquals(value, metadata.getValue());
    }

    @Test
    public void thatBuilderValueJsonObjectWorks() {

        final Object value = new JSONObject();

        MetadataSingleResponse metadata = MetadataSingleResponse.builder()
            .value(value)
            .build();
        assertNotNull(metadata);
        assertEquals(value, metadata.getValue());
    }

    @Test
    public void thatBuilderValueNullWorks() {

        final Object value = null;

        MetadataSingleResponse metadata = MetadataSingleResponse.builder()
            .value(value)
            .build();
        assertNotNull(metadata);
        assertEquals(value, metadata.getValue());
    }

    @Test
    public void testAllArgsConstructor() {

        final String ownerUrn = "urn";
        final String ownerType = "type";
        final String key = "key";
        final Object value = "value";
        final String dataType = "dataType";
        final String tenantUrn = "tenantUrn";

        MetadataSingleResponse metadata = MetadataSingleResponse.builder()
            .ownerType(ownerType)
            .ownerUrn(ownerUrn)
            .key(key)
            .dataType(dataType)
            .value(value)
            .tenantUrn(tenantUrn)
            .build();
        assertNotNull(metadata);

        assertEquals(ownerUrn, metadata.getOwnerUrn());
        assertEquals(ownerType, metadata.getOwnerType());
        assertEquals(key, metadata.getKey());
        assertEquals(value, metadata.getValue());
        assertEquals(dataType, metadata.getDataType());
        assertEquals(tenantUrn, metadata.getTenantUrn());
    }
}
