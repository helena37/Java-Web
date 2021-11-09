package bg.hristoskova.judge1.model.service;

/**
 * @author helena81
 * @version 1.0
 * @since 9.11.21
 */
public abstract class BaseServiceModel {
    private String id;

    public BaseServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
