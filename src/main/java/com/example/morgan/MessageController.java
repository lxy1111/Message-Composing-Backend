package com.example.morgan;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class MessageController {
     private String[] items;
    public MessageController() {
       items=new String[4];
       items[0]="drink milk";
       items[1]="drink tea";
       items[2]="drink coffee";
       items[3]="drink water";
    }

    @GetMapping("/getMessage")
    @CrossOrigin(origins = {"http://localhost:8101","http://localhost:8080"})
   public String[] sendMessage()
    {
        return items;
    }

    @PostMapping("/receiveMessage")
    @CrossOrigin(origins = {"http://localhost:8101","http://localhost:8080"})
    public String getMessage(
        @RequestParam(value="message") JSONObject message) throws JSONException {
//        String str = "[{'columnId':5,'columnName':'人文历史'},{'columnId':2,'columnName':'商业视野'}]}";
//        JSONArray jsonArray = null;
//        jsonArray = new JSONArray(str);
        String text=message.get("text").toString();
        String name=message.get("name").toString();


        System.out.println(message.get("text"));

        return "drink water";
    }
}