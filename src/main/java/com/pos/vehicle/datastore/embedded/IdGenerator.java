package com.pos.vehicle.datastore.embedded;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {

    private final AtomicLong idGenerator;

    public IdGenerator(final Long initialValue) {
        this.idGenerator = new AtomicLong(initialValue);
    }

    protected Long nextId() {
        return idGenerator.getAndIncrement();
    }

}
