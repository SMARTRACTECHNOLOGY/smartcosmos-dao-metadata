package net.smartcosmos.dto.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonIgnoreProperties({ "version" })
public class MetadataValueResponse {

    private static final int VERSION = 1;
    private final int version = VERSION;

    private final Object value;
    private final String tenantUrn;
}
