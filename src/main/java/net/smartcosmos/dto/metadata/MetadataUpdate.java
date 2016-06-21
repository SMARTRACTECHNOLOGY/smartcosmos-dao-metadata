package net.smartcosmos.dto.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.beans.ConstructorProperties;
import java.util.HashMap;
import java.util.Map;

@Builder
@Data
@JsonIgnoreProperties(value = {"version"}, ignoreUnknown = true)
public class MetadataUpdate
{
    private static final int VERSION = 1;

    @Setter(AccessLevel.NONE)
    private int version = VERSION; // just in case there is a default constructor sometime

    private String ownerType;

    private String ownerUrn;

    private String key;

    private String value;

}
