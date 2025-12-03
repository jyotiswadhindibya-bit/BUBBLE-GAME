package net.vas.bubbles;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/bubbles")
public class Controller {
    @PostMapping("/logic")
      public static List<Integer> logic(@RequestBody List<Integer> n){
        List<Integer> l=new ArrayList<>(n); int temp;
        for(int i=0;i<l.size()-1;i++)
            for(int j=0;j<l.size()-i-1;j++){
               if (l.get(j)<l.get(j+1)) {
                temp=l.get(j);
                l.set(j,l.get(j+1));
                l.set(j+1,temp);
               }    
            }
        return l;
      }
}
