package net.smartcosmos.dto.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetadataUpsert {
    private String entityReferenceType;
    private String referenceUrn;
    private String dataType;
    private String key;
    private String rawValue;
    private String moniker;
}
