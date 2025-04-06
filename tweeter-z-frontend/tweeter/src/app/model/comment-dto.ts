export class CommentDTO {
    commentId!: number;
    tweetId!: number;
    userId!: number;
    userHandle!: string;
    
    content!: string;
    createdAt!: Date;
    updatedAt!: Date;
  
    constructor(init?: Partial<CommentDTO>) {
      Object.assign(this, init);
    }
  }
  