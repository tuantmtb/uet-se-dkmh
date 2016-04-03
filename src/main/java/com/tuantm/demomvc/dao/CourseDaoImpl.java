package com.tuantm.demomvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tuantm.demomvc.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class CourseDaoImpl implements CourseDao {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Course findById(Integer id) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);

        String sql = "SELECT * FROM course WHERE id=:id";

        Course result = null;
        try {
            result = namedParameterJdbcTemplate.queryForObject(sql, params, new CourseMapper());
        } catch (EmptyResultDataAccessException e) {
            // do nothing, return null
        }

		/*
         * Course result = namedParameterJdbcTemplate.queryForObject( sql, params,
		 * new BeanPropertyRowMapper<Course>());
		 */
        return result;
    }

    @Override
    public List<Course> findAll() {

        String sql = "SELECT * FROM course";
        List<Course> result = namedParameterJdbcTemplate.query(sql, new CourseMapper());

        return result;

    }

    @Override
    public void save(Course course) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO COURSE(ID_COURSE, NAME_COURSE, TIET, SI_SO, GIAO_VIEN, PHONG_HOC, SO_TIN_CHI, GHI_CHU) "
                + "VALUES ( :id_course, :name_course, :tiet, :si_so, :giao_vien, :phong_hoc, :so_tin_chi, :ghi_chu)";
        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(course), keyHolder);
        course.setId(keyHolder.getKey().intValue());

    }

    @Override
    public void update(Course course) {

        String sql = "UPDATE COURSE SET ID_COURSE=:id_course, NAME_COURSE=:name_course, TIET=:tiet, SI_SO=:si_so, " + "GIAO_VIEN=:giao_vien, PHONG_HOC=:phong_hoc, SO_TIN_CHI=:so_tin_chi WHERE id=:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(course));

    }

    @Override
    public void delete(Integer id) {

        String sql = "DELETE FROM COURSE WHERE id= :id";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));

    }

    private SqlParameterSource getSqlParameterByModel(Course course) {

        // Unable to handle List<String> or Array
        // BeanPropertySqlParameterSource
/**
 Integer id;
 String id_course;
 String tiet;
 Integer si_so;
 String giao_vien;
 String phong_hoc;
 Integer so_tin_chi;
 String ghi_chu;
 */
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", course.getId());
        paramSource.addValue("id_course", course.getId_course());
        paramSource.addValue("name_course", course.getName_course());
        paramSource.addValue("tiet", course.getTiet());
        paramSource.addValue("si_so", course.getSi_so());
        paramSource.addValue("giao_vien", course.getGiao_vien());
        paramSource.addValue("phong_hoc", course.getPhong_hoc());
        paramSource.addValue("so_tin_chi", course.getSo_tin_chi());
        paramSource.addValue("ghi_chu", course.getGhi_chu());

//		// join String
//		paramSource.addValue("framework", convertListToDelimitedString(course.getFramework()));
//		paramSource.addValue("sex", course.getSex());
//		paramSource.addValue("number", course.getNumber());
//		paramSource.addValue("country", course.getCountry());
//		paramSource.addValue("skill", convertListToDelimitedString(course.getSkill()));l
        return paramSource;
    }

    private static final class CourseMapper implements RowMapper<Course> {
        /**
         * Integer id;
         * String id_course;
         * String tiet;
         * Integer si_so;
         * String giao_vien;
         * String phong_hoc;
         * Integer so_tin_chi;
         * String ghi_chu;
         */
        public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
            Course course = new Course();
            course.setId(rs.getInt("id"));
            course.setId_course(rs.getString("id_course"));
            course.setName_course(rs.getString("name_course"));
            course.setTiet(rs.getString("tiet"));
            course.setSi_so(rs.getInt("si_so"));
            course.setGiao_vien(rs.getString("giao_vien"));
            course.setPhong_hoc(rs.getString("phong_hoc"));
            course.setSo_tin_chi(rs.getInt("so_tin_chi"));
            course.setGhi_chu(rs.getString("ghi_chu"));
            return course;
        }
    }

    private static List<String> convertDelimitedStringToList(String delimitedString) {

        List<String> result = new ArrayList<String>();

        if (!StringUtils.isEmpty(delimitedString)) {
            result = Arrays.asList(StringUtils.delimitedListToStringArray(delimitedString, ","));
        }
        return result;

    }

    private String convertListToDelimitedString(List<String> list) {

        String result = "";
        if (list != null) {
            result = StringUtils.arrayToCommaDelimitedString(list.toArray());
        }
        return result;

    }

}