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

    private final String ownerType;
    private final String ownerId;
    private final String dataType;
    private final String keyName;
    private final String value;

    private final String id;

    @Builder
    @ConstructorProperties({"dataType", "ownerType", "keyName", "value", "ownerId", "urn", "moniker"})
    public MetadataResponse(
            String dataType, String ownerType, String ownerId, String keyName, String value, String id) {

        this.dataType = dataType;
        this.ownerType = ownerType;
        this.keyName = keyName;
        this.value = value;
        this.ownerId = ownerId;
        this.id = id;

        this.version = VERSION;
    }
}

