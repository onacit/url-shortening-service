package org.bitbucket.onacit.musinsaurlshorteningservice.data.jpa.domain;

import static java.util.Objects.requireNonNull;

/**
 * An abstract class for testing subclasses of {@link BaseEntity}.
 *
 * @param <T> subclass type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
abstract class BaseEntityTest<T extends BaseEntity> {

    /**
     * Creates a new instance for specified entity class.
     *
     * @param entityClass the entity class to test.
     * @see #entityClass
     */
    protected BaseEntityTest(final Class<T> entityClass) {
        super();
        this.entityClass = requireNonNull(entityClass, "entityClass is null");
    }

    /**
     * The entity class to test.
     */
    protected final Class<T> entityClass;
}