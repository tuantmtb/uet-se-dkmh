package com.tuantm.demomvc.model;

import java.io.Serializable;
import java.util.List;

public class Course implements Serializable {
    // form:hidden - hidden value
    Integer id;
    String id_course;
    String name_course;
    String tiet;
    Integer si_so;
    String giao_vien;
    String phong_hoc;
    Integer so_tin_chi;
    String ghi_chu;

    public Integer getSo_tin_chi() {
        return so_tin_chi;
    }

    public void setSo_tin_chi(Integer so_tin_chi) {
        this.so_tin_chi = so_tin_chi;
    }

    public String getGhi_chu() {
        return ghi_chu;
    }

    public void setGhi_chu(String ghi_chu) {
        this.ghi_chu = ghi_chu;
    }

    public String getGiao_vien() {
        return giao_vien;
    }

    public void setGiao_vien(String giao_vien) {
        this.giao_vien = giao_vien;
    }

    public String getId_course() {
        return id_course;
    }

    public void setId_course(String id_course) {
        this.id_course = id_course;
    }

    public String getPhong_hoc() {
        return phong_hoc;
    }

    public void setPhong_hoc(String phong_hoc) {
        this.phong_hoc = phong_hoc;
    }

    public Integer getSi_so() {
        return si_so;
    }

    public void setSi_so(Integer si_so) {
        this.si_so = si_so;
    }

    public String getTiet() {
        return tiet;
    }

    public void setTiet(String tiet) {
        this.tiet = tiet;
    }
    public String getName_course() {
        return name_course;
    }

    public void setName_course(String name_course) {
        this.name_course = name_course;
    }


//	// form:checkboxes - multiple checkboxes
//	List<String> khoa;

    public boolean isNew() {
        return (this.id == null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", id_course='" + id_course + '\'' +
                ", name_course='" + name_course+ '\'' +
                ", tiet='" + tiet + '\'' +
                ", si_so=" + si_so +
                ", giao_vien='" + giao_vien + '\'' +
                ", phong_hoc='" + phong_hoc + '\'' +
                ", so_tin_chi=" + so_tin_chi +
                ", ghi_chu=" + ghi_chu +
                '}';
    }

    public Course() {
    }


    public Course(Integer id, String id_course, String name_course, String tiet, Integer si_so, String giao_vien, String phong_hoc, Integer so_tin_chi, String ghi_chu) {
        this.id = id;
        this.id_course = id_course;
        this.name_course = name_course;
        this.tiet = tiet;
        this.si_so = si_so;
        this.giao_vien = giao_vien;
        this.phong_hoc = phong_hoc;
        this.so_tin_chi = so_tin_chi;
        this.ghi_chu = ghi_chu;
    }

    public Course(String id_course, String name_course, String tiet, Integer si_so, String giao_vien, String phong_hoc, Integer so_tin_chi, String ghi_chu) {
        this.id_course = id_course;
        this.name_course = name_course;
        this.tiet = tiet;
        this.si_so = si_so;
        this.giao_vien = giao_vien;
        this.phong_hoc = phong_hoc;
        this.so_tin_chi = so_tin_chi;
        this.ghi_chu = ghi_chu;
    }
}
