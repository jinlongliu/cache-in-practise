package top.onos.domain;

import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Liu on 2016/11/18.
 */

public class Student implements Serializable {

    private static final long serialVersionUID = -1349418667088269532L;

    private int id;
    private String name;
    private String address;
    private Date birthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("serialVersionUID", serialVersionUID)
                .add("id", id)
                .add("name", name)
                .add("address", address)
                .add("birthday", birthday)
                .toString();
    }
}
