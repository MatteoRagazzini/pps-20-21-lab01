package lab01.tdd;

import lab01.tdd.CircularList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {
    private int index = 0;
    private List<Integer> list = new ArrayList<Integer>();

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void add(int element) {
        list.add(element);
    }

    public int size() {
        return list.size();
    }

    public Optional<Integer> next() {

        Optional<Integer> next = Optional.of(list.get(index));
        index = (list.size() - 1) == index ? 0 : index + 1;
        return next;
    }

    public Optional<Integer> previous() {
        int previous = index == 0 ? list.size() - 1 : index - 1;
        System.out.println(list.size() -1);
        return Optional.of(list.get(previous));
    }

    // TODO: 01/03/21
    public void reset() {

    }

    // TODO: 01/03/21
    public Optional<Integer> next(SelectStrategy strategy) {
        return Optional.empty();
    }
}
