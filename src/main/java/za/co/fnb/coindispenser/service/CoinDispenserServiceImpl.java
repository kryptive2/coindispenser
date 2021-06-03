package za.co.fnb.coindispenser.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CoinDispenserServiceImpl implements CoinDispenserService{

    /**
     * @param amount - target amount to calculate as a sum of least amount of coin combination
     * @param coins - combination of coins
     * @return least number of coins to make "change"
     */
    @Override
    public int getLeastCoinCombination(int amount, int[] coins) {
        List<Integer> min = dispenseMinCoins(amount,coins);
        return min.size();
    }

    /**
     *
     * @return coin combination list with least amount of coins
     * e.g to make change for 11 from coins[6,5,4,3,1], least coins to make 11 -> 6,5
     */
    @Override
    public List<Integer> dispenseMinCoins(int amount, int[] coins) {
        Arrays.sort(coins);
        List<List<Integer>> coinCombination = getPossibleCoinCombination(amount,coins);

        int listSize = coinCombination.size();
        return (listSize > 0) ? coinCombination.get(listSize-1) : new ArrayList<Integer>();
    }

    /**
     * helper class to get possible coin combination
     * @return a list of possible coin combination as a list [[1,2,3,4],[2,3,5]],
     */
    private List<List<Integer>> getPossibleCoinCombination(int amount, int[] coins){

        List<List<Integer>> result = new ArrayList<>();
        calculateCombination(coins,amount,result, new ArrayList<>(),0,0);
        return result;

    }

    /**
     * Recursive method to calculate possible coin combination that sums up to the amount value;
     * @param result - store list of combinations
     * @param combination - reuse this object to verify all possible combination of coins
     * @param sum -  amount to add up to using possible combination
     * @param start - index for each coin in the list
     */
    private void calculateCombination(int[] coins, int amount, List<List<Integer>> result, List<Integer> combination,int sum, int start){

        //add  a new list only if the condition below is satisfied. Important as we reuse the object to possible combination
        if(sum ==amount){
            result.add(new ArrayList<>(combination));
            return;
        }

        if(sum>amount) // the sum of possible combination should not exceed the target acmount
            return;

        for(int i = start;i<coins.length;i++){
            combination.add(coins[i]);
            calculateCombination(coins, amount, result, combination, sum+coins[i],i);
            combination.remove(combination.size()-1);
        }
    }
}
