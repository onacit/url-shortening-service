package org.bitbucket.onacit.musinsaurlshorteningservice.context;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bitbucket.onacit.musinsaurlshorteningservice.sterotype.JavaUriNormalizeShortener;
import org.bitbucket.onacit.musinsaurlshorteningservice.sterotype.UriShortener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * A configuration for {@link UriShortener} bean.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Configuration
@RequiredArgsConstructor
@Slf4j
public class UriShortenerConfiguration {

    public @Bean
    UriShortener uriShortener() {
        return javaUriNormalizeShortener;
    }

    private final JavaUriNormalizeShortener javaUriNormalizeShortener;
}
