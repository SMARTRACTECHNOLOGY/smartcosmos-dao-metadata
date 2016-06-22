package net.smartcosmos.dto.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * This response model is particularly intended to be used for Query Requests, i.e. with paging.
 * Other requests usually should work with {@link MetadataResponse} and extract the desired portion.
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"version"})
public class MetadataSingleResponse {

    private static final int VERSION = 1;

    private final int version = VERSION;

    private final String ownerType;

    private final String ownerUrn;

    private final String key;

    private final String dataType;

    @JsonInclude(JsonInclude.Include.ALWAYS)
    private final Object value;

    private final String tenantUrn;

}
