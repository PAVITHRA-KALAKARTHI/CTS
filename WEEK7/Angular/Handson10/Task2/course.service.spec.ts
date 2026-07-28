import { TestBed } from '@angular/core/testing';
import {
  HttpClientTestingModule,
  HttpTestingController
} from '@angular/common/http/testing';

import { CourseService } from './course.service';

describe('CourseService', () => {

  let service: CourseService;
  let httpMock: HttpTestingController;

  beforeEach(() => {

    TestBed.configureTestingModule({

      imports: [HttpClientTestingModule],
      providers: [CourseService]

    });

    service = TestBed.inject(CourseService);

    httpMock = TestBed.inject(HttpTestingController);

  });

  afterEach(() => {

    httpMock.verify();

  });

  it('should be created', () => {

    expect(service).toBeTruthy();

  });

  it('should return courses', () => {

    const mockCourses = [

      {
        id: 1,
        name: 'Angular',
        code: 'ANG101',
        credits: 3,
        gradeStatus: 'passed',
        enrolled: false
      },

      {
        id: 2,
        name: 'Java',
        code: 'JAVA101',
        credits: 4,
        gradeStatus: 'passed',
        enrolled: false
      }

    ];

    service.getCourses().subscribe(courses => {

      expect(courses.length).toBe(2);

    });

    const req = httpMock.expectOne('http://localhost:3000/courses');

    expect(req.request.method).toBe('GET');

    req.flush(mockCourses);

  });

  it('should handle HTTP error', () => {

    service.getCourses().subscribe({

      next: () => fail('Expected an error'),

      error: (err) => {

        expect(err.message)
          .toContain('Failed to load courses');

      }

    });

    const req = httpMock.expectOne('http://localhost:3000/courses');

    req.flush('Server Error', {

      status: 500,

      statusText: 'Internal Server Error'

    });

  });

});