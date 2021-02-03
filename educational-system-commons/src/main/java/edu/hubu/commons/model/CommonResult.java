package edu.hubu.commons.model;

/**
 * @author moonlan
 * date 2021/1/25 下午3:30
 */
@SuppressWarnings(value = "unused")
public class CommonResult {
    private int code;
    private String message;
    private int currentPage;
    private int total;
    private Object data;

    public int getCode() {
        return code;
    }

    public CommonResult setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommonResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public CommonResult setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    public int getTotal() {
        return total;
    }

    public CommonResult setTotal(int total) {
        this.total = total;
        return this;
    }

    public Object getData() {
        return data;
    }

    public CommonResult setData(Object data) {
        this.data = data;
        return this;
    }
}
