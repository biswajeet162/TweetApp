import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TweetDTO } from '../model/tweet-dto';
import { CommentRequest } from '../model/comment-request';

@Injectable({
  providedIn: 'root'
})
export class TweetServiceService {

  private baseUrl1 = 'http://localhost:8082'; // Change this to your backend URL
  private baseUrl2 = 'http://localhost:8083'; // Change this to your backend URL

  constructor(private http: HttpClient) { }

  createTweet(tweet: any): Observable<any> {
    return this.http.post(`${this.baseUrl1}/tweet/create`, tweet);
  }

  getHomeTimeline(): Observable<TweetDTO> {
    return this.http.get<TweetDTO>(`${this.baseUrl2}/timeline/home`);
  }

  likeTweet(tweetId: number, userId: number): Observable<any> {
    return this.http.post(`${this.baseUrl1}/tweet/${tweetId}/like?userId=${userId}`, {});
  }


  // addComment(tweetId: number, p0: number, commentContent: string, commentRequest: CommentRequest): Observable<any> {
  //   return this.http.post(`${this.baseUrl1}/tweet/${tweetId}/comment`, commentRequest, {
  //     params: { userId: commentRequest.userId.toString() }
  //   });
  // }

  addComment(tweetId: number, commentRequest: { userId: number; content: string; }): Observable<void> {
    return this.http.post<void>(`${this.baseUrl1}/tweet/${tweetId}/comment`, commentRequest);
  }

}
