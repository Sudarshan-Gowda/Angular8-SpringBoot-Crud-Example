import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { error } from 'util';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {

  user : User = new User();

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
  }

  newUser(): void{
    this.user = new User();
  }

  save(){
    this.userService.createUser(this.user).subscribe(
      data => console.log(data), error => console.log(error)
    );
    this.user = new User();
    this.gotoUserList();
  }

  onSubmit(){
    this.save();
  }
  gotoUserList() {
     this.router.navigate(['/users']);
  }

}
