package net.smartcosmos.dto.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@JsonIgnoreProperties(value = {"version"}, ignoreUnknown = true)
public class MetadataCreate {
    private static final int VERSION = 1;

    private final int version = VERSION;

    private String ownerType;

    private String ownerUrn;

    private Map<String, Object> metadata;

    @Builder
    @java.beans.ConstructorProperties({"ownerType", "ownerUrn", "metadata"})
    public MetadataCreate(String ownerType, String ownerUrn, Map<String, Object> metadata) {
        this.ownerType = ownerType;
        this.ownerUrn = ownerUrn;

        this.metadata = new HashMap<>();
        if (metadata != null) {
            this.metadata.putAll(metadata);
        }
    }
}
