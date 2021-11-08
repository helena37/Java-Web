import {Component, OnInit} from '@angular/core';
import {PostPayload} from "../add-post/post-payload";
import {ActivatedRoute, Router} from "@angular/router";
import {AddPostService} from "../add-post.service";
import {AuthService} from "../auth/auth.service";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {
  editForm: FormGroup;
  post: PostPayload;
  permaLink: Number;

  constructor(private route: ActivatedRoute,
              public postService: AddPostService,
              public authService: AuthService,
              private formBuilder: FormBuilder,
              private router: Router) {

    this.editForm = this.formBuilder.group({
      content: '',
      title: ''
    });
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.permaLink = params['id'];
    });

    this.postService.getPost(this.permaLink).subscribe((data: PostPayload) => {
      this.post = data;
    }, (error: any) => {
      console.log('Failure Response');
    });
  }

  deletePost(): void {
    this.postService.delete(this.permaLink)
      .subscribe(response => {
        console.log(response);
        this.router.navigateByUrl('/home');
      }, error => {
        console.log(error);
      });
  }

  updatePost() {
    this.postService.edit(this.permaLink, this.post).subscribe(data => {
      this.router.navigateByUrl('/home')
    }, error => {
      console.log('Failure Response')
    });
  }

  validateUser(): Boolean {
    return this.authService.getUsername() === this.post.username;
  }
}
