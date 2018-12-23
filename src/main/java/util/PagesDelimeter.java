package util;

import java.util.ArrayList;
import java.util.List;

public class PagesDelimeter<T> {


    public List<Integer> calculatePages(List<T> itemList, int limit) {
        List<Integer> list = new ArrayList<>();
        int listSize = itemList.size();
        if (listSize % limit != 0) {
            int count = (listSize / limit) + 1;
            for (int i = 1; i <= count; i++) {
                list.add(i);
            }
        }
        return list;
    }
}
