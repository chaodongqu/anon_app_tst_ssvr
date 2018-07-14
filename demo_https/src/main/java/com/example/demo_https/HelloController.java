package com.example.demo_https;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/login")
    public String login(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "pwd") String pwd

            ){

        System.out.println("login");

        return "login oK" ;
    }

    @RequestMapping("/login1")
    public String login1(
            @RequestBody Map<String, String> person

    ){
        System.out.println("login1");

        return "login oK" ;
    }

    @RequestMapping("/getLoginInfo.do")
    public String getLoginInfo(
            @RequestBody String person

    ){
        System.out.println("getLoginInfo \t" + person);


        JSONObject obj = new JSONObject();

        String mac = "14:12:00:E2:26:EB" ;
        obj.put("id" ,64423 );
        obj.put("maxassoc" ,12 );
        obj.put("type" ,0 );
        obj.put("current" ,"2018-06-25 16:36:59" );
        obj.put("limit" ,"2018-06-30 16:36:16" );
        obj.put("surplus" ,5 );
        obj.put("flag" ,0 );
        obj.put("mac" ,mac);



        /*
        {"id":64423,"maxassoc":12,"type":0,"current":"2018-06-25 16:36:59","limit":"2018-06-30 16:36:16","surplus":5,"flag":0,”mac”:”14:12:00:E2:26:EB”}
         */


        return  obj.toString();
    }

    // 4.1 网络总览
    @RequestMapping("/getLimitMsg.do")
    public  String getLimitMsg(
            @RequestBody String strObj
    )
    {
        JSONObject obj = new JSONObject();

        obj.put("id" ,65107 );
        // 加密前：{"id":65107,"maxassoc":12,"type":0,"current":"2018-06-25 16:36:59","limit":"2018-06-30 16:36:16","surplus":5,"flag":0}
        obj.put("maxassoc" ,12 );
        obj.put("type" ,0 );
        obj.put("current" ,"2018-06-25 16:36:59" );
        obj.put("limit" ,"2018-06-30 16:36:16" );
        obj.put("surplus" ,5 );
        obj.put("flag" ,0 );

        return obj.toString();

    }

    // 4.2 网络心跳
    @RequestMapping("/getMacMsg.do")
    public  String getMacMsg( @RequestBody String strObj)
    {
        JSONObject obj = new JSONObject();

        obj.put("id" ,65107 );
        obj.put("flag" ,4 );

        return obj.toString();

    }
    // 4.3 出口国家
    @RequestMapping("/getAddressInfo.do")
    public  String getAddressInfo(  @RequestBody String strObj) {

        JSONObject obj = new JSONObject();

        obj.put("id", 65107);
        obj.put("flag", 4);

        return obj.toString();


    }
     // 4.4 出口城市
     @RequestMapping("/getLocationInfo.do")
    public  String getLocationInfo(  @RequestBody String strObj)
    {
        JSONObject obj = new JSONObject();

        obj.put("id", 65107);
        obj.put("flag", 4);
        // [{"countryzhname":"印度","citycnname":"Bengaluru","citycode":null,"countrycode":"IN",
        // "ip":"1.1.1.61,1.1.1.130,1.1.1.56,1.1.15.170,1.1.1.1,1.1.1.45,1.1.1.24,1.1.1.41,1.1.1.42",
        // "count":9,"cityzhname":"班加罗尔","countrycnname":"India"}]

        return obj.toString();
    }


}


