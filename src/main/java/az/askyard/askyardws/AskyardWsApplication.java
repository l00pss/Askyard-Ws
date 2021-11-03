package az.askyard.askyardws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication(exclude = {})
@EnableSwagger2
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableJpaRepositories("az.askyard.askyardws.dataAccess.abstracts")
public class AskyardWsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AskyardWsApplication.class, args);
    }

}
