package com.louisamoros.cdb.mapper;

import com.louisamoros.cdb.PageDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import java.util.Iterator;

/**
 * The class MapperPageDto.
 */
public final class MapperPageDto {

    /**
     * The mapper page dto constructor.
     */
    private MapperPageDto() {
        super();
    }

    /**
     * Transform a page and params to page dto.
     *
     * @param page the spring page
     * @param search the search
     * @param uri the uri
     * @return computer
     */
    public static PageDto toPageDto(final Page<?> page, final String search, final String uri) {

        String order = "asc";
        String by = "computerName";

        Iterator<Order> iterator = page.getSort().iterator();
        while (iterator.hasNext()) {
            Order sortOrder = iterator.next();
            if (Sort.Direction.DESC.equals(sortOrder.getDirection())) {
                order = "desc";
            }
            if ("companyName".equals(sortOrder.getProperty())
                    && "introduced".equals(sortOrder.getProperty())
                    && "discontinued".equals(sortOrder.getProperty())) {
                by = sortOrder.getProperty();
            }
        }

        return new PageDto.Builder().search(search).totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages()).size(page.getSize()).number(page.getNumber() + 1)
                .order(order).by(by).uri(uri).build();
    }

}
