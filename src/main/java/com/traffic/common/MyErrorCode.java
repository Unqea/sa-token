
package com.traffic.common;

import lombok.Getter;

@Getter
public enum MyErrorCode {

    TICKET_NOT_FUND(10001, "工单不存在"),
    CANT_CANCER_T(10002, "不可撤销"),
    CANT_CANCER_OTHERS_T(10003, "不可撤销他人工单"),
    CANT_HAND(10004, "不可处理当前状态工单"),
    CANT_EVALUATE(10005, "不可评价当前状态工单"),

    LABEL_EXIST(11001, "标签已存在"),
    LABEL_HAVE_LOWER(11002, "标签存在下级，不可删除"),

    ;

    private final int code;

    private final String msg;

    MyErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
