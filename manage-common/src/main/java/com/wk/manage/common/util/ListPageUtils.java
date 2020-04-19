package com.wk.manage.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 集合分页
 *
 * @author wukong
 * @create 2020-03-22 下午9:51
 */
public class ListPageUtils {

    /**
     * 按总页数分页
     * @param list
     * @param pageTotal
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> pagingByPageTotal(List<T> list, int pageTotal) {
        List<List<T>> result=new ArrayList<>();
        int pageSize=list.size()/pageTotal;
        List<T> tempList;
        for(int i=0;i<pageTotal;i++)
        {
            if(i==pageTotal-1) {
                tempList = list.subList(pageSize * i, list.size());
            }
            else {
                tempList = list.subList(pageSize * i, pageSize * (i + 1));
            }
            if(tempList!=null&&tempList.size()>0){
                result.add(tempList);
            }
        }
        return result;
    }

    /**
     * 按每页条数分页
     * @param list
     * @param pageSize
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> pagingByPageSize(List<T> list, int pageSize) {
        int totalCount = list.size();
        int pageCount;
        int m = totalCount % pageSize;

        if (m > 0) {
            pageCount = totalCount / pageSize + 1;
        } else {
            pageCount = totalCount / pageSize;
        }
        List<List<T>> totalList = new ArrayList<>();

        for (int i = 1; i <= pageCount; i++) {
            if (m == 0) {
                List<T> subList = list.subList((i - 1) * pageSize, pageSize * (i));
                totalList.add(subList);
            } else {
                if (i == pageCount) {
                    List<T> subList = list.subList((i - 1) * pageSize, totalCount);
                    totalList.add(subList);
                } else {
                    List<T> subList = list.subList((i - 1) * pageSize, pageSize * i);
                    totalList.add(subList);
                }
            }
        }
        return totalList;
    }

}
