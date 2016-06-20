package net.smartcosmos.dto.metadata;

import java.beans.ConstructorProperties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

/**
 * This response model is particularly intended to be used for Query Requests, i.e. with paging.
 * Other requests usually should work with {@link MetadataResponse} and extract the desired portion.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"version"})
public class MetadataSingleResponse {

    private static final int VERSION = 1;

    @Setter(AccessLevel.NONE)
    private int version = VERSION;

    private final String ownerType;

    private final String ownerUrn;

    private final String key;

    private final String dataType;

    @JsonInclude(JsonInclude.Include.ALWAYS)
    private final Object value;

    private final String tenantUrn;

    @Builder
    @ConstructorProperties({"ownerType", "ownerUrn", "key", "dataType", "value", "tenantUrn"})
    private MetadataSingleResponse(
        String ownerType, String ownerUrn, String key, String dataType, Object value, String tenantUrn) {

        this.ownerType = ownerType;
        this.ownerUrn = ownerUrn;
        this.key = key;
        this.dataType = dataType;
        this.value = value;
        this.tenantUrn = tenantUrn;

        this.version = VERSION;
    }
}
