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

    private final String id;
    private final String ownerType;
    private final String ownerId;
    private final String dataType;
    private final String keyName;
    private final String value;
    private final String tenantId;

    @Builder
    @ConstructorProperties({"id", "ownerType", "ownerId", "dataType", "keyName", "value", "tenantId"})
    public MetadataResponse(
        String id, String ownerType, String ownerId, String dataType, String keyName, String value, String tenantId) {

        this.id = id;
        this.ownerType = ownerType;
        this.keyName = keyName;
        this.dataType = dataType;
        this.value = value;
        this.ownerId = ownerId;
        this.tenantId = tenantId;

        this.version = VERSION;
    }
}

