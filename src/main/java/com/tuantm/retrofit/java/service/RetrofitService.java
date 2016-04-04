package com.tuantm.retrofit.java.service;
import com.tuantm.retrofit.java.model.Course; // Chú ý đây là model của android
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.io.IOException;
import java.util.List;

/**
 * Created by tuantmtb-osx on 04/04/2016.
 */
public class RetrofitService {
    public static final String API_URL = "http://localhost:8080/dkmh/";

    public interface APICourse {
        // Lấy toàn bộ courses
        @GET("api/course/all")
        Call<List<Course>> showAllCourses();

        // Lấy course by id
        @GET("api/course/{id}")
        Call<Course> getCourseId(@Path("id") int id);

        // Tạo course mới
        @POST("api/course/create")
        Call<Void> createCourse(@Body Course course);

        // Update course
        // CHÚ Ý: Đối tượng Course phải có ID, nếu không có ID sẽ tạo ra Course mới chứ không phải là sửa course
        @POST("api/course/{id}/update")
        Call<Course> updateCourse(@Path("id") int id, @Body Course course);

        // Xóa course
        @GET("api/course/{id}/delete")
        Call<Void> deleteCourse(@Path("id") String id);

    }

    public static void main(String... args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an instance of our API interface.
        APICourse apiCourse = retrofit.create(APICourse.class);
        RetrofitService retrofitService = new RetrofitService();

//        // Get all course
//        List<Course> coursesAll = retrofitService.getAllCourse(apiCourse);
//        for (Course course : coursesAll) {
//            System.out.println(course);
//        }
//
//        // Get course
        Course courseAfterGet = retrofitService.getCourseId(apiCourse, 1);
        System.out.println(courseAfterGet);

//        // Create course
        retrofitService.createCourse(apiCourse, new Course("Có dấu", "CS 1.6", "3-5", 35, "Trần Thu Hà", "P104-G2", 2, "Môn học tiên quyết"));
//
//        // Update course
        Course courseAfterUpdate = retrofitService.updateCourse(apiCourse, 1, new Course(1,"Quá đỉnh hết bug", "Cap nhat", "3-5", 35, "Trần Thu Hà", "P104-G2", 2, "Môn học tiên quyết"));
//
//        // Delete course
        retrofitService.deleteCourse(apiCourse, "2");

        System.out.println("Sau khi thực hện");

        // Get all course agian
        List<Course> coursesAllAfter = retrofitService.getAllCourse(apiCourse);
        if(coursesAllAfter!=null) {
            for (Course course : coursesAllAfter) {
                System.out.println(course);
            }
        }


    }

    public List<Course> getAllCourse(APICourse apiCourse) throws IOException {
        Call<List<Course>> call = apiCourse.showAllCourses();
        List<Course> courses = call.execute().body();
        return courses;
    }

    public Course getCourseId(APICourse apiCourse, int idCourse) throws IOException {
        Call<Course> call = apiCourse.getCourseId(idCourse);
        Course course = call.execute().body();
        return course;
    }

    public void createCourse(APICourse apiCourse, Course course) throws IOException {
        Call<Void> call = apiCourse.createCourse(course);
        call.execute().body();

    }

    public void deleteCourse(APICourse apiCourse, String id) throws IOException {
        Call<Void> call = apiCourse.deleteCourse(id);
        call.execute().body();
    }

    public Course updateCourse(APICourse apiCourse, int id, Course course) throws IOException {
        Call<Course> call = apiCourse.updateCourse(id, course);
        Course courseNew = call.execute().body();
        return courseNew;
    }


}
