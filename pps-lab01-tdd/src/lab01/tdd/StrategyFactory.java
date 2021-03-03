package lab01.tdd;

public class StrategyFactory {

    public SelectStrategy makeEvenStrategy(){
        return (e) -> e % 2 == 0;
    }
    public SelectStrategy makeMultipleOfStrategy(int number){
        return (e) -> e % number == 0;
    }

    public SelectStrategy makeEqualsStrategy(final int number){
        return (e) -> e == number;
    }
}
