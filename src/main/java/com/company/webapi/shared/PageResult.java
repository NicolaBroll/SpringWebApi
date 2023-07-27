package com.company.webapi.shared;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PageResult<T> {

    private final List<T> data;
    private final Long totalCount;

    private PageResult(List<T> data, Long totalCount) {
        this.data = data;
        this.totalCount = totalCount;
    }

    public static <T> PageResult<T> create(Page<T> page){
        return new PageResult<T>(page.getContent(), page.getTotalElements());
    }

    public static <T> PageResult<T> create(List<T> list, Long totalCount){
        return new PageResult<T>(list, totalCount);
    }

    public static <T> PageResult<T>  empty(){
        return new PageResult<T>(new ArrayList<T>(), 0L);
    }

    public List<T> getData() {
        return data;
    }

    public Long getTotalCount() {
        return totalCount;
    }
}
