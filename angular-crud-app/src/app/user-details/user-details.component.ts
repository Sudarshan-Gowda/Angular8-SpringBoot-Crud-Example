import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../user.service';
import { error, log } from 'util';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  id: number;
  user: User;

  constructor(private route:ActivatedRoute, private router: Router, private userService: UserService) { }
  
  ngOnInit() {

      this.user = new User();
      this.id = this.route.snapshot.params['userId'];
      this.userService.getUser(this.id).subscribe(data =>{
      this.user = data;
    },error => console.log(error)
    );
  }

  userList(){
    this.router.navigate(['users']);
  }

}
