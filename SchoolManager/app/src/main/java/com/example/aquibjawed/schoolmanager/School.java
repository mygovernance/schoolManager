package com.example.aquibjawed.schoolmanager;

/**
 * Created by saddam on 15/3/18.
 */

public class School {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int node_id;
    private String id;
    private String registration_id;
    private String board_id;
    private String address_id;

    public void setId(String id) {
        this.id = id;
    }

    public void setRegistration_id(String registration_id) {
        this.registration_id = registration_id;
    }

    public void setBoard_id(String board_id) {
        this.board_id = board_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public void setNode_id(int node_id) {
        this.node_id = node_id;
    }

    public int getNode_id(){
        return this.node_id;
    }

    public String getId() {
        return id;
    }

    public String getRegistration_id() {
        return registration_id;
    }

    public String getBoard_id() {
        return board_id;
    }

    public String getAddress_id() {
        return address_id;
    }

    public School(int node_id, String id, String registration_id, String board_id, String address_id) {
        this.node_id = node_id;
        this.id = id;
        this.registration_id = registration_id;
        this.board_id = board_id;
        this.address_id = address_id;
    }
}
