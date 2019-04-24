package com.topica.vn;

import com.topica.vn.repository.VietnameseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

  @Autowired
  VietnameseRepository vietnameseRepository;

  public static void main(String[] args){
    SpringApplication.run(Application.class);
  }

  @Override
  public void run(String... args) {
//    try (FileReader fileReader = new FileReader("dictionary-source/viet-anh-dict.txt");
//         BufferedReader br = new BufferedReader(fileReader)) {
//      String line;
//      while ((line = br.readLine()) != null) {
//        Vietnamese vn = new Vietnamese();
//        vn.setContent(line.split(":")[0]);
//        try{
//          vn.setTranslate(line.split(":")[1]);
//        }catch (ArrayIndexOutOfBoundsException e){
//          vn.setTranslate("");
//        }
//        vietnameseRepository.save(vn);
//      }
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    Page<Vietnamese> test = vietnameseRepository.findByContent("mẹ",new PageRequest(0,10));
//    List<Vietnamese> result = test.getContent();
//    for (Vietnamese v : result){
//      System.out.println(v.getContent() + " : "+v.getTranslate());
//    }
  }
}
