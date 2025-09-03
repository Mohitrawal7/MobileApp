package com.mohit7.studentapp.network;

import com.mohit7.studentapp.model.Student;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface StudentApiService {
    @GET("api/students")
    Call<List<Student>> getStudents();

    @POST("api/students")
    Call<Student> addStudent(@Body Student student);

    @DELETE("api/students/{id}")
    Call<Void> deleteStudent(@Path("id") long studentId);
}
