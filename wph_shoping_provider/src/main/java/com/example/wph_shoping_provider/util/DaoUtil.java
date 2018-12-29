package com.example.wph_shoping_provider.util;

public class DaoUtil {
    public String insert(int num) {
        if (num > 0) {
            return "添加成功";
        }
        return "添加失败";
    }

    public String updata(int num) {
        if (num > 0) {
            return "修改成功";
        }
        return "修改失败";
    }
}
