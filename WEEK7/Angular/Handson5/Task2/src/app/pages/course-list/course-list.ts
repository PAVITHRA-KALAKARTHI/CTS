import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { CourseCard } from '../../components/course-card/course-card';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCard],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {

  isLoading = true;

 courses = [

{
id:1,
name:'Angular',
code:'ANG101',
credits:1,
gradeStatus:'passed',
enrolled:true
},

{
id:2,
name:'Java',
code:'JAVA201',
credits:3,
gradeStatus:'failed',
enrolled:false
},

{
id:3,
name:'React',
code:'REA301',
credits:null,
gradeStatus:'pending',
enrolled:true
}

];

  ngOnInit(): void {

  console.log("ngOnInit called");

  setTimeout(() => {

    console.log("Timeout executed");

    this.isLoading = false;

  }, 1500);

}

  // trackBy improves performance by allowing Angular to reuse
  // existing DOM elements instead of recreating them.
  trackByCourseId(index: number, course: any): number {
    return course.id;
  }

}