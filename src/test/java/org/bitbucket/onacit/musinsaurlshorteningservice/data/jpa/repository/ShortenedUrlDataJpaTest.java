package org.bitbucket.onacit.musinsaurlshorteningservice.data.jpa.repository;

import lombok.extern.slf4j.Slf4j;
import org.bitbucket.onacit.musinsaurlshorteningservice.data.jpa.domain.ShortenedUrl;
import org.bitbucket.onacit.musinsaurlshorteningservice.sterotype.HashCodeUriShortener;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * A class for testing {@link ShortenedUrlRepository} repository.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Slf4j
class ShortenedUrlDataJpaTest extends BaseEntityRepositoryDataJpaTest<ShortenedUrlRepository, ShortenedUrl> {

    ShortenedUrlDataJpaTest() {
        super(ShortenedUrlRepository.class, ShortenedUrl.class);
    }

    /**
     * Asserts that {@link ShortenedUrlRepository#findByOriginalUrl(String)} method returns an empty for an unknown
     * {@code originalUrl}.
     */
    @DisplayName("findByOriginalUrl(unknown) returns an empty result")
    @Test
    void findByOriginalUrl_Empty_Unknown() {
        final String originalUrl = "_";
        assertThat(repositoryInstance().findByOriginalUrl(originalUrl))
                .isNotNull()
                .isEmpty();
    }

    /**
     * Asserts {@link ShortenedUrlRepository#findByOriginalUrl(String)} method returns a non-empty result when the
     * {@code originalUrl} is known.
     */
    @DisplayName("findByOriginalUrl(known) returns a non-empty result")
    @Test
    void findByOriginalUrl_NonEmpty_Saved() {
        final String originalUrl = "http://original.url1";
        final String shortenedId = hashCodeUriShortener.shorten(URI.create(originalUrl));
        final ShortenedUrl entity = new ShortenedUrl();
        entity.setOriginalUrl(originalUrl);
        entity.setShortenedId(shortenedId);
        repositoryInstance().save(entity);
        assertThat(repositoryInstance().findByOriginalUrl(originalUrl))
                .isNotEmpty()
                .hasValueSatisfying(e -> {
                    assertThat(e.getOriginalUrl()).isEqualTo(originalUrl);
                });
    }

    /**
     * Asserts that {@link ShortenedUrlRepository#findByShortenedId(String)} method returns an empty result for an
     * unknown {@code originalUrl}.
     */
    @DisplayName("findByShortenedId(unknown) returns an empty result")
    @Test
    void findByShortenedId_Empty_Unknown() {
        final String shortenedId = "_";
        assertThat(repositoryInstance().findByShortenedId(shortenedId))
                .isNotNull()
                .isEmpty();
    }

    /**
     * Asserts {@link ShortenedUrlRepository#findByShortenedId(String)} method returns a non-empty result when the
     * {@code shortenedId} is known.
     */
    @DisplayName("findByShortenedId(known) returns a non-empty result")
    @Test
    void findByShortenedId_NonEmpty_Saved() {
        final String originalUrl = "http://original.url2";
        final String shortenedId = hashCodeUriShortener.shorten(URI.create(originalUrl));
        final ShortenedUrl entity = new ShortenedUrl();
        entity.setOriginalUrl(originalUrl);
        entity.setShortenedId(shortenedId);
        repositoryInstance().save(entity);
        assertThat(repositoryInstance().findByShortenedId(shortenedId))
                .isNotEmpty()
                .hasValueSatisfying(e -> {
                    assertThat(e.getShortenedId()).isEqualTo(shortenedId);
                });
    }

    private final HashCodeUriShortener hashCodeUriShortener = new HashCodeUriShortener();
}
