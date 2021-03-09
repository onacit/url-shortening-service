package org.bitbucket.onacit.musinsaurlshorteningservice.sterotype;

import org.bitbucket.onacit.musinsaurlshorteningservice.data.jpa.domain.ShortenedUrl;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.net.URI;

/**
 * An interface for URL shortening service providers.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@FunctionalInterface
public interface UriShortener {

    /**
     * Shorten specified URL.
     *
     * @param widened the URL to shorten.
     * @return a shortened URL.
     */
    @Size(max = ShortenedUrl.MAX_SHORTENED_ID) @NotBlank String shorten(@NotNull URI widened);
}
