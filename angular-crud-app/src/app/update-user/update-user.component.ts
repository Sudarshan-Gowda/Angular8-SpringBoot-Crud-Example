import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../user.service';
import { error } from '@angular/compiler/src/util';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

   userId: number;
   user: User;

  constructor(private route: ActivatedRoute, private userService: UserService, private router: Router) { }

  ngOnInit() {

    this.user = new User();
    this.userId = this.route.snapshot.params['userId'];
    this.userService.getUser(this.userId).subscribe(
      data =>{
        console.log(data);
        this.user=data;
      },
      error => console.log(error)
    );
  }

  onSubmit(){
    this.modify();
  }

  modify(){
    this.userService.updateUser(this.userId, this.user).subscribe(
      data =>
      console.log(data),error => console.log(error)
    );
    this.user = new User();
    this.gotoList();
  }

  gotoList(){
    this.router.navigate(['users']);
  }

}
