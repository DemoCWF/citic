package com.citic.demo.base;

import com.alibaba.druid.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 批量查询条件，有其他参数集成此类即可 @Author: zhangbing
 * @date: 2018/10/30 14:05
 */
public class ObjectQuery {
    /** 每页显示记录数 */
    private int pageSize = Constants.DEFAULT_PAGESIZE;

    /** 当前页页码 */
    private int currentPage = Constants.DEFAULT_PAGE;

    /** 开始时间,时间戳 */
    private Long beginTime;

    /** 结束时间,时间戳 */
    private Long endTime;

    /** 排序字段 */
    private String sortName;

    /** 排序方向 */
    private String sortOrder;

    public Long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Long beginTime) {
        this.beginTime = beginTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageOffset() {
        return (currentPage - 1) * pageSize;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public List<String> getSortSql() {
        List<String> sortSql = null;
        if (this.isNotBlank(sortName)) {
            sortSql = new ArrayList<>();
            String[] sortArray = sortName.split(",");
            String[] orderArray = sortOrder.split(",");
            for (int i = 0; i < sortArray.length; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(sortArray[i]).append(" ").append(orderArray[i]);
                sortSql.add(sb.toString());
            }
        }
        return sortSql;
    }

    private boolean isNotBlank(String str) {
        return !this.isBlank(str);
    }

    private boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }
}