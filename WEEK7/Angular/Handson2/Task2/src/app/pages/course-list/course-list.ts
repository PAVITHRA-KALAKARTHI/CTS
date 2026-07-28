import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

import { CourseCard } from '../../components/course-card/course-card';

@Component({

selector:'app-course-list',

standalone:true,

imports: [
  CommonModule,
  CourseCard
],

templateUrl:'./course-list.html',

styleUrl:'./course-list.css'

})

export class CourseList{

courses=[

{

id:1,

name:'Angular',

code:'ANG101',

credits:4

},

{

id:2,

name:'Java',

code:'JAVA201',

credits:3

},

{

id:3,

name:'React',

code:'REA301',

credits:4

}

];

}