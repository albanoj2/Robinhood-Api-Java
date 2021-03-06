package com.ampro.robinhood.endpoint.fundamentals.methods;

import com.ampro.robinhood.endpoint.fundamentals.data.TickerFundimentalElementList;
import com.ampro.robinhood.net.request.RequestMethod;
import com.ampro.robinhood.throwables.RequestTooLargeException;

import java.util.Collection;

public class GetTickerFundimentalList extends GetFundamental {

    /** API supports up to ten per request */
    private static int MAX_TICKERS = 10;

    public GetTickerFundimentalList(Collection<String> tickers)
    throws RequestTooLargeException {
        super();
        if (tickers.size() > MAX_TICKERS) {
            throw new RequestTooLargeException(
                    "Ticker request must be under " + MAX_TICKERS
            );
        }
        this.setUrlBase("https://api.robinhood.com/quotes/");
        //Reform the collection as a url param
        //replaceAll("[\\[\\]\\s+]", "") replaces "[]" and empty spaces
        // in collection.toString
        addQueryParameter("symbols", tickers.toString().replaceAll("[\\[\\]\\s+]", ""));

        //This method is ran as GET
        this.setMethodType(RequestMethod.GET);

        this.setReturnType(TickerFundimentalElementList.class);
    }
}
