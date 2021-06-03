package za.co.fnb.coindispenser.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CoinDispenserServiceImplTest {

    int coins[];
    CoinDispenserService coinDispenserService;// avoiding autowiring a test(takes longer)

    @BeforeEach
    void setUp() {
        coins =  new int[]{6,5,4,3,1};
        coinDispenserService = new CoinDispenserServiceImpl();
    }
    @Test
    void getLeastCoinCombination(){
        int leastNumberOfCoinCombination = coinDispenserService.getLeastCoinCombination(11,coins);
        assertEquals(2,leastNumberOfCoinCombination);
    }

    @Test
    void dispenseMinCoins(){
        List<Integer> leastCoinCombination = coinDispenserService.dispenseMinCoins(11,coins);
        Integer[] leastCoins = new Integer[leastCoinCombination.size()];
        leastCoinCombination.toArray(leastCoins);
        assertArrayEquals(new Integer[]{5,6},leastCoins);
    }
}