package net.smartcosmos.dao.metadata;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.ConstraintViolationException;

import net.smartcosmos.dto.metadata.MetadataOwnerResponse;
import net.smartcosmos.dto.metadata.MetadataResponse;
import net.smartcosmos.dto.metadata.MetadataSingleResponse;
import net.smartcosmos.dto.metadata.MetadataValueResponse;
import net.smartcosmos.dto.metadata.Page;

public interface MetadataDao {

    Integer DEFAULT_PAGE = 1;
    Integer DEFAULT_SIZE = 20;
    SortOrder DEFAULT_SORT_ORDER = SortOrder.ASC;
    String DEFAULT_SORT_BY = "created";

    /**
     * Inserts a list of metadata entities associated to a reference entity in the realm of a given tenant, and
     * returns an Optional.empty() if any of the metadata keys already exist.
     *
     * @param tenantUrn the tenant URN
     * @param ownerType the reference type of the associated entity
     * @param ownerUrn the URN of the associated entity
     * @param metadataMap the collection containing the metadata entries to insert
     * @return a {@link MetadataResponse} item containing the inserted metadata
     * @throws ConstraintViolationException if any of the metadata map entries violates constraints enforced by the persistence service
     */
    Optional<MetadataResponse> create(
        String tenantUrn,
        String ownerType,
        String ownerUrn,
        Map<String, Object> metadataMap)
        throws ConstraintViolationException;

    /**
     * Inserts a list of metadata entities associated to a reference entity in the realm of a given tenant, and does
     * merges if keys already exist.
     *
     * @param tenantUrn the tenant URN
     * @param ownerType the reference type of the associated entity
     * @param ownerUrn the URN of the associated entity
     * @param metadataMap the collection containing the metadata entries to insert
     * @return a {@link MetadataResponse} item containing the inserted metadata
     * @throws ConstraintViolationException if any of the metadata map entries violates constraints enforced by the persistence service
     */
    Optional<MetadataResponse> upsert(
        String tenantUrn,
        String ownerType,
        String ownerUrn,
        Map<String, Object> metadataMap)
        throws ConstraintViolationException;

    /**
     * Updates a metadata key associated to a reference entity with a new value in the realm of a given tenant.
     *
     * @param tenantUrn the tenant URN
     * @param ownerType the reference type of the associated entity
     * @param ownerUrn the URN of the associated entity
     * @param key the key of the metadata entity
     * @param value the new value of the metadata entity
     * @return a {@link MetadataResponse} item containing the updated metadata
     * @throws ConstraintViolationException if value violates constraints or does not match the dataType given on create
     */
    Optional<MetadataResponse> update(
        String tenantUrn,
        String ownerType,
        String ownerUrn,
        String key,
        Object value)
        throws ConstraintViolationException;

    /**
     * Deletes an existing metadata key that is associated to an entity (identified by its reference URN key).
     *
     * @param tenantUrn the tenant URN
     * @param ownerType the reference type of the associated entity
     * @param ownerUrn the URN of the associated entity
     * @param key the key of the metadata entity
     * @return a list of {@link MetadataResponse} instances for the deleted metadata entities
     */
    List<MetadataResponse> delete(String tenantUrn, String ownerType, String ownerUrn, String key);

    /**
     * Deletes all existing metadata that is associated to an entity.
     *
     * @param tenantUrn the tenant URN
     * @param ownerType the reference type of the associated entity
     * @param ownerUrn the URN of the associated entity
     * @return a list of {@link MetadataResponse} instances for the deleted metadata entities
     */
    List<MetadataResponse> deleteAllByOwner(String tenantUrn, String ownerType, String ownerUrn);

    /**
     * Finds a metadata entity for an associated entity matching a specified key in the realm of a given tenant.
     *
     * @param tenantUrn the tenant URN
     * @param ownerType the reference type of the associated entities
     * @param ownerUrn the URN of the associated entity
     * @param key the key of the metadata entity
     * @return the value Object assigned to the given key or Optional.empty() in case of a non-existing key
     */
    Optional<MetadataValueResponse> findByKey(String tenantUrn, String ownerType, String ownerUrn, String key);

