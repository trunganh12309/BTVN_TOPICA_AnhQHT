package com.topica.vn.controller;//package com.topica.vn.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//import com.topica.Vietnamese;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class BookRestController {
//
//  @RequestMapping("/api/book")
//  public List<Vietnamese> getBook(){
//    List<Vietnamese> vietnamese = new ArrayList<>();
//    vietnamese.add(new Vietnamese("Đường dẫn đến khung thành", "Kim đồng"));
//    vietnamese.add(new Vietnamese("Bảy viên ngọc rồng", "Kim đồng"));
//
//    return vietnamese;
//  }
//
//  @PostMapping("/api/book")
//  public Vietnamese save(@RequestParam String name, @RequestParam String publisher){
//    return new Vietnamese(name, publisher);
//  }
//
//  @PutMapping("/api/book")
//  public Vietnamese saveJson(@RequestBody Vietnamese vietnamese){
//    vietnamese.setName(vietnamese.getName().toUpperCase());
//    vietnamese.setPublisher(vietnamese.getPublisher().toUpperCase());
//    return vietnamese;
//  }
//
//  @RequestMapping("/api/book/{name}")
//  public Vietnamese findByName(@PathVariable String name){
//    return new Vietnamese(name, "default");
//  }
//
//  @RequestMapping("/api/book-list")
//  public String getList(@RequestParam List<Integer> numbers){
//    return numbers.toString();
//  }
//}
