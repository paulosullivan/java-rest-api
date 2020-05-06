package com.pos.vehicle.datastore.embedded;

import java.util.Collection;

public interface DataStore<T> {

    T create(final T e);

    Collection<T> retrieveAll();

    T retrieve(final Long id);

    T update(final Long id, final T e);

    void delete(final Long id);

}
