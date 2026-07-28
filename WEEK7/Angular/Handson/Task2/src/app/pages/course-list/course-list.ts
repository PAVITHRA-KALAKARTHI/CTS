import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { CourseCard } from '../../components/course-card/course-card';
import { CourseService } from '../../services/course.service';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    CourseCard
  ],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {

  courses: Course[] = [];
  filteredCourses: Course[] = [];
  searchTerm = '';
  isLoading = true;
  errorMessage = '';

  constructor(
    private courseService: CourseService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {

    this.loadCourses();

    this.route.queryParams.subscribe(params => {

      this.searchTerm = params['search'] || '';

      this.filterCourses();

    });

  }

  loadCourses(): void {

  console.log('Loading started');

  this.isLoading = true;

  this.courseService.getCourses().subscribe({

    next: (courses) => {

      console.log('Courses received:', courses);

      this.courses = courses;

      this.filterCourses();

      this.isLoading = false;

      console.log('Loading finished');

    },

    error: (err) => {

      console.error('HTTP Error:', err);

      this.errorMessage = err.message;

      this.isLoading = false;

    }

  });

}

  filterCourses(): void {

    this.filteredCourses = this.courses.filter(course =>

      course.name.toLowerCase().includes(this.searchTerm.toLowerCase())

    );

  }

  onSearch(): void {

    this.router.navigate([], {

      relativeTo: this.route,

      queryParams: {

        search: this.searchTerm

      },

      queryParamsHandling: 'merge'

    });

  }

  trackByCourseId(index: number, course: Course): number {

    return course.id;

  }

}