import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';

import { CourseCard } from './course-card';
import { Course } from '../../models/course.model';

describe('CourseCard', () => {

  let component: CourseCard;
  let fixture: ComponentFixture<CourseCard>;

  beforeEach(async () => {

    await TestBed.configureTestingModule({

      imports: [CourseCard]

    }).compileComponents();

    fixture = TestBed.createComponent(CourseCard);

    component = fixture.componentInstance;

    fixture.detectChanges();

  });

  // Step 102
  it('should create', () => {

    expect(component).toBeTruthy();

  });

  // Step 103
  it('should render course name', () => {

    component.course = {

      id: 1,
      name: 'Data Structures',
      code: 'CS101',
      credits: 4,
      gradeStatus: 'passed',
      enrolled: false

    } as Course;

    fixture.detectChanges();

    const title = fixture.debugElement.query(By.css('h3'));

    expect(title.nativeElement.textContent)
      .toContain('Data Structures');

  });

  // Step 104
  it('should toggle enrollment', () => {

    component.course = {

      id: 1,
      name: 'Angular',
      code: 'ANG101',
      credits: 3,
      gradeStatus: 'passed',
      enrolled: false

    } as Course;

    fixture.detectChanges();

    component.toggleEnrollment();

    expect(component.course.enrolled).toBeTrue();

  });

  // Step 105
  it('should call ngOnChanges', () => {

    spyOn(console, 'log');

    component.ngOnChanges({});

    expect(console.log).toHaveBeenCalled();

  });

});