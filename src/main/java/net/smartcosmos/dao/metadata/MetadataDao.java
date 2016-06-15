package net.smartcosmos.dao.metadata;

import net.smartcosmos.dto.metadata.MetadataQuery;
import net.smartcosmos.dto.metadata.MetadataQueryMatchResponse;
import net.smartcosmos.dto.metadata.MetadataResponse;
import net.smartcosmos.dto.metadata.MetadataCreate;
import net.smartcosmos.dto.metadata.MetadataUpdate;

import javax.validation.ConstraintViolationException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MetadataDao {

    /**
     * Inserts a list of metadata entities associated to a reference entity in the realm of a given tenant.
     *
     * @param tenantId the tenant URN
     * @param createMetadataCollection the collection containing the metadata entries to upsert
     * @return an {@link MetadataResponse} list for the upserted metadata
     * @throws ConstraintViolationException if the {@link MetadataCreate} violates constraints enforced by the persistence service
     */
    List<MetadataResponse> create(String tenantId, Collection<MetadataCreate> createMetadataCollection)
            throws ConstraintViolationException;

    /**
     * Updates a list of metadata entities associated to a reference entity in the realm of a given tenant.
     *
     * @param tenantId the tenant URN
     * @param updateMetadataCollection the collection containing the metadata entries to upsert
     * @return an {@link MetadataResponse} list for the upserted metadata
     * @throws ConstraintViolationException if the {@link MetadataUpdate} violates constraints enforced by the persistence service
     */
    List<MetadataResponse> update(String tenantId, Collection<MetadataUpdate> updateMetadataCollection)
            throws ConstraintViolationException;

    /**
     * Deletes an existing metadata keyName that is associated to an entity (identified by its reference URN keyName).
     *
     * @param tenantId the tenant URN
     * @param ownerType the reference type of the associated entity
     * @param ownerId the URN of the associated entity
     * @param keyName the keyName of the metadata entity
     * @return a list of {@link MetadataResponse} instances for the deleted metadata entities
     */
    List<MetadataResponse> delete(String tenantId, String ownerType, String ownerId, String keyName);

    /**
     * Finds a metadata entity for an associated entity matching a specified keyName in the realm of a given tenant.
     *
     * @param tenantId the tenant URN
     * @param ownerType the reference type of the associated entities
     * @param ownerId the URN of the associated entity
     * @param keyName the keyName of the metadata entity
     * @return an {@link MetadataResponse} instance for the deleted metadata
     */
    Optional<MetadataResponse> findByKeyName(String tenantId, String ownerType, String ownerId, String keyName);

    /**
     * Find all metadata owned by a thing in the realm of a given tenant.
     *
     * @param tenantId the tenant URN
     * @param ownerType the reference type of the associated entities
     * @param ownerId the URN of the associated entity
     * @param keyNames return metadata with given keys, or all metadata when keyNames is Empty
     * @return
     */
    Set<MetadataResponse> findByOwner(String tenantId, String ownerType, String ownerId, Collection<String>keyNames);

    /**
     * Finds a list of associated entities of a specified entity reference type within a given tenant that match specified metadata search criteria.
     *
     * @param tenantId the tenant URN
     * @param ownerType the reference type of the associated entity
     * @param queryMetadataCollection the collection of search criteria
     * @param page the number of the results page
     * @param size the size of a results page
     * @return a list of {@link MetadataQueryMatchResponse} instances of reference entities
     */
    Set<MetadataQueryMatchResponse> findBySearchCriteria(
        String tenantId,
        String ownerType,
        Collection<MetadataQuery> queryMetadataCollection,
        Long page,
        Long size);

    /**
     * Counts the associated entities of a specified entity reference type within a given tenant that match specified metadata search criteria.
     *
     * @param tenantId the tenant URN
     * @param ownerType the reference type of the associated entity
     * @param queryMetadataCollection the collection of search criteria
     * @return the count of matching metadata entities
     */
    Long countBySearchCriteria(String tenantId, String ownerType, Collection<MetadataQuery> queryMetadataCollection);
}
