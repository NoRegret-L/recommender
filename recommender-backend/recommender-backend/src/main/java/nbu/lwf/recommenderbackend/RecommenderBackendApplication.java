package nbu.lwf.recommenderbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("nbu.lwf.recommenderbackend.dao")
public class RecommenderBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecommenderBackendApplication.class, args);
    }

}
