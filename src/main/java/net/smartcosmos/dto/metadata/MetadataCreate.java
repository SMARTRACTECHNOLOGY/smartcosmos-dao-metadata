package net.smartcosmos.dto.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.beans.ConstructorProperties;
import java.util.HashMap;
import java.util.Map;

@Data
@JsonIgnoreProperties(value = {"version"}, ignoreUnknown = true)
public class MetadataCreate {
    private static final int VERSION = 1;

    @Setter(AccessLevel.NONE)
    private int version = VERSION; // just in case there is a default constructor sometime

    private String ownerType;
    private String ownerId;
    private Map<String, Object> metadata;

    @Builder
    @ConstructorProperties({"ownerType", "ownerId", "metadata"})
    public MetadataCreate(String ownerType, String ownerId, Map<String, Object> metadata) {
        this.ownerType = ownerType;
        this.ownerId = ownerId;
        this.metadata = new HashMap<>();
        if (metadata != null) {
            this.metadata.putAll(metadata);
        }

        this.version = VERSION;
    }
}
