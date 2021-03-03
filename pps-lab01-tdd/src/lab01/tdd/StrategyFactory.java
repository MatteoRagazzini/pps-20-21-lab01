package lab01.tdd;

public class StrategyFactory {

    public SelectStrategy makeEvenStrategy(){
        return new EvenStrategy();
    }
    public SelectStrategy makeMultipleOfStrategy(int number){
        return new MultipleOfStrategy(number);
    }

    public SelectStrategy makeEqualsStrategy(int number){
        return new EqualsStrategy(number);
    }
}
