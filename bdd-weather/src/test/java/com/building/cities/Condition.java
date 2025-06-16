package com.building.cities;

import java.util.Objects;

public class Condition {
    private String text;
    private String icon;
    private Integer code;

    public Condition(String text, String icon, Integer code) {
        this.text = text;
        this.icon = icon;
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Condition)) return false;
        Condition condition = (Condition) o;
        return getText().equals(condition.getText()) && getIcon().equals(condition.getIcon()) && getCode().equals(condition.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getText(), getIcon(), getCode());
    }
}
