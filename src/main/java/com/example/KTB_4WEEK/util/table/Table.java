package com.example.KTB_4WEEK.util.table;

import java.util.LinkedHashMap;

// Table 인터페이스
public interface Table<T> {
    LinkedHashMap<Long, T> getTable();

}
