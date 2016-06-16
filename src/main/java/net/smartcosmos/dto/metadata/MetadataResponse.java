package net.smartcosmos.dto.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.beans.ConstructorProperties;
import java.util.HashMap;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"version"})
public class MetadataResponse {

    private static final int VERSION = 1;

    @Setter(AccessLevel.NONE)
    private int version = VERSION; // just in case there is a default constructor sometime

    private final String id;
    private final String ownerType;
    private final String ownerId;
    private Map<String, Object> metadata;
    private final String tenantId;

    @Builder
    @ConstructorProperties({"id", "ownerType", "ownerId", "metadata", "tenantId"})
    public MetadataResponse(
        String id, String ownerType, String ownerId, Map<String, Object> metadata, String tenantId) {

        this.id = id;
        this.ownerType = ownerType;
        this.metadata = new HashMap<>();
        this.metadata.putAll(metadata);
        this.ownerId = ownerId;
        this.tenantId = tenantId;

        this.version = VERSION;
    }
}

