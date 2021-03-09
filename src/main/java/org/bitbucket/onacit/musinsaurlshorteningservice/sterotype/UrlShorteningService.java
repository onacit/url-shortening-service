package org.bitbucket.onacit.musinsaurlshorteningservice.sterotype;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.bitbucket.onacit.musinsaurlshorteningservice.data.jpa.domain.ShortenedUrl;
import org.bitbucket.onacit.musinsaurlshorteningservice.data.jpa.repository.ShortenedUrlRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.Optional;

/**
 * A service class for URL-shortening.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UrlShorteningService {

    /**
     * Shortens specified URL.
     *
     * @param originalUrl the URL to shorten.
     * @return an entity shortened for {@code originalUrl}.
     */
    public @Valid @NotNull ShortenedUrl shorten(final @NotBlank String originalUrl) {
        return shortenedUrlRepository.findByOriginalUrl(originalUrl)
                .orElseGet(() -> {
                    final ShortenedUrl entity = new ShortenedUrl();
                    entity.setOriginalUrl(originalUrl);
                    entity.setShortenedId(uriShortener.shorten(URI.create(originalUrl)));
                    return shortenedUrlRepository.save(entity);
                });
    }

    /**
     * Returns an entity whose {@code shortenedId} matches to specified value.
     *
     * @param shortenedId the shortenId id to search.
     * @return an entity for {@code shortenedId}.
     */
    public @Valid @NotNull Optional<ShortenedUrl> widen(final @NotBlank String shortenedId) {
        return shortenedUrlRepository.findByShortenedId(shortenedId);
    }

    private final ShortenedUrlRepository shortenedUrlRepository;

    @Accessors(fluent = true)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.PROTECTED)
    private final UriShortener uriShortener;
}
