package org.bitbucket.onacit.musinsaurlshorteningservice.sterotype;

import org.bitbucket.onacit.musinsaurlshorteningservice.data.jpa.domain.ShortenedUrl;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.net.URI;

/**
 * A URL shortener uses {@link Object#hashCode() hashCode} of given URI.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Component
public class HashCodeUriShortener implements UriShortener {

    @Override
    public @Size(max = ShortenedUrl.MAX_SHORTENED_ID) @NotBlank String shorten(final @NotNull URI widened) {
        final long decoded = widened.normalize().hashCode() & 0xFFFFFFFFL;
        final StringBuilder builder = new StringBuilder();
        builder.append(decoded);
        builder.reverse();
        return Long.toString(Long.parseLong(builder.toString()), Character.MAX_RADIX);
    }
}
