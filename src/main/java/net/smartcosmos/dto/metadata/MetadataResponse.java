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
import java.util.HashMap;
import java.util.Map;

@ApiModel("Get back \"Metadata\" from the Objects Server.")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"version"})
public class MetadataResponse {

    private static final int VERSION = 1;

    @Setter(AccessLevel.NONE)
    private int version = VERSION; // just in case there is a default constructor sometime

    @ApiModelProperty("The TYPE of the entity the metadata is related to.")
    private final String ownerType;

    @ApiModelProperty("The URN of the entity the metadata is related to.")
    private final String ownerUrn;

    @ApiModelProperty("The collection of metadata entries.")
    private Map<String, Object> metadata;

    @ApiModelProperty("The TENANT which the metadata belongs to.")
    private final String tenantUrn;

    @Builder
    @ConstructorProperties({"ownerType", "ownerUrn", "metadata", "tenantUrn"})
    public MetadataResponse(
        String ownerType, String ownerUrn, Map<String, Object> metadata, String tenantUrn) {

        this.ownerType = ownerType;
        this.metadata = new HashMap<>();
        if (metadata != null) {
            this.metadata.putAll(metadata);
        }
        this.ownerUrn = ownerUrn;
        this.tenantUrn = tenantUrn;

        this.version = VERSION;
    }
}

