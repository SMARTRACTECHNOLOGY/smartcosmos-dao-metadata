package net.smartcosmos.dto.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"version"})
public class MetadataResponse {

    private static final int VERSION = 1;

    @Setter(AccessLevel.NONE)
    private int version = VERSION; // just in case there is a default constructor sometime

    private final String dataType;
    private final String entityReferenceType;
    private final String key;
    private final Long lastModifiedTimestamp;
    private final String rawValue;
    private final String referenceUrn;
    private final String urn;
    private final String moniker;

    @Builder
    @ConstructorProperties({"dataType", "entityReferenceType", "key", "lastModifiedTimestamp", "rawValue", "referenceUrn", "urn", "moniker"})
    public MetadataResponse(String dataType, String entityReferenceType, String key, Long lastModifiedTimestamp, String rawValue, String referenceUrn, String urn, String moniker) {
        this.dataType = dataType;
        this.entityReferenceType = entityReferenceType;
        this.key = key;
        this.lastModifiedTimestamp = lastModifiedTimestamp;
        this.rawValue = rawValue;
        this.referenceUrn = referenceUrn;
        this.urn = urn;
        this.moniker = moniker;

        this.version = VERSION;
    }
}

