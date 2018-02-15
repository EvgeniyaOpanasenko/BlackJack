package com.ua.blackjack.repository;

import com.ua.blackjack.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Contains crud operations with database
 */
@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

}
