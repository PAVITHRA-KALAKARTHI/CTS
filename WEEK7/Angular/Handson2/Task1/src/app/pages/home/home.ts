import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {

  // Interpolation
  portalName = 'Student Course Portal';

  // Property Binding
  isPortalActive = true;

  // Event Binding
  message = '';

  // Two-way Binding
  searchTerm = '';

  // Hardcoded statistics
  coursesAvailable = 12;
  enrolledCourses = 3;
  gpa = 3.8;

  onEnrollClick() {
    this.message = 'Enrollment opened!';
  }

}