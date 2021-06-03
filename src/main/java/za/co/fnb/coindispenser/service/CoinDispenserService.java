package za.co.fnb.coindispenser.service;

import java.util.List;

public interface CoinDispenserService {
    public List<Integer> dispenseMinCoins(int amount, int[] coins);
    public int getLeastCoinCombination(int amount, int[] coins);
}
