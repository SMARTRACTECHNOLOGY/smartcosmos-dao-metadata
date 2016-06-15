package net.smartcosmos.dto.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetadataQuery {

    private static final int VERSION = 1;

    @Setter(AccessLevel.NONE)
    private int version = VERSION; // just in case there is a default constructor sometime

    private String ownerType;
    private String keyName;
    private String value;

    @Builder
    @ConstructorProperties({"ownerType", "keyName", "value"})
    public MetadataQuery(String ownerType, String keyName, String dataType, String value) {
        this.ownerType = ownerType;
        this.keyName = keyName;
        this.value = value;

        this.version = VERSION;
    }
}
