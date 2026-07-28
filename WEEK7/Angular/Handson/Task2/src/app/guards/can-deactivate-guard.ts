import { CanDeactivateFn } from '@angular/router';
import { ReactiveEnrollmentForm } from '../pages/reactive-enrollment-form/reactive-enrollment-form';

export const canDeactivateGuard: CanDeactivateFn<ReactiveEnrollmentForm> = (
  component
) => {

  if (component.enrollForm.dirty) {

    return confirm('You have unsaved changes. Do you really want to leave this page?');

  }

  return true;

};