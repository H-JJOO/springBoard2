package org.example.springboard2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardMapper mapper;

    public int insBoard(BoardEntity entity) {
        int result = 0;
        try {
            result = mapper.insBoard(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public List<BoardEntity> selBoardList() {
        return mapper.selBoardList();
    }

}
