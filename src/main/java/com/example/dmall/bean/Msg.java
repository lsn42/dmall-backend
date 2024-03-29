package com.example.dmall.bean;

import java.util.HashMap;
import java.util.Map;

public class Msg {
    int code;
    String msg;
    Map<String,Object> extend = new HashMap<>();

    public Msg success(String key,Object value) {
        this.setCode(200);
        this.setMsg("处理成功");
        this.getExtend().put(key, value);
        return this;
    }

    public static Msg success(){
        Msg msg = new Msg();
        msg.setMsg("处理成功");
        msg.setCode(200);
        return msg;
    }

    public static Msg fail() {
        Msg result = new Msg();
        result.setCode(100);
        result.setMsg("处理失败");
        return result;
    }

    public static Msg error(String message){
        Msg result = new Msg();
        result.setMsg(message);
        result.setCode(100);
        return  result;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
