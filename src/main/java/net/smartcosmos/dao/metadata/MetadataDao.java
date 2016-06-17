package net.smartcosmos.dao.metadata;

import net.smartcosmos.dto.metadata.MetadataResponse;
import net.smartcosmos.dto.metadata.MetadataCreate;

import javax.validation.ConstraintViolationException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface MetadataDao {

    /**
     * Inserts a list of metadata entities associated to a reference entity in the realm of a given tenant.
     *
     * @param tenantUrn the tenant URN
     * @param createMetadata the collection containing the metadata entries to insert
     * @return a {@link MetadataResponse} item containing the inserted metadata
     * @throws ConstraintViolationException if the {@link MetadataCreate} violates constraints enforced by the persistence service
     */
    Optional<MetadataResponse> create(String tenantUrn, MetadataCreate createMetadata)
            throws ConstraintViolationException;

    /**
     * Updates a metadata key associated to a reference entity with a new value in the realm of a given tenant.
     *
     * @param tenantUrn the tenant URN
     * @param ownerType the reference type of the associated entity
     * @param ownerUrn the URN of the associated entity
     * @param keyName the keyName of the metadata entity
     * @param value the new value of the metadata entity
     * @return a {@link MetadataResponse} item containing the updated metadata
     * @throws ConstraintViolationException if value violates constraints or does not match the dataType given on create
     */
    Optional<MetadataResponse> update(
            String tenantUrn,
            String ownerType,
            String ownerUrn,
            String keyName,
            Object value)
            throws ConstraintViolationException;

    /**
     * Deletes an existing metadata keyName that is associated to an entity (identified by its reference URN keyName).
     *
     * @param tenantUrn the tenant URN
     * @param ownerType the reference type of the associated entity
     * @param ownerUrn the URN of the associated entity
     * @param keyName the keyName of the metadata entity
     * @return a list of {@link MetadataResponse} instances for the deleted metadata entities
     */
    List<MetadataResponse> delete(String tenantUrn, String ownerType, String ownerUrn, String keyName);

    /**
     * Finds a metadata entity for an associated entity matching a specified keyName in the realm of a given tenant.
     *
     * @param tenantUrn the tenant URN
     * @param ownerType the reference type of the associated entities
     * @param ownerUrn the URN of the associated entity
     * @param keyName the keyName of the metadata entity
     * @return the value Object assigned to the given key or Optional.empty() in case of a non-existing key
     */
    Optional<Object> findByKeyName(String tenantUrn, String ownerType, String ownerUrn, String keyName);

    /**
     * Find all metadata owned by a thing in the realm of a given tenant.
     *
     * @param tenantUrn the tenant URN
     * @param ownerType the reference type of the associated entities
     * @param ownerUrn the URN of the associated entity
     * @param keyNames return metadata with given keys, or all metadata when keyNames is Empty
     * @return the {@link MetadataResponse} populated with values for the given keyNames
     */
    Optional<MetadataResponse> findByOwner(String tenantUrn, String ownerType, String ownerUrn, Collection<String>keyNames);
}
