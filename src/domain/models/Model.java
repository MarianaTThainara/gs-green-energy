package domain.models;

import java.util.UUID;

abstract class Model {

    String id;

    public Model() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
}
