package net.smartcosmos.dto.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.beans.ConstructorProperties;

/**
 * This response model is particularly intended to be used for Query Requests, i.e. with paging.
 * Other requests usually should work with {@link MetadataResponse} and extract the desired portion.
 */
@ApiModel("Get back a single \"Metadata\" entry from the Objects Server.")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"version"})
public class MetadataSingleResponse {

    private static final int VERSION = 1;

    @Setter(AccessLevel.NONE)
    private int version = VERSION;

    @ApiModelProperty("The TYPE of the entity the metadata is related to.")
    private final String ownerType;

    @ApiModelProperty("The URN of the entity the metadata is related to.")
    private final String ownerUrn;

    @ApiModelProperty("The KEY of the metadata entry.")
    private final String key;

    @ApiModelProperty("The DATA TYPE of the metadata entry (String, Boolean, Number, JSON Object, JSON Array).")
    private final String dataType;

    @ApiModelProperty("The VALUE of the metadata entry.")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private final Object value;

    @ApiModelProperty("The TENANT which the metadata belongs to.")
    private final String tenantUrn;

    @Builder
    @ConstructorProperties({"ownerType", "ownerUrn", "key", "dataType", "value", "tenantUrn"})
    public MetadataSingleResponse(
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
