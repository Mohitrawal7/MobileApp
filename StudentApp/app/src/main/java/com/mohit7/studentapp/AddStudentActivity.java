package com.mohit7.studentapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.mohit7.studentapp.model.Student;
import com.mohit7.studentapp.network.RetrofitClient;
import com.mohit7.studentapp.network.StudentApiService;

public class AddStudentActivity extends AppCompatActivity {

    private EditText editName, editEmail, editAge, editMath, editScience, editEnglish, editNepali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        editName = findViewById(R.id.edit_name);
        editEmail =findViewById(R.id.edit_email);
        editAge = findViewById(R.id.edit_age);
        editMath = findViewById(R.id.edit_math);
        editScience = findViewById(R.id.edit_science);
        editEnglish = findViewById(R.id.edit_english);
        editNepali = findViewById(R.id.edit_nepali);

        Button saveButton = findViewById(R.id.button_save);
        saveButton.setOnClickListener(v -> saveStudent());
    }

    private void saveStudent() {
        String name = editName.getText().toString().trim();
        String email = editEmail.getText().toString().trim();
        String agestr = editAge.getText().toString().trim();
        String math = editMath.getText().toString().trim();
        String science = editScience.getText().toString().trim();
        String english = editEnglish.getText().toString().trim();
        String nepali = editNepali.getText().toString().trim();



        if (name.isEmpty() || email.isEmpty() || agestr.isEmpty() || math.isEmpty() || science.isEmpty() || english.isEmpty() || nepali.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        int age= Integer.parseInt(agestr);

        Map<String, Integer> marks = new HashMap<>();
        marks.put("Math", editMath.getText().toString().isEmpty() ? 0 : Integer.parseInt(editMath.getText().toString()));
        marks.put("Science", editScience.getText().toString().isEmpty() ? 0 : Integer.parseInt(editScience.getText().toString()));
        marks.put("English", editEnglish.getText().toString().isEmpty() ? 0 : Integer.parseInt(editEnglish.getText().toString()));
        marks.put("Nepali", editNepali.getText().toString().isEmpty() ? 0 : Integer.parseInt(editNepali.getText().toString()));

        String grade = calculateGrade(marks);

        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setAge(age);
        student.setMarks(marks);
        student.setGrade(grade);

        StudentApiService apiService = RetrofitClient.getRetrofitInstance().create(StudentApiService.class);
        apiService.addStudent(student).enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(AddStudentActivity.this, "Student added!", Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK);
                    finish(); // Go back to MainActivity
                } else {
                    Toast.makeText(AddStudentActivity.this, "Failed to add student", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                Toast.makeText(AddStudentActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String calculateGrade(Map<String, Integer> marks) {
        if (marks == null || marks.isEmpty()) {
            Toast.makeText(AddStudentActivity.this, "Error: " , Toast.LENGTH_SHORT).show();
        }
        int totalMarks = 0;
        for (Integer mark : marks.values()) {
            totalMarks += mark;
        }
        double average = (double) totalMarks / marks.size();
        if (average>=90) return "A+";
        else if (average >= 80) return "A";
        else if (average >= 70) return "B";
        else if (average >= 60) return "C";
        else if (average >= 50) return "D";
        else return "F";

    }
}