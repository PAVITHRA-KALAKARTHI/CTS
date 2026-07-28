import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NotificationService } from '../../services/notification';

@Component({
  selector: 'app-notification',
  standalone: true,
  imports: [
    CommonModule
  ],

  // Component-level provider creates a NEW NotificationService
  // instance only for this component and its child components.
  providers: [NotificationService],

  templateUrl: './notification.html',
  styleUrl: './notification.css'
})
export class Notification {

  constructor(
    public notificationService: NotificationService
  ) {}

}