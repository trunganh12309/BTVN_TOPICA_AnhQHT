package itlab;

import itlab.service.MySum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner {

  @Autowired
  private MySum mySum;

  public static void main(String[] args){
    SpringApplication.run(Application.class);
  }

  @Override
  public void run(String... args) {

    String result1 = mySum.sum("2","3");
    log.info("result1: {}",result1);

    String result2 = mySum.sum("12312asda","3");
    log.info("result2: {}",result2);
  }
}
