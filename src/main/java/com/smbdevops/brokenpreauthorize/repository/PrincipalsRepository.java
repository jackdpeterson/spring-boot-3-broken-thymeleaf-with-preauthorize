package com.smbdevops.brokenpreauthorize.repository;

import com.smbdevops.brokenpreauthorize.entity.PrincipalEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PrincipalsRepository extends CrudRepository<PrincipalEntity, Long>, PagingAndSortingRepository<PrincipalEntity, Long> {

    @Query("select * from principals where username = :username")
    Optional<PrincipalEntity> findByUsername(@Param("username") String username);
}
