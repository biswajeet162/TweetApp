import { CommentDTO } from "./comment-dto";

export class TweetDTO {
    tweetId!: number;
    userId!: number;
    userHandle!: string;
    userName!: string;
    
    content!: string;
    createdAt!: Date;
    updatedAt!: Date;
    comments!: CommentDTO[];
    likes!: number[]; // User IDs who liked the tweet
    imageUrls!: string[];
    videoUrls!: string[];
    showComments: boolean = false; // Default value
  
    constructor(init?: Partial<TweetDTO>) {
      Object.assign(this, init);
    }
  }
  