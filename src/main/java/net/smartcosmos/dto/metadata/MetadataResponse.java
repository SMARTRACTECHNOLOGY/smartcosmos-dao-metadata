package net.smartcosmos.dto.metadata;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetadataResponse {
    private final String dataType;
    private final String entityReferenceType;
    private final String key;
    private final Long lastModifiedTimestamp;
    private final String rawValue;
    private final String referenceUrn;
    private final String urn;
    private final String moniker;
}

