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

    private final String urn;
    private final String ownerType;
    private final String ownerUrn;
    private Map<String, Object> metadata;
    private final String tenantUrn;

    @Builder
    @ConstructorProperties({"urn", "ownerType", "ownerUrn", "metadata", "tenantUrn"})
    public MetadataResponse(
        String urn, String ownerType, String ownerUrn, Map<String, Object> metadata, String tenantUrn) {

        this.urn = urn;
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

