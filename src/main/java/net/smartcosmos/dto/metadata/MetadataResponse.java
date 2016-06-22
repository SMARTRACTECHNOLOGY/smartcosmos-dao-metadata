package net.smartcosmos.dto.metadata;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonIgnoreProperties({"version"})
public class MetadataResponse {

    private static final int VERSION = 1;

    private final int version = VERSION; // just in case there is a default constructor sometime

    private final String ownerType;

    private final String ownerUrn;

    private Map<String, Object> metadata;

    private final String tenantUrn;

}

