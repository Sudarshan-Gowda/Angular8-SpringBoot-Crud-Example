import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { error } from 'util';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: Observable<User[]>;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }
  reloadData() {
     this.users = this.userService.getUserList();
  }

  deleteUser(userId:number){
    this.userService.deleteUser(userId).subscribe(
      data =>{
        console.log(data);
        this.reloadData();
      },
      error => console.log(error)
    );
  }

  userDetails(userId:number){
    this.router.navigate(['details',userId]);
  }

  modifyDetails(userId:number){
    this.router.navigate(['modify',userId]);
  }

}
