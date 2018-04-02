package com.example.aquibjawed.schoolmanager;

import com.example.aquibjawed.schoolmanager.utility.MyLog;

/**
 * Created by saddam on 15/3/18.
 */

public class Address {
    private final String TAG="Address";
    private int node_id,state_id,country_id;
    private String address_line_1,address_line_2,pinccode,city;

    public Address(int node_id, int state_id, int country_id, String address_line_1, String address_line_2, String pinccode, String city) {
        this.node_id = node_id;
        this.state_id = state_id;
        this.country_id = country_id;
        this.address_line_1 = address_line_1;
        this.address_line_2 = address_line_2;
        this.pinccode = pinccode;
        this.city = city;
    }
   public void print(){
       MyLog.d(TAG," node_id="+node_id+" state_id="+state_id+" country_id="+country_id+" address_line_1="+address_line_1+" address_line_2="+address_line_2+" pinccode="+pinccode+" city="+city);
   }
    public int getNode_id() {
        return node_id;
    }

    public void setNode_id(int node_id) {
        this.node_id = node_id;
    }

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getAddress_line_1() {
        return address_line_1;
    }

    public void setAddress_line_1(String address_line_1) {
        this.address_line_1 = address_line_1;
    }

    public String getAddress_line_2() {
        return address_line_2;
    }

    public void setAddress_line_2(String address_line_2) {
        this.address_line_2 = address_line_2;
    }

    public String getPinccode() {
        return pinccode;
    }

    public void setPinccode(String pinccode) {
        this.pinccode = pinccode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
