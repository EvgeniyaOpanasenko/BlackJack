package com.ua.blackjack.repository;

import com.ua.blackjack.model.BasicPlayer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<BasicPlayer, Long> {

}
