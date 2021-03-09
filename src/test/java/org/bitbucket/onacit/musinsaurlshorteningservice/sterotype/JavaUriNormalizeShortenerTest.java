package org.bitbucket.onacit.musinsaurlshorteningservice.sterotype;

import lombok.extern.slf4j.Slf4j;
import org.bitbucket.onacit.musinsaurlshorteningservice.data.jpa.domain.ShortenedUrl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class JavaUriNormalizeShortenerTest {

    private static List<String> urls() {
        return Arrays.asList(
                "http://daum.net",
                "https://www.microsoft.com/index.html"
        );
    }

    /**
     * Tests {@link JavaUriNormalizeShortener#shorten(URI)} method.
     *
     * @param widened a full URI to test with.
     */
    @ParameterizedTest
    @MethodSource({"urls"})
    void test(final String widened) {
        final String shortenedId
                = new JavaUriNormalizeShortener(new HashCodeUriShortener()).shorten(URI.create(widened));
        log.debug("{} <- {}", shortenedId, widened);
        assertThat(shortenedId).isNotBlank().hasSizeLessThanOrEqualTo(ShortenedUrl.MAX_SHORTENED_ID);
    }
}