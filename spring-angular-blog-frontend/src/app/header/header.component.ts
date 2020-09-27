import { Component, OnInit } from '@angular/core';
import {AuthService} from "../auth/auth.service";
import {LoginPayload} from "../auth/login-payload";
import {ActivatedRoute, Router} from "@angular/router";
import {dashCaseToCamelCase} from "@angular/compiler/src/util";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public authService: AuthService) { }

  ngOnInit(): void {

  }

  logout() {
    this.authService.logout();
  }
}
