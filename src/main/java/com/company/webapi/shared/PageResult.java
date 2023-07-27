package com.company.webapi.shared;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PageResult<T> {

    private final List<T> data;
    private final Long totalCount;

    private PageResult(List<T> data, Long totalCount) {
        this.data = data;
        this.totalCount = totalCount;
    }

    public static <T> PageResult<T> create(Page<T> page){
        return new PageResult<>(page.getContent(), page.getTotalElements());
    }

    public static <T> PageResult<T> create(List<T> list, Long totalCount){
        return new PageResult<>(list, totalCount);
    }

    public static <T> PageResult<T> empty(){
        return new PageResult<>(new ArrayList<>(), 0L);
    }

}
