package com.lambdaschool.piggybank.repositories;

import com.lambdaschool.piggybank.modules.Coin;
import org.springframework.data.repository.CrudRepository;

public interface CoinRepository extends CrudRepository<Coin, Long> {
}
