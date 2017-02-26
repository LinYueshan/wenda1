package com.nowcoder.controller;

import com.nowcoder.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/25.
 */
@Controller
public class IndexController {
    @RequestMapping(path={"/","/index"}, method = {RequestMethod.GET})
    @ResponseBody
    public String index(){
        return "hello spring boot";
    }

    @RequestMapping(path={"/profile/{groupId}/{userId}"})
    @ResponseBody
    public String profile(@PathVariable("groupId") String groupId,
                          @PathVariable("userId") int userId,
                          @RequestParam(value = "type",defaultValue = "1",required = false) int type,
                          @RequestParam(value = "key",required = false) String key){
        return String.format("Profile Page of %s %d, type:%d, key:%s", groupId,userId, type, key);
    }

    @RequestMapping(path={"/vm"}, method = {RequestMethod.GET})
    public String template(Model model){
        model.addAttribute("name", "abc");

        List<String> colors = Arrays.asList(new String[]{"red","green","blue"});
        model.addAttribute("colors",colors);

        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < 3; i++){
            map.put(String.valueOf(i), String.valueOf(i*i));
        }
        model.addAttribute("map", map);

        model.addAttribute("user", new User("Linn"));

        return "home";
    }
}
