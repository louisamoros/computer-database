package com.louisamoros.cdb.dto.mapper;

import com.louisamoros.cdb.dto.PageDto;

import org.springframework.data.domain.Page;

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

        // formatter:off
        return new PageDto.Builder().search(search).totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages()).size(page.getSize()).number(page.getNumber())
                .uri(uri).build();
        // formatter:on

    }

}
