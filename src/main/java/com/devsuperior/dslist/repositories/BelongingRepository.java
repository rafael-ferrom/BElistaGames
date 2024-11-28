package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.entities.Belonging;
import com.devsuperior.dslist.entities.BelongingPK;

public interface BelongingRepository extends JpaRepository<Belonging, BelongingPK> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Belonging b WHERE b.id.game.id = :gameId")
    void deleteByGameId(Long gameId);
}
