package com.mohit7.studentapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.mohit7.studentapp.R;
import com.mohit7.studentapp.StudentDetailActivity;
import com.mohit7.studentapp.model.Student;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.name.setText(student.getName());
        holder.email.setText(student.getEmail());
        holder.grade.setText(student.getGrade());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), StudentDetailActivity.class);
            intent.putExtra("STUDENT_DETAIL", student);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public void updateData(List<Student> newStudentList) {
        this.studentList.clear();
        this.studentList.addAll(newStudentList);
        notifyDataSetChanged();
    }

    public Student getStudentAt(int position) {
        return studentList.get(position);
    }

    public void removeStudentAt(int position) {
        studentList.remove(position);
        notifyItemRemoved(position);
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView name, email, grade;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textViewName);
            email = itemView.findViewById(R.id.textViewEmail);
            grade = itemView.findViewById(R.id.textViewGrade);
        }
    }
}