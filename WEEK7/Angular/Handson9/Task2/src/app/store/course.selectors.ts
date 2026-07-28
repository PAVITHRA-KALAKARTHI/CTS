import { createFeatureSelector, createSelector } from '@ngrx/store';

import { EnrollmentState } from './enrollment.reducer';

export const selectEnrollmentState =
  createFeatureSelector<EnrollmentState>('enrollment');

export const selectEnrolledIds = createSelector(

  selectEnrollmentState,

  state => state.enrolledIds

);

export const selectIsEnrolled = (courseId: number) =>

  createSelector(

    selectEnrolledIds,

    ids => ids.includes(courseId)

  );