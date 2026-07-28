import { Injectable } from '@angular/core';

@Injectable()
export class NotificationService {

  getMessage(): string {

    return 'Notification Service created using Component Level Provider';

  }

}