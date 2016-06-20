package net.smartcosmos.dto.metadata;

import java.beans.ConstructorProperties;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"version"})
public class MetadataResponse {

    private static final int VERSION = 1;

    @Setter(AccessLevel.NONE)
    private int version = VERSION; // just in case there is a default constructor sometime

    private final String ownerType;

    private final String ownerUrn;

    private Map<String, Object> metadata;

    private final String tenantUrn;

    @Builder
    @ConstructorProperties({"ownerType", "ownerUrn", "metadata", "tenantUrn"})
    private MetadataResponse(
        String ownerType, String ownerUrn, Map<String, Object> metadata, String tenantUrn) {

        this.ownerType = ownerType;
        this.metadata = new HashMap<>();
        if (metadata != null) {
            this.metadata.putAll(metadata);
        }
        this.ownerUrn = ownerUrn;
        this.tenantUrn = tenantUrn;

        this.version = VERSION;
    }
}

