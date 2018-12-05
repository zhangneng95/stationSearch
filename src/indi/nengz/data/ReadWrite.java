package indi.nengz.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

public class ReadWrite {
    public void saveDataToFile(String fileName,String data) {
        BufferedWriter writer = null;
        File file = new File("D:\\workspace\\JavaWorkspace\\teamviewSearch\\data\\"+ fileName + ".json");
        //如果文件不存在，则新建一个
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //写入
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,false), "UTF-8"));
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("文件写入成功！");
    }


    public String getDatafromFile(String fileName) {

        String Path="D:\\workspace\\JavaWorkspace\\teamviewSearch\\data\\" + fileName+ ".json";
        BufferedReader reader = null;
        String laststr = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(Path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr += tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }

    public static void main(String[] args){
//		String flag = null;
//		ReadWrite rw = new ReadWrite();
//		String json = rw.getDatafromFile("Json");
//		JSONArray jsonArray = new JSONArray().fromObject(json);
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("province", "江苏");
//		jsonObject.put("city", "苏州");
//		jsonObject.put("username", "泗州食品");
//		jsonObject.put("teamView", "155953290");
//		jsonObject.put("password", "narada123");
//		for(int i = 0 ; i < jsonArray.size(); i++)
//		{
//			if(jsonArray.getJSONObject(i).equals(jsonObject))
//			return;
//		}
//		jsonArray.add(jsonObject);
//		rw.saveDataToFile("Json", jsonArray.toString());
        System.out.println(Class.class.getClass().getResource("/").getPath());
    }


}