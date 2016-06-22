package net.smartcosmos.dto.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(value = {"version"}, ignoreUnknown = true)
public class MetadataUpdate
{
    private static final int VERSION = 1;

    private final int version = VERSION; // just in case there is a default constructor sometime

    private String ownerType;

    private String ownerUrn;

    private String key;

    private Object value;
}
