package com.codestates.repository;

import com.codestates.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(value = "SELECT * FROM MEMBER m" + "LEFT JOIN COMP_TYPE t ON t.TYPE_ID = m.TYPE_ID"
            + "LEFT JOIN COMP_LOCATION l on l.LOCATION_ID = m.LOCATION_ID"
            + "WHERE l.LOCATION = :location AND t.TYPE = :type", nativeQuery = true)
    List<Member> findAllByLocationAndType(@Param("location") String location, @Param("type") String type);
}
