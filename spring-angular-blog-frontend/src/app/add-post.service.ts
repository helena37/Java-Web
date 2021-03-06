import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {PostPayload} from "./add-post/post-payload";
import {Observable} from "rxjs";

const baseUrl = 'http://localhost:8080/api/posts/';

@Injectable({
  providedIn: 'root'
})
export class AddPostService {

  constructor(private httpClient: HttpClient) { }

  addPost(postPayload: PostPayload) {
    return this.httpClient.post(baseUrl, postPayload)
  }

  getAllPosts(): Observable<Array<PostPayload>> {
   return this.httpClient.get<Array<PostPayload>>("http://localhost:8080/api/posts/all");
  }

  getPost(permaLink: Number): Observable<PostPayload> {
    return this.httpClient.get<PostPayload>('http://localhost:8080/api/posts/get/' + permaLink);
  }

  delete(id: Number): Observable<any> {
    return this.httpClient.delete(`${baseUrl}${id}`);
  }

  edit(id: Number, value: any): Observable<Object> {
    return this.httpClient.put(`${baseUrl}edit/${id}`, value);
  }
}
