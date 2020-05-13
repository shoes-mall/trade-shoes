package com.shoes.order.commons;

/**
 * 结果码
 **/
public enum ResultCode {
    /**
     * 结果码
     */
    SUCCESS(200, "操作成功"),
    FAIL(500, "请求失败，请稍后重试！");

    private final int code;
    private final String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static String getMsg(int code) {
        for (ResultCode resultCode : ResultCode.values()) {
            if (resultCode.getCode() == code) {
                return resultCode.getMsg();
            }
        }
        return null;
    }

    public static boolean codeExists(int code) {
        for (ResultCode resultCode : ResultCode.values()) {
            if (resultCode.getCode() == code) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "ResultCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
