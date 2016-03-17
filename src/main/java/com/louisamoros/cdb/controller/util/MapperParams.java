package com.louisamoros.cdb.controller.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * The class MapperParams.
 */
public final class MapperParams {

    /**
     * The mapper page dto constructor.
     */
    private MapperParams() {
        super();
    }

    /**
     * Transform params to spring pageable.
     *
     * @param params the params
     * @return pageable
     */
    public static Pageable toPageable(final Params params) {

        params.verify();

        Sort sort;
        if (params.getOrder().equals("desc")) {
            sort = new Sort(Sort.Direction.DESC, params.getBy());
        } else {
            sort = new Sort(Sort.Direction.ASC, params.getBy());
        }

        return new PageRequest(params.getPage(), params.getSize(), sort);

    }

}
