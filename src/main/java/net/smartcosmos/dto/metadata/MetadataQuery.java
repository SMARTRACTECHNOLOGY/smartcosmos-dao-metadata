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

    private final int version = VERSION; // just in case there is a default constructor sometime

    private String entityReferenceType;
    private String key;
    private String dataType;
    private String rawValue;

}
