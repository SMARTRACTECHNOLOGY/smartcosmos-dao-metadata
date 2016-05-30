package net.smartcosmos.dao.metadata;

import net.smartcosmos.dto.metadata.MetadataResponse;
import net.smartcosmos.dto.metadata.MetadataUpsert;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

public interface MetadataDao {

    /**
     * Upserts a list of metadata entities associated to a reference entity in the realm of a given account.
     *
     * @param accountUrn the account URN
     * @param entityReferenceType the reference type of the associated entity
     * @param referenceUrn the URN of the associated entity
     * @param metadataUpsertList the list containing the metadata entries to upsert
     * @return an {@link MetadataResponse} list for the upserted metadata
     * @throws ConstraintViolationException if the {@link MetadataUpsert} violates constraints enforced by the persistence service
     */
    List<MetadataResponse> upsert(String accountUrn, String entityReferenceType, String referenceUrn, List<MetadataUpsert> metadataUpsertList) throws ConstraintViolationException;

    /**
     * Deletes an existing metadata key that is associated to an entity (identified by its reference URN key).
     *
     * @param accountUrn the account URN
     * @param entityReferenceType the reference type of the associated entity
     * @param referenceUrn the URN of the associated entity
     * @param key the key of the metadata entity
     * @return an {@link MetadataResponse} instance for the deleted metadata
     */
    Optional<MetadataResponse> delete(String accountUrn, String entityReferenceType, String referenceUrn, String key);

    /**
     * Finds a metadata entity for an associated entity matching a specified key in the realm of a given account.
     *
     * @param accountUrn the account URN
     * @param entityReferenceType the reference type of the associated entity
     * @param referenceUrn the URN of the associated entity
     * @param key the key of the metadata entity
     * @return an {@link MetadataResponse} instance for the deleted metadata
     */
    Optional<MetadataResponse> findByKey(String accountUrn, String entityReferenceType, String referenceUrn, String key);
}
