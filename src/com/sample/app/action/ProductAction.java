package com.sample.app.action;

import com.fererlab.action.SupportAction;
import com.fererlab.dto.*;
import com.sample.app.model.*;

/**
 * acm | 1/16/13
 */
public class ProductAction extends SupportAction<Product> {

    public ProductAction() {
        super(Product.class);
    }

    public Response details(Request request) {
        Product product;
        if (request.getParams().containsKey("id")) {
            product = find(Long.valueOf(String.valueOf(request.getParams().getValue("id"))));
            return Response.create(request, toContent(request, product), Status.STATUS_OK);
        } else {
            return Response.create(request, "param 'id' not found", Status.STATUS_NOT_FOUND);
        }
    }

}
