package bg.hristoskova.judge1.model.service;

/**
 * @author helena81
 * @version 1.0
 * @since 9.11.21
 */
public class RoleServiceModel extends BaseServiceModel {
    private String name;

    public RoleServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
