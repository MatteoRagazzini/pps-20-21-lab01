package lab01.tdd;

import lab01.tdd.CircularList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private List<Integer> list = new ArrayList<Integer>();

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void add(int element) {
        list.add(1);
    }

    // TODO: 01/03/21
    public int size() {
        return 0;
    }

    // TODO: 01/03/21
    public Optional<Integer> next() {
        return Optional.empty();
    }

    // TODO: 01/03/21
    public Optional<Integer> previous() {
        return Optional.empty();
    }

    // TODO: 01/03/21
    public void reset() {

    }

    // TODO: 01/03/21
    public Optional<Integer> next(SelectStrategy strategy) {
        return Optional.empty();
    }
}
