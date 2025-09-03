package com.mohit7.studentapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.mohit7.studentapp.model.Student;
import com.mohit7.studentapp.network.RetrofitClient;
import com.mohit7.studentapp.network.StudentApiService;

import retrofit2.Call;
import retrofit2.Response;

public class StudentDetailActivity extends AppCompatActivity {
private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        Student student = (Student) getIntent().getSerializableExtra("STUDENT_DETAIL");

        if (student != null) {
            ((TextView) findViewById(R.id.detail_name)).setText(student.getName());
            ((TextView) findViewById(R.id.detail_email)).setText(student.getEmail());
            ((TextView) findViewById(R.id.detail_age)).setText("Age: " + student.getAge());
            ((TextView) findViewById(R.id.detail_marks_math)).setText("Math: " + student.getMarks().get("Math"));
            ((TextView) findViewById(R.id.detail_marks_science)).setText("Science: " + student.getMarks().get("Science"));
            ((TextView) findViewById(R.id.detail_marks_english)).setText("English: " + student.getMarks().get("English"));
            ((TextView) findViewById(R.id.detail_marks_nepali)).setText("Nepali: " + student.getMarks().get("Nepali"));
            ((TextView) findViewById(R.id.detail_grade)).setText("Grade: " + student.getGrade());
        }


        Button btn = findViewById(R.id.back);
        btn.setOnClickListener(v -> {
                Intent intent;
                intent = new Intent(StudentDetailActivity.this,
                        MainActivity.class);
                startActivity(intent);

        });
        Button btnDelete = findViewById(R.id.delete);
        btnDelete.setOnClickListener(v -> {
            deleteStudent(student.getId());
        });
    }

        private void deleteStudent(long studentId) {
            StudentApiService apiService = RetrofitClient.getRetrofitInstance().create(StudentApiService.class);

            apiService.deleteStudent(studentId).enqueue(new retrofit2.Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(StudentDetailActivity.this, "Student deleted", Toast.LENGTH_SHORT).show();
                        // After deleting, go back to MainActivity
                        Intent intent = new Intent(StudentDetailActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(StudentDetailActivity.this, "Failed to delete", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(StudentDetailActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
    }
}