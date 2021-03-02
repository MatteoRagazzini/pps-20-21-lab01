package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {
    private int index = 0;
    private final List<Integer> list = new ArrayList<>();

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
        Optional<Integer> next = list.isEmpty() ?
                Optional.empty() : Optional.of(list.get(index));
        index = (list.size() - 1) == index ? 0 : index + 1;
        return next;
    }

    public Optional<Integer> previous() {

        index = (index == 0) ? list.size() - 1 : index - 1;
        // consistency check to avoid IndexOutOfBound
        return list.isEmpty() ? Optional.empty() : Optional.of(list.get(index));
    }

    // TODO: 01/03/21
    public void reset() {

    }

    // TODO: 01/03/21
    public Optional<Integer> next(SelectStrategy strategy) {
        return Optional.empty();
    }
}
