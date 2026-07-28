import {
  Component,
  Input,
  OnChanges,
  SimpleChanges
} from '@angular/core';

import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

import { HighlightDirective } from '../../directives/highlight.directive';
import { CreditLabelPipe } from '../../pipes/credit-label.pipe';

import { EnrollmentService } from '../../services/enrollment';

import { Course } from '../../models/course.model';

import { Store } from '@ngrx/store';

import * as EnrollmentActions from '../../store/enrollment.actions';

import * as EnrollmentSelectors from '../../store/enrollment.selectors';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [
    CommonModule,
    HighlightDirective,
    CreditLabelPipe
  ],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCard implements OnChanges {

  @Input()
  course!: Course;

  isExpanded = false;

  toggleEnrollment(): void {

  if (this.course.enrolled) {

    this.store.dispatch(

      EnrollmentActions.unenrollFromCourse({

        courseId: Number(this.course.id)

      })

    );

    this.course.enrolled = false;

  }

  else {

    this.store.dispatch(

      EnrollmentActions.enrollInCourse({

        courseId: Number(this.course.id)

      })

    );

    this.course.enrolled = true;

  }

}

  ngOnChanges(changes: SimpleChanges): void {

    console.log(changes);

  }

  toggleDetails(): void {

    this.isExpanded = !this.isExpanded;

  }

  toggleEnrollment(): void {

    if (this.enrollmentService.isEnrolled(this.course.id)) {

      this.enrollmentService.unenroll(this.course.id);

    } else {

      this.enrollmentService.enroll(this.course.id);

    }

  }

  navigateToCourse(): void {

    this.router.navigate(['courses', this.course.id]);

  }

  get cardClasses() {

    return {

      'card-enrolled': this.course.enrolled,

      'card-full': this.course.credits >= 4,

      'expanded': this.isExpanded

    };

  }

  get borderColor() {

    switch (this.course.gradeStatus) {

      case 'passed':
        return 'green';

      case 'failed':
        return 'red';

      default:
        return 'gray';

    }

  }

}