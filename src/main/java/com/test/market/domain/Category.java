package com.test.market.domain;

public class Category {
    private int categoruId;
    private String category;
    private boolean active;

    public int getCategoruId() {
        return categoruId;
    }

    public void setCategoruId(int categoruId) {
        this.categoruId = categoruId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
