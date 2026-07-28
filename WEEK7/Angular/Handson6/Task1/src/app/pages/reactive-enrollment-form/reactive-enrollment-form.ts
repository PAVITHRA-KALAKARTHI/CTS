import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

import {
  ReactiveFormsModule,
  FormBuilder,
  FormGroup,
  Validators,
  FormArray
} from '@angular/forms';

import {
  noCourseCode,
  simulateEmailCheck
} from '../../validators/custom.validators';

@Component({
  selector: 'app-reactive-enrollment-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './reactive-enrollment-form.html',
  styleUrl: './reactive-enrollment-form.css'
})

export class ReactiveEnrollmentForm implements OnInit {

  enrollForm!: FormGroup;

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {

    this.enrollForm = this.fb.group({

      studentName: [
        '',
        [
          Validators.required,
          Validators.minLength(3)
        ]
      ],

      studentEmail: [
        '',
        [
          Validators.required,
          Validators.email
        ],
        [
          simulateEmailCheck
        ]
      ],

      courseId: [
        '',
        [
          Validators.required,
          noCourseCode
        ]
      ],

      preferredSemester: [
        'Odd',
        Validators.required
      ],

      agreeToTerms: [
        false,
        Validators.requiredTrue
      ],

      additionalCourses: this.fb.array([])

    });

  }

  // Getter for FormArray
  get additionalCourses(): FormArray {

    return this.enrollForm.get('additionalCourses') as FormArray;

  }

  // Add another course
  addCourse(): void {

    this.additionalCourses.push(

      this.fb.control(
        '',
        Validators.required
      )

    );

  }

  // Remove course
  removeCourse(index: number): void {

    this.additionalCourses.removeAt(index);

  }

  // Submit
  onSubmit(): void {

    console.log("Form Value");
    console.log(this.enrollForm.value);

    console.log("Raw Value");
    console.log(this.enrollForm.getRawValue());

  }

}