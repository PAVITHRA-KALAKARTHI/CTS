import { Injectable } from '@angular/core';

import { Course } from '../models/course.model';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private courses: Course[] = [

    {
      id: 1,
      name: 'Angular',
      code: 'ANG101',
      credits: 1,
      gradeStatus: 'passed',
      enrolled: true
    },

    {
      id: 2,
      name: 'Java',
      code: 'JAVA201',
      credits: 3,
      gradeStatus: 'failed',
      enrolled: false
    },

    {
      id: 3,
      name: 'React',
      code: 'REA301',
      credits: 0,
      gradeStatus: 'pending',
      enrolled: true
    },

    {
      id: 4,
      name: 'Spring Boot',
      code: 'SPR401',
      credits: 4,
      gradeStatus: 'passed',
      enrolled: true
    },

    {
      id: 5,
      name: 'Node JS',
      code: 'NODE501',
      credits: 2,
      gradeStatus: 'pending',
      enrolled: false
    }

  ];

  getCourses(): Course[] {

    return this.courses;

  }

  getCourseById(id: number): Course | undefined {

    return this.courses.find(course => course.id === id);

  }

  addCourse(course: Course): void {

    this.courses.push(course);

  }

}