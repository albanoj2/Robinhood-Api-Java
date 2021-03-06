package com.ampro.robinhood.endpoint.orders.methods;

import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.orders.data.SecurityOrderElementList;
import com.ampro.robinhood.net.request.RequestMethod;

/**
 * REST GET method to retrieve a user's orders.
 * @author Jonathan Augustine
 */
public class GetOrderMethod extends OrderMethod {

    /**
     * Set api URL to GET from and return type
     * ({@link SecurityOrderElementList}).
     * @param config a logged in {@link Configuration}
     */
    public GetOrderMethod(Configuration config) {
        super(config);
        this.setUrlBase("https://api.robinhood.com/orders/");

        this.addHeaderParameter("Content-Type", "application/x-www-form-urlencoded");

        //This method should be ran as POST
        this.setMethodType(RequestMethod.GET);

        this.setReturnType(SecurityOrderElementList.class);
    }

}
