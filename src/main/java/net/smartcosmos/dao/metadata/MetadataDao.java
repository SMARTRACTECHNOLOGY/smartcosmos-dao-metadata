package net.smartcosmos.dao.metadata;

import net.smartcosmos.dto.metadata.MetadataQuery;
import net.smartcosmos.dto.metadata.MetadataQueryMatchResponse;
import net.smartcosmos.dto.metadata.MetadataResponse;
import net.smartcosmos.dto.metadata.MetadataUpsert;

import javax.validation.ConstraintViolationException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MetadataDao {

    /**
     * Upserts a list of metadata entities associated to a reference entity in the realm of a given account.
     *
     * @param accountUrn the account URN
     * @param upsertMetadataCollection the collection containing the metadata entries to upsert
     * @return an {@link MetadataResponse} list for the upserted metadata
     * @throws ConstraintViolationException if the {@link MetadataUpsert} violates constraints enforced by the persistence service
     */
    List<MetadataResponse> upsert(String accountUrn, Collection<MetadataUpsert> upsertMetadataCollection) throws ConstraintViolationException;

    /**
     * Deletes an existing metadata key that is associated to an entity (identified by its reference URN key).
     *
     * @param accountUrn the account URN
     * @param entityReferenceType the reference type of the associated entity
     * @param referenceUrn the URN of the associated entity
     * @param key the key of the metadata entity
     * @return a list of {@link MetadataResponse} instances for the deleted metadata entities
     */
    List<MetadataResponse> delete(String accountUrn, String entityReferenceType, String referenceUrn, String key);

    /**
     * Finds a metadata entity for an associated entity matching a specified key in the realm of a given account.
     *
     * @param accountUrn the account URN
     * @param entityReferenceType the reference type of the associated entities
     * @param referenceUrn the URN of the associated entity
     * @param key the key of the metadata entity
     * @return an {@link MetadataResponse} instance for the deleted metadata
     */
    Optional<MetadataResponse> findByKey(String accountUrn, String entityReferenceType, String referenceUrn, String key);

    /**
     * Finds a list of associated entities of a specified entity reference type within a given account that match specified metadata search criterias.
     *
     * @param accountUrn the account URN
     * @param entityReferenceType the reference type of the associated entity
     * @param queryMetadataCollection the collection of search criterias
     * @param count the maximum count of results to return
     * @return a list of {@link MetadataQueryMatchResponse} instances of reference entities
     */
    Set<MetadataQueryMatchResponse> findBySearchCriteria(String accountUrn, String entityReferenceType, Collection<MetadataQuery> queryMetadataCollection, Integer count);

    /**
     * Counts the metadata entities of a given account that match specified search criterias.
     *
     * @param accountUrn the account URN
     * @param queryMetadataCollection the collection of search criterias
     * @return the count of matching metadata entities
     */
    Long countBySearchCriteria(String accountUrn, Collection<MetadataQuery> queryMetadataCollection);
}
