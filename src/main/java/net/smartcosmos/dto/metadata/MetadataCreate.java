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
    private String ownerUrn;
    private Map<String, Object> metadata;

    @Builder
    @ConstructorProperties({"ownerType", "ownerUrn", "metadata"})
    public MetadataCreate(String ownerType, String ownerUrn, Map<String, Object> metadata) {
        this.ownerType = ownerType;
        this.ownerUrn = ownerUrn;
        this.metadata = new HashMap<>();
        if (metadata != null) {
            this.metadata.putAll(metadata);
        }

        this.version = VERSION;
    }
}
