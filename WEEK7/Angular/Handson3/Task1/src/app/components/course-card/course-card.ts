import {
Component,
Input,
OnChanges,
SimpleChanges
} from '@angular/core';

import { CommonModule } from '@angular/common';

@Component({
selector:'app-course-card',
standalone:true,
imports:[CommonModule],
templateUrl:'./course-card.html',
styleUrl:'./course-card.css'
})

export class CourseCard implements OnChanges{

@Input()

course:any;

ngOnChanges(changes:SimpleChanges){

console.log(changes);

}

}