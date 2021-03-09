package org.bitbucket.onacit.musinsaurlshorteningservice.sterotype;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bitbucket.onacit.musinsaurlshorteningservice.data.jpa.domain.ShortenedUrl;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.net.URI;

/**
 * A URL shortener uses the {@link URI#normalize() normalized} form of a URI.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class JavaUriNormalizeShortener implements UriShortener {

    @Override
    public @Size(max = ShortenedUrl.MAX_SHORTENED_ID) @NotBlank String shorten(final @NotNull URI widened) {
        return hashCodeUriShortener.shorten(widened.normalize());
    }

    private final HashCodeUriShortener hashCodeUriShortener;
}
