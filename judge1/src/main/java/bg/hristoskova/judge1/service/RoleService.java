package bg.hristoskova.judge1.service;

import bg.hristoskova.judge1.model.service.RoleServiceModel;

/**
 * @author helena81
 * @version 1.0
 * @since 9.11.21
 */
public interface RoleService {
    RoleServiceModel findByName(String name);
}
