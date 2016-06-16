package net.smartcosmos.dao.metadata;

import net.smartcosmos.dto.metadata.MetadataResponse;
import net.smartcosmos.dto.metadata.MetadataCreate;

import javax.validation.ConstraintViolationException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MetadataDao {

    /**
     * Inserts a list of metadata entities associated to a reference entity in the realm of a given tenant.
     *
     * @param tenantId the tenant ID
     * @param createMetadataCollection the collection containing the metadata entries to insert
     * @return an {@link MetadataResponse} list for the inserted metadata
     * @throws ConstraintViolationException if the {@link MetadataCreate} violates constraints enforced by the persistence service
     */
    List<MetadataResponse> create(String tenantId, Collection<MetadataCreate> createMetadataCollection)
            throws ConstraintViolationException;

    /**
     * Updates a metadata key associated to a reference entity with a new value in the realm of a given tenant.
     *
     * @param tenantId the tenant ID
     * @param ownerType the reference type of the associated entity
     * @param ownerId the ID of the associated entity
     * @param keyName the keyName of the metadata entity
     * @param value the new value of the metadata entity
     * @throws ConstraintViolationException if value violates constraints or does not match the dataType given on create
     * @return
     */
    Optional<MetadataResponse> update(
            String tenantId,
            String ownerType,
            String ownerId,
            String keyName,
            Object value)
            throws ConstraintViolationException;

    /**
     * Deletes an existing metadata keyName that is associated to an entity (identified by its reference URN keyName).
     *
     * @param tenantId the tenant ID
     * @param ownerType the reference type of the associated entity
     * @param ownerId the ID of the associated entity
     * @param keyName the keyName of the metadata entity
     * @return a list of {@link MetadataResponse} instances for the deleted metadata entities
     */
    List<MetadataResponse> delete(String tenantId, String ownerType, String ownerId, String keyName);

    /**
     * Finds a metadata entity for an associated entity matching a specified keyName in the realm of a given tenant.
     *
     * @param tenantId the tenant ID
     * @param ownerType the reference type of the associated entities
     * @param ownerId the URN of the associated entity
     * @param keyName the keyName of the metadata entity
     * @return an {@link MetadataResponse} instance for the deleted metadata
     */
    Optional<MetadataResponse> findByKeyName(String tenantId, String ownerType, String ownerId, String keyName);

    /**
     * Find all metadata owned by a thing in the realm of a given tenant.
     *
     * @param tenantId the tenant ID
     * @param ownerType the reference type of the associated entities
     * @param ownerId the URN of the associated entity
     * @param keyNames return metadata with given keys, or all metadata when keyNames is Empty
     * @return
     */
    Set<MetadataResponse> findByOwner(String tenantId, String ownerType, String ownerId, Collection<String>keyNames);
}
