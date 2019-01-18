package util;

import java.util.ArrayList;
import java.util.List;

public class PagesDelimiter<T> {

    public List<Integer> calculatePages(List<T> itemList, int limit) {
        List<Integer> list = new ArrayList<>();
        int listSize = itemList.size();
        int count ;
        if (listSize % limit != 0) {
            count = (listSize / limit) + 1;
        } else {
            count = (listSize / limit);
        }
        for (int i = 1; i <= count; i++) {
            list.add(i);
        }
        return list;
    }
}
