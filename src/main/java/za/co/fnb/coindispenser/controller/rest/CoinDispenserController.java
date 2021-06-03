package za.co.fnb.coindispenser.controller.rest;

import org.springframework.web.bind.annotation.RequestParam;
import za.co.fnb.coindispenser.controller.rest.exception.InvalidInputException;
import za.co.fnb.coindispenser.service.CoinDispenserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api("CoinDispenser")
public class CoinDispenserController {

    private final CoinDispenserService coinDispenserService;

    public CoinDispenserController(CoinDispenserService coinDispenserService) {
        this.coinDispenserService = coinDispenserService;
    }

    @RequestMapping("/dispenseCoin")
    @ApiOperation(value = "View Minimum coin combination[actual coins/change]",response = List.class)
    public List<Integer> dispenseCoin(@RequestParam int amount,@RequestParam int[] coins){
        validateInput(amount,coins);

        return coinDispenserService.dispenseMinCoins(amount,coins);
    }
    @RequestMapping("/coinCounter")
    @ApiOperation(value = "View least number of coin combination")
    public int getMinimumNumberOfCoinsToDispense(@RequestParam int amount,@RequestParam int[] coins){
        validateInput(amount,coins);

        return coinDispenserService.getLeastCoinCombination(amount,coins);
    }
  private void validateInput(int amount, int[] coins){
        if(amount<=0)
            throw new InvalidInputException("The amount to calculate change has to be more than 0");
        if(coins.length <=0)
            throw new InvalidInputException("No coins input");

      for (int coin : coins)
          if (coin <= 0)
              throw new InvalidInputException("Invalid coin input");
  }

}
