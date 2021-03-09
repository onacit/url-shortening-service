package org.bitbucket.onacit.musinsaurlshorteningservice.data.jpa.repository;

import org.bitbucket.onacit.musinsaurlshorteningservice.data.jpa.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * A base repository interface for subclasses of {@link BaseEntity}.
 *
 * @param <T> entity type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@NoRepositoryBean
public interface BaseEntityRepository<T extends BaseEntity>
        extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
}
