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

    private String entityReferenceType;
    private String key;
    private String dataType;
    private String rawValue;

    @Builder
    @ConstructorProperties({"entityReferenceType", "key", "dataType", "rawValue"})
    public MetadataQuery(String entityReferenceType, String key, String dataType, String rawValue) {
        this.entityReferenceType = entityReferenceType;
        this.key = key;
        this.dataType = dataType;
        this.rawValue = rawValue;

        this.version = VERSION;
    }
}
