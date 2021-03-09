package org.bitbucket.onacit.musinsaurlshorteningservice.data.jpa.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * An entity class for url shortening info.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Entity
@Table(name = "shortened_url")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Setter
@Getter
public class ShortenedUrl extends BaseEntity {

    public static final int MAX_SHORTENED_ID = 8;

    @Basic(optional = false)
    @Column(name = "original_url", nullable = false, insertable = true, updatable = false, unique = true)
    private String originalUrl;

    @Size(max = MAX_SHORTENED_ID)
    @NotBlank
    @Basic(optional = false)
    @Column(name = "shortened_id", nullable = false, insertable = true, updatable = false, unique = true)
    private String shortenedId;

    @Transient
    private String shortenedUrl;
}
