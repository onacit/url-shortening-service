package org.bitbucket.onacit.musinsaurlshorteningservice.data.jpa.repository;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.bitbucket.onacit.musinsaurlshorteningservice.data.jpa.domain.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static java.util.Objects.requireNonNull;

/**
 * An abstract class for testing subclasses of {@link BaseEntityRepository} interface.
 *
 * @param <T> repository type parameter
 * @param <U> entity class type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@DataJpaTest
@Slf4j
abstract class BaseEntityRepositoryDataJpaTest<T extends BaseEntityRepository<U>, U extends BaseEntity> {

    /**
     * Creates a new instance with specified repository class and entity class.
     *
     * @param repositoryClass the repository class to test.
     * @param entityClass     the entity class on which {@code repositoryClass} is based.
     * @see #repositoryClass
     * @see #entityClass;
     */
    protected BaseEntityRepositoryDataJpaTest(final Class<T> repositoryClass, final Class<U> entityClass) {
        super();
        this.repositoryClass = requireNonNull(repositoryClass, "repositoryClass is null");
        this.entityClass = requireNonNull(entityClass, "entityClass is null");
    }

    /**
     * The repository class to test.
     */
    protected final Class<T> repositoryClass;

    /**
     * The entity class on which the {@link #repositoryClass} is based.
     */
    protected final Class<U> entityClass;

    @Autowired
    @Accessors(fluent = true)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.PROTECTED)
    private T repositoryInstance;
}