package indi.nengz.entity;

import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Station s1 = new Station("zj","hz","lp","123456","123456");
        Station s2 = new Station("js","sz","szsp","123456","123456");
        List<Station> list= new ArrayList<Station>();
        list.add(s1);
        list.add(s2);
        JSONArray jsonArray = new JSONArray().fromObject(list);
        System.out.println(jsonArray.toString());
    }
}
