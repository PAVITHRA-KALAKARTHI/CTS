import { ApplicationConfig, provideBrowserGlobalErrorListeners } from '@angular/core';

import {
  provideHttpClient,
  withInterceptors
} from '@angular/common/http';

import { provideRouter } from '@angular/router';
import { provideClientHydration } from '@angular/platform-browser';

import { provideStore } from '@ngrx/store';
import { provideStoreDevtools } from '@ngrx/store-devtools';

import { routes } from './app.routes';

import { authInterceptor } from './interceptors/auth.interceptor';
import { errorHandlerInterceptor } from './interceptors/error-handler-interceptor';
import { loadingInterceptor } from './interceptors/loading-interceptor';

import { courseReducer } from './store/course.reducer';

import { provideEffects } from '@ngrx/effects';

import { CourseEffects } from './store/course.effects';

import { enrollmentReducer } from './store/enrollment.reducer';


export const appConfig: ApplicationConfig = {

  providers: [

    provideBrowserGlobalErrorListeners(),

    provideRouter(routes),

    provideHttpClient(

      withInterceptors([
        authInterceptor,
        errorHandlerInterceptor,
        loadingInterceptor
      ])

    ),

    provideStore({

  courses: courseReducer,

  enrollment: enrollmentReducer

}),

    provideEffects([

  CourseEffects

]), 
    provideStoreDevtools({

      maxAge: 25

    }),

    provideClientHydration()

  ]

};