
package com.tuantm.retrofit.java.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Course {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("id_course")
    @Expose
    private String idCourse;
    @SerializedName("name_course")
    @Expose
    private String nameCourse;
    @SerializedName("tiet")
    @Expose
    private String tiet;
    @SerializedName("si_so")
    @Expose
    private Integer siSo;
    @SerializedName("giao_vien")
    @Expose
    private String giaoVien;
    @SerializedName("phong_hoc")
    @Expose
    private String phongHoc;
    @SerializedName("so_tin_chi")
    @Expose
    private Integer soTinChi;
    @SerializedName("ghi_chu")
    @Expose
    private String ghiChu;
    @SerializedName("new")
    @Expose
    private Boolean _new;

    /**
     * No args constructor for use in serialization
     */
    public Course() {
    }

    /**
     * @param id
     * @param phongHoc
     * @param _new
     * @param idCourse
     * @param nameCourse
     * @param giaoVien
     * @param soTinChi
     * @param siSo
     * @param ghiChu
     * @param tiet
     */
    public Course(Integer id, String idCourse, String nameCourse, String tiet, Integer siSo, String giaoVien, String phongHoc, Integer soTinChi, String ghiChu, Boolean _new) {
        this.id = id;
        this.idCourse = idCourse;
        this.nameCourse = nameCourse;
        this.tiet = tiet;
        this.siSo = siSo;
        this.giaoVien = giaoVien;
        this.phongHoc = phongHoc;
        this.soTinChi = soTinChi;
        this.ghiChu = ghiChu;
        this._new = _new;
    }

    public Course(Integer id, String idCourse, String nameCourse, String tiet, Integer siSo, String giaoVien, String phongHoc, Integer soTinChi, String ghiChu) {
        this.id = id;
        this.idCourse = idCourse;
        this.nameCourse = nameCourse;
        this.tiet = tiet;
        this.siSo = siSo;
        this.giaoVien = giaoVien;
        this.phongHoc = phongHoc;
        this.soTinChi = soTinChi;
        this.ghiChu = ghiChu;
    }

    public Course(String idCourse, String nameCourse, String tiet, Integer siSo, String giaoVien, String phongHoc, Integer soTinChi, String ghiChu, Boolean _new) {
        this.idCourse = idCourse;
        this.nameCourse = nameCourse;
        this.tiet = tiet;
        this.siSo = siSo;
        this.giaoVien = giaoVien;
        this.phongHoc = phongHoc;
        this.soTinChi = soTinChi;
        this.ghiChu = ghiChu;
        this._new = _new;
    }

    public Course(String idCourse, String nameCourse, String tiet, Integer siSo, String giaoVien, String phongHoc, Integer soTinChi, String ghiChu) {
        this.idCourse = idCourse;
        this.nameCourse = nameCourse;
        this.tiet = tiet;
        this.siSo = siSo;
        this.giaoVien = giaoVien;
        this.phongHoc = phongHoc;
        this.soTinChi = soTinChi;
        this.ghiChu = ghiChu;
    }

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The idCourse
     */
    public String getIdCourse() {
        return idCourse;
    }

    /**
     * @param idCourse The id_course
     */
    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    /**
     * @return The nameCourse
     */
    public String getNameCourse() {
        return nameCourse;
    }

    /**
     * @param nameCourse The name_course
     */
    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    /**
     * @return The tiet
     */
    public String getTiet() {
        return tiet;
    }

    /**
     * @param tiet The tiet
     */
    public void setTiet(String tiet) {
        this.tiet = tiet;
    }

    /**
     * @return The siSo
     */
    public Integer getSiSo() {
        return siSo;
    }

    /**
     * @param siSo The si_so
     */
    public void setSiSo(Integer siSo) {
        this.siSo = siSo;
    }

    /**
     * @return The giaoVien
     */
    public String getGiaoVien() {
        return giaoVien;
    }

    /**
     * @param giaoVien The giao_vien
     */
    public void setGiaoVien(String giaoVien) {
        this.giaoVien = giaoVien;
    }

    /**
     * @return The phongHoc
     */
    public String getPhongHoc() {
        return phongHoc;
    }

    /**
     * @param phongHoc The phong_hoc
     */
    public void setPhongHoc(String phongHoc) {
        this.phongHoc = phongHoc;
    }

    /**
     * @return The soTinChi
     */
    public Integer getSoTinChi() {
        return soTinChi;
    }

    /**
     * @param soTinChi The so_tin_chi
     */
    public void setSoTinChi(Integer soTinChi) {
        this.soTinChi = soTinChi;
    }

    /**
     * @return The ghiChu
     */
    public String getGhiChu() {
        return ghiChu;
    }

    /**
     * @param ghiChu The ghi_chu
     */
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    /**
     * @return The _new
     */
    public Boolean getNew() {
        return _new;
    }

    /**
     * @param _new The new
     */
    public void setNew(Boolean _new) {
        this._new = _new;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", idCourse='" + idCourse + '\'' +
                ", nameCourse='" + nameCourse + '\'' +
                ", tiet='" + tiet + '\'' +
                ", siSo=" + siSo +
                ", giaoVien='" + giaoVien + '\'' +
                ", phongHoc='" + phongHoc + '\'' +
                ", soTinChi=" + soTinChi +
                ", ghiChu='" + ghiChu + '\'' +
                '}';
    }
//
//    @Override
//    public String toString() {
//        return ToStringBuilder.reflectionToString(this);
//    }

}