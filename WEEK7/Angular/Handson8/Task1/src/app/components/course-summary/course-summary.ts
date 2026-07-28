import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseService } from '../../services/course.service';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-summary',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './course-summary.html',
  styleUrl: './course-summary.css'
})
export class CourseSummary implements OnInit {

  totalCourses = 0;
  enrolledCourses = 0;

  constructor(
    private courseService: CourseService
  ) {}

  ngOnInit(): void {

    this.courseService.getCourses().subscribe({

      next: (courses: Course[]) => {

        this.totalCourses = courses.length;

        this.enrolledCourses = courses.filter(
          course => course.enrolled
        ).length;

      },

      error: (err) => {

        console.error(err);

      }

    });

  }

}