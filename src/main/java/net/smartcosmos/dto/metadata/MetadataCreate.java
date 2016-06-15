package net.smartcosmos.dto.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetadataCreate {
    private static final int VERSION = 1;

    @Setter(AccessLevel.NONE)
    private int version = VERSION; // just in case there is a default constructor sometime

    private String ownerType;
    private String ownerId;
    private String dataType;
    private String keyName;
    private String value;

    @Builder
    @ConstructorProperties({"ownerType", "ownerId", "dataType", "keyName", "value"})
    public MetadataCreate(String ownerType, String ownerId, String dataType, String keyName, String value) {
        this.ownerType = ownerType;
        this.ownerId = ownerId;
        this.dataType = dataType;
        this.keyName = keyName;
        this.value = value;

        this.version = VERSION;
    }
}
