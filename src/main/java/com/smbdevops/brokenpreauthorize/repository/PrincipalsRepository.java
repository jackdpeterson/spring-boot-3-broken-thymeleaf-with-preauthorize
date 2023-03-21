package com.smbdevops.brokenpreauthorize.repository;

import com.smbdevops.brokenpreauthorize.entity.PrincipalEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PrincipalsRepository extends ReactiveCrudRepository<PrincipalEntity, Long>, ReactiveSortingRepository<PrincipalEntity, Long> {

    @Query("select * from principals where username = :username")
    Mono<PrincipalEntity> findByUsername(@Param("username") String username);
}
