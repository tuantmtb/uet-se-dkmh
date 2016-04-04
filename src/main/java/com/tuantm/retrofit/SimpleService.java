package com.tuantm.retrofit;

import com.tuantm.demomvc.model.Course;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by tuantmtb-osx on 04/04/2016.
 */
public class SimpleService {
    public static final String API_URL = "http://localhost:8080/dkmh/";

    public interface APICourse {
        @GET("api/course/all")
        Call<List<Course>> showAllCourses();

        @GET("api/course/{id}")
        Call<Course> getCourseId(@Path("id") String id);

        @POST("api/course/create")
        Call<Void> createCourse(@Body Course course);

        @PUT("/api/course/{id}/update")
        Call<Course> updateCourse(@Path("id") String id, @Body Course course);

        @DELETE("/api/course/{id}/delete")
        Call<Course> deleteCourse(@Path("id") String id);

    }

    public static void main(String... args) throws IOException {
        // Create a very simple REST adapter which points the GitHub API.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an instance of our GitHub API interface.
        APICourse apiCourse = retrofit.create(APICourse.class);
        SimpleService simpleService = new SimpleService();

        // Get single couse by Id
        simpleService.getCourseId(apiCourse, "1");

        // Create course
        simpleService.createCourse(apiCourse,new Course("MAT123","Giải tích", "3-5", 35, "Trần Thị Hà", "P104-G2",5,"Môn học tiên quyết"));

        // Delete course
        simpleService.deleteCourse(apiCourse,"3");

        // Update course
        simpleService.updateCourse(apiCourse,"2", new Course("MAT124","Giải tích 2", "3-5", 35, "Trần Thị Hà", "P104-G2",5,"Môn học tiên quyết"));

        // Get all course
        simpleService.getAllCourse(apiCourse);

    }

    public List<Course> getAllCourse(APICourse apiCourse) throws IOException {
        // Create a call instance for looking up Retrofit contributors.
        Call<List<Course>> call = apiCourse.showAllCourses();

        // Fetch and print a list of the contributors to the library.
        List<Course> courses = call.execute().body();
        for (Course course : courses) {
            System.out.println(course);
        }
        return courses;
    }

    public Course getCourseId(APICourse apiCourse, String idCourse) throws IOException {
        // Create a call instance for looking up Retrofit contributors.
        Call<Course> call = apiCourse.getCourseId(idCourse);

        // Fetch and print a list of the contributors to the library.
        Course course = call.execute().body();
        System.out.println(course);
        return course;
    }

    public void createCourse(APICourse apiCourse, Course course) throws IOException {
        // Create a call instance for looking up Retrofit contributors.
        Call<Void> call = apiCourse.createCourse(course);
        call.execute().body();

        // Fetch and print a list of the contributors to the library.
    }

    public Course deleteCourse(APICourse apiCourse, String id) throws IOException {
        Call<Course> call = apiCourse.deleteCourse(id);
        Course course = call.execute().body();
        return course;
    }

    public Course updateCourse(APICourse apiCourse,String id, Course course) throws IOException{
        Call<Course> call = apiCourse.updateCourse(id,course);
        Course courseNew = call.execute().body();
        return courseNew;
    }


}
