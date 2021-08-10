package bg.softuni.eshop.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author helena81
 * @version 1.0
 * @since 9.08.21
 */
@Configuration
public class AppBeanConfiguration {

    @Bean
    public ModelMapper modelmapper() {
        return new ModelMapper();
    }
}
