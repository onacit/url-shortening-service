package org.bitbucket.onacit.musinsaurlshorteningservice.data.jpa.repository;

import org.bitbucket.onacit.musinsaurlshorteningservice.data.jpa.domain.ShortenedUrl;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * A repository for {@link ShortenedUrl} entity.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Repository
public interface ShortenedUrlRepository extends BaseEntityRepository<ShortenedUrl> {

    /**
     * Finds the entity whose {@code originalUrl} attribute matches to specified value.
     *
     * @param originalUrl the value for {@code originalUrl} attribute to match.
     * @return an optional found entity; {@code empty} if not found.
     */
    Optional<ShortenedUrl> findByOriginalUrl(String originalUrl);

    /**
     * Finds the entity whose {@code shortenedId} attribute matches to specified value.
     *
     * @param shortenedId the value for {@code shortenedId} attribute to match.
     * @return an optional found entity; {@code empty} if not found.
     */
    Optional<ShortenedUrl> findByShortenedId(String shortenedId);
}
