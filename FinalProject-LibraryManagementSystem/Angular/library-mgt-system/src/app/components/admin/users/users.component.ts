import { Component, OnInit } from '@angular/core';
import {User} from '../../../models/User';
import {HttpClientService} from '../../../services/user/http-client.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users: Array<User>;
  selectedUser: User;
  action: string;

  constructor(private httpClientService: HttpClientService,
              private router: Router, // navigate to other pages
              private activatedRoute: ActivatedRoute // gives access to current route instance
  ) {}

  ngOnInit(): void {
    this.refreshData();
  }

  refreshData() {
    this.httpClientService.getUsers().subscribe(
      response => this.handleSuccessfulResponse(response),
    );

    this.activatedRoute.queryParams.subscribe(
      (params) => {
        // this.action = params['action']
        console.log('test 1');
        // getting the value of the action parameter
        this.action = params.action;
        console.log('test 2');
        const selectedUserId = params.id;
        if (selectedUserId) { // show the view page for the selected user
          this.selectedUser = this.users.find(user => user.id === +selectedUserId);
        }
      }
    );
  }

  handleSuccessfulResponse(response) {
    this.users = response;
  }

  viewUser(id: number) {
    this.router.navigate(['users'], {queryParams: {id, action: 'view'}});
  }

  addUser() {
    console.log('test 3');
    this.selectedUser = new User();
    console.log('test 4');
    this.router.navigate(['users'], {queryParams: {action: 'add'}});
  }
}
