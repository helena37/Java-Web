package bg.softuni.beanpuzzle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class BeanpuzzleApplication {
    private final MyConfiguration myConfiguration;
    private final MyBean myBean;

    public BeanpuzzleApplication(MyConfiguration myConfiguration, MyBean myBean) {
        this.myConfiguration = myConfiguration;
        this.myBean = myBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(BeanpuzzleApplication.class, args);
    }

    @PostConstruct
    private void postConstructor() {
        myBean.sayHello();
        MyBean myOtherBean = myConfiguration.getAnotherBean();
        myOtherBean.sayHello();

        System.out.println(myBean.hashCode());
        System.out.println(myOtherBean.hashCode());
        System.out.println(myOtherBean == myBean);
    }

}

@Configuration
class MyConfiguration {
    @Bean
    public MyBean getMyBean() {
        return new MyBean();
    }

    public MyBean getAnotherBean() {
        return getMyBean();
    }
}

class MyBean {
    public MyBean() {
        System.out.println("In the constructor of my bean! " + this.hashCode());
    }
    public void sayHello() {
        System.out.println("Hello from me! My hash code is " + this.hashCode());
    }
}
