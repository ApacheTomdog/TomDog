package com.brcc.business.home.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class MenuUserNewEntityPK implements Serializable {
    private String menuId;
    private String userId;

    @Column(name = "menu_id")
    @Id
    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Column(name = "user_id")
    @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuUserNewEntityPK that = (MenuUserNewEntityPK) o;

        if (menuId != null ? !menuId.equals(that.menuId) : that.menuId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = menuId != null ? menuId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
