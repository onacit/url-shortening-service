package org.bitbucket.onacit.musinsaurlshorteningservice.web.bind;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * A class for submitting a URL shortening form.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Setter
@Getter
@Slf4j
public class ShortenedUrlForm implements Serializable {

    private static final long serialVersionUID = -624957793957756673L;

    @org.hibernate.validator.constraints.URL
    @NotBlank
    private String originalUrl;
}
