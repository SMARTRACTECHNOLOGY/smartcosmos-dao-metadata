package net.smartcosmos.dto.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetadataUpsert {

    private static final int VERSION = 1;

    @Setter(AccessLevel.NONE)
    private int version = VERSION; // just in case there is a default constructor sometime

    private String entityReferenceType;
    private String referenceUrn;
    private String dataType;
    private String key;
    private String rawValue;
    private String moniker;

    @Builder
    @ConstructorProperties({"entityReferenceType", "referenceUrn", "dataType", "key", "rawValue", "moniker"})
    public MetadataUpsert(String entityReferenceType, String referenceUrn, String dataType, String key, String rawValue, String moniker) {
        this.entityReferenceType = entityReferenceType;
        this.referenceUrn = referenceUrn;
        this.dataType = dataType;
        this.key = key;
        this.rawValue = rawValue;
        this.moniker = moniker;

        this.version = VERSION;
    }
}
