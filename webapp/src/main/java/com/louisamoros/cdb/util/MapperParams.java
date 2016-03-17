package com.louisamoros.cdb.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

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

        Order order;
        if ("desc".equals(params.getOrder())) {
            order = new Order(Sort.Direction.DESC, params.getBy());
        } else {
            order = new Order(Sort.Direction.ASC, params.getBy());
        }

        return new PageRequest(params.getPage() - 1, params.getSize(), new Sort(order));

    }

}
