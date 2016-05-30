package net.smartcosmos.dto.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetadataCreate {
    private String dataType;
    private String key;
    private String rawValue;
}
