import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {User} from '../../../../models/User';
import {HttpClientService} from '../../../../services/user/http-client.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-view-users',
  templateUrl: './view-users.component.html',
  styleUrls: ['./view-users.component.css']
})
export class ViewUsersComponent implements OnInit {

  @Input()
  user: User

  @Output()
  userDeletedEvent = new EventEmitter();

  constructor(private httpClientService: HttpClientService,
              private router: Router) { }

  ngOnInit(): void {
  }

  deleteUser() {
    this.httpClientService.deleteUser(this.user.id).subscribe(
      (user) => {
        this.userDeletedEvent.emit(); // refreshing after a deletion
        this.router.navigate(['users']);
      }
    );
  }
}
