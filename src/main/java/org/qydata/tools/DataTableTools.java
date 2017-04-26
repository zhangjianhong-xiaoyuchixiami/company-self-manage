package org.qydata.tools;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonhn on 2017/4/26.
 */
public class DataTableTools {

    public static Map<String,Object> traverseParam(String aaData){
        Map<String,Object> map = new HashMap<>();
        JSONArray jsonarray = JSONArray.fromObject(aaData);
        String sEcho = null;
        int iDisplayStart = 0; // 起始索引
        int iDisplayLength = 0; // 每页显示的行数
        int iSortCol = 0; //第几列排序
        String sSortDir = null; //按什么排序
        for (int i = 0; i < jsonarray.size(); i++) {
            JSONObject obj = (JSONObject) jsonarray.get(i);
            if (obj.get("name").equals("sEcho")) {
                sEcho = obj.get("value").toString();
            }
            if (obj.get("name").equals("iDisplayStart")) {
                iDisplayStart = obj.getInt("value");
            }
            if (obj.get("name").equals("iDisplayLength")) {
                iDisplayLength = obj.getInt("value");
            }
            if (obj.get("name").equals("iSortCol_0")) {
                iSortCol = obj.getInt("value");
            }
            if (obj.get("name").equals("sSortDir_0")) {
                sSortDir = obj.get("value").toString();
            }
        }
        map.put("sEcho",sEcho);
        map.put("iDisplayStart",iDisplayStart);
        map.put("iDisplayLength",iDisplayLength);
        map.put("iSortCol",iSortCol);
        map.put("sSortDir",sSortDir);
        return map;
    }

}