    /**
     * Finds a metadata entity for an associated entity matching a specified key, regardless of tenant.
     *
     * @param ownerType the reference type of the associated entities
     * @param ownerUrn the URN of the associated entity
     * @param key the key of the metadata entity
     * @return the value Object assigned to the given key or Optional.empty() in case of a non-existing key
     */
    Optional<MetadataValueResponse> findByKeyNoTenant(String ownerType, String ownerUrn, String key);

    /**
     * Find all metadata owned by a thing in the realm of a given tenant.
     *
     * @param tenantUrn the tenant URN
     * @param ownerType the reference type of the associated entities
     * @param ownerUrn the URN of the associated entity
     * @param keys return metadata with given keys, or all metadata when keys is Empty
     * @return the {@link MetadataResponse} populated with values for the given keys
     */
    Optional<MetadataResponse> findByOwner(String tenantUrn, String ownerType, String ownerUrn, Collection<String> keys);

    /**
     * Return all metadata entries associated to owners of a given type in the realm of a given tenant (paged).
     *
     * @param tenantUrn the tenant URN
     * @param ownerType the type of the Metadata owner
     * @param page the number of the results page
     * @param size the maximum size of a results page
     * @return the paged list of {@link MetadataSingleResponse} instances in the realm
     */
    Page<MetadataSingleResponse> findByOwnerType(String tenantUrn, String ownerType, Integer page, Integer size);

    /**
     * Return all metadata entries associated to owners of a given type in the realm of a given tenant (paged and sorted).
     *
     * @param tenantUrn the tenant URN
     * @param ownerType the type of the Metadata owner
     * @param page the number of the results page
     * @param size the maximum size of a results page
     * @param sortOrder order to sort the result, can be {@code ASC} or {@code DESC}
     * @param sortBy name of the field to sort by
     * @return the paged list of {@link MetadataSingleResponse} instances in the realm
     */
    Page<MetadataSingleResponse> findByOwnerType(String tenantUrn, String ownerType, Integer page, Integer size, SortOrder sortOrder, String sortBy);

    /**
     * Finds all owner entities of a given type that are associated with a given set of metadata entries in the realm of a given tenant (paged and
     * sorted).
     *
     * @param tenantUrn the tenant URN
     * @param ownerType the type of the Metadata owner
     * @param keyValuePairs the map of metadata key-value pairs
     * @param page the number of the results page
     * @param size the maximum size of a results page
     * @param sortOrder order to sort the result, can be {@code ASC} or {@code DESC}
     * @param sortBy name of the field to sort by
     * @return the paged list of {@link MetadataOwnerResponse} instances in the realm
     */
    Page<MetadataOwnerResponse> findOwnersByTypeAndKeyValuePairs(
        String tenantUrn,
        String ownerType,
        Map<String, Object> keyValuePairs,
        Integer page,
        Integer size,
        SortOrder sortOrder,
        String sortBy);

    /**
     * Finds all owner entities of a given type that are associated with a given set of metadata entries, regardless of tenant (paged and
     * sorted).
     *
     * @param ownerType the type of the Metadata owner
     * @param keyValuePairs the map of metadata key-value pairs
     * @param page the number of the results page
     * @param size the maximum size of a results page
     * @param sortOrder order to sort the result, can be {@code ASC} or {@code DESC}
     * @param sortBy name of the field to sort by
     * @return the paged list of {@link MetadataOwnerResponse} instances in the realm
     */
    Page<MetadataOwnerResponse> findOwnersByTypeAndKeyValuePairsNoTenant(
        String ownerType,
        Map<String, Object> keyValuePairs,
        Integer page,
        Integer size,
        SortOrder sortOrder,
        String sortBy);
}
