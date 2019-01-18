/**
 * @Auther: 13654
 * @Date: 2018/12/29 17:28
 * @Description:
 */
package com.example.wph_order_provider.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
  * 功能描述: 特殊分页工具类
  * @Author 13654
  * @Date 17:51 2018/12/29
  * @Param  * @param null
  * @return
  **/

public class Paging {

    //总页数
    private int page;

    //总条数
    private int total;

    //结果集
    private List<Object> list;

    //当前页
    private int pageNum;

    //每页的数量
    private int pageSize;

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return this.total;
    }

    public void setSize(int size) {
        this.total = size;
    }

    public List<Object> getList() {
        return this.list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String page(Integer total, List list, int pageNum, int pageSize){
        setPageNum(pageNum);
        setPageSize(pageSize);
        if(total<=pageSize){
            page = 1;
        }else if(total%pageSize>0){
            page=total/pageSize+1;
        }else {
            page=total/pageSize;
        }
//        setSize(list.size());
//        List<Object> objectArrayList = new ArrayList<Object>();
//        int currIdx = (pageNum > 1 ? (pageNum -1) * pageSize : 0);
//        setSize(currIdx);
//        for (int i = 0; i < pageSize && i < list.size() - currIdx; i++) {
//            Object object = list.get(currIdx + i);
//            objectArrayList.add(object);
//        }
        if (!list.isEmpty()){
            Map<String,Object> map = new HashMap<>();
            map.put("pages",page);
            map.put("total",total);
            map.put("list",list);
            map.put("pageNum",this.pageNum);
            map.put("pageSize",this.pageSize);
            String str = JSON.toJSONString(map);
            return str;
        }
        return null;
    }
}
