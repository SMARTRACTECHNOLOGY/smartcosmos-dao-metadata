package net.smartcosmos.dto.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetadataQuery {

    private static final int VERSION = 1;

    private final int version = VERSION;

    private String ownerType;
    private String key;
    private String dataType;
    private Object value;

}
