import { createReducer, on } from '@ngrx/store';

import * as EnrollmentActions from './enrollment.actions';

export interface EnrollmentState {

  enrolledIds: number[];

}

export const initialState: EnrollmentState = {

  enrolledIds: []

};

export const enrollmentReducer = createReducer(

  initialState,

  on(EnrollmentActions.enrollInCourse, (state, { courseId }) => ({

    ...state,

    enrolledIds: [...state.enrolledIds, courseId]

  })),

  on(EnrollmentActions.unenrollFromCourse, (state, { courseId }) => ({

    ...state,

    enrolledIds: state.enrolledIds.filter(id => id !== courseId)

  })),

  on(EnrollmentActions.setEnrolledCourses, (state, { enrolledIds }) => ({

    ...state,

    enrolledIds

  }))

);