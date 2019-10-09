package com.jiujiuhouse.resource.mvc;

import org.springframework.ui.ModelMap;

public class JsonResult extends ModelMap {
    private static final String CODE = "code";
    private static final String MESSAGE = "message";

    public static JsonResult create() {
        return new JsonResult();
    }

    public JsonResult() {
        this(0, "Success");
    }

    public JsonResult(int code, String message) {
        this.addAttribute("code", code);
        this.addAttribute("message", message);
    }

    public JsonResult setCode(int code) {
        this.addAttribute("code", code);
        return this;
    }

    public JsonResult setMessage(String message) {
        this.addAttribute("message", message);
        return this;
    }

    @Override
    public JsonResult addAttribute(String attributeName, Object attributeValue) {
        super.addAttribute(attributeName, attributeValue);
        return this;
    }

    public JsonResult addResult(Object attributeValue) {
        super.addAttribute("result", attributeValue);
        return this;
    }

    public JsonResult addkeyValue(String key, Object attributeValue) {
        super.addAttribute(key, attributeValue);
        return this;
    }

    public JsonResult result(Object value) {
        return create().addResult(value);
    }
}
