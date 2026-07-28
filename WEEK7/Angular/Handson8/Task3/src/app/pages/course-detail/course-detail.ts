import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

import { switchMap } from 'rxjs/operators';

import { CourseService } from '../../services/course.service';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-detail',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './course-detail.html',
  styleUrl: './course-detail.css'
})
export class CourseDetail implements OnInit {

  course?: Course;

  constructor(
    private route: ActivatedRoute,
    private courseService: CourseService
  ) {}

  ngOnInit(): void {

    this.route.paramMap.pipe(

      // Step 87 - switchMap()
      // switchMap() cancels the previous HTTP request
      // if a new route parameter arrives before it completes.
      switchMap(params => {

        const id = Number(params.get('id'));

        return this.courseService.getCourseById(id);

      })

    ).subscribe({

      next: (course) => {

        this.course = course;

      },

      error: (err) => {

        console.error(err);

      }

    });

  }

}