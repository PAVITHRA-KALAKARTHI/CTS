import { Component, OnInit, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CourseService } from '../../services/course.service';
import { CourseSummary } from '../../components/course-summary/course-summary';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    CourseSummary
  ],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home implements OnInit, OnDestroy {

  portalName = 'Student Course Portal';

  isPortalActive = true;

  message = '';

  searchTerm = '';

  coursesAvailable = 0;

  enrolledCourses = 3;

  gpa = 3.8;

  constructor(
    private courseService: CourseService
  ) {}

  ngOnInit(): void {

    this.coursesAvailable = this.courseService.getCourses().length;

    console.log('HomeComponent initialised - courses loaded');

  }

  ngOnDestroy(): void {

    console.log('HomeComponent destroyed');

  }

  onEnrollClick(): void {

    this.message = 'Enrollment opened!';

  }

}