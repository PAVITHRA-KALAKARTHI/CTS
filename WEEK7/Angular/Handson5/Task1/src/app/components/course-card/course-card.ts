import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HighlightDirective } from '../../directives/highlight.directive';
import { CreditLabelPipe } from '../../pipes/credit-label.pipe';

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
  course: any;

  isExpanded = false;

  ngOnChanges(changes: SimpleChanges): void {
    console.log(changes);
  }

  toggleDetails() {
    this.isExpanded = !this.isExpanded;
  }

  // Getter keeps the template clean by moving the ngClass logic here.
  get cardClasses() {
  if (!this.course) {
    return {};
  }

  return {
    'card-enrolled': this.course.enrolled,
    'card-full': this.course.credits >= 4,
    'expanded': this.isExpanded
  };
}

  get borderColor() {

  if (!this.course) {
    return 'gray';
  }

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