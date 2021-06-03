package za.co.fnb.coindispenser.repository;

import za.co.fnb.coindispenser.repository.entity.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinDispenserRepository extends JpaRepository<Coin,Long> {
}
