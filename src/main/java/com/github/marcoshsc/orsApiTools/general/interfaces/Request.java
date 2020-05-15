package com.github.marcoshsc.orsApiTools.general.interfaces;

import com.github.marcoshsc.orsApiTools.general.exceptions.InvalidParameters;
import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;

/**
 *
 * Define a method that every request must have.
 *
 * @param <T> Return type of the request.
 *
 * Created By Marcos Henrique in 28-04-2020
 */
public interface Request<T> {
    T makeRequest() throws RequestException, InvalidParameters;
}
