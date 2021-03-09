package org.bitbucket.onacit.musinsaurlshorteningservice.data.jpa.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static java.util.Objects.requireNonNull;

/**
 * An abstract class for testing subclasses of {@link BaseEntity} in a JPA environment.
 *
 * @param <T> subclass type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@DataJpaTest
@Slf4j
abstract class BaseEntityDataJpaTest<T extends BaseEntity> {

    /**
     * Creates a new instance for specified entity class.
     *
     * @param entityClass the entity class to test.
     * @see #entityClass
     */
    protected BaseEntityDataJpaTest(final Class<T> entityClass) {
        super();
        this.entityClass = requireNonNull(entityClass, "entityClass is null");
    }

    /**
     * The entity class to test.
     */
    protected final Class<T> entityClass;
}