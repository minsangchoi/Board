package com.project.Board.Service;

import com.project.Board.domain.Comments;
import com.project.Board.repository.CommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CommentsService {
    private final CommentsRepository commentsRepository;

    //댓글저장
    public void register(Comments comment) {
        commentsRepository.save(comment);
    }
    //댓글 상세
    public Comments Commentsdetail(Long id) {
        Comments comments = commentsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("댓글을 찾을수 없습니다."));

        return comments;
    }
    //댓글리스트조회
    public List<Comments> SearchComments(int idx) {
        List<Comments> comments = commentsRepository.searchDetailComments(idx);

        return comments;
    }
    //댓글삭제
    public void CommentDelete(Long id) {
        commentsRepository.deleteById(id);
    }

    //댓글수정
    public void CommentUpdate(Long id, String updatedComment) {
        Comments comment = commentsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No Comments found with id " + id));
        comment.setComment(updatedComment);
        commentsRepository.save(comment);
    }


}
