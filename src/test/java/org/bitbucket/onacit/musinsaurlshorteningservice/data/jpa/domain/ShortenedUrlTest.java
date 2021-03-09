package org.bitbucket.onacit.musinsaurlshorteningservice.data.jpa.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * A class for testing {@link ShortenedUrl}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
class ShortenedUrlTest extends BaseEntityTest<ShortenedUrl> {

    ShortenedUrlTest() {
        super(ShortenedUrl.class);
    }

    @Test
    void getOriginalUrl_Null_New() {
        assertThat(new ShortenedUrl().getOriginalUrl()).isNull();
    }

    @Test
    void setOriginalUrl_DoesNotThrow_Null() {
        assertDoesNotThrow(() -> new ShortenedUrl().setOriginalUrl(null));
    }

    @Test
    void getShortedId_Null_New() {
        assertThat(new ShortenedUrl().getShortenedId()).isNull();
    }

    @Test
    void setShortenedId_DoesNotThrow_Null() {
        assertDoesNotThrow(() -> new ShortenedUrl().setShortenedId(null));
    }
}