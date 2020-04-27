import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {User} from '../../../../models/User';
import {HttpClientService} from '../../../../services/user/http-client.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  @Input()
  user: User

  @Output()
  userAddedEvent = new EventEmitter();
  // we need to tell the parent users component that child
  // add user component has added a new User so fetch the
  // users list again. We do this using the Output annotation.

  constructor(private httpClientService: HttpClientService,
              private router: Router) { }

  ngOnInit(): void {
  }

  addUser() {
    this.httpClientService.addUser(this.user).subscribe(
      (user) => {
        // this.router.navigate(['admin', 'users']);
        this.userAddedEvent.emit();
        this.router.navigate(['users']);
      }
    );
  }

}
