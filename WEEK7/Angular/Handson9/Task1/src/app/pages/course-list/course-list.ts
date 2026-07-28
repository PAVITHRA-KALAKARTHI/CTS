import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { Store } from '@ngrx/store';

import { CourseCard } from '../../components/course-card/course-card';
import { Course } from '../../models/course.model';

import * as CourseActions from '../../store/course.actions';
import * as CourseSelectors from '../../store/course.selectors';

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
  isLoading = false;
  errorMessage = '';

  constructor(
    private store: Store,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {

    this.store.dispatch(CourseActions.loadCourses());

    this.store.select(CourseSelectors.selectAllCourses)
      .subscribe(courses => {

        this.courses = courses;

        this.filterCourses();

      });

    this.store.select(CourseSelectors.selectLoading)
      .subscribe(loading => {

        this.isLoading = loading;

      });

    this.store.select(CourseSelectors.selectError)
      .subscribe(error => {

        this.errorMessage = error ?? '';

      });

    this.route.queryParams.subscribe(params => {

      this.searchTerm = params['search'] || '';

      this.filterCourses();

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