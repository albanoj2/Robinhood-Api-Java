package com.ampro.robinhood.net.pagination;

import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.net.ApiMethod;
import com.ampro.robinhood.throwables.RobinhoodNotLoggedInException;

/**
 * An API method for pagination
 * @author Jonathan Augustine
 */
public class Paginate extends ApiMethod {

    /**
     * Build a Paginator without Authorization token
     * @param type The return type of each page
     */
    protected Paginate(Class<?> type) {
        super(Configuration.getDefault());
        setReturnType(type);
    }

    /**
     * Build a Paginator with authorization token
     * @param config A logged in {@link Configuration}
     * @param type The return type
     * @throws RobinhoodNotLoggedInException If the {@link Configuration} is
     *              not logged in
     */
    protected Paginate(Class<?> type, Configuration config)
    throws RobinhoodNotLoggedInException {
        super(config);
        addAuthTokenParameter();
        setReturnType(type);
    }

}
