package cn.lambochen.demo.simple.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

import java.util.List;

/**
 * @author lambochen
 * @date 2022-11-03 20:33
 */
public class JSONPaths {

    public static void main(String[] args) {
        String json = "{\"ext_black_list\":[],\"ext_inner_balance_list\":[105003578,109593374,111632415],\"ext_outer_balance_list\":[91212528,90445053,40593494,92156292,95049416,44080158,92211890,91016312,40910257,98303091,92215461,45443850,18921303,99717308,97044811,98575639,101649588,97417693,96593013,44243480,110214226,93790052,100634105,104821702,103602217]}";
        String jsonPath = "$.ext_inner_balance_list";
        JSONObject jsonObject = JSON.parseObject(json);

        Object list = JSONPath.eval(jsonObject, jsonPath);
        if (list instanceof List) {
            ((List<Long>) list).add(1234L);
        }
        System.out.println(list);


        JSONPath.set(jsonObject, jsonPath, list);
        System.out.println(json);
    }

}
