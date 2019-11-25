package com.visionary.visionary.controller.pagination;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Max;
import java.util.Objects;

public class Pagination {
    @Max(value = 50)
    private Integer size = 20;
    private Integer page = 0;
    private Sort sort;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public Pageable convert() {
        return convert(null);
    }

    public Pageable convert(Sort defaultSort) {
        if (Objects.nonNull(sort)) {
            return PageRequest.of(page,size,sort);
        } else if (Objects.nonNull(defaultSort)) {
            return PageRequest.of(page,size,defaultSort);
        }
        return PageRequest.of(page,size);
    }
}
