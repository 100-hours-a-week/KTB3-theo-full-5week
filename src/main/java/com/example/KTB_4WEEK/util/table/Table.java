package com.example.KTB_4WEEK.util.table;

import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

// Table 인터페이스
public interface Table<T> {
    ConcurrentHashMap<Long, T> getTable();

}
