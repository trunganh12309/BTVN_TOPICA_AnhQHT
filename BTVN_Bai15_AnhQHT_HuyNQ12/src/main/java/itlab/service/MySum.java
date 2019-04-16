package itlab.service;

import itlab.annotation.AopTrack;
import org.springframework.stereotype.Service;

@Service
public class MySum {

    @AopTrack
    public String sum (String t1, String t2) {
            Integer a = Integer.parseInt(t1);
            Integer b = Integer.parseInt(t2);
            return String.valueOf(a+b);
        }
}
