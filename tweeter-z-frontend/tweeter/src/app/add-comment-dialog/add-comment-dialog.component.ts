import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  standalone: false,
  selector: 'app-add-comment-dialog',
  templateUrl: './add-comment-dialog.component.html',
  styleUrls: ['./add-comment-dialog.component.css']
})
export class AddCommentDialogComponent {
  commentContent: string = '';
  @Output() commentAdded = new EventEmitter<string>();
  @Output() dialogClosed = new EventEmitter<void>();

  closeDialog(): void {
    this.dialogClosed.emit();
  }

  sendComment(): void {
    this.commentAdded.emit(this.commentContent);
    this.closeDialog();
  }
}